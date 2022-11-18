package entidad.premio;

import javax.swing.JLabel;
import entidad.Entidad;
import entidad.enemigo.Enemigo;
import entidad_grafica.EntidadGraficaPremio;
import entidad_grafica.EntidadGraficaPremioPocion;
import juego.Juego;
import movimiento.MovimientoVerticalPremio;
import visitor.Visitor;
import visitor.VisitorPremio;

public class MejoraPocion extends Mejora{

	public MejoraPocion(int lim_inf,int lim_sup,String nombre, Juego juego, Enemigo e) {
		//this.nombre=nombre;
		this.juego=juego;
		JLabel etiqueta = new JLabel();
		JLabel etiqueta_enemigo = e.getEntidadGrafica().getEtiqueta();
		etiqueta.setBounds(etiqueta_enemigo.getX()+(etiqueta_enemigo.getWidth()/2), etiqueta_enemigo.getY()+80, 25, 25);
		//System.out.println("b->"+etiqueta.getBounds().toString());
		ent_graf = new EntidadGraficaPremioPocion(etiqueta);
		int direccion=1;
		int velocidad=5;
		movimiento = new MovimientoVerticalPremio(this, direccion, velocidad, lim_inf, lim_sup);
		v = new VisitorPremio(this);
		
		tiempo_pausa=0;
	}
	@Override
	public void activar() {
		this.juego.getJugador().curar();
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitarPocion(this);
	}

	@Override
	public void mover() {
		movimiento.mover();
	}
	@Override
	public void accionar(){
		Iterable<Entidad> colisiones = this.detectarColisiones();
		for (Entidad e:colisiones)
			e.aceptar(this.v);

		if (tiempo_pausa==0)
			this.mover();
		else
			--tiempo_pausa;
	}

}
