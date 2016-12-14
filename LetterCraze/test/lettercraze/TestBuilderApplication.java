package lettercraze;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import junit.framework.TestCase;
import lettercraze.controller.builder.BackToMenuController;
import lettercraze.controller.builder.CreateNewLevelController;
import lettercraze.controller.builder.ResetBoardSquaresController;
import lettercraze.controller.builder.SaveLevelController;
import lettercraze.view.BuilderPuzzlePanelView;
import lettercraze.view.DefaultJFrame;
import lettercraze.view.DefaultViewPanel;

public class TestBuilderApplication extends TestCase {
	
	private BuilderApplication ba;

	public TestBuilderApplication(){
		ba = new BuilderApplication();
	}
	
	public void testBuilderApplication(){
		BuilderApplication ba = new BuilderApplication();
	}
	
	public void testCreateNewLevel(){
		CreateNewLevelController create = new CreateNewLevelController(ba, ba.getPanelMain(), ba.model);
				
		create.mousePressed(null);
		
		CardLayout cdL = (CardLayout) ba.getPanelMain().getLayout();
		
		DefaultViewPanel card = null;
		for (Component comp : ba.getPanelMain().getComponents()) {
		    if (comp.isVisible() == true) {
		    	System.out.println("visible");
		        card =  (DefaultViewPanel) comp;
		    }
		}
				
		assertEquals(card.getPanelName(), "BuilderView");
		
		MouseEvent me = new MouseEvent(ba.getPanelMain(), MouseEvent.MOUSE_PRESSED, 
				System.currentTimeMillis(), 0, 
				200, 200, 0, false);
		
		
		new ResetBoardSquaresController(ba.builderView, ba.model).mousePressed(me);
		
		ba.builderView.getComboBox().setSelectedItem("Puzzle");
		
		BuilderPuzzlePanelView bPV = (BuilderPuzzlePanelView) ba.builderView.getPnlLevelSwitch().getComponent(0);
		
		bPV.getTxtfldOneStar().setText("10");
		bPV.getTxtfldTwoStar().setText("20");
		bPV.getTxtfldThreeStar().setText("30");
		bPV.getTxtfldmaxWords().setText("10");
		
		assertEquals(bPV.getTxtfldOneStar().getText(), "10");
		assertEquals(bPV.getTxtfldTwoStar().getText(), "20");
		assertEquals(bPV.getTxtfldThreeStar().getText(), "30");
		assertEquals(bPV.getTxtfldmaxWords().getText(), "10");

		
		new SaveLevelController(ba.builderView, ba.getPanelMain(), ba.model).mousePressed(me);;

		
	}
	


}
