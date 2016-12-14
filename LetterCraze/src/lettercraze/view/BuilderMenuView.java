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
import javax.swing.SwingConstants;

public class BuilderMenuView extends DefaultViewPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4467150633130963753L;
	private JPanel cardLayoutPanel;
	private Model model;
	private BuilderApplication app;

	public BuilderMenuView(JPanel cardLayoutPanel, Model m, BuilderApplication app) {
		setBackground(new Color(204, 255, 255));
		setLayout(null);
		
		this.cardLayoutPanel = cardLayoutPanel;
		this.model = m;
		this.app = app;
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 255, 255));
		panel.setBounds(0, 0, 969, 616);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblLettercrazeBuilder = new JLabel("LetterCraze Builder");
		lblLettercrazeBuilder.setHorizontalAlignment(SwingConstants.CENTER);
		lblLettercrazeBuilder.setBounds(234, 176, 507, 73);
		lblLettercrazeBuilder.setFont(new Font("Tahoma", Font.PLAIN, 60));
		panel.add(lblLettercrazeBuilder);
		
		JButton btnNewButton = new JButton("Create New Level");
		btnNewButton.setBackground(new Color(153, 204, 255));
		btnNewButton.addMouseListener(new CreateNewLevelController(app, cardLayoutPanel, model));
		btnNewButton.setBounds(281, 319, 180, 53);
		panel.add(btnNewButton);
		
		JButton btnEditExistingLevel = new JButton("Edit Existing Level");
		btnEditExistingLevel.setBackground(new Color(153, 204, 255));
		btnEditExistingLevel.setBounds(509, 319, 180, 53);
		btnEditExistingLevel.addMouseListener(new OpenLevelSelecterController(cardLayoutPanel));
		panel.add(btnEditExistingLevel);
		
	}

	@Override
	public String getPanelName() {
		// TODO Auto-generated method stub
		return "BuilderMenuView";
	}
}