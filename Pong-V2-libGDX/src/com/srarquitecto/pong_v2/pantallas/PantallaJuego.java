package com.srarquitecto.pong_v2.pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL11;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.srarquitecto.pong_v2.Mundo;
import com.srarquitecto.pong_v2.Pong_V2;
import com.srarquitecto.pong_v2.actores.ActorBola;
import com.srarquitecto.pong_v2.actores.Limites;

public class PantallaJuego extends PantallaAbstracta {
	
	//private Mundo mundo;
	private Stage escena;
	private Mundo mundo;
	private ActorBola bola;
	private Limites limites;
	
	//private float alto  = Pong_V2.MANAGER.get("img/bola.png", Texture.class).getHeight();
	//private float ancho = Pong_V2.MANAGER.get("img/bola.png", Texture.class).getWidth();
	
	public PantallaJuego(Pong_V2 juego) {
		super(juego);

	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		this.escena.getCamera().update();
		
		this.mundo.getMundo().step(1/60f, 6, 2);
		
		this.mundo.getDebugger().render(this.mundo.getMundo(), this.escena.getCamera().combined);
		
		this.escena.act();
		this.escena.draw();

	}

	@Override
	public void show() {
		this.mundo = new Mundo(new Vector2(0, -9.8f), true);
		this.escena = new Stage();
		
		this.limites = new Limites(mundo);
		this.escena.addActor(this.limites);
		
		this.bola = new ActorBola(mundo);
		this.escena.addActor(this.bola);

	}

	@Override
	public void dispose() {
		
		this.escena.dispose();

	}

}
