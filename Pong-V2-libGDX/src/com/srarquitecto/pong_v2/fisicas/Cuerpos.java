package com.srarquitecto.pong_v2.fisicas;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public abstract class Cuerpos {
	
	protected Body cuerpo;
	protected BodyDef defCuerpo;
	protected FixtureDef fixture;
	
	public Body getCuerpo() {
		return cuerpo;
	}

	public void setCuerpo(Body cuerpo) {
		this.cuerpo = cuerpo;
	}

	public BodyDef getDefCuerpo() {
		return defCuerpo;
	}

	public void setDefCuerpo(BodyDef defCuerpo) {
		this.defCuerpo = defCuerpo;
	}

	public FixtureDef getFixture() {
		return fixture;
	}

	public void setFixture(FixtureDef fixture) {
		this.fixture = fixture;
	}
	
	public Cuerpos() {
		//this.setDefCuerpo(new BodyDef());
		//this.setFixture(new FixtureDef());
		//this.setRecta(new EdgeShape());
		
		this.defCuerpo = null;
		this.fixture   = null;
	}
	
	public abstract Mundo CuerpoLinea(Mundo mundo,float posX, float posY, float posXV1, float posYV1, float posXV2, float posYV2, int tipoCuerpo, float densidad, float friccion, float rebote, String nombre);
	
	/*
	
	public Mundo cuerpoLinea(Mundo mundo,float posX, float posY, float posXV1, float posYV1, float posXV2, float posYV2, int tipoCuerpo, float densidad, float friccion, float rebote, String nombre) {

		this.defCuerpo = new BodyDef();
		this.defCuerpo.position.set(posX, posY);
		
		switch(tipoCuerpo) {
		case 0:
			this.defCuerpo.type = BodyType.StaticBody;
			break;
		
		case 1:
			this.defCuerpo.type = BodyType.KinematicBody;
			break;
		
		case 2:
			this.defCuerpo.type = BodyType.DynamicBody;
			break;	
		}
		
		this.recta     = new EdgeShape();
		this.recta.set(posXV1, posYV1, posXV2, posYV2);
		
		this.fixture   = new FixtureDef();
		this.fixture.shape = this.recta;
		
		this.fixture.density = densidad;
		this.fixture.friction = friccion;
		this.fixture.restitution = rebote;
		
		this.cuerpo = mundo.getMundo().createBody(this.defCuerpo);
		this.cuerpo.createFixture(this.fixture);
		
		this.recta.dispose();
		
		return mundo;
		
	}
	*/
	
}
