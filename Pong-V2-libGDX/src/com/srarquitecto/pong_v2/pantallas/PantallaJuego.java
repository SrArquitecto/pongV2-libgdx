package com.srarquitecto.pong_v2.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL11;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.srarquitecto.pong_v2.Pong_V2;
import com.srarquitecto.pong_v2.actores.ActorBola;
import com.srarquitecto.pong_v2.actores.ActorIA;
import com.srarquitecto.pong_v2.actores.ActorJugador;
import com.srarquitecto.pong_v2.actores.ActorPala;
import com.srarquitecto.pong_v2.actores.Limites;
import com.srarquitecto.pong_v2.actores.Porterias;
import com.srarquitecto.pong_v2.fisicas.Mundo;

public class PantallaJuego extends PantallaAbstracta {
	
	//private Mundo mundo;
	private Stage escena;
	private Mundo mundo;
	private ActorBola bola;
	private Limites limites;
	private Porterias porterias;
	private ActorPala pala1, pala2;
	private boolean segundoJugador;
	
	//private float alto  = Pong_V2.MANAGER.get("img/bola.png", Texture.class).getHeight();
	//private float ancho = Pong_V2.MANAGER.get("img/bola.png", Texture.class).getWidth();
	
	public PantallaJuego(Pong_V2 juego) {
		super(juego);

	}

	@Override
	public void render(float delta) {
		//Refresco de la pantalla.
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		//Actualizamos la camara.
		this.escena.getCamera().update();
		
		//Frecuencia de redresco de Box2D. Cuanto mayor sea, mayor es la precision pero menor el rendimiento.
		this.mundo.getMundo().step(1/60f, 6, 2);
		
		//Permite ver las lineas y formas descritas con Box2D.
		this.verDebug(true);
		
		this.escena.act();
		this.escena.draw();

	}

	@Override
	public void show() {
		this.mundo = new Mundo(new Vector2(0f, -0f), true);
		this.escena = new Stage();
		
		this.porterias = new Porterias(this.mundo);
		this.escena.addActor(this.porterias);
		
		this.limites = new Limites(mundo);
		this.escena.addActor(this.limites);
		
		this.pala1 = new ActorJugador(mundo, "Jugador 1");
		this.escena.addActor(this.pala1);
		
		if(!segundoJugador) {
			this.pala2 = new ActorIA(mundo);
			this.escena.addActor(pala2);
		}
		else {
			this.pala2 = new ActorJugador(mundo, "Jugador 2");
			this.escena.addActor(pala2);
		}
		
		this.bola = new ActorBola(mundo);
		this.escena.addActor(this.bola);
		

	}
	
	private void verDebug(boolean activar) {
		if(activar)
			this.mundo.getDebugger().render(this.mundo.getMundo(), this.escena.getCamera().combined);
	}

	@Override
	public void dispose() {
		
		this.escena.dispose();
		this.mundo.dispose();

	}

}
