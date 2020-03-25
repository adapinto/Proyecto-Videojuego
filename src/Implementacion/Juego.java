package Implementacion;

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

public class Juego extends Application {
		private Group root;
		private Scene escena;
		private Canvas lienzo;
		private GraphicsContext graficos;
		private int x=0;
	
	public static void main (String [] args) {
	launch (args);	
	}
	

	@Override
	public void start(Stage ventana) throws Exception {
		inicializarComponentes();
		gestionEventos();
		ventana.setScene(escena);
		ventana.setTitle("Oppositi Complementari");
		ventana.show();
		cicloJuego();
		
	}
	
	public void cicloJuego() {
		long tiempoInicial=System.nanoTime();
		AnimationTimer animationTimer= new AnimationTimer() {

			@Override
			public void handle(long tiempoActual) {
				double t=(tiempoActual-tiempoInicial)/1000000000.0;
				actualizarEstado();
				pintar();
			}
			
		};
		animationTimer.start();
		}
	
	public void actualizarEstado() {
		
	}
	
	public void inicializarComponentes() {
		root= new Group();
		escena=new Scene(root, 700,500);
		lienzo=new Canvas(700,500);
		root.getChildren().add(lienzo);
		graficos=lienzo.getGraphicsContext2D();
	}
	
	
	public void pintar() {
		graficos.fillRect(0, 0,700, 500);
		graficos.drawImage(new Image("personaje.png"),x,0);
	}
	
	
	
	public void gestionEventos() {
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
				switch (evento.getCode().toString()) {
				case "RIGHT":
					x+=10;
					break;
				}
			}	
		});
			
		
		
	}
	
}
