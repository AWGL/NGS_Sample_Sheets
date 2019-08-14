/**
 * 
 */
package nhs.cardiff.genetics.ngssamplesheets.gui;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

/**
 * @author Rhys Cooper
 * @Date 17/02/2017
 * @version 1.4.8
 * 
 */
public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private Gui inputPanel;

	/**
	 * CONSTRUCTOR
	 * @param title The title of the main window
	 */
	public MainFrame(String title) {
		super(title);	
		setLayout(new BorderLayout());
		inputPanel = new Gui();
		Container container = getContentPane();
		//container.add(inputPanel, "Center");
	}
}
