package modelo;



	import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import ui.VentanaPrincipalUI;

	public class Jtree {
	    
		private ArrayList<DefaultMutableTreeNode> dmtnLista= new ArrayList<>();
		//private DefaultTreeModel modelo;
		//private Integer i=2;
		private int j=0, m,k,l;
		private JTree tree;
		
		public Jtree(ArrayList<Nodo> ListaNodo){
			
			dmtnLista.add(new DefaultMutableTreeNode("Articulos"));
			DefaultTreeModel modelo =new DefaultTreeModel(dmtnLista.get(0));
			tree = new JTree(modelo);
			
//			for(Nodo nodo: ListaNodo)
//			  ArmaJtree(nodo);
			dmtnLista.add(new DefaultMutableTreeNode(ListaNodo.get(0).GetValor()));
		    modelo.insertNodeInto(dmtnLista.get(1), dmtnLista.get(0), 0);
			ArmaJtree(ListaNodo.get(0),1,modelo,0);
			
			MostrarArbol();
		}
		
		public void ArmaJtree(Nodo nodo,int avanceLista,  DefaultTreeModel modelo, int indicePtemporal)
		{

			
			//dmtnLista.add(new DefaultMutableTreeNode(nodo.GetHijos().get(j).GetValor()));
			if (nodo.GetHijos()!=null)
			{
				
				for (Nodo hijo: nodo.GetHijos())
				{
					//indicePtemporal=avanceLista;
					//indicePtemporal--;
					 avanceLista++;
					 indicePtemporal++;
					 dmtnLista.add(new DefaultMutableTreeNode(hijo.GetValor().toString()));
				     modelo.insertNodeInto(dmtnLista.get(dmtnLista.size()-1), dmtnLista.get(indicePtemporal),j);
//					 System.out.println(dmtnLista.get(dmtnLista.size()-1));
					 //i, i--
					
//					 modelo.insertNodeInto(dmtnLista.get(m),  dmtnLista.get(i), j);
//				     i++;j=0;
				     ArmaJtree(hijo,avanceLista,modelo,indicePtemporal);
				     if(hijo.GetHijos()!=null)
				       j++;
				     indicePtemporal--;
				     
				     //avanceLista++;
				    
				}
				//j--;
			}
			else 
				{//ahi nomas hace el return y el -- no afecta
				indicePtemporal--;}
				
		return;
			
		}
		
		
		
//		 public DefaultTreeModel doExplosion2(DefaultMutableTreeNode Father, DefaultTreeModel model){
//
//		        int sons=0;
//		        DefaultMutableTreeNode nodes[] = new DefaultMutableTreeNode[100];
//		        
//		        try {
//		            Connection cn = new Connection();
//		            ResultSet listaHijos = null;
//		            String qry = "SELECT description.desc_std FROM (SELECT fatherson.boms_id AS fs, description.lan_id AS lan FROM description,bom,design,fatherson WHERE description.desc_id = design.desc_id AND design.des_id = bom.des_id AND bom.bom_id = fatherson.bomf_id AND description.desc_std = '"+Father+"') T, bom, design, description WHERE T.fs = bom.bom_id AND bom.des_id = design.des_id AND design.desc_id = description.desc_id AND T.lan = description.lan_id";
//		            listaHijos = cn.st.executeQuery(qry);
//
//		            while (listaHijos.next()) {
//		                nodes[sons] = new DefaultMutableTreeNode(listaHijos.getString("description.desc_std")); //guardo el nombre de cada hijo
//		                model.insertNodeInto(nodes[sons], Father, sons);
//		                doExplosion2(nodes[sons], model);
//		                sons++;               
//		            }
//		            cn.st.close();
//		            cn.connection.close(); 
//		        } catch (Exception e) {
//		            e.printStackTrace();
//		            System.out.println("DataBase error: " + e.getMessage());
//		            JOptionPane.showMessageDialog(null, "Error");
//		        }      
//		        
//		        return model;      
//		    }
		
		 
		public void MostrarArbol ()
		{
			VentanaPrincipalUI v = new VentanaPrincipalUI();
//			v.setMinimumSize(new Dimension(200, 200));
	        JScrollPane scroll = new JScrollPane(tree);
//	        JTree arbolPre=new JTree();
//	        arbolPre=v.GetArbolPrecargado();
//	        arbolPre=this.tree;
	        v.getContentPane().add(scroll);
	        v.pack();
	        v.setVisible(true);
	        v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
		
	}
