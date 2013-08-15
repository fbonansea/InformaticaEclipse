package modelo;

import java.util.ArrayList;

public class Nodo {


		private Integer valor;
		private Nodo padre;
		private  ArrayList<Nodo> hijo;
		private Integer cont=0;
		private Nodo proxPadre;
		private Integer cuentaHijo=0;
		
		private String descripcion;
		
//		public Nodo(Integer p, Integer[] h)
//		{
//			valor=p;
//			hijo=h;
//		}
		public Nodo(Integer p)
		{
			valor=p;
			
		}

		public Integer GetValor ()
		{
			return valor;
		}
		
//		public Integer GetPadre ()
//		{
//			return padre;
//		}

		public void setPadre (Nodo p)
		{
			padre=p;
		}
		public ArrayList<Nodo> GetHijos()
		{
			return hijo;
		}
		
//		public Integer GetProxHijo()
//		{
//			cont++;
//			return hijo[cont--];
//		}
		
		public void SetProxPadre (Nodo proximo)
		{
			proxPadre=proximo;
		}
		
		public void AgregarHijo(Nodo h)
		{
			if(hijo== null)
				hijo = new ArrayList<>();
		   
			hijo.add(h);

		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
}
