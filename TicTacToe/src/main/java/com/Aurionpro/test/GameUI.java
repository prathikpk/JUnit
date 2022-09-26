package com.Aurionpro.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import comm.Aurionpro.model.Board;
import comm.Aurionpro.model.Game;
import comm.Aurionpro.model.Player;
import comm.Aurionpro.model.ResultAnalyzer;
import comm.Aurionpro.model.ResultType;

import static javax.swing.JOptionPane.showMessageDialog;

@SuppressWarnings("serial")
public class GameUI extends JFrame implements ActionListener {

	JFrame frame = new JFrame();// Frame object
	JPanel t_panel = new JPanel();// Panel for text
	JPanel bt_panel = new JPanel();// Panel for buttons
	JLabel textfield = new JLabel();// Label object to display text
	JButton[] bton = new JButton[9];// creating an array of button's because in tic tac toe game there are 9
									// position's
	int chance_flag = 0;
	Random random = new Random();
	boolean pl1_chance;
	Game game;
	ResultAnalyzer analyzer;
	Board board;
	Player[] players = new Player[2];
	

	public GameUI(String p1Name, String p2Name) {
		players[0] = new Player(p1Name);
		players[1] = new Player(p2Name);
		game = new Game(players);
		analyzer =game.getAnalyzer();
		board=analyzer.getBoard();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setTitle("TIC TAC TOE");
		//frame.setTitle(game.getCurrentPlayer().getName()+" ("+game.getCurrentPlayer().getMark()+")");
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);

		textfield.setBackground(new Color(120, 20, 124));
		textfield.setForeground(new Color(25, 255, 0));
		textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
		textfield.setHorizontalAlignment(JLabel.CENTER);
		textfield.setText(game.getCurrentPlayer().getName()+" ("+game.getCurrentPlayer().getMark()+")");
		textfield.setOpaque(true);

		t_panel.setLayout(new BorderLayout());
		t_panel.setBounds(0, 0, 800, 100);
		bt_panel.setLayout(new GridLayout(3, 3));// setting layout of bt_pannel as gridlayout
		bt_panel.setBackground(new Color(150, 150, 150));

		for (int i = 0; i < 9; i++) {
			bton[i] = new JButton();// creating object for each button element of array
			bton[i].setText(i + "");
			bt_panel.add(bton[i]);// adding each button to the pannel for buttons
			bton[i].setFont(new Font("Ink Free", Font.BOLD, 120));
			bton[i].setFocusable(false);
			bton[i].addActionListener(this);
		}

		t_panel.add(textfield);
		frame.add(t_panel, BorderLayout.NORTH);
		frame.add(bt_panel);
		frame.setResizable(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton tempButton = (JButton) e.getSource();
		int loc = Integer.valueOf(e.getActionCommand());
		tempButton.setText(game.getCurrentPlayer().getMark().toString());
		game.play(loc);
		tempButton.setEnabled(false);
		textfield.setText(game.getCurrentPlayer().getName()+" ("+game.getCurrentPlayer().getMark()+")");
		// showMessageDialog(null, analyzer.getResult().toString());

		if (analyzer.getResult() != ResultType.PROGRESS) {
			String displayMessage = "";
			if (analyzer.getResult() == ResultType.WIN) {
				displayMessage = game.getCurrentPlayer().getName().toUpperCase() + " WINS!!! ";
						
			}
			if (analyzer.getResult() == ResultType.DRAW) {
				displayMessage = "MATCH IS " + analyzer.getResult().toString();
			}
			disableAllButtons();
			showMessageDialog(null, displayMessage);
		}
	}

	private void disableAllButtons() {
		String num="012345678"; //{"0","1","2","3","4","5","6","7","8"};
		for (int i = 0; i < 9; i++) {
			if(num.contains(bton[i].getText())) {
				bton[i].setText("-");
			}
			bton[i].setEnabled(false);
		}

	}

}
