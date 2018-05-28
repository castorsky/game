package game;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Field extends JPanel {
	private Image background, basket, gameover;
	private Ball[] balls;
	public int x = 400;
	private int difficulty;
	public Timer drawTimer, ballsUpdateTimer;
	
    public Field(int difficulty) {
    	this.difficulty = difficulty;
        drawTimer = new Timer(50, new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                        repaint();
                }
        });
        ballsUpdateTimer = new Timer(3000, new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ballsUpdate();
            }
        }); 
                
        try {
        	background = ImageIO.read(new File("court.jpg"));
        } catch (IOException exc) {
        	System.out.println("Error encountered while opening file court: "+exc.getMessage());
        }
        try {
        	basket = ImageIO.read(new File("basket.png"));
        } catch (IOException exc) {
        	System.out.println("Error encountered while opening file basket: "+exc.getMessage());
        }
        try {
        	gameover = ImageIO.read(new File("S2e16_Game_over.png"));
        } catch (IOException exc) {
        	System.out.println("Error encountered while opening file gameover: "+exc.getMessage());
        }
        
        balls = new Ball[3];
        for (int i=0; i<3; i++) {
            try {
            	balls[i] = new Ball(ImageIO.read(new File("ball"+(i+1)+".png")));
            } catch (IOException exc) {
            	System.out.println("Error encountered while opening file ball"+(i+1)+".png: "+exc.getMessage());
            }
        	
        }
        
        drawTimer.start();
        ballsUpdateTimer.start();
    }
    
    public void paintComponent(Graphics gr) {
    	super.paintComponent(gr);
    	gr.drawImage(background, 0, 0, null);
    	gr.drawImage(basket, x, 400, 150, 150, null);
    	for (int i=0; i<3; i++) {
    		balls[i].draw(gr);
    		if ((balls[i].active == true) && 
    				(balls[i].y+80>479)) {
    			if (Math.abs(balls[i].x-x)>75) {
    				gr.drawImage(gameover, 0,0,800,600,null);
    				drawTimer.stop();
    				ballsUpdateTimer.stop();
    				break;
    			} else {
    				balls[i].active = false;
    			}
    		}
    	}
    }
    
    private void ballsUpdate() {
    	int count = 0;
    	for (int i=0; i<3; i++) {
    		if (!balls[i].active) {
    			if (count < difficulty) {
    				balls[i].start();
    				break;
    			}
    		} else {
    			count++;
    		}
    	}
    }
}