package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ball {
	private Image ball;
	public int x, y;
	public int stepDown = 5;
	private int ballDimension = 80;
	public boolean active;
	private Timer updater;
	
	public Ball(Image image, int fallingSpeed) {
		updater = new Timer(200, new ActionListener() {
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
		x = (int)(Math.random()*900);
		active = true;
	}
	
	public void moveDown() {
		if (active) {
			y+=stepDown;
		}
		if (y+ballDimension >= 648) {
			updater.stop();
		}
	}
	
	public void draw(Graphics gr) {
		if (active) {
			gr.drawImage(ball, x, y, ballDimension, ballDimension, null);
		}
	}
}
