package Clases;

import Implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;

public class Jugador extends ObjetoJuego {
	private int vidas;
	
	
	public Jugador(int x, int y, String nombreImagen, int velocidad, int vidas) {
		super(x, y, nombreImagen, velocidad);
		this.vidas = vidas;
	}


	
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get(nombreImagen), x, y);
	}
	
	@Override
	public void mover() {
		if (x>700)
			x=-80;
		
		if (Juego.derecha)
			x+=velocidad;
		
		if (Juego.izquierda)
			x-=velocidad;
		
		if (Juego.arriba)
			y-=velocidad;
		
		if (Juego.abajo)
			y+=velocidad;
	}
}