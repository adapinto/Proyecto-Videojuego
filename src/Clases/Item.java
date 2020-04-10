package Clases;

import Implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Item extends ObjetoJuego {
	private int cantidadVidas;

	public Item(int x, int y, String nombreImagen, int velocidad, int cantidadPuntos) {
		super(x, y, nombreImagen, velocidad);
		this.setCantidadVidas(cantidadVidas);
		this.ancho = (int)Juego.imagenes.get("coin").getWidth();
		this.alto = (int)Juego.imagenes.get("coin").getHeight();
	}


	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get("coin"), this.x,this.y);
		graficos.setStroke(Color.RED);
		graficos.strokeRect(x, y, ancho, alto);
		
	}

	@Override
	public void mover() {
		if (Juego.arriba) {
			y-=velocidad;
		}
		
		if (Juego.abajo) {
			y+=velocidad;
		}
		
	}

	public Rectangle obtenerRectangulo() {
		return new Rectangle(x, y, ancho, alto);
	}
	public void setCantidadVidas(int cantidadVidas) {
		this.cantidadVidas = cantidadVidas;
	}
	

}
