package game;

import javax.swing.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Field extends JPanel {
        public Field() {
                Timer timer = new Timer(50, new ActionListener() {
                        public void actionPerformed(ActionEvent event) {
                                repaint();
                        }
                });
        }
        public void paintComponent(Graphics gr) {

        }
}