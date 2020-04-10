package Clases;

import java.util.HashMap;

import Implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
//import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Villano extends ObjetoJuego {
	private int vidas;
	private HashMap<String, Animacion> animaciones;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	private String animacionActual;
	private int direccion=1;
	
	
	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public Villano(int x, int y, String nombreImagen, int velocidad, int vidas, String animacionActual) {
		super(x, y, nombreImagen, velocidad);
		this.vidas = vidas;
		this.animacionActual=animacionActual;
		animaciones = new HashMap<String, Animacion>();
		inicializarAnimaciones(); 
	}
	
	public int getVidas() {
		return vidas;
	}
	public void setVidas(int vidas) {
		this.vidas = vidas;
	}
	
	public void inicializarAnimaciones() {
		Rectangle coordenadasLanzar[]= {
				new Rectangle(0,7,27,75),
				new Rectangle(36,2,43,81),
				new Rectangle(93,8,41,74),	
				new Rectangle(146,7,36,76),
				new Rectangle(200,7,29,75)
		};
		Animacion animacionLanzar=new Animacion(1,coordenadasLanzar);
		animaciones.put("lanzar",animacionLanzar);		
	}
	
	public void calcularFrame(double t) {
		Rectangle coordenadas=animaciones.get("lanzar").calcularFrameActual(t);
		this.xImagen = (int)coordenadas.getX();
		this.yImagen = (int)coordenadas.getY();
		this.altoImagen = (int)coordenadas.getWidth();
		this.anchoImagen = (int)coordenadas.getHeight();
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(x, y, anchoImagen, altoImagen);
	}
	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen,yImagen,anchoImagen,altoImagen, x,y,anchoImagen,altoImagen);
		graficos.setStroke(Color.RED);
		graficos.strokeRect(x, y, (direccion*anchoImagen), altoImagen);
	}
	
	@Override
	public void mover() {  
	}

	public String getAnimacionActual() {
		return animacionActual;
	}

	public void setAnimacionActual(String animacionActual) {
		this.animacionActual = animacionActual;
	}
}