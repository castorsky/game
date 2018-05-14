package game;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Field extends JPanel {
	private Image background, basket;
	public int x = 400;
	
    public Field() {
        Timer timer = new Timer(50, new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                        repaint();
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
        timer.start();
    }
    
    public void paintComponent(Graphics gr) {
    	super.paintComponent(gr);
    	gr.drawImage(background, 0, 0, null);
    	gr.drawImage(basket, x, 400, 150, 150, null);
    }
}