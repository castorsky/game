package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {
    private Field gameField;
    // Уровень сложности
    private int difficulty;
    // Размер окна и картинки поля
    private int dimX = 1024, dimY = 768;
    private class MyKey implements KeyListener {
        @Override
        public void keyPressed(KeyEvent arg0) {
            int key_ = arg0.getKeyCode();
            if (key_ == 27) System.exit(0);
            if (key_ == 37) {
            	if (gameField.x-30 > -78) gameField.x-=30;
            }
            if (key_ == 39) {
            	if (gameField.x-30 < (dimX-150)) gameField.x+=30;
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
        setBounds(0,0, dimX, dimY);
        setTitle("Ball Catcher Game");
        gameField = new Field(difficulty, dimX, dimY);
        Container container = getContentPane();
        container.add(gameField);
        setVisible(true);
    }
}