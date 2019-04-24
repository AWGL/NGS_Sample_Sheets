/**
 * 
 */
package nhs.cardiff.genetics.ngssamplesheets.gui;
import javax.mail.MessagingException;
import javax.swing.SwingUtilities;


/**
 * @author Rhys Cooper
 * @Date 17/02/2017
 * @version 1.4.3
 * 
 */
public class Main {

	/**
	 * 
	 * @param args
	 * @throws InterruptedException
	 * @throws MessagingException
	 */
	public static void main(String[] args) throws InterruptedException, MessagingException {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				@SuppressWarnings("unused")
				Controller control = new Controller();
			}
		});	
	}
}
