package com.srarquitecto.pong_v2.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.srarquitecto.pong_v2.Mundo;

public class Limites extends Actor{

	private Mundo mundo;
	private BodyDef limiteInf, limiteSup;
	private EdgeShape lineaInf, lineaSup;
	private FixtureDef fixture;
	private Body cuerpo;
	
	public Limites(Mundo mundo) {
		this.mundo = mundo;
		this.crearLimiteInferior();
	}
	
	public void crearLimiteInferior() {
		super.setPosition(0, 0);
		
		this.limiteInf = new BodyDef();
		this.limiteInf.position.set(getX(), getY());
		this.limiteInf.type = BodyType.StaticBody;
		
		//Creamos la linea que va desde la posicion (0, 0) a (1280, 0);
		this.lineaInf = new EdgeShape();
		this.lineaInf.set(0, 0, Gdx.graphics.getWidth(), 0);
		
		this.fixture = new FixtureDef();
		this.fixture.shape = lineaInf;
		
		this.cuerpo = this.mundo.getMundo().createBody(this.limiteInf);
	}
	
	public void crearLimiteSuperior() {
		
	}
}
