package rotulos;


import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class LabelDemo {

	public static void main(String[] args) {
		
		ImageIcon labelIcon = new ImageIcon("GUItip.gif");
		
		JLabel northLabel = new JLabel("North");

		
		JLabel centerLabel = new JLabel(labelIcon);
		
		JLabel southLabel = new JLabel(labelIcon);
		
		southLabel.setText("South");
		centerLabel.setText("Center");
		northLabel.setText("North");

		JFrame application = new JFrame();
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		application.add(northLabel, BorderLayout.NORTH);
		application.add(centerLabel, BorderLayout.CENTER);
		application.add(southLabel, BorderLayout.SOUTH);
		
		application.setSize(300, 300);
		
		application.setVisible(true);
	}

}
