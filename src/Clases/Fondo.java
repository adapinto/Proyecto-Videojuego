package Clases;

import Implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;

public class Fondo extends ObjetoJuego{
	private String nombreImagen2;
	private int y2;
	public Fondo(int x, int y, String nombreImagen,String nombreImagen2, int velocidad) {
		super(x, y, nombreImagen, velocidad);
		this.nombreImagen2=nombreImagen2;
		this.ancho = (int)Juego.imagenes.get("fondo").getWidth();
		this.alto = (int)Juego.imagenes.get("fondo").getHeight();
		this.y2 = this.alto+this.y;
	}

	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get(this.nombreImagen), this.x, this.y);
		graficos.drawImage(Juego.imagenes.get(this.nombreImagen2), this.x, this.y2);
	}

	@Override
	public void mover() {
		if (y <= -1*alto) {
			y=ancho;
		}
		if (y2 <= -1*alto) {
			y2=alto;
		}
		if (Juego.arriba) {
			y-=velocidad;
			y2-=velocidad;
		}
		
		if (Juego.abajo) {
			y+=velocidad;
			y2+=velocidad;
		}
	}
	
}
