package game;

import javax.swing.JOptionPane;

public class Game {

    public static void main(String[] args) {
    	String input = JOptionPane.showInputDialog(null, "Введите сложность игры (от 1 до 3): ", "Сложность игры", 1);
    	int difficulty = input.charAt(0)-'0';
    	if ((difficulty > 0) && (difficulty < 4)) {
			Window window = new Window(difficulty);
		}
    }

}