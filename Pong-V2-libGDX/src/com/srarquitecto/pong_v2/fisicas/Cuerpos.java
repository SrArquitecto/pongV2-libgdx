package com.srarquitecto.pong_v2.fisicas;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;

public class Cuerpos {
	
	private Body cuerpo;
	private BodyDef defCuerpo;
	private FixtureDef fixture;
	
	private EdgeShape recta;
	private PolygonShape poligono;
	private CircleShape circulo;

	private String nombre;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
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

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public EdgeShape getRecta() {
		return recta;
	}

	public void setRecta(EdgeShape recta) {
		this.recta = recta;
	}
	
	public PolygonShape getPoligono() {
		return poligono;
	}

	public void setPoligono(PolygonShape poligono) {
		this.poligono = poligono;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre()  {
		return this.nombre;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	public Cuerpos() {
		
		this.defCuerpo = null;
		this.fixture   = null;
		this.poligono = null;
		
		this.recta = null;
		this.poligono = null;
		this.circulo = null;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	
	public Mundo crearLinea(Mundo mundo, Vector2 posicion, Vector2 posicionV1, Vector2 posicionV2, int tipoCuerpo, float densidad, float friccion, float rebote, String nombre) {
		
		this.nombre = nombre;
		
		this.defCuerpo = new BodyDef();
		this.defCuerpo.position.set(posicion);
		
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
		this.recta.set(posicionV1, posicionV2);
		
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
	
	public Mundo crearRectangulo(Mundo mundo, Vector2 posicion, Vector2 radio, int tipoCuerpo, float densidad, float friccion, float rebote, String nombre) {
		this.nombre = nombre;
		
		this.nombre = nombre;
		
		this.defCuerpo = new BodyDef();
		this.defCuerpo.position.set(posicion);
		
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
		
		this.poligono = new PolygonShape();
		this.poligono.setAsBox(radio.x, radio.y);
		
		this.fixture   = new FixtureDef();
		this.fixture.shape = this.poligono;
		
		this.fixture.density = densidad;
		this.fixture.friction = friccion;
		this.fixture.restitution = rebote;
		
		this.cuerpo = mundo.getMundo().createBody(this.defCuerpo);
		this.cuerpo.createFixture(this.fixture);
		
		this.poligono.dispose();
		
		return mundo;
	}
	
	public Mundo crearPoligono(Mundo mundo, Vector2 posicion, Vector2[] vertices, int tipoCuerpo, float densidad, float friccion, float rebote, String nombre) {
		this.nombre = nombre;
		
		this.nombre = nombre;
		
		this.defCuerpo = new BodyDef();
		this.defCuerpo.position.set(posicion);
		
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
		
		this.poligono = new PolygonShape();
		this.poligono.set(vertices);
		
		this.fixture   = new FixtureDef();
		this.fixture.shape = this.poligono;
		
		this.fixture.density = densidad;
		this.fixture.friction = friccion;
		this.fixture.restitution = rebote;
		
		this.cuerpo = mundo.getMundo().createBody(this.defCuerpo);
		this.cuerpo.createFixture(this.fixture);	
		
		this.poligono.dispose();
		
		return mundo;
	}

	
}
