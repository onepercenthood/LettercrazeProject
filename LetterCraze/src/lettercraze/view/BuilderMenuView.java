package lettercraze.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lettercraze.BuilderApplication;
import lettercraze.controller.builder.CreateNewLevelController;
import lettercraze.controller.builder.OpenLevelSelecterController;
import lettercraze.model.Model;

import java.awt.Font;
import java.awt.Color;

/**
 * Allows the option of either loading a level or creating a new one. First Screen of builder
 * @author Everett
 *
 */
public class BuilderMenuView extends DefaultViewPanel{

	
	private static final long serialVersionUID = 4467150633130963753L;
	private JPanel cardLayoutPanel;
	private Model model;
	private BuilderApplication app;

	/**
	 * Constructor for the BuilderMenuView. Takes in the parent panel,
	 *  the model to be edited, and the parent builderApplication
	 * @param cardLayoutPanel as JPanel
	 * @param m as Model
	 * @param app as BuilderApplication
	 */
	public BuilderMenuView(JPanel cardLayoutPanel, Model m, BuilderApplication app) {
		setBackground(new Color(204, 255, 255));
		setLayout(null);
		
		this.cardLayoutPanel = cardLayoutPanel;
		this.model = m;
		this.app = app;
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(0, 0, 969, 600);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblLettercrazeBuilder = new JLabel("LetterCraze Builder");
		lblLettercrazeBuilder.setBounds(215, 177, 507, 73);
		lblLettercrazeBuilder.setFont(new Font("Tahoma", Font.PLAIN, 60));
		panel.add(lblLettercrazeBuilder);
		
		JButton btnNewButton = new JButton("Create New Level");
		btnNewButton.addMouseListener(new CreateNewLevelController(app, cardLayoutPanel, model));
		btnNewButton.setBounds(253, 319, 180, 53);
		panel.add(btnNewButton);
		
		JButton btnEditExistingLevel = new JButton("Edit Existing Level");
		btnEditExistingLevel.setBounds(499, 319, 180, 53);
		btnEditExistingLevel.addMouseListener(new OpenLevelSelecterController(cardLayoutPanel));
		panel.add(btnEditExistingLevel);
		
	}

	@Override
	public String getPanelName() {
		// TODO Auto-generated method stub
		return "BuilderMenuView";
	}
}