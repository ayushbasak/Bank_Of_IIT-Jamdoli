package HelperClasses;
import javax.swing.*;
import java.awt.*;
public class GUI {
	static Font font = new Font("Sans Serif",Font.PLAIN,15);
	
	public void redefineFrame(JFrame frame, int width, int height) {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(width,height);
		frame.setVisible(true);
	}
	public void redefinePanel(JPanel panel, String hexColor, int rows, int columns, int parting) {
		GridLayout layout = new GridLayout(rows, columns);
		layout.setHgap(parting);
		layout.setVgap(parting);
		panel.setLayout(layout);
		panel.setBackground(Color.decode(hexColor));
				
	}
	public void redefineButton(JButton button, String hexColor, int borderWidth) {
		button.setBorder(BorderFactory.createLineBorder(Color.decode(hexColor), borderWidth));
		button.setBackground(Color.decode(hexColor));
		button.setForeground(Color.WHITE);
		button.setFont(font);
	}
	public void redefineLabel(JLabel label) {
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(font);
	}
	public void redefineTextField(JTextField textField) {
		textField.setFont(font);
	}
	public void redefineRadioButton(JRadioButton rbutton) {
		
	}
}
