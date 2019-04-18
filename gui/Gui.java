/**
 * 
 */
package nhs.cardiff.genetics.ngssamplesheets.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 * @author Rhys Cooper & Sara Rey
 * @Date 14/08/2017
 * @version 1.4.3
 * 
 */
public class Gui extends Menu {
	
	private final String[] indexes = new String[] {"Default", "E501", "E502", "E503", "E504", "E505", "E506", "E517"};
	// comboHack string is used to set index select combobox defaults sizes
	private String comboHack = "aroundthis.";
	JLabel worksheetLabel = new JLabel();
	JLabel selectionsLabel = new JLabel();
	JSeparator sep = new JSeparator();
	JComboBox indexSelect1 = new JComboBox(indexes);
	JComboBox indexSelect2 = new JComboBox(indexes);
	JComboBox indexSelect3 = new JComboBox(indexes);
	JComboBox indexSelect4 = new JComboBox(indexes);
	JTextField inputField1 = new JTextField();
	JTextField inputField2 = new JTextField();
	JTextField inputField3 = new JTextField();
	JTextField inputField4 = new JTextField();
	JButton goButton = new JButton();
	JLabel infoField = new JLabel();
	
	public Gui(){
		
		//**************** FRAME ****************
		// CREATE FRAME
		JFrame frame = new JFrame("NGS Sample Sheet Generator - Version 1.4.3");
		frame.setJMenuBar(menuBar);
		// Add mainpanel which contains all subpanels
		frame.add(mainPanel());
		frame.setSize(500, 200);
		frame.setDefaultCloseOperation(3);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * 
	 * @return Returns the mainPanel Component, mainPanel houses all other panels
	 */
	private Component mainPanel(){
		JPanel mainPanel = new JPanel();
		Dimension size = mainPanel.getPreferredSize();
		size.height = 200;
		size.width = 500;
		mainPanel.setPreferredSize(size);
		mainPanel.setBorder(BorderFactory.createTitledBorder(""));
		GridBagConstraints gbc = new GridBagConstraints();
		mainPanel.setLayout(new GridBagLayout());
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 1;
		gbc.weighty = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		mainPanel.add(infoPanel(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		mainPanel.add(indexPanel(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		mainPanel.add(entryPanel(), gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		mainPanel.add(goPanel(), gbc);
		
		return mainPanel;
	}
	
	/**
	 * 
	 * @return Returns the infoPanel Component, displays infomation to user
	 */
	private Component infoPanel(){
		
		JPanel infoPanel = new JPanel();
		Dimension size = infoPanel.getPreferredSize();
		size.height = 150;
		size.width = 500;
		infoPanel.setPreferredSize(size);
		GridBagConstraints gbc = new GridBagConstraints();
		infoPanel.setLayout(new GridBagLayout());
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 1;
		gbc.weighty = 1;
	
		// WORKSHEET LABEL
		worksheetLabel = new JLabel("Select worksheets, select index, enter worksheet number, click go");
		gbc.gridx = 0;
		gbc.gridy = 0;
		infoPanel.add(worksheetLabel, gbc);
		
		// SELECTIONS LABEL
		selectionsLabel = new JLabel("");
		gbc.gridx = 0;
		gbc.gridy = 1;
		infoPanel.add(selectionsLabel, gbc);
		
		return infoPanel;	
	}
	
	/**
	 * 
	 * @return Returns the indexPanel Component, enabled user to select indexes to use
	 */
	private Component indexPanel(){
		
		JPanel indexPanel = new JPanel();
		Dimension size = indexPanel.getPreferredSize();
		size.height = 150;
		size.width = 500;
		indexPanel.setPreferredSize(size);
		GridBagConstraints gbc = new GridBagConstraints();
		indexPanel.setLayout(new GridBagLayout());
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 1;
		gbc.weighty = 1;

		indexSelect1.setVisible(false);
		indexSelect1.setPrototypeDisplayValue(comboHack);
		gbc.gridx = 0;
		gbc.gridy = 0;
		indexPanel.add(indexSelect1, gbc);
		
		indexSelect2.setVisible(false);
		indexSelect2.setPrototypeDisplayValue(comboHack);
		gbc.gridx = 1;
		gbc.gridy = 0;
		indexPanel.add(indexSelect2, gbc);
		
		indexSelect3.setVisible(false);
		indexSelect3.setPrototypeDisplayValue(comboHack);
		gbc.gridx = 2;
		gbc.gridy = 0;
		indexPanel.add(indexSelect3, gbc);
		
		indexSelect4.setVisible(false);
		indexSelect4.setPrototypeDisplayValue(comboHack);
		gbc.gridx = 3;
		gbc.gridy = 0;
		indexPanel.add(indexSelect4, gbc);	

		return indexPanel;
	}
	
	/**
	 * 
	 * @return Returns the entryPanel Component, enables user to enter worksheet details
	 */
	private Component entryPanel(){
		
		JPanel entryPanel = new JPanel();
		Dimension size = entryPanel.getPreferredSize();
		size.height = 150;
		size.width = 500;
		entryPanel.setPreferredSize(size);
		GridBagConstraints gbc = new GridBagConstraints();
		entryPanel.setLayout(new GridBagLayout());
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 1;
		gbc.weighty = 1;
		
		// INPUTFIELD 1
		inputField1 = new JTextField(8);
		inputField1.setMinimumSize(inputField1.getPreferredSize());
		inputField1.setVisible(false);
		inputField1.setToolTipText("All NGS Worksheets");
		gbc.gridx = 0;
		gbc.gridy = 0;
		entryPanel.add(inputField1, gbc);
		
		// INPUTFIELD 2
		inputField2 = new JTextField(8);
		inputField2.setMinimumSize(inputField2.getPreferredSize());
		inputField2.setVisible(false);
		inputField2.setToolTipText("All NGS Worksheets");
		gbc.gridx = 1;
		gbc.gridy = 0;
		entryPanel.add(inputField2, gbc);
		
		// INPUTFIELD 3
		inputField3 = new JTextField(8);
		inputField3.setMinimumSize(inputField3.getPreferredSize());
		inputField3.setVisible(false);
		inputField3.setToolTipText("All NGS Worksheets");
		gbc.gridx = 2;
		gbc.gridy = 0;
		entryPanel.add(inputField3, gbc);
		
		// INPUTFIELD 4
		inputField4 = new JTextField(8);
		inputField4.setMinimumSize(inputField4.getPreferredSize());
		inputField4.setVisible(false);
		inputField4.setToolTipText("All NGS Worksheets");
		gbc.gridx = 3;
		gbc.gridy = 0;
		entryPanel.add(inputField4, gbc);
		
		return entryPanel;
	}
	
	/**
	 * 
	 * @return Returns the goPanel Component, enables the user to start process and also displays some error messages
	 */
	private Component goPanel(){
		
		JPanel finalPanel = new JPanel();
		Dimension size = finalPanel.getPreferredSize();
		size.height = 150;
		size.width = 200;
		finalPanel.setPreferredSize(size);
		GridBagConstraints gbc = new GridBagConstraints();
		finalPanel.setLayout(new GridBagLayout());
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 1;
		gbc.weighty = 1;
		
		// GO BUTTON
		goButton = new JButton("Go");
		goButton.setVisible(true);
		gbc.gridx = 0;
		gbc.gridy = 0;
		finalPanel.add(goButton, gbc);

		// INFOFIELD
		infoField = new JLabel("Non shire worksheets and non-NGS worksheets will be rejected");
		infoField.setVisible(true);
		gbc.gridx = 0;
		gbc.gridy = 1;
		finalPanel.add(infoField, gbc);
		
		return finalPanel;		
	}
}
