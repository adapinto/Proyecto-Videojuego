package Clases;

import Implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;


public class Tiles extends ObjetoJuego {
	private int xImagen;
	private int yImagen;
	private int tipoTile;
	
	
	public Tiles(int tipoTile, int x, int y, String nombreImagen, int velocidad, int alto, int ancho) {
		super(x, y, nombreImagen, velocidad);
		this.alto = alto;
		this.ancho = ancho;
		this.tipoTile=tipoTile;
	
		
		
		
		switch(tipoTile) {
		case 1:
			this.xImagen = 35;
			this.yImagen = 34;
			break;
		case 2:
			this.xImagen=34;
			this.yImagen=100;
			break;
		case 3:
			this.xImagen=34;
			this.yImagen=362;
			break;
		case 4:
			this.xImagen=296;
			this.yImagen=34;
			break;
		case 5:
			this.xImagen=296;
			this.yImagen=134;
			break;
		case 6:
			this.xImagen=361;
			this.yImagen=34;
			break;
		case 7:
			this.xImagen=329;
			this.yImagen=200;
			break;
	}
		}


	public int getxImagen() {
		return xImagen;
	}

	public void setxImagen(int xImagen) {
		this.xImagen = xImagen;
	}

	public int getyImagen() {
		return yImagen;
	}




	public void setyImagen(int yImagen) {
		this.yImagen = yImagen;
	}

	public int getTipoTile() {
		return tipoTile;
	}

	public void setTipoTile(int tipoTile) {
		this.tipoTile = tipoTile;
	}

	@Override
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen,yImagen,ancho,alto,x,y,ancho,alto);
		
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
	}
	
	

	

