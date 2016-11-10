package hipster.view;

import javax.swing.*;
import hipster.controller.HipsterController;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HipsterPanel extends JPanel
{
	private HipsterController baseController;
	private JButton myButton;
	private JComboBox dropDown;
	private JLabel wordsLabel;
	private SpringLayout baseLayout;
	
	public HipsterPanel(HipsterController baseController)
	{
		super();
		this.baseController = baseController;
		myButton = new JButton("Click here!!");
		wordsLabel = new JLabel("such words!");
		baseLayout = new SpringLayout();
		dropDown = new JComboBox(baseController.getWords());
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.ORANGE);
		this.add(myButton);
		this.add(wordsLabel);
		this.add(dropDown);
		
	}
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, wordsLabel, 176, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, wordsLabel, -69, SpringLayout.NORTH, myButton);
		baseLayout.putConstraint(SpringLayout.WEST, myButton, 166, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, myButton, -111, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, dropDown, 115, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, dropDown, 77, SpringLayout.WEST, this);
		
	}
	private void setupListeners()
	{
		dropDown.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				String selectedText = baseController.getWords()[dropDown.getSelectedIndex()];
				wordsLabel.setText(selectedText);
			}
		});
	}
}
