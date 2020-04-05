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
			this.xImagen = 134;
			this.yImagen = 200;
			break;
		case 2:
			this.xImagen=0;
			this.yImagen=200;
			break;
		case 3:
			this.xImagen=134;
			this.yImagen=235;
			break;
		case 4:
			this.xImagen=166;
			this.yImagen=201;
			break;
		case 5:
			this.xImagen=199;
			this.yImagen=202;
			break;
		case 6:
			this.xImagen=167;
			this.yImagen=202;
			break;
		case 7:
			this.xImagen=294;
			this.yImagen=14;
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
		// TODO Auto-generated method stub
		
	}
	
	

}
