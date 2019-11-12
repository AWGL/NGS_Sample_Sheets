/**
 * 
 */
package nhs.cardiff.genetics.ngssamplesheets;

/**
 * @author Rhys Cooper & Sara Rey
 * @Date 16/09/2019
 * @version 1.5.0
 * 
 */

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;


public class ImportWorksheet {
	private ArrayList<Worksheet> worksheets = new ArrayList<Worksheet>();
	private String db;
	private String url;
	private String user;
	private String test;
	private boolean goPan;
	private boolean go;
	private boolean goNGS;

	public ImportWorksheet() {
		go = false;
		goNGS = false;
		goPan = false;
		db = "M:\\Pyrosequencing\\Pyrosequencing Service\\PCR & PYRO spreadsheets\\Log\\IT\\SHIRE COPY FOR PYRO.MDB";
		url = ("jdbc:odbc:Driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ=" + db);
	}
	
	/**
	 * 
	 * @param input The input strings provided by the user
	 * @param index The indexes selected by the user
	 * @param combine Boolean, true if user wishes to combine worksheets into one output file
	 * @throws Exception Throws exception if the input string is not a valid shire or NGS worksheet
	 */
	public void process(ArrayList<String> input, ArrayList<Index> index, Boolean combine, Boolean pan) throws Exception{
		ExportSampleSheet export = new ExportSampleSheet();

		// reduce input down to amount of worksheets selected
		// don't need this null removal? Test...
		input.remove(null);

		//Support where one additional input is appended to end of input array for pan cancer index option
		int inputEnd = input.size();
		String indexStart = "no index";
		if (pan) {
			inputEnd = input.size() - 1;
			indexStart = input.get(input.size() - 1);

		}

		for (int i = 0; i < inputEnd; i++) {
			Worksheet ws = new Worksheet();
			importShire(ws, input.get(i).toString(), indexStart);
			worksheets.add(ws);
		}
		if(combine == true){			
			combine(worksheets, index);		
		}else if(combine == false){	
			for (Worksheet ws : worksheets) {
				for (int i = 0; i < ws.getTest().size(); i++) {
					test = ws.getTest().get(i);
				}
				export.selectExport(ws, index, test);
			}
		}
	}
	
	/**
	 * 
	 * @param worksheets ArrayList of worksheet objects
	 * @param index The indexes selected by the user
	 * @throws IOException Throws exception if the input string is not a valid shire or NGS worksheet
	 */
	private void combine(ArrayList<Worksheet> worksheets, ArrayList<Index> index) throws IOException{
		
		ExportSampleSheet export = new ExportSampleSheet();
		export.selectExport(worksheets, index);


		// To get test details, dont think its needed for combined sheets
//		for (Worksheet ws : worksheets) {
//			for (int i = 0; i < ws.getTest().size(); i++) {
//				test = ws.getTest().get(i);
//			}
//		}
	}

	/**
	 * 
	 * @param ws The worksheet object
	 * @param input The input string provided by the user
	 * @throws Exception Throws exception if the input string is not a valid shire or NGS worksheet
	 */
	private void importShire(Worksheet ws, String input, String panInd) throws Exception{

		user = System.getProperty("user.name");

		//Allow worksheets with no pan index through
		if (!panInd.equals("no index")){
			//If there is an entry, check it
			goPan = checkInputPanIndex(panInd);
			if (!goPan){
				Exception ex = new Exception("Not a Valid index, please try again");
				throw ex;
			}
		}

		go = checkInputShire(input);
		User getUser = new User(user);
		boolean done = false;

		if (go) {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn = DriverManager.getConnection(url);

			PreparedStatement st = conn.prepareStatement("SELECT DISTINCTROW DNA_Worksheet.*,"
					+ " DNA_WORKSHEET_DET.POSITION,"
					+ " DNA_WORKSHEET_DET.LABNO,"
					+ " DNA_Worksheet.WORKSHEET,"
					+ " DNA_Worksheet.UPDATEDBY,"
					+ " DNA_WORKSHEET_DET.WORKSHEET,"
					+ " PATIENT.SEX,"
					+ " DNALAB.REASON_FOR_REFERRAL,"
					+ " PATIENT.FIRSTNAME"
					+ " FROM (((DNA_Worksheet LEFT JOIN DNA_TEST"
					+ " ON [DNA_Worksheet].TEST = [DNA_TEST].TEST)"
					+ " INNER JOIN DNA_WORKSHEET_DET"
					+ " ON [DNA_Worksheet].WORKSHEET = [DNA_WORKSHEET_DET].WORKSHEET)"
					+ " LEFT OUTER JOIN [DNALAB]"
					+ " ON [DNA_WORKSHEET_DET].LABNO = [DNALAB].LABNO)"
					+ " LEFT OUTER JOIN [PATIENT]"
					+ " ON [DNALAB].INTID = [PATIENT].INTID"
					+ " WHERE ((([DNA_Worksheet].WORKSHEET)=[DNA_WORKSHEET_DET].[WORKSHEET])"
					+ " AND (([DNA_WORKSHEET_DET].WORKSHEET)=?))"
					+ " ORDER BY DNA_WORKSHEET_DET.POSITION ASC;");
			

			st.setString(1, input);

			PreparedStatement st2 = conn.prepareStatement("SELECT DISTINCTROW DNALAB_TEST.*,"
					+ " DNALAB_TEST.TEST,"
					+ " DNALAB_TEST.COMMENTS FROM"
					+ " DNALAB_TEST WHERE DNALAB_TEST.LABNO =?");


			ResultSet rs = st.executeQuery();

			int offset = 0;

			while (rs.next()) {
				ws.setWorksheet(rs.getString("WORKSHEET").toString());
				String spaceFix = rs.getString("LABNO");
				// Remove whitespace, weird bug for only some labno returns...
				// Don't know why!?
				try {
					spaceFix = spaceFix.replace(" ", "");
				} catch (Exception e) {
					// No need to do anything, just means no spaces in the string
				}
				ws.setLabNo(spaceFix);
				ws.setPosition(rs.getString("POSITION"));
				ws.setUser(getUser.getUser().toString());
				ws.setTest(rs.getString("TEST"));
				ws.setUpdateDate(rs.getString("UPDATEDDATE").substring(2, 10).replace("-", "/"));
				ws.setSexes(rs.getString("SEX"));
				ws.setGenes(rs.getString("REASON_FOR_REFERRAL"));
				ws.setCRUKIdentifier(rs.getString("FIRSTNAME"));


				//If pancancer (front end selection) add indices to ws object in order
				//Only add indexes where there is an associated lab number
				if (goPan && spaceFix != null) {
					PanIndexes pi = new PanIndexes();
					pi.setStartingIndex(panInd);
					List<String> listKeys = new ArrayList<String>(pi.getPanIndices().keySet());
					//System.out.println(listKeys);
					//Get the position of the index
					int keyIndex = listKeys.indexOf(panInd);
					int currentIndex = (keyIndex + offset);
					String currentKey = (listKeys.get(currentIndex));
					ws.setPanIndexId(currentKey);

					//Get values from key
					List<String> panIndices = pi.getPanIndices().get(currentKey);
					ws.setPanFirstIndex(panIndices.get(0));
					ws.setPanSecondIndex(panIndices.get(1));

					//Handle where indexes start again at A1
					if (currentIndex < listKeys.size()-1) {
						offset = (offset + 1);
					} else{
						offset = -(keyIndex);
					}
				}
		
				// Check if NGS worksheet
				// Gets size - 1 to pick to the last entry
				goNGS = checkInputNGS(ws.getTest().get(ws.getTest().size() - 1));
				st2.setString(1, ws.getLabNo().get(ws.getLabNo().size() - 1));

				if (goNGS && ws.getLabNo() != null) {
					System.out.println(ws.getLabNo());
					ResultSet rs2 = st2.executeQuery();
					done = false;
					while (rs2.next()) {
						String temp = rs2.getString("TEST");
						// Check is the test is actually NGS and not MLPA etc
						// As we only want the comments from the NGS ones.
						if(temp.equalsIgnoreCase("Trusight Cancer") && (done == false)
								|| temp.equalsIgnoreCase("NEXTERA NGS") && (done == false)
								|| temp.equalsIgnoreCase("TruSight One CES panel") && (done == false)
								|| temp.equalsIgnoreCase("TAM panel") && (done == false)
								|| temp.equalsIgnoreCase("CRM panel") && (done == false)
								|| temp.equalsIgnoreCase("BRCA panel") && (done == false)
								|| temp.equalsIgnoreCase("GeneRead pooled") && (done == false)
								|| temp.equalsIgnoreCase("haem NGS") && (done == false)
							    || temp.equalsIgnoreCase("PanCancerNGS panel") && (done == false)
								|| temp.equalsIgnoreCase("FH NGS Panel v1") && (done == false)
						        || temp.equalsIgnoreCase("Illumina TST170_DNA") && (done == false)){
							ws.setPanel(temp);
							ws.setComments(rs2.getString("COMMENTS"));
							done = true;
						}
					}
					if(done == false){
						ws.setPanel("null panel");
						ws.setComments("no comments");
					}
				} else if (!goNGS) {
					Exception ex = new Exception("Not a Valid NGS worksheet, please try again");
					throw ex;
				}
			}
		} else if (!go) {
			Exception ex = new Exception("Not a valid shire worksheet, please try again");
			throw ex;
		}
	}

	/**
	 * 
	 * @param worksheetInput The input from the user
	 * @return true if input valid Shire worksheet
	 */
	private boolean checkInputShire(String worksheetInput) {
		String filter = "(^\\d{1,2}[-]\\d{1,5})";
		Pattern pattern = Pattern.compile(filter, 2);
		Matcher matcher = pattern.matcher(worksheetInput);

		if (matcher.find()) {
			return true;
		}
		return false;
	}

	/**
	 *
	 * @param indexInput The input from the user
	 * @return true if input valid index
	 */
	private boolean checkInputPanIndex(String indexInput) {
		String filter = "((^[A-H]0?[1-9]$)|(^[A-H]1[0-2]$))";
		Pattern pattern = Pattern.compile(filter, 2);
		Matcher matcher = pattern.matcher(indexInput);

		if (matcher.find()) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param test denoting the name of the test
	 * @return true if test a valid NGS test
	 */
	private boolean checkInputNGS(String test) {
		if ((test.equalsIgnoreCase("NEXTERA NGS"))
				|| (test.equalsIgnoreCase("TruSight Cancer"))
				|| (test.equalsIgnoreCase("TruSight One CES panel"))
				|| (test.equalsIgnoreCase("TAM panel"))
				|| (test.equalsIgnoreCase("CRM panel"))
				|| (test.equalsIgnoreCase("BRCA panel"))
				|| (test.equalsIgnoreCase("GeneRead pooled"))
				|| (test.equalsIgnoreCase("haem NGS"))
		        || (test.equalsIgnoreCase("PanCancerNGS panel"))
                || (test.equalsIgnoreCase("FH NGS Panel v1"))
				|| (test.equalsIgnoreCase("Illumina TST170_DNA"))){

			goNGS = true;
		} else {
			goNGS = false;
		}
		return goNGS;
	}
}
