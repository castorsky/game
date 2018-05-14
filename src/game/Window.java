package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame {
        private Field gameField;
        private class MyKey implements KeyListener {
                @Override
                public void keyPressed(KeyEvent arg0) {
                        int key_ = arg0.getKeyCode();
                }
                @Override
                public void keyReleased(KeyEvent arg0) {
                }
                @Override
                public void keyTyped(KeyEvent arg0) {
                }

        }

        public Window() {
                addKeyListener(new MyKey());
                setFocusable(true);
                setBounds(0,0,800,600);
                this.setTitle("Ball Catcher Game");
                gameField = new Field();
                Container container = getContentPane();
                container.add(gameField);
                setVisible(true);
        }
}