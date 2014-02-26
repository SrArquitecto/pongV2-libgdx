package com.srarquitecto.pong_v2.fisicas;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

public class CuerpoLinea extends Cuerpos{
	
	private EdgeShape recta;
	
	public EdgeShape getRecta() {
		return recta;
	}

	public void setRecta(EdgeShape recta) {
		this.recta = recta;
	}
	
	public CuerpoLinea() {
		super();
		this.recta = null;
	}
	
	public Mundo CuerpoLinea(Mundo mundo,float posX, float posY, float posXV1, float posYV1, float posXV2, float posYV2, int tipoCuerpo, float densidad, float friccion, float rebote, String nombre) {

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

}
