package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ball {
	private Image ball;
	public int x, y;
	public boolean active;
	private Timer updater;
	
	public Ball(Image image) {
		updater = new Timer(500, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				moveDown();
			}
		});
		ball = image;
		active = false;
	}
	
	public void start() {
		updater.start();
		y = 0;
		x = (int)(Math.random()*700);
		active = true;
	}
	
	private void moveDown() {
		
	}
}
