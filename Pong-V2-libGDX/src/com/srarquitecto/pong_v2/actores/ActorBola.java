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
	
	private Vector2 posicion;
	private Mundo        mundo;
	private Body         cuerpo;
	private BodyDef      bola;
	private FixtureDef   fixture;
	private PolygonShape cuadrado;
	private TextureRegion region;
	//float x, y;
	
	private Sprite spriteCuadrado;;
	
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
		this.posicion = this.cuerpo.getPosition();
		//this.spriteCuadrado.setPosition(this.posicion.x, this.posicion.y);
		//this.spriteCuadrado.setOrigin(this.cuerpo.geto, originY);
		//this.spriteCuadrado.draw(batch);
		batch.draw(this.region, this.posicion.x, this.posicion.y, 0, 0, getWidth(), getHeight(), 1, 1, getRotation());
	}
	
	@Override
	public void act(float delta) {
		//super.act(delta);

		if(Gdx.input.isKeyPressed(Keys.UP))
			this.cuerpo.setLinearVelocity(0f,800f);
		if(Gdx.input.isKeyPressed(Keys.DOWN))
			this.cuerpo.setLinearVelocity(0f,-600f);
		if(Gdx.input.isKeyPressed(Keys.RIGHT))
			this.cuerpo.setLinearVelocity(600f,0f);
		if(Gdx.input.isKeyPressed(Keys.LEFT))
			this.cuerpo.setLinearVelocity(-600f,0f);
		if(Gdx.input.isKeyPressed(Keys.LEFT) && Gdx.input.isKeyPressed(Keys.UP))
			this.cuerpo.setLinearVelocity(-600f,600f);

	}
	
	//Este metodo es el encargado de crear la "bola" del Pong.
	public void crearBola() {
		this.region = new TextureRegion(Pong_V2.MANAGER.get("img/bola.png", Texture.class),(int) this.anchoBola, (int) this.altoBola);
		
		super.setHeight(this.altoBola);
		super.setWidth(this.anchoBola);
		super.setPosition(Gdx.graphics.getWidth()/2 - anchoBola/2, Gdx.graphics.getHeight()/2 - altoBola/2);
		
		this.bola = new BodyDef();
		this.bola.position.set(getX() + this.anchoBola/2f, getY() + this.altoBola/2f);
		this.bola.type = BodyType.DynamicBody;
		
		this.cuadrado = new PolygonShape();
		//Aquí no se refiere al diametro, si no al radio, por lo que dividimos entre dos el alto y el ancho de la imagen.
		this.cuadrado.setAsBox(this.anchoBola/2, this.altoBola/2);
		
		this.fixture = new FixtureDef();
		this.fixture.shape = cuadrado;
		
		this.cuerpo = this.mundo.getMundo().createBody(this.bola);
		this.cuerpo.createFixture(fixture);
		
		cuadrado.dispose();
	

	}
}
