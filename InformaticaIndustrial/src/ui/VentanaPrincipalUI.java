package ui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;

import modelo.VentanaPrincipal;

import java.awt.Insets;
import java.awt.GridLayout;

public class VentanaPrincipalUI extends JFrame {

	private JPanel contentPane;
	private JTree tree;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipalUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
				
		
	}
	
//	public void ArmaArbol(Nodo nodo)
//	{
//		Jtree jt = new Jtree(nodo);
//	}
	
	
	

//
//	public static void  TreeDemo() {
//		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
//		DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Child 1");
//		root.add(child1);
//		DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Child 2");
//		root.add(child2);
//		JTree tree = new JTree(root);
//		//VentanaPrincipalUI.add(new JScrollPane(tree));
//	}
	
}
