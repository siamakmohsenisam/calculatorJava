package formpackage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.SystemColor;

import javax.swing.JTextField;

import calcupackage.Operation;
import calcupackage.Operationlist;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Form1 extends JFrame{
	
	
	Operationlist cal=new Operationlist();
	private JList<String> countlist;
	private JScrollPane scrollPane;
	private JTextField textField1;
	private JTextField textField2;
	private JButton bmm;
	public Form1() {
		setTitle("Siamak Mohseni Sam         Calculator");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(636, 401);
		getContentPane().setBackground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		getContentPane().setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "");
		panel.setLayout(null);
		
		textField1 = new JTextField();
		textField1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String s;
				s=textField1.getText();
				String[] s1={" "," "};
				Operation.getCounter().clear();
				try
				{
					cal.setString1(s);								
					cal.stringtrim();
					s=String.format("\n\n\n%s =", cal.getString1());
					s+=String.format(" %-20.2f",cal.solve(cal.stringtoarray()));
					textField2.setText(s);
					countlist.setListData(Operation.getCounter().toArray(s1));
					
					
				}
				catch(Exception e)
				{
					s=String.format("you have an error in this sentence"+e);
					textField2.setText(s);
					s=String.format("\n\n\n%s", cal.getString1());
					textField1.setText(s);
				}	
			}
		});
		textField1.setText("-(80+10-10-(-10-99+9)-10(.5*8.0))");
		textField1.setBounds(10, 11, 600, 27);
		panel.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setText("if you type a phrase on the top row and press enter on key board or button, you can see a result here ");
		textField2.setEditable(false);
		textField2.setBounds(10, 42, 600, 27);
		panel.add(textField2);
		textField2.setColumns(10);
		
		countlist = new JList<>();
		scrollPane = new JScrollPane(countlist);
		scrollPane.setBounds(10, 84, 293, 244);
		panel.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("all the steps");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 339, 293, 14);
		panel.add(lblNewLabel);
		
		JButton bs = new JButton("+");
		bs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bs.isEnabled())
				{
					String s=textField1.getText();
					s+="+";
					textField1.setText(s);
				}
			}
		});
		bs.setFont(new Font("Arial Black", Font.PLAIN, 15));
		bs.setBounds(561, 140, 45, 101);
		panel.add(bs);
		
		JButton b6 = new JButton("6");
		b6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(b6.isEnabled())
				{
					String s=textField1.getText();
					s+="6";
					textField1.setText(s);
				}
			}
		});
		b6.setFont(new Font("Arial Black", Font.PLAIN, 15));
		b6.setBounds(506, 196, 45, 45);
		panel.add(b6);
		
		JButton b5 = new JButton("5");
		b5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(b5.isEnabled())
				{
					String s=textField1.getText();
					s+="5";
					textField1.setText(s);
				}
			}
		});
		b5.setFont(new Font("Arial Black", Font.PLAIN, 15));
		b5.setBounds(451, 196, 45, 45);
		panel.add(b5);
		
		JButton b4 = new JButton("4");
		b4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(b4.isEnabled())
				{
					String s=textField1.getText();
					s+="4";
					textField1.setText(s);
				}
			}
		});
		b4.setFont(new Font("Arial Black", Font.PLAIN, 15));
		b4.setBounds(396, 196, 45, 45);
		panel.add(b4);
		
		JButton b9 = new JButton("9");
		b9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(b9.isEnabled())
				{
					String s=textField1.getText();
					s+="9";
					textField1.setText(s);
				}
			}
		});
		b9.setFont(new Font("Arial Black", Font.PLAIN, 15));
		b9.setBounds(506, 140, 45, 45);
		panel.add(b9);
		
		JButton b8 = new JButton("8");
		b8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(b8.isEnabled())
				{
					String s=textField1.getText();
					s+="8";
					textField1.setText(s);
				}
			}
		});
		b8.setFont(new Font("Arial Black", Font.PLAIN, 15));
		b8.setBounds(451, 140, 45, 45);
		panel.add(b8);
		
		JButton b7 = new JButton("7");
		b7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(b7.isEnabled())
				{
					String s=textField1.getText();
					s+="7";
					textField1.setText(s);
				}
			}
		});
		b7.setFont(new Font("Arial Black", Font.PLAIN, 15));
		b7.setBounds(396, 140, 45, 45);
		panel.add(b7);
		
		JButton b3 = new JButton("3");
		b3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(b3.isEnabled())
				{
					String s=textField1.getText();
					s+="3";
					textField1.setText(s);
				}
			}
		});
		b3.setFont(new Font("Arial Black", Font.PLAIN, 15));
		b3.setBounds(506, 252, 45, 45);
		panel.add(b3);
		
		JButton b2 = new JButton("2");
		b2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(b2.isEnabled())
				{
					String s=textField1.getText();
					s+="2";
					textField1.setText(s);
				}
			}
		});
		b2.setFont(new Font("Arial Black", Font.PLAIN, 15));
		b2.setBounds(451, 252, 45, 45);
		panel.add(b2);
		
		JButton b1 = new JButton("1");
		b1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(b1.isEnabled())
				{
					String s=textField1.getText();
					s+="1";
					textField1.setText(s);
				}
			}
		});
		b1.setFont(new Font("Arial Black", Font.PLAIN, 15));
		b1.setBounds(396, 252, 45, 45);
		panel.add(b1);
		
		JButton be = new JButton("=");
		be.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(be.isEnabled())
				{
					String s;
					s=textField1.getText();
					String[] s1={" "," "};
					Operation.getCounter().clear();
					try
					{
						cal.setString1(s);								
						cal.stringtrim();
						s=String.format("\n\n\n%s =", cal.getString1());
						s+=String.format(" %-20.2f",cal.solve(cal.stringtoarray()));
						textField2.setText(s);
						countlist.setListData(Operation.getCounter().toArray(s1));
						
						
					}
					catch(Exception e1)
					{
						s=String.format("you have an error in this sentence"+e1);
						textField2.setText(s);
						s=String.format("\n\n\n%s", cal.getString1());
						textField1.setText(s);
					}	
				}				
			}
		});
		be.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		be.setFont(new Font("Arial Black", Font.PLAIN, 15));
		be.setBounds(561, 252, 45, 101);
		panel.add(be);
		
		JButton bp = new JButton(".");
		bp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bp.isEnabled())
				{
					String s=textField1.getText();
					s+=".";
					textField1.setText(s);
				}
			}
		});
		bp.setFont(new Font("Arial Black", Font.PLAIN, 15));
		bp.setBounds(506, 308, 45, 45);
		panel.add(bp);
		
		JButton b0 = new JButton("0");
		b0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(b0.isEnabled())
				{
					String s=textField1.getText();
					s+="0";
					textField1.setText(s);
				}
			}
		});
		b0.setFont(new Font("Arial Black", Font.PLAIN, 15));
		b0.setBounds(396, 308, 100, 45);
		panel.add(b0);
		
		JButton bmi = new JButton("-");
		bmi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bmi.isEnabled())
				{
					String s=textField1.getText();
					s+="-";
					textField1.setText(s);
				}
			}
		});
		bmi.setFont(new Font("Arial Black", Font.PLAIN, 15));
		bmi.setBounds(561, 84, 45, 45);
		panel.add(bmi);
		
		JButton bmu = new JButton("*");
		bmu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bmu.isEnabled())
				{
					String s=textField1.getText();
					s+="*";
					textField1.setText(s);
				}
			}
		});
		bmu.setFont(new Font("Arial Black", Font.PLAIN, 15));
		bmu.setBounds(506, 84, 45, 45);
		panel.add(bmu);
		
		JButton bdi = new JButton("/");
		bdi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bdi.isEnabled())
				{
					String s=textField1.getText();
					s+="/";
					textField1.setText(s);
				}
			}
		});
		bdi.setFont(new Font("Arial Black", Font.PLAIN, 15));
		bdi.setBounds(451, 84, 45, 45);
		panel.add(bdi);
		
		JButton bpc = new JButton(")");
		bpc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bpc.isEnabled())
				{
					String s=textField1.getText();
					s+=")";
					textField1.setText(s);
				}
			}
		});
		bpc.setFont(new Font("Arial Black", Font.PLAIN, 15));
		bpc.setBounds(341, 140, 45, 45);
		panel.add(bpc);
		
		JButton bpo = new JButton("(");
		bpo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bpo.isEnabled())
				{
					String s=textField1.getText();
					s+="(";
					textField1.setText(s);
				}
			}
		});
		bpo.setFont(new Font("Arial Black", Font.PLAIN, 15));
		bpo.setBounds(341, 196, 45, 45);
		panel.add(bpo);
		
		JButton btnNumLock = new JButton("Num Lock");
		btnNumLock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(b1.isEnabled())
				{
					b1.setEnabled(false);b2.setEnabled(false);b3.setEnabled(false);
					b4.setEnabled(false);b5.setEnabled(false);b6.setEnabled(false);
					b7.setEnabled(false);b8.setEnabled(false);b9.setEnabled(false);
					b0.setEnabled(false);bdi.setEnabled(false);be.setEnabled(false);
					bmi.setEnabled(false);bmu.setEnabled(false);bp.setEnabled(false);
					bpc.setEnabled(false);bpo.setEnabled(false);bs.setEnabled(false);
					bmm.setEnabled(false);
				}
				else 
				{
					b1.setEnabled(true);b2.setEnabled(true);b3.setEnabled(true);
					b4.setEnabled(true);b5.setEnabled(true);b6.setEnabled(true);
					b7.setEnabled(true);b8.setEnabled(true);b9.setEnabled(true);
					b0.setEnabled(true);bdi.setEnabled(true);be.setEnabled(true);
					bmi.setEnabled(true);bmu.setEnabled(true);bp.setEnabled(true);
					bpc.setEnabled(true);bpo.setEnabled(true);bs.setEnabled(true);
					bmm.setEnabled(true);
				}
			}
		});
		btnNumLock.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnNumLock.setBounds(341, 84, 100, 45);
		panel.add(btnNumLock);
		
		bmm = new JButton("%");
		bmm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(bmm.isEnabled())
				{
					String s=textField1.getText();
					s+="%";
					textField1.setText(s);
				}
			}
		});
		bmm.setFont(new Font("Arial Black", Font.BOLD, 10));
		bmm.setBounds(341, 252, 45, 101);
		panel.add(bmm);
		
		
	}
}
