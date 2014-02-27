package com.srarquitecto.pong_v2.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.srarquitecto.pong_v2.Pong_V2;
import com.srarquitecto.pong_v2.fisicas.Cuerpos;
import com.srarquitecto.pong_v2.fisicas.Mundo;

public class ActorBola extends Actor {

	private Mundo mundo;
	private Cuerpos bola;
	
	private TextureRegion region;
	private Vector2 posicion;
	
	//private Sprite spriteCuadrado;
	
	private float altoBola  = Pong_V2.MANAGER.get("img/bola.png", Texture.class).getHeight();
	private float anchoBola = Pong_V2.MANAGER.get("img/bola.png", Texture.class).getWidth();
	
	public ActorBola(Mundo mundo) {
		this.mundo = mundo;
		//this.spriteCuadrado = new Sprite(Pong_V2.MANAGER.get("img/bola.png", Texture.class));
		this.region = new TextureRegion(Pong_V2.MANAGER.get("img/bola.png", Texture.class));
		this.crearBola();
		//this.crearBola();
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		this.posicion = this.bola.getCuerpo().getPosition();
		//this.spriteCuadrado.setPosition(this.posicion.x, this.posicion.y);
		//this.spriteCuadrado.setOrigin(this.cuerpo.geto, originY);
		//this.spriteCuadrado.draw(batch);
		batch.draw(this.region, this.posicion.x - anchoBola/2, this.posicion.y - altoBola/2, 0, 0, getWidth(), getHeight(), 1, 1, getRotation());
	}
	
	@Override
	public void act(float delta) {
		//super.act(delta);

	/*
		if(Gdx.input.justTouched())
			this.bola.getCuerpo().setLinearVelocity(0f, 50f);
		
		if(Gdx.input.isKeyPressed(Keys.UP))
			this.bola.getCuerpo().setLinearVelocity(0f,800f);
		if(Gdx.input.isKeyPressed(Keys.DOWN))
			this.bola.getCuerpo().setLinearVelocity(0f,-600f);
		if(Gdx.input.isKeyPressed(Keys.RIGHT))
			this.bola.getCuerpo().setLinearVelocity(600f,0f);
		if(Gdx.input.isKeyPressed(Keys.LEFT))
			this.bola.getCuerpo().setLinearVelocity(-600f,0f);
		if(Gdx.input.isKeyPressed(Keys.LEFT) && Gdx.input.isKeyPressed(Keys.UP))
			this.bola.getCuerpo().setLinearVelocity(-600f,600f);
			
	*/
		if(Gdx.input.isKeyPressed(Keys.ENTER))
			this.bola.getCuerpo().setLinearVelocity(600f, 600f);

	}
	
	private void crearBola() {
		this.region = new TextureRegion(Pong_V2.MANAGER.get("img/bola.png", Texture.class),(int) this.anchoBola, (int) this.altoBola);
		
		super.setHeight(this.altoBola);
		super.setWidth(this.anchoBola);
		
		Vector2 posicion = new Vector2(Gdx.graphics.getWidth()/2 /* - anchoBola/2*/, Gdx.graphics.getHeight()/2 /*+ this.altoBola/2f*/);
		Vector2 radio = new Vector2(this.anchoBola/2, this.altoBola/2);
		int tipoCuerpo = 2;
		float densidad = 0;
		float friccion = 0;
		float rebote = 1;
		String nombre = "bola";
		
		this.bola = new Cuerpos();
		this.mundo = this.bola.crearRectangulo(mundo, posicion, radio, tipoCuerpo, densidad, friccion, rebote, nombre);
	}

}
