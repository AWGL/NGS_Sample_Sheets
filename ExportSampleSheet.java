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
	private int crukRow;
	//private int crukAnRow;
	private int truRow;
	private int truOneRow;
	private int tamRow;
	private int wcbRow;
	private int myeloidRow;
	
	public ExportSampleSheet() {
		properties();
		filepath = "";
		crukRow = 17;
		//crukAnRow = 28;
		truRow = 14;
		truOneRow = 17;
		tamRow = 14;
		wcbRow = 14;
		myeloidRow = 17;
	}

	/**
	 * 
	 * @param ws The worksheet object
	 * @param index The indexes selected by the user
	 * @param test The test specified on the worksheet
	 * @throws IOException Throws exception if cannot save output file
	 */
	public void selectExport(Worksheet ws, ArrayList<Index> index, String test) throws IOException{
		if(test.equalsIgnoreCase("NEXTERA NGS")){
			// OLD SINGLE INDEX
			//exportCRUKTAM(ws, index, "CRUK", crukRow, "Y:\\samplesheet-templates\\CRUK-SeqOnly.xls");
			exportCRUKTAMMye(ws, index, "CRUK", crukRow, "Y:\\samplesheet-templates\\CRUK-SeqOnly-DualIndex.xls");
			// ANALYSIS SHEET NO LONGER REQUIRED
			//exportCRUKTAM(ws, index, "ANALYSIS", crukAnRow, "Y:\\samplesheet-templates\\CRUK-analysis.xls");
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
		}else if(test.equalsIgnoreCase("haem NGS")){
			exportCRUKTAMMye(ws, index, "MYELOID", myeloidRow, "Y:\\samplesheet-templates\\Myeloid.xls");
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
	private void exportCRUKTAMMye(Worksheet ws, ArrayList<Index> index, String select, int rowNum, String file) throws IOException {
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
		if(select.equalsIgnoreCase("CRUK") || select.equalsIgnoreCase("ANALYSIS")){
			row = worksheet.getRow(4);
			cell = row.createCell(1);
			cell.setCellValue(ws.getUpdateDate().get(0));
		}

		for (int i = 0; i < ws.getLabNo().size(); i++) {
			if(ws.getLabNo().get(i) != null){
				row = worksheet.getRow(rowNum);
				cell = row.createCell(0);
				cell.setCellValue(ws.getLabNo().get(i));
				cell = row.createCell(1);
				if(select.equalsIgnoreCase("CRUK") || select.equalsIgnoreCase("ANALYSIS")){
					//SPECIFIC TO CRUK
					cell.setCellValue(ws.getLabNo().get(i));
					cell = row.createCell(2);
					cell.setCellValue(ws.getWorksheet().get(i));
					
					// DUAL INDEXES FOR CRUK
					for (Index ind : index) {
						 //INDEX NAME
						cell = row.createCell(6);
						if(ind.getIndexSelect().toString().equalsIgnoreCase(ind.getE501().toString())){
							cell.setCellValue("E501");
						}else if(ind.getIndexSelect().toString().equalsIgnoreCase(ind.getE502().toString())){
							cell.setCellValue("E502");
						}else if(ind.getIndexSelect().toString().equalsIgnoreCase(ind.getE503().toString())){
							cell.setCellValue("E503");
						}else if(ind.getIndexSelect().toString().equalsIgnoreCase(ind.getE504().toString())){
							cell.setCellValue("E504");
						}else if(ind.getIndexSelect().toString().equalsIgnoreCase(ind.getE505().toString())){
							cell.setCellValue("E505");
						}else if(ind.getIndexSelect().toString().equalsIgnoreCase(ind.getE506().toString())){
							cell.setCellValue("E506");
						}else if(ind.getIndexSelect().toString().equalsIgnoreCase(ind.getE517().toString())){
							cell.setCellValue("E517");
						}
						 //INDEX BASES
						cell = row.createCell(7);
						cell.setCellValue(ind.getIndexSelect().toString());
					}

					// SPECIFIC TO CRUK
					cell = row.createCell(9);
					cell.setCellValue(crukPipeline);

				}else if(select.equalsIgnoreCase("TAM")){
					// SPECIFIC TO TAM
					cell.setCellValue(ws.getWorksheet().get(i));
					cell = row.createCell(6);
					cell.setCellValue(tamPipeline);

				}else if(select.equalsIgnoreCase("MYELOID")){
					// SPECIFIC TO Myeloid
					cell.setCellValue(ws.getWorksheet().get(i));
					cell = row.createCell(8);
					cell.setCellValue(myeloidPipeline);
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
				}
			}
			rowNum += 1;
		}
		
		if(select.equalsIgnoreCase("TRUSIGHT")){
			rowNum = truRow;
		}else if(select.equalsIgnoreCase("TRUSIGHTONE")){
			rowNum = truOneRow;
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
				if(ws.getLabNo().get(i).equalsIgnoreCase("NTC-WCB")){
					cell = row.createCell(6);
					cell.setCellValue(wcbPipeline);
				}else if(ws.getLabNo().get(i).equalsIgnoreCase("NTC-FOCUS4") || ws.getLabNo().get(i).equalsIgnoreCase("NTC-GIST")){
					cell = row.createCell(6);
					cell.setCellValue(focus4Pipeline);
				}else if(ws.getLabNo().get(i).equalsIgnoreCase("NTC-BRCA")){
					cell = row.createCell(6);
					cell.setCellValue(brcaPipeline);
				}
			}
			rowNum += 1;
		}
		
		rowNum = 14;
		for (int i = 0; i < ws.getComments().size(); i++) {
			row = worksheet.getRow(rowNum);
			cell = row.createCell(6);
			if (ws.getComments().get(i) == null){
				// Removed as per request from Hood 08/01/2017
				// Rhys could you please amend the macro so that if a sample has nothing in the 'comments' box - no analysis pipeline is assigned to it.
				// This would make it easier for something reviewing the samplesheet to spot that something is missing in SHIRE. 
				
				//cell.setCellValue(focus4Pipeline);
			}else if(ws.getComments().get(i).equalsIgnoreCase("FOCUS4")
					|| ws.getComments().get(i).equalsIgnoreCase("FOCUS 4")
					|| ws.getComments().get(i).equalsIgnoreCase("GIST")){
				cell.setCellValue(focus4Pipeline);
			}else if(ws.getComments().get(i).equalsIgnoreCase("WCB")){
				cell.setCellValue(wcbPipeline);
			}else if(ws.getComments().get(i).equalsIgnoreCase("BRCA")){
				cell.setCellValue(brcaPipeline);
			}
			rowNum += 1;
		}

		save(workbook, "", "WCB");
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
					if(ws.getLabNo().get(i).equalsIgnoreCase("NTC-WCB")){
						cell = row.createCell(6);
						cell.setCellValue(wcbPipeline);
					}else if(ws.getLabNo().get(i).equalsIgnoreCase("NTC-FOCUS4") || ws.getLabNo().get(i).equalsIgnoreCase("NTC-GIST")){
						cell = row.createCell(6);
						cell.setCellValue(focus4Pipeline);
					}else if(ws.getLabNo().get(i).equalsIgnoreCase("NTC-BRCA")){
						cell = row.createCell(6);
						cell.setCellValue(brcaPipeline);
					}else if(ws.getLabNo().get(i).equalsIgnoreCase("NTC-TAM")){
						cell = row.createCell(6);
						cell.setCellValue(tamPipeline);
					}
					amount++;
				}
				rowNum += 1;
			}
			
			rowNum = 14 + skip;
			for (int i = 0; i < ws.getComments().size(); i++) {
				row = worksheet.getRow(rowNum);
				cell = row.createCell(6);
				if (ws.getComments().get(i) == null){
					// Removed as per request from Hood 08/01/2017
					// Rhys could you please amend the macro so that if a sample has nothing in the 'comments' box - no analysis pipeline is assigned to it.
					// This would make it easier for something reviewing the samplesheet to spot that something is missing in SHIRE. 
					
					//cell.setCellValue(focus4Pipeline);
				}else if(ws.getComments().get(i).equalsIgnoreCase("FOCUS4")
						|| ws.getComments().get(i).equalsIgnoreCase("FOCUS 4")
						|| ws.getComments().get(i).equalsIgnoreCase("GIST")){
					cell.setCellValue(focus4Pipeline);
				}else if(ws.getComments().get(i).equalsIgnoreCase("WCB")){
					cell.setCellValue(wcbPipeline);
				}else if(ws.getComments().get(i).equalsIgnoreCase("BRCA")){
					cell.setCellValue(brcaPipeline);
				}else if(ws.getComments().get(i).equalsIgnoreCase("TAM")){
					cell.setCellValue(tamPipeline);
				}
				rowNum += 1;
			}
			// add to count when a worksheet is completed
			count++;
		}
		save(workbook, "", "WCB");
	}
}