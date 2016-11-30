package lettercraze.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import lettercraze.BuilderApplication;
import lettercraze.controller.BuilderCreateNewLevelController;
import lettercraze.model.Model;

import java.awt.Font;

public class BuilderMenuView extends DefaultViewPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4467150633130963753L;
	private JPanel cardLayoutPanel;
	private Model model;
	private BuilderApplication app;

	public BuilderMenuView(JPanel cardLayoutPanel, Model m, BuilderApplication app) {
		setLayout(null);
		
		this.cardLayoutPanel = cardLayoutPanel;
		this.model = m;
		this.app = app;
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 800, 600);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblLettercrazeBuilder = new JLabel("LetterCraze Builder");
		lblLettercrazeBuilder.setBounds(141, 176, 507, 73);
		lblLettercrazeBuilder.setFont(new Font("Tahoma", Font.PLAIN, 60));
		panel.add(lblLettercrazeBuilder);
		
		JButton btnCreatNewLevel = new JButton("Creat New Level");
		btnCreatNewLevel.addMouseListener(new BuilderCreateNewLevelController(app, cardLayoutPanel, model));
		btnCreatNewLevel.setBounds(213, 319, 126, 53);
		panel.add(btnCreatNewLevel);
		
		JButton btnEditExistingLevel = new JButton("Edit Existing Level");
		btnEditExistingLevel.setBounds(412, 319, 126, 53);
		panel.add(btnEditExistingLevel);
		
	}

	@Override
	public String getPanelName() {
		// TODO Auto-generated method stub
		return "Builder Menu View";
	}
}