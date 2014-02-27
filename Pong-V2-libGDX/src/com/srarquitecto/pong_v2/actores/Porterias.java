package com.srarquitecto.pong_v2.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.srarquitecto.pong_v2.fisicas.Cuerpos;
import com.srarquitecto.pong_v2.fisicas.Mundo;

public class Porterias extends Actor {

	private Mundo mundo;
	private Cuerpos porteriaIzq, porteriaDer;
	
	@SuppressWarnings("unused")
	private int contadorIzq, contadorDer;
	
	public Porterias(Mundo mundo) {
		this.mundo = mundo;
		this.contadorDer = 0;
		this.contadorIzq = 0;
		this.crearPorterias();
	}
	
	private void crearPorterias() {
		this.porteriaIzq = new Cuerpos();
		this.mundo = this.porteriaIzq.crearLinea(mundo, new Vector2(-32f, 0f), new Vector2(0, 0), new Vector2(0, Gdx.graphics.getHeight()), 0, 0, 0, 1, "porteriaIzq");
		
		this.porteriaDer = new Cuerpos();
		this.mundo = this.porteriaDer.crearLinea(mundo, new Vector2(Gdx.graphics.getWidth() + 32, 0f), new Vector2(0, 0), new Vector2(0, Gdx.graphics.getHeight()), 0, 0, 0, 1, "porteriaDer");
		//this.mundo = this.mundo.crearLinea(-32f, 0f, 0, 0, 0, Gdx.graphics.getHeight(), 0, 0, 0, 1, "porteriaIzq", this.mundo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	
	private void crearPorteriaIzq() {
		this.porteriaIzq = new BodyDef();
		this.porteriaIzq.position.set(-32, 0);
		this.porteriaIzq.type = BodyType.StaticBody;
		
		this.lineaIzq = new EdgeShape();
		this.lineaIzq.set(0, 0, 0, Gdx.graphics.getHeight());
		
		this.fixtureIzq = new FixtureDef();
		this.fixtureIzq.shape = this.lineaIzq;
		this.fixtureIzq.restitution = 1f;
		
		this.cuerpoIzq = this.mundo.getMundo().createBody(porteriaIzq);
		this.cuerpoIzq.createFixture(this.fixtureIzq);
		
		this.lineaIzq.dispose();
	}
	
	private void crearPorteriaDer() {
		this.porteriaDer = new BodyDef();
		this.porteriaDer.position.set(Gdx.graphics.getWidth() + 32, 0);
		this.porteriaDer.type = BodyType.StaticBody;
		
		this.lineaDer = new EdgeShape();
		this.lineaDer.set(0, 0, 0, Gdx.graphics.getHeight());
		
		this.fixtureDer = new FixtureDef();
		this.fixtureDer.shape = this.lineaIzq;
		this.fixtureDer.restitution = 1f;
		
		this.cuerpoDer = this.mundo.getMundo().createBody(porteriaDer);
		this.cuerpoDer.createFixture(this.fixtureDer);
		
		this.lineaDer.dispose();
	}
	
	*/
}
