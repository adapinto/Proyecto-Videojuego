package Implementacion;

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
	
	public static void main (String [] args) {
	launch (args);	
	}
	

	@Override
	public void start(Stage ventana) throws Exception {
		inicializarComponentes();
		pintar();
		gestionEventos();
		ventana.setScene(escena);
		ventana.setTitle("Oppositi Complementari");
		ventana.show();
		
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
		graficos.drawImage(new Image("personaje.png"),0,0);
	}
	
	
	
	public void gestionEventos() {
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
				System.out.println("Se está presionado la tecla:"+evento.getCode());
			}	
		});
			
		
		
	}
	
}
