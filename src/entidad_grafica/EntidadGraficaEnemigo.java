package entidad_grafica;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;


public class EntidadGraficaEnemigo extends EntidadGrafica {
	private String [] imagenes;
	private int cont;
	
	/**
	 * Crea una EntidadGraficaEnemigo nueva partiendo de una etiqueta
	 * @param etiqueta JLabel
	 */
	public EntidadGraficaEnemigo(JLabel etiqueta) {
		this.etiqueta=etiqueta;
		grafica = new ImageIcon();
		imagenes = new String[] {"/img/ElfoBueno.png","/img/ElfoLibre.png","/img/ElfoMalo.png","/img/ElfoMaloHerido.png"};
		
		etiqueta.setIcon(grafica);
		
		cont=0;
		//etiqueta.setBorder(new LineBorder(Color.black));
	}
	
	@Override
	public void iniciar() {
		ImageIcon nuevo = new ImageIcon(this.getClass().getResource(this.imagenes[2]));
		grafica.setImage(nuevo.getImage());
	}
	
	@Override
	public void liberar() {
		ImageIcon nuevo = new ImageIcon(this.getClass().getResource(this.imagenes[1]));
		grafica.setImage(nuevo.getImage());
	}
	
	@Override
	public void daniar() {
		ImageIcon nuevo = new ImageIcon(this.getClass().getResource(this.imagenes[3]));
		grafica.setImage(nuevo.getImage());
	}
	
	@Override
	public void desaparecer() {
		/*if(cont==0) {
			liberar();
			cont++;
		}else {
			this.etiqueta.setVisible(false);
		}*/
		this.etiqueta.setVisible(false);
	}
	
	/**
	 * Establece las imagenes de la entidad grafica
	 * @param img arreglo de nuevas imagenes de la entidad grafica
	 */
	public void setImagenes(String [] img) {
		this.imagenes=img;
	}
	
	/**
	 * Consulta las imagenes de la entidad grafica
	 * @return arreglo de imagenes de la entidad grafica.	
	 */
	public String[] getImagenes() {
		return this.imagenes;
	}
	
	@Override
	public JLabel getEtiqueta() {
		return this.etiqueta;
	}
}
