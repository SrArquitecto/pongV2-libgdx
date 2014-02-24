package com.srarquitecto.pong_v2.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.srarquitecto.pong_v2.Mundo;
import com.srarquitecto.pong_v2.Pong_V2;

public class ActorBola extends Actor {
	
	private Mundo        mundo;
	private Body         cuerpo;
	private BodyDef      bola;
	private FixtureDef   fixture;
	private PolygonShape cuadrado;
	
	private TextureRegion region = new TextureRegion(Pong_V2.MANAGER.get("img/bola.png", Texture.class));
	
	private float altoBola  = Pong_V2.MANAGER.get("img/bola.png", Texture.class).getHeight();
	private float anchoBola = Pong_V2.MANAGER.get("img/bola.png", Texture.class).getWidth();
	
	public ActorBola(Mundo mundo) {
		this.mundo = mundo;
		crearBola();
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(region, getX(), getY(), 0, 0, getWidth(), getHeight(), 1, 1, getRotation());
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		setX(this.bola.position.x - anchoBola/2f);
		setY(this.bola.position.y - altoBola/2f);
		
	}

	//Este metodo es el encargado de crear la "bola" del Pong.
	public void crearBola() {
		super.setHeight(this.altoBola);
		super.setWidth(this.anchoBola);
		super.setPosition(Gdx.graphics.getWidth()/2 - anchoBola/2, Gdx.graphics.getHeight()/2 - altoBola/2);
		
		this.bola = new BodyDef();
		this.bola.position.set(getX() + anchoBola/2f, getY() + altoBola/2f);
		this.bola.type = BodyType.DynamicBody;
		
		this.cuadrado = new PolygonShape();
		//Aquí no se refiere al diametro, si no al radio, por lo que dividimos entre dos el alto y el ancho de la imagen.
		this.cuadrado.setAsBox(anchoBola/2, altoBola/2);
		
		this.fixture = new FixtureDef();
		this.fixture.shape = cuadrado;
		
		this.cuerpo = this.mundo.getMundo().createBody(this.bola);
		this.cuerpo.createFixture(fixture);
		
		cuadrado.dispose();
		
		
		this.cuerpo.setLinearVelocity(20f, 15f);
	}

}
