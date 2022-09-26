package com.Aurionpro.test;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class TicTacToeUserNameUI extends JFrame implements ActionListener {
	JLabel lblPlayer1;
	JLabel lblPlayer2;
	JTextField txtPlayer1Name, txtPlayer2Name;
	JButton btnStart;
	JFrame f = new JFrame("Tic-Tac-Toe");

	public TicTacToeUserNameUI() throws HeadlessException {
		
		JPanel panel = new JPanel();
		panel.setBounds(40, 40, 200, 300);

		this.lblPlayer1 = new JLabel("Player 1 name :");
		lblPlayer1.setBounds(50, 100, 100, 40);

		txtPlayer1Name = new JTextField(15);
		txtPlayer1Name.setBounds(170, 100, 200, 40);

		this.lblPlayer2 = new JLabel("Player 1 name :");
		lblPlayer1.setBounds(50, 140, 100, 40);

		txtPlayer2Name = new JTextField(15);
		txtPlayer2Name.setBounds(170, 140, 200, 40);

		btnStart = new JButton("Start Game");

		btnStart.setBounds(100, 350, 200, 40);

		panel.add(lblPlayer1);
		panel.add(txtPlayer1Name);
		panel.add(lblPlayer2);
		panel.add(txtPlayer2Name);
		panel.add(btnStart);

		f.add(panel);
		btnStart.addActionListener(this);

		f.setSize(300, 400);
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ae) // pass action listener as a parameter
	{
		String player1 = txtPlayer1Name.getText(); 
		String player2 = txtPlayer2Name.getText();
		GameUI page = new GameUI(player1,player2);
		//f.setVisible(false);
		f.dispose();
		page.setVisible(true);

	}

}
