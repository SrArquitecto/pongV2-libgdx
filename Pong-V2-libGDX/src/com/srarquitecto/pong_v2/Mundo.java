package com.srarquitecto.pong_v2;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class Mundo {

	private World mundo;
	private Box2DDebugRenderer debug = new Box2DDebugRenderer();
	
	private static final float factorConversionMetro = 1f;
	private static final float factorConversionPixel = 0.5f;
	
	private static final float ALTO  = Gdx.graphics.getHeight();
	private static final float ANCHO = Gdx.graphics.getWidth();
	
	//Todos estos metodos son de conversion entre pixeles y metros, para hacer mas facil el programa.
	
	public float pixelMetro(float pixel) {
		return pixel * factorConversionMetro;
	}
	
	public float metroPixel(float metro) {
		return metro * factorConversionPixel;
	}
	
	public Vector2 pixelMetro(Vector2 vector) {
		vector.x = vector.x * factorConversionMetro;
		vector.y = vector.y * factorConversionMetro;
		
		return vector;
	}
	
	public Vector2 metroPixel(Vector2 vector) {
		vector.x = vector.x * factorConversionMetro;
		vector.y = vector.y * factorConversionMetro;
		
		return vector;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Box2DDebugRenderer getDebugger() {
		return debug;
	}
	
	public World getMundo() {
		return this.mundo;
	}
	
	public Mundo(Vector2 gravedad, Boolean dormir) {
		this.mundo = new World(gravedad, dormir);
	}
}
