package lettercraze.controller.builder;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import lettercraze.BuilderApplication;
import lettercraze.model.Model;
import lettercraze.view.BuilderPuzzlePanelView;

public class SaveLevelController extends MouseAdapter{
	
	BuilderApplication app;
	
	JPanel cardLayoutPanel;
	
	CardLayout cardLayout;
	
	Model model;

	public SaveLevelController(BuilderApplication app, JPanel cardLayoutPanel, Model model) {
		super();
		this.app = app;
		this.cardLayoutPanel = cardLayoutPanel;
		this.cardLayout = (CardLayout) cardLayoutPanel.getLayout();
		this.model = model;
	}
	
	public void mousePressed(MouseEvent me){
		boolean shape[][] = {{true,true,true,true,true,true},{true,true,true,true,true,true},{true,true,true,true,true,true},{true,true,true,true,true,true},{true,true,true,true,true,true},{true,true,true,true,true,true}};
		CardLayout cl = (CardLayout) app.getBuilderView().getPnlLevelSwitch().getLayout();
		BuilderPuzzlePanelView test = (BuilderPuzzlePanelView) app.getBuilderView().getPnlLevelSwitch().getComponent(0);
		System.out.println(test.makeLevel(shape, 1));
	}

}
