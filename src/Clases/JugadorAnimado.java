package Clases;

import java.util.HashMap;

import Implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
//import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class JugadorAnimado extends ObjetoJuego {
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

	public JugadorAnimado(int x, int y, String nombreImagen, int velocidad, int vidas, String animacionActual) {
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
		Rectangle coordenadasCorrer[]= {
				new Rectangle(7,150, 58,29),
				new Rectangle(55,150,58,29),
				new Rectangle(103,150,58,29)	
		};
		Animacion animacionCorrer=new Animacion(0.08,coordenadasCorrer);
		animaciones.put("correr",animacionCorrer);
		
		Rectangle coordenadasDescanso []= {
				new Rectangle(6,4, 62,33),
				new Rectangle(52,4,62,33),
				new Rectangle(100,4,62,33)
		};
			Animacion animacionDescanso=new Animacion(0.4,coordenadasDescanso);
			animaciones.put("descanso",animacionDescanso);
			
			Rectangle coordenadasCorrerArriba []= {
					new Rectangle(5,220,60,31),
					new Rectangle(53,220,62,33),
					new Rectangle(102,220,62,33)
			};
				Animacion animacionCorrerArriba=new Animacion(0.08,coordenadasCorrerArriba);
				animaciones.put("correrarriba",animacionCorrerArriba);
				
				
	}
	
	public void calcularFrame(double t) {
		Rectangle coordenadas=animaciones.get(animacionActual).calcularFrameActual(t);
		this.xImagen = (int)coordenadas.getX();
		this.yImagen = (int)coordenadas.getY();
		this.altoImagen = (int)coordenadas.getWidth();
		this.anchoImagen = (int)coordenadas.getHeight();
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(x, y, (direccion*anchoImagen), altoImagen);
	}
	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen,yImagen,anchoImagen,altoImagen, x,y,(direccion*anchoImagen),altoImagen);
		//graficos.setStroke(Color.RED);
		//graficos.strokeRect(x, y, (direccion*anchoImagen), altoImagen);
	}
	
	@Override
	public void mover() {
		if (x>700)
			x=-80;
		if (y<0)
			y=500;
		if (Juego.derecha)
			x+=velocidad;
		
		if (Juego.izquierda)
			x-=velocidad;
		
		if (Juego.arriba)
			y-=velocidad;
		
		if (Juego.abajo)
			y+=velocidad;
	}

	public String getAnimacionActual() {
		return animacionActual;
	}

	public void setAnimacionActual(String animacionActual) {
		this.animacionActual = animacionActual;
	}
	
	/*public void verificarColisionesItem(Item item) {
	if	(this.obtenerRectangulo().getBoundsInLocal().intersects(item.obtenerRectangulo().getBoundsInLocal()));
	System.out.println("Estan colisionando");
		}*/
}