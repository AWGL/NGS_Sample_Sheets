/**
 * 
 */
package nhs.cardiff.genetics.ngssamplesheets;

/**
 * @author Rhys Cooper & Sara Rey
 * @Date 17/04/2019
 * @version 1.4.3
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

public class ImportWorksheet {
	private ArrayList<Worksheet> worksheets = new ArrayList<Worksheet>();
	private String db;
	private String url;
	private String user;
	private String test;
	private boolean go;
	private boolean goNGS;

	public ImportWorksheet() {
		go = false;
		goNGS = false;
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
	public void process(ArrayList<String> input, ArrayList<Index> index, Boolean combine) throws Exception{
		ExportSampleSheet export = new ExportSampleSheet();
		// reduce input down to amount of worksheets selected
		// don't need this null removal? Test...
		input.remove(null);
		for (int i = 0; i < input.size(); i++) {
			Worksheet ws = new Worksheet();
			importShire(ws, input.get(i).toString());
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
	private void importShire(Worksheet ws, String input) throws Exception{
		
		user = System.getProperty("user.name");
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
					+ " PATIENT.SEX"
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
		
				// Check if NGS worksheet
				// Gets size - 1 to pick to the last entry
				goNGS = checkInputNGS(ws.getTest().get(ws.getTest().size() - 1));
				st2.setString(1, ws.getLabNo().get(ws.getLabNo().size() - 1));

				if (goNGS && ws.getLabNo() != null) {
					ResultSet rs2 = st2.executeQuery();
					done = false;
					while (rs2.next()) {
						String temp = rs2.getString("TEST");
						// Check is the test is actually NGS and not MLPA etc
						// As we only want the comments from the NGS ones.
						if(temp.equalsIgnoreCase("Trusight Cancer") && (done == false)
								|| temp.equalsIgnoreCase("TruSight One CES panel") && (done == false)
								|| temp.equalsIgnoreCase("TAM panel") && (done == false)
								|| temp.equalsIgnoreCase("CRM panel") && (done == false)
								|| temp.equalsIgnoreCase("BRCA panel") && (done == false)
								|| temp.equalsIgnoreCase("GeneRead pooled") && (done == false)
								|| temp.equalsIgnoreCase("haem NGS") && (done == false)){
							ws.setPanel(temp);
							ws.setComments(rs2.getString("COMMENTS"));
							done = true;
						}

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
	 * @param arrayList denoting the name of the test
	 * @return true if test a valid NGS test
	 */
	private boolean checkInputNGS(String test) {
		if ((test.equals("NEXTERA NGS"))
				|| (test.equals("TruSight Cancer"))
				|| (test.equals("TruSight One CES panel"))
				|| (test.equals("TAM panel"))
				|| (test.equals("CRM panel"))
				|| (test.equals("BRCA panel"))
				|| (test.equals("GeneRead pooled"))
				| (test.equals("haem NGS"))) {
			goNGS = true;
		} else {
			goNGS = false;
		}
		return goNGS;
	}
}
