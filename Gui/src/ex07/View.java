package ex07;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import GUI.MyFrame;
public class View extends JFrame implements ActionListener,MyFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public View() {
		super("計算機");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	//キーボード
	private static final String[] keyboardLayout = {
		"MC","M+","M-","MR",
		"C","±","^","÷",
		"7","8","9","×",
		"4","5","6","-",
		"1","2","3","+",
		"0","00",".","=",
		"(",")","π","e",
		"DEL","1/x"
		
	};
	private String formula = "0";
	private String memory = "0";
	final Controller action = new Controller();
	final JLabel display = new JLabel(formula);

	public void run(){
		this.setSize(300, 310);
		this.setLocationRelativeTo(null);
		JPanel pane = new JPanel();

		JPanel labelpanel = new JPanel();
		labelpanel.setPreferredSize(new Dimension(200,25));
		labelpanel.setBackground(Color.white);
		labelpanel.add(display);

		JPanel panel = new JPanel(new GridLayout(8,4));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
		getContentPane().add(panel);

		for(int i = 0;i<30;i++) {
			JButton button = new JButton(""+keyboardLayout[i]);
			panel.add(button);
			button.addActionListener(this);
		}
		
		pane.add(labelpanel,BorderLayout. NORTH);
		pane.add(panel,BorderLayout. SOUTH);
		getContentPane().add(pane);
		setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) {
		try{
			String input = ((JButton)e.getSource()).getText();
			formula = action.Controll(input, formula,memory);
			memory = action.Memory(input, formula, memory);
			if(formula.endsWith(".0")) formula = formula.substring(0,formula.length()-2);
			
			display.setText(formula);
		}catch(Exception E){
			display.setText("計算不可");
		}
	}
}