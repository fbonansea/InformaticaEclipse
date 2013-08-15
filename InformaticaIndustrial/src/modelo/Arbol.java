package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import persistencia.Conexion;

public class Arbol {

	Conexion c=new Conexion();
	Connection cn= c.getConexion();
	//Connection cn;
	Integer[][] bom = new Integer[10][10];
	int i,j=0;
	
	ArrayList<Nodo> padresPrincipales = new ArrayList<>();
	int m=0;
	int n=1;
	public Arbol(){
	
//		try
//        {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            cn=DriverManager.getConnection("jdbc:odbc:Conecta_db"); 
//
//        }
//		catch (Exception e){
//			e.printStackTrace();
//			System.out.println("Problemas con la conexion");
//		}

//OBTENER PADRES PRINCIPALES
		try {
			StringBuilder sb=new StringBuilder();
//			sb.append("Select distinct padre ");
//			sb.append("from TEST");
//			sb.append("where padre not in (select hijo from TEST)");
			ResultSet padresP = cn.prepareStatement("Select distinct padre from TEST where padre not in (select hijo from TEST)").executeQuery();
//			ResultSet padresP=cn.prepareStatement(sb.toString()).executeQuery();
			 while (padresP.next()) {
		        	padresPrincipales.add(new Nodo (padresP.getInt("padre")));
		        }
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
 //OBTENER TODA LA BOM
			try {
				ResultSet result= cn.prepareStatement("Select * from TEST").executeQuery();
		        
		        while (result.next()) {
		        	bom[i][j] = result.getInt("padre");
		        	  j++;
		        	bom[i][j] = (Integer)result.getObject("hijo");
		        	  i++;
		        	j=0;  
		        }
//Para cada padrePrincipal le arma el arbol		        
		     for(Nodo a: padresPrincipales)
		     {
				// Nodo PadrePrincipal = new Nodo (bom[0][0]);
			     ArmaArbol(bom, a);
		     }
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}
			
			StringBuilder sb=new StringBuilder();
			sb=MostrarArbol(sb,padresPrincipales.get(0));	
			System.out.println(sb.toString());
			
	}
	
	//bom: lo que levanto de la tabla BOM transformado en un array
	//k: posicion de la bom que se esta usando en este momento
	
	private void ArmaArbol(Integer bom[][],Nodo nodo)
	{
				//   La primera vez entra con el nodo padreprincipal
				//	 recorre la bom hasta encontrar q el padre coincide, 
				//	 una vez que lo encuentra setea al hijo segun la segunda columna de la bom
				//	 y llama a la funcion con el hijo 
				//	 cuando no tiene mas hijo, aumenta el k y pregunta de ahi para abajo (bom[k][0])= nodo.getPadre
				//	 
					try{	
						//System.out.println("         ");
						for (int k=0; k<bom.length;k++)
						{	//System.out.println("BOM["+ ((Integer)k).toString() +"]="+bom[k][0] +"  Nodo="+nodo.GetValor().toString() );
						while (bom[k][0]!= null &&(bom[k][0].equals(nodo.GetValor())) && k<7)
					        { 
							  //Integer hijo = nodo.GetProxHijo();
							 System.out.println("Valor: "+nodo.GetValor().toString());
							 Nodo h = new Nodo(bom[k][1]);
							 nodo.AgregarHijo(h);
							 h.setPadre(nodo);
							  System.out.println("Hijo: "+bom[k][1].toString()); 
							 // Nodo hijoN = new Nodo(bom[k][1]);
							  //nodo.SetProxPadre(hijoN);
							  ArmaArbol(bom,h);
							  k++;
							  
					        }
						}
						
						 return;
					  }catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
					}
	}
	
//	private ArrayList<Nodo> Explosiona (Nodo padre)
//	{
//		for (Nodo nodoLista: padresPrincipales)
//		{
//			if(padre.GetValor().equals(nodoLista.GetValor()))
//			{
//				MostrarArbol(padre);
//			}
//		}
//		return null;
//	}
	
	private StringBuilder MostrarArbol (StringBuilder sb,Nodo padre)
	{
//		System.out.println(sb.toString());
		System.out.println("||||||||||||||||||||||");
		sb.append(padre.GetValor());
		if(padre.GetHijos()!=null){
			
			sb.append("\n \t |");
			
				for (Nodo nodoH:padre.GetHijos()){
					System.out.println("hijo->"+nodoH.GetValor());
//					sb.append("\t");
//					System.out.println(sb.toString());
//					System.out.println("---------------");
					
					MostrarArbol(sb, nodoH);
					sb.append("\n \t |");
//					sb.append("\n \t |");
//					sb.append("\t");
//					sb.append(nodoH.GetValor());
//					System.out.println(sb.toString());
				}
		}
			
			
//			Jtree j = new Jtree(padresPrincipales);
			return sb;
	}
	
//	private StringBuilder Tabular (int cantidad){
//		for(int )
//	}
	


}
