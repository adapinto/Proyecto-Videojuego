package Implementacion;

import java.util.ArrayList;
import java.util.HashMap;

import Clases.Fondo;
import Clases.Item;
import Clases.JugadorAnimado;
import Clases.Tiles;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent; 
import javafx.stage.Stage;

public class Juego extends Application{
	private GraphicsContext graficos;
	private Group root;
	private Scene escena;
	private Canvas lienzo;
	private JugadorAnimado jugadorAnimado;
	private Fondo fondo;
	public static boolean arriba;
	public static boolean abajo;
	public static boolean izquierda;
	public static boolean derecha;
	public static HashMap<String, Image> imagenes;
	private Item item;

	private ArrayList<Tiles> tiles;

	private int tilemap[][] = {
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,7,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,7,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,7,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,7,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,7,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,7,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2},
			{2,1,0,0,0,0,5,0,0,0,0,0,0,0,0,0,0,5,0,0,0,0,1,2},
			{2,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2}
			
	};

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ventana) throws Exception {
		inicializarComponentes();
		gestionEventos();
		ventana.setScene(escena);
		ventana.setTitle("Oppsiti Complementari");
		ventana.show();
		cicloJuego();
	}
	
	public void cicloJuego() {
		long tiempoInicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {

			@Override
			public void handle(long tiempoActual) {
				double t = (tiempoActual - tiempoInicial) / 1000000000.0;
				//System.out.println(t);
				actualizarEstado(t);
				pintar();
			}
			
		};
		
		animationTimer.start();
	}
	
	public void actualizarEstado(double t) {
		//jugadorAnimado.verificarColisionesItem(item);
		jugadorAnimado.calcularFrame(t);
		jugadorAnimado.mover();
		fondo.mover();	
		for(int i=0;i<tiles.size();i++)
			tiles.get(i).mover();
	}
	
	public void inicializarComponentes() {
		imagenes = new HashMap<String,Image>();
		cargarImagenes();

		jugadorAnimado= new JugadorAnimado(250,400,"HojaSprites",3,0, "descanso");
		fondo= new Fondo(0,0,"fondo", "fondo2", 1);
		inicializarTiles();
		item= new Item(320,320,"item",0,1);
		root = new Group();
		escena = new Scene(root, 700, 500);
		lienzo = new Canvas(700, 500);
		root.getChildren().add(lienzo);
		graficos = lienzo.getGraphicsContext2D();
	}
	
	public void inicializarTiles() {
		tiles = new ArrayList<Tiles>();
		for(int i=0;i<tilemap.length;i++) {
			for(int j=0;j<tilemap[i].length;j++) {
				if (tilemap[i][j]!=0)
					this.tiles.add(new Tiles(tilemap[i][j],j*30,i*30,"tiles01",1,30,30));
			}
		}
	}
	
	public void cargarImagenes() {
		imagenes.put("personaje", new Image("personaje.png"));
		imagenes.put("fondo",new Image("fondo.jpg"));
		imagenes.put("fondo2",new Image("fondo2.jpg"));
		imagenes.put("tiles01",new Image("tiles01.png"));
		imagenes.put("HojaSprites",new Image("HojaSprites.png"));
		imagenes.put("item", new Image("item.png"));
	}
	
	public void pintar() {
		fondo.pintar(graficos);
	for(int i=0;i<tiles.size();i++)
			tiles.get(i).pintar(graficos);
		jugadorAnimado.pintar(graficos);
		//item.pintar(graficos);
	}
	
	public void gestionEventos() {
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				switch(evento.getCode().toString()) {
					case "RIGHT":
						derecha = true;
						jugadorAnimado.setDireccion(1);
						jugadorAnimado.setAnimacionActual("correr");
						break;
					case "LEFT":
						izquierda = true;
						jugadorAnimado.setDireccion(-1);
						jugadorAnimado.setAnimacionActual("correr");
						break; 
					case "UP":
						arriba = true;
						jugadorAnimado.setAnimacionActual("correrarriba");
						break;
					case "DOWN":
						abajo = true;
						break;
					case "SPACE":
						jugadorAnimado.setVelocidad(15);
						break;
				}
			}
		});
		
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
				public void handle(KeyEvent evento) {
					switch(evento.getCode().toString()) {
					case "RIGHT":
						derecha = false;
						jugadorAnimado.setAnimacionActual("descanso");
						break;
					case "LEFT":
						izquierda = false;
						jugadorAnimado.setAnimacionActual("descanso");
						break;
					case "UP":
						arriba = false;
						jugadorAnimado.setAnimacionActual("descanso");
						break;
					case "DOWN":
						abajo = false;
						break;
					case "SPACE":
						jugadorAnimado.setVelocidad(5);
				}
			}
			
		});
	}
	
	

}