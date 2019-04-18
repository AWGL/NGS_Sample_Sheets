package nhs.cardiff.genetics.ngssamplesheets.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import nhs.cardiff.genetics.ngssamplesheets.ImportWorksheet;
import nhs.cardiff.genetics.ngssamplesheets.Index;

/**
 * @author Rhys Cooper
 * @Date 14/08/2017
 * @version 1.4.3
 * 
 */
public class Controller{

	private Gui g = new Gui();
	private ArrayList<String> input = new ArrayList<String>();
	private ArrayList<Index> indexArray = new ArrayList<Index>();
	private Boolean combine = false;
	Index index1 = new Index();
	Index index2 = new Index();
	Index index3 = new Index();
	Index index4 = new Index();
	private int selected;
	
	public Controller(){
		
		g.goButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.infoField.setText("");
				if(selected == 1){
					// 1 Worksheet
					input.add(g.inputField1.getText());
					indexArray.add(index1);
				}else if(selected == 2){
					// 2 Worksheets
					input.add(g.inputField1.getText());
					input.add(g.inputField2.getText());
					indexArray.add(index1);
					indexArray.add(index2);
				}else if(selected == 3){
					// 3 Worksheets
					input.add(g.inputField1.getText());
					input.add(g.inputField2.getText());
					input.add(g.inputField3.getText());
					indexArray.add(index1);
					indexArray.add(index2);
					indexArray.add(index3);
				}else if(selected == 4){
					// 4 Worksheets
					input.add(g.inputField1.getText());
					input.add(g.inputField2.getText());
					input.add(g.inputField3.getText());
					input.add(g.inputField4.getText());
					indexArray.add(index1);
					indexArray.add(index2);
					indexArray.add(index3);
					indexArray.add(index4);
				}
				ImportWorksheet worksheet = new ImportWorksheet();
				try {
					worksheet.process(input, indexArray, combine);
				} catch (Throwable e1) {
					g.infoField.setText(e1.toString().substring(21));
				}
			}
		});	
		
		
		//**************** WORKSHEET OPTIONS ****************
		g.ws1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// input fields
					g.inputField1.setVisible(true);
					g.inputField2.setVisible(false);
					g.inputField3.setVisible(false);
					g.inputField4.setVisible(false);
					//index select
					g.indexSelect1.setVisible(true);
					g.indexSelect2.setVisible(false);
					g.indexSelect3.setVisible(false);
					g.indexSelect4.setVisible(false);
					// Set all to default
					g.indexSelect1.setSelectedIndex(0);
					g.indexSelect2.setSelectedIndex(0);
					g.indexSelect3.setSelectedIndex(0);
					g.indexSelect4.setSelectedIndex(0);
					g.selectionsLabel.setText("1 Worksheet Selected");
					selected = 1;
				} catch (Exception localException) {
				}
			}
		});
		
		g.ws2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// input fields
					g.inputField1.setVisible(true);
					g.inputField2.setVisible(true);
					g.inputField3.setVisible(false);
					g.inputField4.setVisible(false);
					//index select
					g.indexSelect1.setVisible(true);
					g.indexSelect2.setVisible(true);
					g.indexSelect3.setVisible(false);
					g.indexSelect4.setVisible(false);
					// Set all to default
					g.indexSelect1.setSelectedIndex(0);
					g.indexSelect2.setSelectedIndex(0);
					g.indexSelect3.setSelectedIndex(0);
					g.indexSelect4.setSelectedIndex(0);
					g.selectionsLabel.setText("2 Worksheets Selected");
					selected = 2;
				} catch (Exception localException) {
				}
			}
		});
		
		g.ws3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// input fields
					g.inputField1.setVisible(true);
					g.inputField2.setVisible(true);
					g.inputField3.setVisible(true);
					g.inputField4.setVisible(false);
					//index select
					g.indexSelect1.setVisible(true);
					g.indexSelect2.setVisible(true);
					g.indexSelect3.setVisible(true);
					g.indexSelect4.setVisible(false);
					// Set all to default
					g.indexSelect1.setSelectedIndex(0);
					g.indexSelect2.setSelectedIndex(0);
					g.indexSelect3.setSelectedIndex(0);
					g.indexSelect4.setSelectedIndex(0);
					g.selectionsLabel.setText("3 Worksheets Selected");
					selected = 3;
				} catch (Exception localException) {
				}
			}
		});
		
		g.ws4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// input fields
					g.inputField1.setVisible(true);
					g.inputField2.setVisible(true);
					g.inputField3.setVisible(true);
					g.inputField4.setVisible(true);
					//index select
					g.indexSelect1.setVisible(true);
					g.indexSelect2.setVisible(true);
					g.indexSelect3.setVisible(true);
					g.indexSelect4.setVisible(true);
					// Set all to default
					g.indexSelect1.setSelectedIndex(0);
					g.indexSelect2.setSelectedIndex(0);
					g.indexSelect3.setSelectedIndex(0);
					g.indexSelect4.setSelectedIndex(0);
					g.selectionsLabel.setText("4 Worksheets Selected");
					selected = 4;
				} catch (Exception localException) {
				}
			}
		});
		
		
		//**************** COMBINE OPTIONS ****************
		g.combineYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(g.combineYes.isSelected()){
						g.worksheetLabel.setText("Combining worksheets");
						g.worksheetLabel.setForeground(Color.RED);
						g.combineNo.setSelected(false);
						combine = true;
					}
				} catch (Exception localException) {
				}
			}
		});
		
		g.combineNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(g.combineNo.isSelected()){
						g.worksheetLabel.setText("Not Combining Worksheets");
						g.worksheetLabel.setForeground(Color.GREEN);
						g.combineYes.setSelected(false);
						combine = false;
					}
				} catch (Exception localException) {
				}
			}
		});
		
		
		//**************** INDEX OPTIONS ****************
		g.indexSelect1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					indexSelect(g.indexSelect1, index1);
				} catch (Exception localException) {
				}
			}
		});
		
		g.indexSelect2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					indexSelect(g.indexSelect2, index2);
				} catch (Exception localException) {
				}
			}
		});
		
		g.indexSelect3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					indexSelect(g.indexSelect3, index3);
				} catch (Exception localException) {
				}
			}
		});
		
		g.indexSelect4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					indexSelect(g.indexSelect4, index4);
				} catch (Exception localException) {
				}
			}
		});	
	}

	/**
	 * 
	 * @param indexSelect the index selected by the user
	 * @param index index class containing index details
	 */
	private void indexSelect(JComboBox indexSelect, Index index){
		if(indexSelect.getSelectedItem().toString().equalsIgnoreCase("Default")){
			index.setIndexSelect("");
		}else if(indexSelect.getSelectedItem().toString().equalsIgnoreCase("E501")){
			index.setIndexSelect(index.getE501());
		}else if(indexSelect.getSelectedItem().toString().equalsIgnoreCase("E502")){
			index.setIndexSelect(index.getE502());
		}else if(indexSelect.getSelectedItem().toString().equalsIgnoreCase("E503")){
			index.setIndexSelect(index.getE503());
		}else if(indexSelect.getSelectedItem().toString().equalsIgnoreCase("E504")){
			index.setIndexSelect(index.getE504());
		}else if(indexSelect.getSelectedItem().toString().equalsIgnoreCase("E505")){
			index.setIndexSelect(index.getE505());
		}else if(indexSelect.getSelectedItem().toString().equalsIgnoreCase("E506")){
			index.setIndexSelect(index.getE506());
		}else if(indexSelect.getSelectedItem().toString().equalsIgnoreCase("E517")){
			index.setIndexSelect(index.getE517());
		}
	}
}
