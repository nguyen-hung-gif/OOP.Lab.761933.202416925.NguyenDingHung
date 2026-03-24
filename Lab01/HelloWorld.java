package Lab01;

import javax.swing.JOptionPane;

public class HelloWorld {

	public static void main(String[] args) {
		String result;
		result = JOptionPane.showInputDialog("Please enter your name: ");
		JOptionPane.showMessageDialog(null, "Hello World! I'm " + result);
		System.exit(0);
	}

}