package lettercraze.controller.builder;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class OpenLevelSelecterController extends MouseAdapter {
	
	/**the parent panel for switching views **/
	JPanel parent;
	
	/**the layout manager for switching views **/
	CardLayout cardLayout;
	public OpenLevelSelecterController(JPanel parent) {
		this.parent = parent;
		this.cardLayout = (CardLayout) parent.getLayout();
	}
	
	public void mousePressed(MouseEvent me){
		System.out.println("Switching to menu view");
		cardLayout.show(parent, "BuilderLevelSelecter");
	}

}
