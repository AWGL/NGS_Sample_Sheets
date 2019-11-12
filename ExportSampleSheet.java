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
import java.lang.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportSampleSheet {
	private String filepath;
	private String worksheetName;
	private String fileSave;
	private String trusightPipeline;
	private String trusightOnePipeline;
	private String focus4Pipeline;
	private String wcbPipeline;
	private String brcaPipeline;
	private String tamPipeline;
	private String crukPipeline;
	private String myeloidPipeline;
	private String panCancerPipeline;
	private String pancrmPipeline;
	private String fhPipeline;
	private int crukRow;
	//private int crukAnRow;
	private int truRow;
	private int truOneRow;
	private int tamRow;
	private int wcbRow;
	private int myeloidRow;
	private int panCancerRow;
	private int fhRow;

	public ExportSampleSheet() {
		properties();
		filepath = "";
		crukRow = 21;
		//crukAnRow = 28;
		truRow = 14;
		truOneRow = 17;
		tamRow = 14;
		wcbRow = 14;
		myeloidRow = 17;
		panCancerRow = 18;
		fhRow = 17;
	}

	/**
	 * 
	 * @param ws The worksheet object
	 * @param index The indexes selected by the user
	 * @param test The test specified on the worksheet
	 * @throws IOException Throws exception if cannot save output file
	 */
	public void selectExport(Worksheet ws, ArrayList<Index> index, String test) throws IOException, Exception{
		if(test.equalsIgnoreCase("Illumina TST170_DNA")){
			exportCRUKTAMMye(ws, index, "CRUK", crukRow, "Y:\\samplesheet-templates\\CRUK.xls");
		}else if(test.equalsIgnoreCase("TruSight Cancer")){
			exportTrusight(ws, index, "TRUSIGHT", truRow, "Y:\\samplesheet-templates\\Trusight.xls");
		}else if(test.equalsIgnoreCase("TruSight One CES panel")){
			exportTrusight(ws, index, "TRUSIGHTONE", truOneRow, "Y:\\samplesheet-templates\\TrusightOne.xls");
		}else if (test.equalsIgnoreCase("TAM panel") && test.equalsIgnoreCase("CRM panel")){
			// COMBINED ONE HERE... OVERLOADED METHOD HERE IF IT'S NEEDED
		}else if(test.equalsIgnoreCase("TAM panel")){
			exportCRUKTAMMye(ws, index, "TAM", tamRow, "Y:\\samplesheet-templates\\TAMGeneRead.xls");
		}else if(test.equalsIgnoreCase("CRM panel")){
			exportWCB(ws, index, "CRM", wcbRow, "Y:\\samplesheet-templates\\WCB.xls");
		}else if(test.equalsIgnoreCase("haem NGS")) {
			exportCRUKTAMMye(ws, index, "MYELOID", myeloidRow, "Y:\\samplesheet-templates\\Myeloid.xls");
		}else if(test.equalsIgnoreCase("PanCancerNGS panel")) {
			exportPanCancer(ws, index, "PANCANCER", panCancerRow, "Y:\\samplesheet-templates\\Pancancer.xls");
		}else if(test.equalsIgnoreCase("FH NGS Panel v1")) {
			exportTrusight(ws, index, "FH", fhRow, "Y:\\samplesheet-templates\\FH.xls");
		}else if(test.equalsIgnoreCase("BRCA panel")) {
			exportWCB(ws, index, "BRCA", wcbRow, "Y:\\samplesheet-templates\\WCB.xls");
			//}else if(test.equalIgnoreCase("NEXTERA NGS")){
			//exportCRUKTAM(ws, index, "CRUK", crukRow, "Y:\\samplesheet-templates\\CRUK-SeqOnly.xls");
			// ANALYSIS SHEET NO LONGER REQUIRED
			//exportCRUKTAM(ws, index, "ANALYSIS", crukAnRow, "Y:\\samplesheet-templates\\CRUK-analysis.xls");
		}
	}


	/**
	 * 
	 * @param worksheets ArrayList of worksheet objects
	 * @param index The indexes selected by the user
	 * @throws IOException Throws exception if cannot save output file
	 */
	public void selectExport(ArrayList<Worksheet> worksheets,ArrayList<Index> index) throws IOException {
		// uses WCB sheet for combined sheets
		exportCombined(worksheets, index, "CRM", wcbRow, "Y:\\samplesheet-templates\\WCB.xls");
	}
	
	

	/**
	 * @category Loads pipeline properties for the generator
	 */
	private void properties(){
		Properties properties = new Properties();
		try {
		  properties.load(new FileInputStream("Y:\\samplesheet-templates\\pipelines.properties"));
		  trusightPipeline = properties.getProperty("TRUSIGHT");
		  trusightOnePipeline = properties.getProperty("TRUSIGHTONE");
		  focus4Pipeline = properties.getProperty("FOCUS4");
		  wcbPipeline = properties.getProperty("WCB");
		  brcaPipeline = properties.getProperty("BRCA");
		  tamPipeline = properties.getProperty("TAM");
		  crukPipeline = properties.getProperty("CRUK");
		  myeloidPipeline = properties.getProperty("MYELOID");
		  panCancerPipeline = properties.getProperty("PANCANCER");
		  pancrmPipeline = properties.getProperty("PANCRM");
		  fhPipeline = properties.getProperty("FH");

		} catch (IOException e) {
			
		}
	}

	/**
	 * 
	 * @param workbook HSSFWorkBook Object
	 * @param type String denoting type of file to be exported - Analysis or not
	 * @param assay String denoting assay type
	 * @throws IOException Thrown if file cannot be saved
	 */
	private void save(HSSFWorkbook workbook, String type, String assay) throws IOException {
		if (assay.equals("CRUK")) {
			filepath = "L:\\Auto NGS Sample sheets\\CRUK\\";
		} else if (assay.equals("Trusight")) {
			filepath = "L:\\Auto NGS Sample sheets\\Trusight\\";
		} else if (assay.equals("TAM")) {
			filepath = "L:\\Auto NGS Sample sheets\\TAM\\";
		} else if (assay.equals("WCB")) {
			filepath = "L:\\Auto NGS Sample sheets\\WCB\\";
		} else if (assay.equals("Trusightone")) {
			filepath = "L:\\Auto NGS Sample sheets\\Trusight One\\";
		} else if (assay.equals("myeloid")) {
			filepath = "L:\\Auto NGS Sample sheets\\Myeloid\\";
		} else if (assay.equals("pancancer")) {
			filepath = "L:\\Auto NGS Sample sheets\\Pancancer\\";
		} else if (assay.equals("FamHyp")) {
			filepath = "L:\\Auto NGS Sample sheets\\FH\\";
		}
		
		if (type.equals("analysis")) {
			fileSave = ("L:\\CRUK\\Nextera\\worksheets\\Analysis SampleSheets\\" + worksheetName + "_analysis" + ".xls");
		} else {
			fileSave = (filepath + worksheetName + ".xls");
		}
		workbook.setSheetName(0, worksheetName);
		FileOutputStream fileOut = new FileOutputStream(fileSave);
		workbook.write(fileOut);
		workbook.close();
		fileOut.flush();
		fileOut.close();
		Desktop dt = Desktop.getDesktop();
		dt.open(new File(fileSave));
	}

	/**
	 * 
	 * @param ws The worksheet object
	 * @param index The indexes selected by the user
	 * @param select String to denote normal sample sheet or analysis sample sheet output
	 * @param rowNum The rownumber in excel to start inputting data on
	 * @param file Filepath string for file save location
	 * @throws IOException Thrown if file cannot be saved
	 */
	private void exportCRUKTAMMye(Worksheet ws, ArrayList<Index> index, String select, int rowNum, String file) throws IOException, Exception {
		FileInputStream fileIn = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(fileIn);
		HSSFSheet worksheet = workbook.getSheet("Sheet1");
		HSSFRow row = worksheet.getRow(2);
		HSSFCell cell = row.createCell(1);
		cell.setCellValue(ws.getUser().get(0) + "-NHS");

		row = worksheet.getRow(3);
		cell = row.createCell(1);
		cell.setCellValue(ws.getWorksheet().get(0));
		worksheetName = ws.getWorksheet().get(0);

		// SPECIFIC TO CRUK SHEETS
		if(select.equalsIgnoreCase("CRUK") || select.equalsIgnoreCase("ANALYSIS")) {
			row = worksheet.getRow(4);
			cell = row.createCell(1);
			cell.setCellValue(ws.getUpdateDate().get(0));
		}


		// Is sample DNA or RNA (for indices)- create count variables
		int offset = 0;
		int dnaCount = 0;
		int rnaCount = 16; //Offset of RNA samples in indexes
		for (int i = 0; i < ws.getLabNo().size(); i++) {
			if(ws.getLabNo().get(i) != null){
				String labNo = ws.getLabNo().get(i);
				row = worksheet.getRow(rowNum);
				cell = row.createCell(0);
				cell.setCellValue(labNo);
				cell = row.createCell(1);

				if(select.equalsIgnoreCase("CRUK") || select.equalsIgnoreCase("ANALYSIS")) {
					//SPECIFIC TO CRUK
					//Variable to store sample type
					String sampleT;
					cell.setCellValue(ws.getLabNo().get(i));
					cell = row.createCell(2);
					cell.setCellValue(ws.getWorksheet().get(i));
					// Is sample DNA or RNA (for indices)
					try {
						if (labNo.substring(labNo.lastIndexOf('M')).charAt(1) == '8') {
							; //.equals('8')) {
							rnaCount += 1;
							sampleT = "RNA";
						} else {
							dnaCount += 1;
							sampleT = "DNA";
						}
					} catch (IndexOutOfBoundsException Ex) {
						// Sample is named atypically
						if (labNo.matches("(?i:.*NTC.*DNA.*)")) {
							dnaCount += 1;
							sampleT = "DNA";
						} else if (labNo.matches("(?i:.*NTC.*)")) {
							rnaCount += 1;
							sampleT = "RNA";
						} else if (labNo.matches("(?i:.*Control.*DNA.*)")) {
							dnaCount += 1;
							sampleT = "DNA";
						} else {
							throw new IndexOutOfBoundsException("Sample name " + labNo + " format is not supported.");
						}
					}

					// CRUK rotate indexes
					CRUKIndexes cruki = new CRUKIndexes();
					String selected = index.get(0).getIndexSelect();
					int crukind = 404; // Set to high number so this will break if the correct assignment fails

					if (!"CRUKset1".equals(selected) && !"CRUKset2".equals(selected)) {
						//Do not write out indexes
						;
					}else {
						if (selected.equals("CRUKset1")) {
							offset = 0;
							if (sampleT.equals("DNA")) {
								offset += dnaCount;
							} else if (sampleT.equals("RNA")) {
								offset += rnaCount;
							} else {
								throw new Exception("Could not determine if sample" + labNo + "is DNA or RNA.");
							}
						} else if (selected.equals("CRUKset2")) {
							offset = 8;
							if (sampleT.equals("DNA")) {
								offset += dnaCount;
							} else if (sampleT.equals("RNA")) {
								offset += rnaCount;
							} else {
								throw new Exception("Could not determine if sample" + labNo + "is DNA or RNA.");
							}
						}
						//Write out indexes
						crukind = offset;
						String crukIndNum = Integer.toString(crukind);
						String indexName = cruki.getCrukIndices().get(crukIndNum).get(0);
						cell = row.createCell(4);
						cell.setCellValue(indexName); //Set to compound index name
						String i7Name = cruki.getCrukIndices().get(crukIndNum).get(1);
						cell = row.createCell(5);
						cell.setCellValue(i7Name); //Set to i7 index name
						String crukInd1 = cruki.getCrukIndices().get(crukIndNum).get(3); //First index
						cell = row.createCell(6);
						cell.setCellValue(crukInd1);
						String crukInd2 = cruki.getCrukIndices().get(crukIndNum).get(4); //Second index
						String i5Name = cruki.getCrukIndices().get(crukIndNum).get(2);
						cell = row.createCell(7);
						cell.setCellValue(i5Name); //Set to i5 index name
						cell = row.createCell(8);
						cell.setCellValue(crukInd2);
					}

					/*

					//INDEX BASES- LEGAGY CODE
					//cell = row.createCell(7);
					//cell.setCellValue(ind.getIndexSelect().toString());

                    */
					// SPECIFIC TO CRUK
					cell = row.createCell(10);
					cell.setCellValue(crukPipeline + ";pairs=" + ws.getCRUKIdentifier().get(i) +
										";sampleType=" + sampleT);

				}else if(select.equalsIgnoreCase("TAM")){
					// SPECIFIC TO TAM
					cell.setCellValue(ws.getWorksheet().get(i));
					cell = row.createCell(6);
					cell.setCellValue(tamPipeline  + ";referral=" + ws.getGenes().get(i));

				}else if(select.equalsIgnoreCase("MYELOID")){
					// SPECIFIC TO Myeloid
					cell.setCellValue(ws.getWorksheet().get(i));
					cell = row.createCell(8);
					String referral = ws.getGenes().get(i);
					if(referral.equalsIgnoreCase("Myeloid NGS Panel")){
						referral = "Myeloid";
					}
					cell.setCellValue(myeloidPipeline + ";referral=" + referral);
				}

			}
			rowNum += 1;
		}

		if(select.equalsIgnoreCase("CRUK")){
			save(workbook, "", "CRUK");
		}else if(select.equalsIgnoreCase("ANALYSIS")){
			save(workbook, "analysis", "CRUK");
		}else if(select.equalsIgnoreCase("TAM")){
			save(workbook, "", "TAM");
		}else if(select.equalsIgnoreCase("MYELOID")){
			save(workbook, "", "myeloid");
		}

	}


	/**
	 * 
	 * @param ws The worksheet object
	 * @param index The indexes selected by the user
	 * @param select String to denote normal sample sheet or analysis sample sheet output
	 * @param rowNum The rownumber in excel to start inputting data on
	 * @param file Filepath string for file save location
	 * @throws IOException Thrown if file cannot be saved
	 */
	private void exportTrusight(Worksheet ws, ArrayList<Index> index, String select, int rowNum, String file) throws IOException{
		FileInputStream fileIn = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(fileIn);
		HSSFSheet worksheet = workbook.getSheet("Sheet1");
		HSSFRow row = worksheet.getRow(2);
		HSSFCell cell = row.createCell(1);
		cell.setCellValue(ws.getUser().get(0) + "-NHS");

		row = worksheet.getRow(3);
		cell = row.createCell(1);
		cell.setCellValue(ws.getWorksheet().get(0));
		worksheetName = (ws.getWorksheet().get(0));


		for (int i = 0; i < ws.getLabNo().size(); i++) {
			if(ws.getLabNo().get(i) != null){
				row = worksheet.getRow(rowNum);
				cell = row.createCell(0);
				cell.setCellValue(ws.getLabNo().get(i));
				cell = row.createCell(1);
				cell.setCellValue(ws.getWorksheet().get(i));
				// Write out FH index set
				if(select.equalsIgnoreCase("FH")) {
					FHIndexes fhi = new FHIndexes();
					String selected = index.get(0).getIndexSelect();
					int fhind = 404; // Set to high number so this will break if the correct assignment fails
					if(selected.equals("FH1to24")) {
						int offset = 1;
						fhind = offset + i;
					} else if(selected.equals("FH25to48")){
						int offset = 25;
						fhind = offset + i;
					}
					String fhIndNum = Integer.toString(fhind);
					cell = row.createCell(3);
					cell.setCellValue(fhIndNum);
					String fhInd = fhi.getFhIndices().get(fhIndNum);
					cell = row.createCell(4);
					cell.setCellValue(fhInd);
				}

				cell = row.createCell(8);
				String sex;

				// Put sexes in ped file format
				if (ws.getSexes().get(i) != null) {
					if (ws.getSexes().get(i).equals("M")) {
						sex = "1";
					} else if (ws.getSexes().get(i).equals("F")) {
						sex = "2";
					} else {
						sex = "0"; // Sex is not known
					}
				} else {
					sex = "0";
				}

				if(select.equalsIgnoreCase("TRUSIGHT")){
					cell.setCellValue(trusightPipeline + ";sex=" + sex);
				}else if(select.equalsIgnoreCase("TRUSIGHTONE")){
					cell.setCellValue(trusightOnePipeline + ";sex=" + sex);
				}else if(select.equalsIgnoreCase("FH")){
					cell.setCellValue(fhPipeline + ";sex=" + sex);
				}
			}
			rowNum += 1;
		}
		
		if(select.equalsIgnoreCase("TRUSIGHT")){
			rowNum = truRow;
		}else if(select.equalsIgnoreCase("TRUSIGHTONE")){
			rowNum = truOneRow;
		}else if (select.equalsIgnoreCase("FH")) {
			rowNum = fhRow;
		}
		/*
		for (int i = 0; i < ws.getComments().size(); i++) {
			if(ws.getComments().get(i) != null){
				row = worksheet.getRow(rowNum);
				cell = row.createCell(7);
				cell.setCellValue(ws.getComments().get(i));
			}
			rowNum += 1;
		}
		*/
		if(select.equalsIgnoreCase("TRUSIGHT")){
			save(workbook, "", "Trusight");
		}else if(select.equalsIgnoreCase("TRUSIGHTONE")){
			save(workbook, "", "Trusightone");
		}else if(select.equalsIgnoreCase("FH")){
			save(workbook, "", "FamHyp");
		}
	}	

	/**
	 * 
	 * @param ws The worksheet object
	 * @param index The indexes selected by the user
	 * @param select String to denote normal sample sheet or analysis sample sheet output
	 * @param rowNum The rownumber in excel to start inputting data on
	 * @param file Filepath string for file save location
	 * @throws IOException Thrown if file cannot be saved
	 */
	private void exportWCB(Worksheet ws, ArrayList<Index> index, String select, int rowNum, String file) throws IOException {
		FileInputStream fileIn = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(fileIn);
		HSSFSheet worksheet = workbook.getSheet("Sheet1");
		HSSFRow row = worksheet.getRow(2);
		HSSFCell cell = row.createCell(1);
		cell.setCellValue(ws.getUser().get(0) + "-NHS");

		row = worksheet.getRow(3);
		cell = row.createCell(1);
		cell.setCellValue(ws.getWorksheet().get(0));
		worksheetName = (ws.getWorksheet().get(0));

		for (int i = 0; i < ws.getLabNo().size(); i++) {
			if(ws.getLabNo().get(i) != null){
				row = worksheet.getRow(rowNum);
				cell = row.createCell(0);
				cell.setCellValue(ws.getLabNo().get(i));
				cell = row.createCell(1);
				cell.setCellValue(ws.getWorksheet().get(i));

				// Write out pipelines for NTCs
				if(ws.getLabNo().get(i).matches("(?i:.*NTC.*WCB.*)")){ //.equalsIgnoreCase("NTC-WCB")){
					cell = row.createCell(6);
					cell.setCellValue(wcbPipeline  + ";referral=" + ws.getGenes().get(i));
				}else if(ws.getLabNo().get(i).matches("(?i:.*NTC.*FOCUS4.*)") || ws.getLabNo().get(i).matches("(?i:.*NTC.*GIST.*)")){ //.equalsIgnoreCase("NTC-GIST")){
					cell = row.createCell(6);
					cell.setCellValue(focus4Pipeline  + ";referral=" + ws.getGenes().get(i));
				}else if(ws.getLabNo().get(i).matches("(?i:.*NTC.*BRCA.*)")){ //.equalsIgnoreCase("NTC-BRCA")){
					cell = row.createCell(6);
					cell.setCellValue(brcaPipeline  + ";referral=" + ws.getGenes().get(i));
				}else if(ws.getLabNo().get(i).matches("(?i:.*NTC.*CRM.*)")){ //.equalsIgnoreCase("NTC-BRCA")){
					cell = row.createCell(6);
					cell.setCellValue(pancrmPipeline  + ";referral=" + ws.getGenes().get(i));
				}
			}
			rowNum += 1;
		}
		
		rowNum = wcbRow;
		// Write out pipeline into description field for samples
		for (int i = 0; i < ws.getComments().size(); i++) {
			row = worksheet.getRow(rowNum);
			cell = row.createCell(6);
			if (ws.getComments().get(i) == null) {
				//Comments are null for pan referrals
				//Note that equalsIgnoreCase is not null safe and if ws.getGenes().get(i) is null this will throw an exception
				if (ws.getGenes().get(i).equalsIgnoreCase("Breast")
						|| ws.getGenes().get(i).equalsIgnoreCase("Colorectal")
						|| ws.getGenes().get(i).equalsIgnoreCase("GIST")
						|| ws.getGenes().get(i).equalsIgnoreCase("Glioma")
						|| ws.getGenes().get(i).equalsIgnoreCase("HeadAndNeck")
						|| ws.getGenes().get(i).equalsIgnoreCase("Lung")
						|| ws.getGenes().get(i).equalsIgnoreCase("Melanoma")
						|| ws.getGenes().get(i).equalsIgnoreCase("Ovarian")
						|| ws.getGenes().get(i).equalsIgnoreCase("Prostate")
						|| ws.getGenes().get(i).equalsIgnoreCase("Thyroid")
						|| ws.getGenes().get(i).equalsIgnoreCase("Tumour")){
					cell.setCellValue(pancrmPipeline + ";referral=" + ws.getGenes().get(i));
				}
				// Removed as per request from Hood 08/01/2017
				// Rhys could you please amend the macro so that if a sample has nothing in the 'comments' box - no analysis pipeline is assigned to it.
				// This would make it easier for something reviewing the samplesheet to spot that something is missing in SHIRE.
				//cell.setCellValue(focus4Pipeline);
			}else if (ws.getComments().get(i).equalsIgnoreCase("FOCUS4")
					|| ws.getComments().get(i).equalsIgnoreCase("FOCUS 4")
					|| ws.getComments().get(i).equalsIgnoreCase("GIST")){
				cell.setCellValue(focus4Pipeline + ";referral=" + ws.getGenes().get(i));
			} else if (ws.getComments().get(i).equalsIgnoreCase("WCB")) {
				cell.setCellValue(wcbPipeline + ";referral=" + ws.getGenes().get(i));
			} else if (ws.getComments().get(i).equalsIgnoreCase("BRCA")){
				cell.setCellValue(brcaPipeline + ";referral=" + ws.getGenes().get(i));
			}
			rowNum += 1;
		}

		save(workbook, "", "WCB");
	}

	private void exportPanCancer(Worksheet ws, ArrayList<Index> index, String select, int rowNum, String file) throws IOException {
		FileInputStream fileIn = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(fileIn);
		HSSFSheet worksheet = workbook.getSheet("Sheet1");
		HSSFRow row = worksheet.getRow(2);
		HSSFCell cell = row.createCell(1);
		cell.setCellValue(ws.getUser().get(0) + "-NHS");

		row = worksheet.getRow(3);
		cell = row.createCell(1);
		cell.setCellValue(ws.getWorksheet().get(0));
		worksheetName = ws.getWorksheet().get(0);

		for (int i = 0; i < ws.getLabNo().size(); i++) {
			if(ws.getLabNo().get(i) != null) {
				row = worksheet.getRow(rowNum);
				cell = row.createCell(0);
				cell.setCellValue(ws.getLabNo().get(i));
				cell = row.createCell(1);
				cell.setCellValue(ws.getWorksheet().get(i));

				if (!ws.getPanFirstIndex().isEmpty() && !ws.getPanSecondIndex().isEmpty()) {
					//Write out indexes to sample sheet
					cell = row.createCell(3);
					cell.setCellValue(ws.getPanIndexId().get(i)); //pan index name
					cell = row.createCell(4);
					cell.setCellValue(ws.getPanFirstIndex().get(i)); //first pan index
					cell = row.createCell(5);
					cell.setCellValue(ws.getPanIndexId().get(i)); //pan index name
					cell = row.createCell(6);
					cell.setCellValue(ws.getPanSecondIndex().get(i)); //second pan index
				}

				cell = row.createCell(8);

				String sex;

				// Put sexes in ped file format
				if (ws.getSexes().get(i) != null) {
					if (ws.getSexes().get(i).equals("M")) {
						sex = "1";
					} else if (ws.getSexes().get(i).equals("F")) {
						sex = "2";
					} else {
						sex = "0"; // Sex is not known
					}
				} else {
					sex = "0";
				}

				cell.setCellValue(panCancerPipeline + ";referral=" + ws.getGenes().get(i) + ";sex=" + sex);

			}

			rowNum += 1;

		}

			save(workbook, "", "pancancer");

	}
	
	/**
	 * 
	 * @param worksheets The worksheet object
	 * @param index The indexes selected by the user
	 * @param select String to denote normal sample sheet or analysis sample sheet output
	 * @param rowNum The rownumber in excel to start inputting data on
	 * @param file Filepath string for file save location
	 * @throws IOException Thrown if file cannot be saved
	 */
	private void exportCombined(ArrayList<Worksheet> worksheets, ArrayList<Index> index, String select, int rowNum, String file) throws IOException {
		FileInputStream fileIn = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(fileIn);
		HSSFSheet worksheet = workbook.getSheet("Sheet1");
		// to skip previous filled rows from previous worksheet
		int skip = 0;
		// to count if a worksheet has already been iterated through
		int count = 0;
		// to count amount of actual samples
		int amount = 0;
		
		// iterate over worksheets array of worksheets
		for (Worksheet ws : worksheets) {
			
			// Only if a worksheet has already been used.
			if(count > 0){
				// amount to skip in next iteration
				skip = amount;
				rowNum = 14;
			}
			
			HSSFRow row = worksheet.getRow(2);
			HSSFCell cell = row.createCell(1);
			cell.setCellValue(ws.getUser().get(0) + "-NHS");

			row = worksheet.getRow(3);
			cell = row.createCell(1);
			if(count >0){
				worksheetName = worksheetName + "_" + (ws.getWorksheet().get(0));
				cell.setCellValue(worksheetName);
			}else{
				worksheetName = (ws.getWorksheet().get(0));
				cell.setCellValue(worksheetName);
			}


			for (int i = 0; i < ws.getLabNo().size(); i++) {
				if(ws.getLabNo().get(i) != null){
					//Row number + skip amount
					row = worksheet.getRow(rowNum + skip);
					cell = row.createCell(0);
					cell.setCellValue(ws.getLabNo().get(i));
					cell = row.createCell(1);
					cell.setCellValue(ws.getWorksheet().get(i));
					if(ws.getLabNo().get(i).matches("(?i:.*NTC.*WCB.*)")){ //.equalsIgnoreCase("NTC-WCB")){
						cell = row.createCell(6);
						cell.setCellValue(wcbPipeline  + ";referral=" + ws.getGenes().get(i));
					}else if(ws.getLabNo().get(i).matches("(?i:.*NTC.*FOCUS4.*)") || ws.getLabNo().get(i).matches("(?i:.*NTC.*GIST.*)")){ //.equalsIgnoreCase("NTC-GIST")){
						cell = row.createCell(6);
						cell.setCellValue(focus4Pipeline  + ";referral=" + ws.getGenes().get(i));
					}else if(ws.getLabNo().get(i).matches("(?i:.*NTC.*BRCA.*)")){ //equalsIgnoreCase("NTC-BRCA")){
						cell = row.createCell(6);
						cell.setCellValue(brcaPipeline  + ";referral=" + ws.getGenes().get(i));
					}else if(ws.getLabNo().get(i).matches("(?i:.*NTC.*TAM.*)")){ //.equalsIgnoreCase("NTC-TAM")){
						cell = row.createCell(6);
						cell.setCellValue(tamPipeline + ";referral=" + ws.getGenes().get(i));
					}else if(ws.getLabNo().get(i).matches("(?i:.*NTC.*CRM.*)")){ //.equalsIgnoreCase("NTC-BRCA")){
						cell = row.createCell(6);
						cell.setCellValue(focus4Pipeline + ";referral=" + ws.getGenes().get(i));
					}
					amount++;
				}
				rowNum += 1;
			}
			
			rowNum = 14 + skip;
			for (int i = 0; i < ws.getComments().size(); i++) {
				row = worksheet.getRow(rowNum);
				cell = row.createCell(6);
				if (ws.getComments().get(i) == null) {
					//Comments are null for pan referrals
					//Note that equalsIgnoreCase is not null safe and if ws.getGenes().get(i) is null this will throw an exception
					if (ws.getGenes().get(i).equalsIgnoreCase("Breast")
							|| ws.getGenes().get(i).equalsIgnoreCase("Colorectal")
							|| ws.getGenes().get(i).equalsIgnoreCase("GIST")
							|| ws.getGenes().get(i).equalsIgnoreCase("Glioma")
							|| ws.getGenes().get(i).equalsIgnoreCase("HeadAndNeck")
							|| ws.getGenes().get(i).equalsIgnoreCase("Lung")
							|| ws.getGenes().get(i).equalsIgnoreCase("Melanoma")
							|| ws.getGenes().get(i).equalsIgnoreCase("Ovarian")
							|| ws.getGenes().get(i).equalsIgnoreCase("Prostate")
							|| ws.getGenes().get(i).equalsIgnoreCase("Thyroid")
							|| ws.getGenes().get(i).equalsIgnoreCase("Tumour")){
						cell.setCellValue(pancrmPipeline + ";referral=" + ws.getGenes().get(i));
					}
					// Removed as per request from Hood 08/01/2017
					// Rhys could you please amend the macro so that if a sample has nothing in the 'comments' box - no analysis pipeline is assigned to it.
					// This would make it easier for something reviewing the samplesheet to spot that something is missing in SHIRE.
					//cell.setCellValue(focus4Pipeline);
				} else if (ws.getComments().get(i).equalsIgnoreCase("FOCUS4")
						|| ws.getComments().get(i).equalsIgnoreCase("FOCUS 4")
						|| ws.getComments().get(i).equalsIgnoreCase("GIST")){
					cell.setCellValue(focus4Pipeline + ";referral=" + ws.getGenes().get(i));
				} else if (ws.getComments().get(i).equalsIgnoreCase("WCB")) {
					cell.setCellValue(wcbPipeline + ";referral=" + ws.getGenes().get(i));
				} else if (ws.getComments().get(i).equalsIgnoreCase("BRCA")){
					cell.setCellValue(brcaPipeline + ";referral=" + ws.getGenes().get(i));
				} else if (ws.getComments().get(i).equalsIgnoreCase("TAM")){
					cell.setCellValue(tamPipeline + ";referral=" + ws.getGenes().get(i));
				} else if (ws.getPanel().get(i).equals("PanCancerNGS panel")){
					cell.setCellValue(pancrmPipeline + ";referral=" + ws.getGenes().get(i));
				}
				rowNum += 1;
			}
			// add to count when a worksheet is completed
			count++;
		}
		save(workbook, "", "WCB");
	}
}