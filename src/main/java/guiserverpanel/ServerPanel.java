package guiserverpanel;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@Component
//public class ServerPanel extends JPanel implements MainFrame
public class ServerPanel extends JPanel
{

	public static guiserverpanel.MainFrame mframe;

	public ServerPanel()
	{

		//guiserverpanel.MainFrame mframe = new MainFrame();
		//mframe = new MainFrame();
		initComponents();


	}

	private void button1ActionPerformed(ActionEvent e) {
		// TODO add your code here
		System.out.print("JButton1 click event" + "\n");
	}


	// start H2 Database
	public void button2ActionPerformed(ActionEvent e)
	{



		// starting H2 Database from Servers
		//mframe.startDatabaseServer();
	}



	// stop H2 Database
	private void button3ActionPerformed(ActionEvent e) {
		// TODO add your code here
	}

	private void initComponents()
	{
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		tabbedPane1 = new JTabbedPane();
		panel1 = new JPanel();
		label1 = new JLabel();
		comboBox1 = new JComboBox();
		label3 = new JLabel();
		button2 = new JButton();
		button3 = new JButton();
		scrollPane1 = new JScrollPane();
		list1 = new JList();
		button1 = new JButton();
		panel2 = new JPanel();
		comboBox2 = new JComboBox();
		label2 = new JLabel();
		panel3 = new JPanel();
		panel4 = new JPanel();

		//======== this ========

		setLayout(null);

		//======== tabbedPane1 ========
		{

			//======== panel1 ========
			{
				panel1.setLayout(null);

				//---- label1 ----
				label1.setText("Sprache");
				panel1.add(label1);
				label1.setBounds(15, 20, 175, label1.getPreferredSize().height);
				panel1.add(comboBox1);
				comboBox1.setBounds(15, 40, 180, comboBox1.getPreferredSize().height);

				//---- label3 ----
				label3.setText("DatenbankServer");
				panel1.add(label3);
				label3.setBounds(20, 85, 175, label3.getPreferredSize().height);

				//---- button2 ----
				button2.setText("start ");
				button2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						button2ActionPerformed(e);
					}
				});
				panel1.add(button2);
				button2.setBounds(20, 105, 175, button2.getPreferredSize().height);

				//---- button3 ----
				button3.setText("stop");
				button3.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						button3ActionPerformed(e);
					}
				});
				panel1.add(button3);
				button3.setBounds(20, 130, 175, button3.getPreferredSize().height);

				//======== scrollPane1 ========
				{
					scrollPane1.setViewportView(list1);
				}
				panel1.add(scrollPane1);
				scrollPane1.setBounds(210, 40, 350, 220);

				//---- button1 ----
				button1.setText("load panel data");
				button1.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						button1ActionPerformed(e);
					}
				});
				panel1.add(button1);
				button1.setBounds(15, 220, 175, button1.getPreferredSize().height);

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < panel1.getComponentCount(); i++) {
						Rectangle bounds = panel1.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel1.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel1.setMinimumSize(preferredSize);
					panel1.setPreferredSize(preferredSize);
				}
			}
			tabbedPane1.addTab("Server config", panel1);


			//======== panel2 ========
			{
				panel2.setLayout(null);
				panel2.add(comboBox2);
				comboBox2.setBounds(30, 70, 245, comboBox2.getPreferredSize().height);

				//---- label2 ----
				label2.setText("text");
				panel2.add(label2);
				label2.setBounds(30, 45, 255, label2.getPreferredSize().height);

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < panel2.getComponentCount(); i++) {
						Rectangle bounds = panel2.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel2.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel2.setMinimumSize(preferredSize);
					panel2.setPreferredSize(preferredSize);
				}
			}
			tabbedPane1.addTab("remote and backup", panel2);


			//======== panel3 ========
			{
				panel3.setLayout(null);

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < panel3.getComponentCount(); i++) {
						Rectangle bounds = panel3.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel3.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel3.setMinimumSize(preferredSize);
					panel3.setPreferredSize(preferredSize);
				}
			}
			tabbedPane1.addTab("update ", panel3);


			//======== panel4 ========
			{
				panel4.setLayout(null);

				{ // compute preferred size
					Dimension preferredSize = new Dimension();
					for(int i = 0; i < panel4.getComponentCount(); i++) {
						Rectangle bounds = panel4.getComponent(i).getBounds();
						preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
						preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
					}
					Insets insets = panel4.getInsets();
					preferredSize.width += insets.right;
					preferredSize.height += insets.bottom;
					panel4.setMinimumSize(preferredSize);
					panel4.setPreferredSize(preferredSize);
				}
			}
			tabbedPane1.addTab("PlugIns", panel4);

		}
		add(tabbedPane1);
		tabbedPane1.setBounds(5, 5, 580, 305);

		{ // compute preferred size
			Dimension preferredSize = new Dimension();
			for(int i = 0; i < getComponentCount(); i++) {
				Rectangle bounds = getComponent(i).getBounds();
				preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
				preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
			}
			Insets insets = getInsets();
			preferredSize.width += insets.right;
			preferredSize.height += insets.bottom;
			setMinimumSize(preferredSize);
			setPreferredSize(preferredSize);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JTabbedPane tabbedPane1;
	private JPanel panel1;
	private JLabel label1;
	private JComboBox comboBox1;
	private JLabel label3;
	private JButton button2;
	private JButton button3;
	private JScrollPane scrollPane1;
	private JList list1;
	private JButton button1;
	private JPanel panel2;
	private JComboBox comboBox2;
	private JLabel label2;
	private JPanel panel3;
	private JPanel panel4;
	// JFormDesigner - End of variables declaration  //GEN-END:variables


	public guiserverpanel.MainFrame getMframe()
	{
		mframe = new MainFrame();
		return mframe;
	}

	public void setMframe(guiserverpanel.MainFrame mframe) {
		this.mframe = mframe;
	}

	public JLabel getLabel3() {
		return label3;
	}

	public void setLabel3(JLabel label3) {
		this.label3 = label3;
	}

	public JButton getButton2() {
		return button2;
	}

	public void setButton2(JButton button2) {
		this.button2 = button2;
	}

	public JButton getButton3() {
		return button3;
	}

	public void setButton3(JButton button3) {
		this.button3 = button3;
	}

	public JScrollPane getScrollPane1() {
		return scrollPane1;
	}

	public void setScrollPane1(JScrollPane scrollPane1) {
		this.scrollPane1 = scrollPane1;
	}

	public JList getList1() {
		return list1;
	}

	public void setList1(JList list1) {
		this.list1 = list1;
	}

	public JButton getButton1() {
		return button1;
	}

	public void setButton1(JButton button1) {
		this.button1 = button1;
	}

	public JPanel getPanel3() {
		return panel3;
	}

	public void setPanel3(JPanel panel3) {
		this.panel3 = panel3;
	}

	public JPanel getPanel4() {
		return panel4;
	}

	public void setPanel4(JPanel panel4) {
		this.panel4 = panel4;
	}

	public JTabbedPane getTabbedPane1() {
		return tabbedPane1;
	}

	public void setTabbedPane1(JTabbedPane tabbedPane1) {
		this.tabbedPane1 = tabbedPane1;
	}

	public JPanel getPanel1() {
		return panel1;
	}

	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}

	public JLabel getLabel1() {
		return label1;
	}

	public void setLabel1(JLabel label1) {
		this.label1 = label1;
	}

	public JComboBox getComboBox1() {
		return comboBox1;
	}

	public void setComboBox1(JComboBox comboBox1) {
		this.comboBox1 = comboBox1;
	}

	public JPanel getPanel2() {
		return panel2;
	}

	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}

	public JComboBox getComboBox2() {
		return comboBox2;
	}

	public void setComboBox2(JComboBox comboBox2) {
		this.comboBox2 = comboBox2;
	}

	public JLabel getLabel2() {
		return label2;
	}

	public void setLabel2(JLabel label2) {
		this.label2 = label2;
	}
}
