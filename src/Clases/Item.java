package Clases;

import Implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Item extends ObjetoJuego {
	//private int cantidadPuntos;

	public Item(int x, int y, String nombreImagen, int velocidad, int cantidadPuntos) {
		super(x, y, nombreImagen, velocidad);
		//this.cantidadPuntos = cantidadPuntos;
		this.ancho = (int)Juego.imagenes.get("item").getWidth();
		this.alto = (int)Juego.imagenes.get("item").getHeight();
	}

	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get("item"), this.x,this.y);
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
	
	/*public void Animaciones() {
		Rectangle coordenadasMoneda []= {
				new Rectangle(38,90,105,26),
				new Rectangle(81,90,100,57),
				new Rectangle(150,90,100,87),
				new Rectangle(260,90,100,102),
				new Rectangle(382,90,100,87),
				new Rectangle(487,90,100,57),
				new Rectangle(563,90,100,26)
		};
			Animacion animacionMoneda=new Animacion(0.08,coordenadasMoneda);
			animaciones.put("moneda",animacionMoneda);
	}*/

	public Rectangle obtenerRectangulo() {
		return new Rectangle(x, y, ancho, alto);
	}
	

}
