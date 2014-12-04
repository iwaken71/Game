package GUI;
import javax.swing.*;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class StartGUI extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int N = 3;
	private DATA[] data = new DATA[N];
	private JPanel panel;	
	private JButton[] button = new JButton[N];
	StartGUI(){
		super("Start");
		this.SetDATA();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(250, 250, 200, 200);
		panel = new JPanel();//‘S‘Ì‚Ìƒpƒlƒ‹
		
		JMenu menu1 = new JMenu("Menu");
		menu1.addActionListener(this);
		JMenuBar menubar = new JMenuBar();
		this.setJMenuBar(menubar);
		
		menubar.add(menu1);
		JMenuItem menuitem1 = new JMenuItem("Exit");
		menuitem1.addActionListener(this);
		menu1.add(menuitem1);
		for(int i = 0; i < N; i++){
			button[i] = new JButton(data[i].title);
			panel.add(button[i]);
			button[i].addActionListener(this);
		}
		this.add(panel);
		this.getContentPane().add(panel);
	
	}
	public void run(){
		this.setVisible(true);
	}
	private void SetDATA(){
		data[0] = new DATA("Prime Number",new MyGUI("Prime Number",new PrimeCon(new Prime())));
		data[1] = new DATA("Four Number",new MyGUI("Four Number",new Calcu(new FourNum())));
		data[2] = new DATA("Calculator",new ex07.View());
	}

	public void actionPerformed(ActionEvent e) {
		try{
			String push = ((AbstractButton)e.getSource()).getText();
			if(push.equals("Exit")){
				System.exit(0);
			}
			for(int i = 0; i< N; i++){
				if(push.equals(data[i].title)){
					data[i].frame.run();
				}
			}
		}catch(Exception E){
		}
	}
	private class DATA{
		String title;
		MyFrame frame;
		DATA(String title,MyFrame frame){
			this.title = title;
			this.frame = frame;
		}

	}
	public static void main(String[] agrs){
		StartGUI start = new StartGUI();
		start.run();
	}
}
