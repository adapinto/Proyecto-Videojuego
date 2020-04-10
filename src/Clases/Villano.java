package Clases;

import java.util.HashMap;

import Implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Villano extends ObjetoJuego {
	private HashMap<String, Animacion> animaciones;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	private String animacionActual;

	public Villano(int x, int y, String nombreImagen, int velocidad, String animacionActual) {
		super(x, y, nombreImagen, velocidad);
		this.animacionActual=animacionActual;
		animaciones = new HashMap<String, Animacion>();
		inicializarAnimaciones();
	}

	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen,yImagen,anchoImagen,altoImagen, x,y,anchoImagen,altoImagen);
	}

	public void inicializarAnimaciones() {
		Rectangle coordenadasVillano[]= {
				new Rectangle(2,51, 80,28),
				new Rectangle(93,7,75,40),
				new Rectangle(146,9,73,36),
				new Rectangle(103,150,58,29)	
		};
		Animacion animacionVillano=new Animacion(0.8,coordenadasVillano);
		animaciones.put("villano",animacionVillano);
	}
	
	public void calcularFrame(double t) {
		Rectangle coordenadas=animaciones.get(animacionActual).calcularFrameActual(t);
		this.xImagen = (int)coordenadas.getX();
		this.yImagen = (int)coordenadas.getY();
		this.altoImagen = (int)coordenadas.getWidth();
		this.anchoImagen = (int)coordenadas.getHeight();
	}
	
	@Override
	public void mover() {
		// TODO Auto-generated method stub
		
	}
	public String getAnimacionActual() {
		return animacionActual;
	}

	public void setAnimacionActual(String animacionActual) {
		this.animacionActual = animacionActual;
	}
}
