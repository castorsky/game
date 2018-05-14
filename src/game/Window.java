package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {
    private Field gameField;
    private int difficulty;
    private class MyKey implements KeyListener {
        @Override
        public void keyPressed(KeyEvent arg0) {
            int key_ = arg0.getKeyCode();
            if (key_ == 27) System.exit(0);
            if (key_ == 37) {
            	if (gameField.x-30 > -78) gameField.x-=30;
            }
            if (key_ == 39) {
            	if (gameField.x-30 < 650) gameField.x+=30;
            }	
        }
        @Override
        public void keyReleased(KeyEvent arg0) {
        }
        @Override
        public void keyTyped(KeyEvent arg0) {
        }

    }

    public Window(int difficulty) {
    	this.difficulty = difficulty;
        addKeyListener(new MyKey());
        setFocusable(true);
        setBounds(0,0,800,600);
        setTitle("Ball Catcher Game");
        gameField = new Field(difficulty);
        Container container = getContentPane();
        container.add(gameField);
        setVisible(true);
    }
}