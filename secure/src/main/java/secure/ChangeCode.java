package secure;

import java.awt.Component;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class ChangeCode extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4183393595731905010L;

	JLabel l; JLabel [] out_l; 
	JCheckBox [] cb;  
	ButtonGroup btnG; 
	JRadioButton rb1, rb2; // 암호화,  복호화? 
	JTextArea input; JTextArea [] out; 
	JButton submit; 
	String op_val[] = {"bcrypt", "base64"}; 
	int a_x = 20, a_y = 20; 
	int b_x = 300, b_y = 20; 
	int width = 1000; 
	ArrayList<String> type = new ArrayList<String>();

	ChangeCode(){
		int optionNum = op_val.length; 
		l = new JLabel("inputYourTxt"); 
		l.setBounds(a_x, a_y, 300, 20);
		a_y+=30; 
		add(l);
		input = new JTextArea();  
		input.setBounds(a_x, a_y, 200, 200);
		a_y+=210; 
		add(input); 
		//radiobtn area
		int r_x = a_x + 150, r_y = a_y; 
		rb1 = new JRadioButton("en");  
		rb2 = new JRadioButton("de"); 
		rb1.setBounds(r_x, r_y, 100, 30);
		r_y+=30;  
		rb2.setBounds(r_x, r_y, 100, 30);
		btnG = new ButtonGroup(); 
		add(rb1);add(rb2);
		//checkbox 
		cb = new JCheckBox[optionNum]; 
		for(int i = 0; i < optionNum ;  i++	){
			final String val = op_val[i]; 
			cb[i] = new JCheckBox(val); 
			cb[i].setBounds(a_x, a_y, 150, 30);
			add(cb[i]); 
			a_y+=30;
		}
		a_y+=20;
		
		submit = new JButton("Change!");
		submit.setBounds(a_x, a_y, 200 , 30);
		submit.addActionListener(this);
		add(submit);
		a_y+=30; 
		
		//area b 
		JLabel b_label = new JLabel("result"); 
		b_label .setBounds(b_x, b_y, 300, 20);
		b_y+=30; 
		add(b_label );
		out = new JTextArea[optionNum]; 
		out_l = new JLabel[optionNum]; 
		for(int i = 0 ; i < optionNum; i++){
			out_l[i] = new JLabel(op_val[i]); 
			out_l[i].setBounds(b_x, b_y, 600, 20);
			add(out_l[i]);
			b_y+=30;
			out[i] = new JTextArea();
			out[i].setBounds(b_x, b_y, 600, 100);
			add(out[i]);
			b_y+= 110; 
		}
		setSize(width, a_y+100);  
		setLayout(null);  
		setVisible(true);  
		setDefaultCloseOperation(EXIT_ON_CLOSE);  
	}

	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0 ; i < cb.length; i++){
			if(cb[i].isSelected()){
				System.out.println(cb[i].getText());
			}
		}
	}
	

	public static void main(String[] args) {
		new ChangeCode();
	}

}
