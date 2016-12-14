package lettercraze.view;
import javax.swing.JPanel;
import java.awt.BorderLayout;
/**
 * MainView is the veiw used to hold the application's views
 * @author Everett
 *
 */
public class MainView extends DefaultJFrame{
	/**
	 * Constructor for MainView intializes the view
	 */
	public MainView() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4944248036650955589L;

}
