package lettercraze.controller.builder;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import lettercraze.view.BuilderLevelSelecterView;

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
		BuilderLevelSelecterView selectView = new BuilderLevelSelecterView(parent);
		parent.add(selectView, selectView.getPanelName());
		cardLayout.show(parent, "BuilderLevelSelecter");
	}

}
