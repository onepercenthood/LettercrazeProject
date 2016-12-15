package lettercraze.controller.builder;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import lettercraze.view.BuilderLevelSelecterView;

/**
 * This controller is responsible for opening an existing level when the user wishes to edit
 * an existing level.
 * 
 * @author ddeisadze
 *
 */
public class OpenLevelSelecterController extends MouseAdapter {
	
	/**the parent panel for switching views **/
	JPanel parent;
	
	/**the layout manager for switching views **/
	CardLayout cardLayout;
	
	/**
	 * The main constructor for this class
	 * 
	 * @param parent as the main panel from the BuilderApplication
	 */
	public OpenLevelSelecterController(JPanel parent) {
		this.parent = parent;
		this.cardLayout = (CardLayout) parent.getLayout();
	}
	
	/**
	 * MousePressed event to handle the main actionable method in this class
	 */
	public void mousePressed(MouseEvent me){
		System.out.println("Switching to menu view");
		BuilderLevelSelecterView selectView = new BuilderLevelSelecterView(parent);
		
		parent.add(selectView, selectView.getPanelName());
		cardLayout.show(parent, "BuilderLevelSelecter");
	}

}
