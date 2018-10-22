/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class TicTacToe extends JFrame implements ActionListener{

  private final int ROWS = 3;
  private final int COLS = 3;
  private final int GAP = 0;
  private final int NUM = ROWS * COLS;
  private CardLayout cards = new CardLayout();
  private int x;
  int count = 0;
  int countX = 0;
  int countO = 0;
  
  Font headlineFont = new Font("Arial", Font.BOLD, 48);
  Font font = new Font("Arial", Font.BOLD, 12);
  
  JMenuBar mainBar = new JMenuBar();
  JMenu menu1 = new JMenu("Game");
  JMenu menu2 = new JMenu("Help");
  JMenuItem newGame = new JMenuItem("New Game");
  JMenuItem score = new JMenuItem("Score");
  JMenuItem resetScore = new JMenuItem("Reset Score");
  JMenuItem exit = new JMenuItem("Exit");
  
  JMenuItem rules = new JMenuItem("Rules");
  JMenuItem about = new JMenuItem("About");
  
  private Color color1 = Color.YELLOW;
  private Color color2 = Color.GREEN;
  
  private JPanel pane = new JPanel (new GridLayout(ROWS, COLS, GAP, GAP));
  private JPanel pane2 = new JPanel();
  private JButton[] panel = new JButton[NUM];
  private JLabel winning = new JLabel("");
  
  private Container con = getContentPane();
  
  public TicTacToe()
  {
    super("Swing Tic-Tac-Toe");
      add(pane);
   
      setJMenuBar(mainBar);
      mainBar.add(menu1);
      mainBar.add(menu2);
      menu1.add(newGame);
      menu1.add(score);
      menu1.add(resetScore);
      menu1.add(exit);
      menu2.add(rules);
      menu2.add(about);
      
      //makes nav bar
      
      con.setLayout(cards);
      con.add("First Pane", pane);
      con.add("Second Pane", pane2);
      pane2.add(winning);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      for(x = 0; x < NUM; ++x)
      {
        panel[x] = new JButton();
        pane.add(panel[x]);
      
        panel[x].setText(" ");
        panel[x].setFont(headlineFont);
        winning.setFont(font);
        
        panel[x].addActionListener(this);
        exit.addActionListener(this);
        newGame.addActionListener(this);
        resetScore.addActionListener(this);
        score.addActionListener(this);
        rules.addActionListener(this);
        about.addActionListener(this);
      
        //sets up the board and keeps a lookout for actions made    
      }
  }
  
     
  
    public static void main(String[] args) 
    {
     TicTacToe frame = new TicTacToe();
     frame.setSize(250, 275);
     frame.setVisible(true);
     //makes the frame
    }

   
    @Override
    public void actionPerformed(ActionEvent e) 
    {
       //every single action made 
      System.out.println(count); 
      System.out.println(panel[0].getText());
      Object source = e.getSource(); 
      
      if(source == exit)
         System.exit(0);
      //closes game
      if(source == rules)
      {
      cards.next(getContentPane()); 
      winning.setText("<html>The object of Tic Tac Toe is to get three in a row.<br>You play on a three by three game board.<br>The first player is known as X and the second is O.<br>Players alternate placing Xs and Os on the game board until either oppent has three in a row or all nine squares are filled.<br>In the event that no one has three in a row, the stalemate is called a cat game.<html>");
      winning.setPreferredSize(new Dimension(200, 200));
      }
      //shows rules
      if(source == score)
      {
      cards.next(getContentPane()); 
      winning.setText("X wins: " + countX + "O wins:" + countO);
      winning.setPreferredSize(new Dimension(250, 100));
      }
      //shows scores
      if(source == newGame)
      {
      cards.next(getContentPane());
      cards.next(getContentPane()); 
      }
      //resets the board
      if(source == resetScore)
      {
      cards.next(getContentPane()); 
      winning.setText("<html>Scores have been reset!<br>Click new game to play again!<html>");
      winning.setPreferredSize(new Dimension(200, 50));
      countX=0;
      countO=0;
      }
      //resets the score boards
      if(source == about)
      {
      cards.next(getContentPane()); 
      winning.setText("<html>Made by Jeno Dusci<br>On the date of 3/21/18<br>Of the game Swing Tic-Tac-Toe<html>");
      winning.setPreferredSize(new Dimension(200, 50));
      }
      //shows the about
      //next few lines are showing how the boxs switch to x and o and changes color
      if(source == panel[0])
     {
      switching();
      if(count == 0)
      {
       panel[0].setText("X");
       panel[0].setBackground(color1);
      }
      else
      {
       panel[0].setText("O");
       panel[0].setBackground(color2);
      }
      winTest();
     }
      
      else if(source == panel[1])
     {
      switching();
      if(count == 0)
      {
       panel[1].setText("X");
       panel[1].setBackground(color1);
      }
      else
      {
       panel[1].setText("O");
       panel[1].setBackground(color2);
      }
      winTest();
     }
      else if(source == panel[2])
     {
      switching();
        if(count == 0)
      {
       panel[2].setText("X");
       panel[2].setBackground(color1);
      }
      else
      {
       panel[2].setText("O");
       panel[2].setBackground(color2);
      }
       winTest(); 
     }
      else if(source == panel[3])
     {
      switching();
        if(count == 0)
      {
       panel[3].setText("X");
       panel[3].setBackground(color1);
      }
      else
      {
       panel[3].setText("O");
       panel[3].setBackground(color2);
      }
       winTest(); 
     }
      else if(source == panel[4])
     {
      switching();
        if(count == 0)
      {
       panel[4].setText("X");
       panel[4].setBackground(color1);
      }
      else
      {
       panel[4].setText("O");
       panel[4].setBackground(color2);
      }
       winTest(); 
     }
      else if(source == panel[5])
     {
      switching();
        if(count == 0)
      {
       panel[5].setText("X");
       panel[5].setBackground(color1);
      }
      else
      {
       panel[5].setText("O");
       panel[5].setBackground(color2);
      }
       winTest(); 
     }
      else if(source == panel[6])
     {
       switching();
        if(count == 0)
      {
       panel[6].setText("X");
       panel[6].setBackground(color1);
      }
      else
      {
       panel[6].setText("O");
       panel[6].setBackground(color2);
      }
       winTest(); 
     }
      else if(source == panel[7])
     {
      switching();
        if(count == 0)
      {
       panel[7].setText("X");
       panel[7].setBackground(color1);
      }
      else
      {
       panel[7].setText("O");
       panel[7].setBackground(color2);
      }
      winTest(); 
     }
      else if(source == panel[8])
     {
      switching();
        if(count == 0)
      {
       panel[8].setText("X");
       panel[8].setBackground(color1);
      }
      else
      {
       panel[8].setText("O");
       panel[8].setBackground(color2);
      }
      winTest();  
     }

    }
       
    public void switching() 
    {
        //gives boxes a int
      if(count == 0)
      {
       count++;
       
      }
      else
      {
       count--;
       
      }
    }
    public void winTest() 
    {
        //tests the wins
      if(panel[0].getText() == "X" && panel[1].getText() == "X" && panel[2].getText() == "X")
      {
        cards.next(getContentPane());   
        winning.setText("Congratulations! X wins!");
        countX++;
      }
      if(panel[3].getText() == "X" && panel[4].getText() == "X" && panel[5].getText() == "X")
      {
        cards.next(getContentPane());   
        winning.setText("Congratulations! X wins!");
        countX++;
      }
      if(panel[6].getText() == "X" && panel[7].getText() == "X" && panel[8].getText() == "X")
      {
        cards.next(getContentPane());   
        winning.setText("Congratulations! X wins!");
        countX++;
      }
      
      if(panel[0].getText() == "X" && panel[3].getText() == "X" && panel[6].getText() == "X")
      {
        cards.next(getContentPane());   
        winning.setText("Congratulations! X wins!");
        countX++;
      }
      if(panel[1].getText() == "X" && panel[4].getText() == "X" && panel[7].getText() == "X")
      {
        cards.next(getContentPane());   
        winning.setText("Congratulations! X wins!");
        countX++;
      }
      if(panel[2].getText() == "X" && panel[5].getText() == "X" && panel[8].getText() == "X")
      {
        cards.next(getContentPane());   
        winning.setText("Congratulations! X wins!");
        countX++;
      }
      
       if(panel[0].getText() == "X" && panel[4].getText() == "X" && panel[8].getText() == "X")
      {
        cards.next(getContentPane());   
        winning.setText("Congratulations! X wins!");
        countX++;
      }
      if(panel[2].getText() == "X" && panel[4].getText() == "X" && panel[6].getText() == "X")
      {
        cards.next(getContentPane());   
        winning.setText("Congratulations! X wins!");
        countX++;
      }
      
       if(panel[0].getText() == "O" && panel[1].getText() == "O" && panel[2].getText() == "O")
      {
        cards.next(getContentPane());   
        winning.setText("Congratulations! O wins!");
        countO++;
      }
      if(panel[3].getText() == "O" && panel[4].getText() == "O" && panel[5].getText() == "O")
      {
        cards.next(getContentPane());   
        winning.setText("Congratulations! O wins!");
        countO++;
      }
      if(panel[6].getText() == "O" && panel[7].getText() == "O" && panel[8].getText() == "O")
      {
        cards.next(getContentPane());   
        winning.setText("Congratulations! O wins!");
        countO++;
      }
      
      if(panel[0].getText() == "O" && panel[3].getText() == "O" && panel[6].getText() == "O")
      {
        cards.next(getContentPane());   
        winning.setText("Congratulations! O wins!");
        countO++;
      }
      if(panel[1].getText() == "O" && panel[4].getText() == "O" && panel[7].getText() == "O")
      {
        cards.next(getContentPane());   
        winning.setText("Congratulations! O wins!");
        countO++;
      }
      if(panel[2].getText() == "O" && panel[5].getText() == "O" && panel[8].getText() == "O")
      {
        cards.next(getContentPane());   
        winning.setText("Congratulations! O wins!");
        countO++;
      }
      
       if(panel[0].getText() == "O" && panel[4].getText() == "O" && panel[8].getText() == "O")
      {
        cards.next(getContentPane());   
        winning.setText("Congratulations! O wins!");
        countO++;
      }
      if(panel[2].getText() == "O" && panel[4].getText() == "O" && panel[6].getText() == "O")
      {
        cards.next(getContentPane());   
        winning.setText("Congratulations! O wins!");
        countO++;
      }
    }
}
