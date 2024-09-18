package brickBracker.java;


import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener, ActionListener{
	private boolean play= false;
	private int score = 0;
	
	private int totalBricks=21;
	private Timer time;
	private int delay =8;
	private int playerx= 310;
	private int ballposx=120;
	private int ballposy=350;
	private int ballXdir=-1;
	private int ballYdir=-2;
	
	
	public Gameplay() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		Timer timer = new Timer(delay, this);
		timer.start();
		
	}
	
	
	public void paint(Graphics g) {
		
		//background
		g.setColor(Color.black);
		g.fillRect(1, 1, 692, 592);
		
		// borders
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		// the paddle
		
		g.setColor(Color.green);
		g.fillRect(playerx, 550, 100, 8);
		
		//THE BALL
		g.setColor(Color.yellow);
		g.fillOval(ballposx, ballposy, 20, 20);
		
		g.dispose();
		
		
		
	}
	
	
	
	
	@Override 
	
	public void keyTyped(KeyEvent e) {
		//something happens
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Timer timer = null;
		// TODO Auto-generated method stub
		timer.start();
		if(play) {
			ballposx+=ballXdir;
			ballposy +=ballYdir;
			
			if(ballposx < 0) {
				ballXdir= -ballXdir;
			}
			if(ballposy < 0) {
				ballYdir= -ballYdir;
			}
			if(ballposx > 670) {
				ballXdir= -ballXdir;
			}
		}
		repaint();
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			if(playerx >= 600) {
				playerx=600;
			}else {
				moveRight();
			}
		
	     }
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			if (playerx < 10) {
				playerx=10;
			}else {
				moveLeft();
			}
			
	     }
	
     }
	
	public void moveRight() {
		
		play=true;
		playerx+=20;
	}
	
	public void moveLeft() {
		
		play=true;
		playerx-=20;
	}
	
}
