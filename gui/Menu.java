package nhs.cardiff.genetics.ngssamplesheets.gui;

import javax.swing.JCheckBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author Rhys Cooper and Sara Rey
 * @Date 13/06/2019
 * @version 1.4.6
 * 
 */
public class Menu {
	
	private JMenu wsNo = new JMenu();
	private JMenu options = new JMenu();
	private JMenu combine = new JMenu();
	private JMenu panIndices = new JMenu();
	JMenuItem ws1 = new JMenuItem();
	JMenuItem ws2 = new JMenuItem();
	JMenuItem ws3 = new JMenuItem();
	JMenuItem ws4 = new JMenuItem();
	JCheckBox combineYes = new JCheckBox("Yes");
	JCheckBox combineNo = new JCheckBox("No");
	JCheckBox panYes = new JCheckBox("Yes");
	JCheckBox panNo = new JCheckBox("No");
	JMenuBar menuBar = new JMenuBar();

	public Menu(){
		// WORKSHEET SUBMENU
		wsNo = new JMenu("Worksheets");
		ws1 = new JMenuItem("1 Worksheet");
		ws2 = new JMenuItem("2 Worksheets");
		ws3 = new JMenuItem("3 Worksheets");
		ws4 = new JMenuItem("4 Worksheets");
		wsNo.add(ws1);
		wsNo.add(ws2);
		wsNo.add(ws3);
		wsNo.add(ws4);	
		
		// COMBINE SUBMENU
		combine = new JMenu("Combine");
		combine.add(combineYes);
		combine.add(combineNo);

		// PANCANCER SUBMENU
		panIndices = new JMenu("PanIndices");
		panIndices.add(panYes);
		panIndices.add(panNo);

		// MAIN MENU ITEM
		options = new JMenu("Options");
		options.add(wsNo);
		options.add(combine);
		options.add(panIndices);
		
		// MAIN MENU BAR
		menuBar.add(options);	
	}
}
