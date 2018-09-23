package game;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Field extends JPanel {
	private Image background, basket, gameover;
	private Ball[] balls;
	private Font font;
	private int ballsCounter = 6;
	// Размеры окна (игрового поля)
	private int dimX, dimY;
	public int x = 400;
	private int difficulty;
	public Timer drawTimer, ballsUpdateTimer;
	public int countDracula = 0, speedyRunner = 1;
	
    public Field(int difficulty, int dimX, int dimY) {
    	this.difficulty = difficulty;
    	this.dimX = dimX;
    	this.dimY = dimY;

    	font = new Font("Verdana", Font.BOLD, 24);

        drawTimer = new Timer(100, new ActionListener() {
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
        
        balls = new Ball[ballsCounter];
        for (int i=0; i<ballsCounter; i++) {
            try {
            	balls[i] = new Ball(ImageIO.read(new File("ball"+(i+1)+".png")), speedyRunner);
            } catch (IOException exc) {
            	System.out.println("Error encountered while opening file ball"+(i+1)+".png: "+exc.getMessage());
            }
        	
        }
        
        drawTimer.start();
        ballsUpdateTimer.start();
    }
    
    public void paintComponent(Graphics gr) {
    	super.paintComponent(gr);
    	gr.setFont(font);
    	gr.drawImage(background, 0, 0, null);
    	gr.drawImage(basket, x, dimY-200, 150, 150, null);
		gr.drawString("Счёт: "+countDracula, dimX/2-5, 95);
    	for (int i=0; i<ballsCounter; i++) {
    		balls[i].draw(gr);
    		if ((balls[i].active == true) && (balls[i].y+80>(dimY-121))) {
    				if (Math.abs(balls[i].x-x)>75) {
						gr.drawImage(gameover, 0,0, dimX, dimY,null);
						drawTimer.stop();
						ballsUpdateTimer.stop();
						break;
					} else {
						balls[i].active = false;
						countDracula++;
						if ((countDracula)%5==0) {
							balls[i].stepDown+=3;
						}
    				}
    		}
    	}
    }
    
    private void ballsUpdate() {
    	int count = 0;
    	for (int i=0; i<ballsCounter; i++) {
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