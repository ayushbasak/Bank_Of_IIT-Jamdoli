package HelperClasses;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class GUI {
	static Font font = new Font("Sans Serif",Font.PLAIN,15);
	
//	JFrame
	public void redefineFrame(JFrame frame, int width, int height) {
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(width,height);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.out.println("Closed");
                e.getWindow().dispose();
            }
        });
	}

//	JPanel
	public void redefinePanel(JPanel panel, String hexColor, int rows, int columns, int parting) {
		GridLayout layout = new GridLayout(rows, columns);
		layout.setHgap(parting);
		layout.setVgap(parting);
		panel.setLayout(layout);
		panel.setBackground(Color.decode(hexColor));
				
	}

//	JButton
	public void redefineButton(JButton button, String hexColor, int borderWidth) {
		button.setBorder(BorderFactory.createLineBorder(Color.decode(hexColor), borderWidth));
		button.setBackground(Color.decode(hexColor));
		button.setForeground(Color.WHITE);
		button.setFont(font);
	}
	
//	JLabel
	public void redefineLabel(JLabel label) {
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(font);
	}
	
//	JTextField
	public void redefineTextField(JTextField textField) {
		textField.setFont(font);
	}
	public void redefineRadioButton(JRadioButton rbutton) {
		
	}
}
