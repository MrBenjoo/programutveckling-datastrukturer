package p6;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.*;

import javax.swing.*;

/**
 * Klassen innehåller metoder föratt visa inmatnings dialog som innehåller 3 knappar då man trycker på en av dem
 * kommer timer att fungerar
 * @author NAZDAR & George
 * 
 */
public class FlowingText1 extends JFrame{
	int count;
	FlowingText2 fl2;
	private JTextField tf;
	private JLabel timeLabel;
	private JLabel label1;
	private JButton start, stop, cancel;
	private String textFieldText;
	/**
	 * Konstruktorn innehåller knappar med lyssnare
	 */
	public FlowingText1() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		label1 = new JLabel(" Mata in en text ");
		panel.add(label1);

		tf = new JTextField(20);
		panel.add(tf);
		
		//Buttons
		start = new JButton("Start");
		stop = new JButton("Stop");
		cancel = new JButton("Cancel");
	
		
		panel.add(start);
		panel.add(stop);
		panel.add(cancel);
		
		start.addActionListener(new ButtonListener());
		stop.addActionListener(new ButtonListener());
		cancel.addActionListener(new ButtonListener());
		
		add(panel);
		this.pack();	
	}
	
	public String getText(){
		return textFieldText;
	}

	/**
	 * Inre klass som implementerar ActionListener
	 * 
	 * @author George & Nazdar
	 *
	 */
	private class ButtonListener implements ActionListener {
		
		/**rsxcv
		 * Vi trycker på en knapp För att det ska gå, skickar vi ett värde till
		 * klassen som innehåller alla metoder som ska anropas, genom dess
		 * referens, och metodNamn
		 */
		public void actionPerformed(ActionEvent e) {
			//Sends the input to the FlowingText2 class
			if(e.getSource() == start){
				if(tf.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "The textfield is empty. Please try again.");
				else{
					textFieldText = tf.getText();
					fl2 = new FlowingText2(textFieldText);
					tf.setText(null);
					fl2.run();
				}
			}
			//Stops the timer
			else if(e.getSource() == stop){
				fl2.stopTimer();
			}
			//Closes the JFrame window
			else{
				JFrame.getFrames()[0].dispose();
			}
				
		}

	}
	
	/**
	 * Körprogrammet
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FlowingText1 ft1 = new FlowingText1();

		ft1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		ft1.setLocationRelativeTo(null); 
		ft1.setVisible(true);
		ft1.setSize(new Dimension(300,200) );
		
	}
}

