package Clases;

import Implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Item extends ObjetoJuego {
	private int cantidadPuntos;

	public Item(int x, int y, String nombreImagen, int velocidad, int cantidadPuntos) {
		super(x, y, nombreImagen, velocidad);
		this.cantidadPuntos = cantidadPuntos;
		this.ancho = (int)Juego.imagenes.get("moneda").getWidth();
		this.alto = (int)Juego.imagenes.get("moneda").getHeight();
	}

	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get("moneda"), this.x,this.y);
		graficos.setStroke(Color.RED);
		graficos.strokeRect(x, y, ancho, alto);
		
	}

	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}

	public Rectangle obtenerRectangulo() {
		return new Rectangle(x, y, ancho, alto);
	}
	

}
