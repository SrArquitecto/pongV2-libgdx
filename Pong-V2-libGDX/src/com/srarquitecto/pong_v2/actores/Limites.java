package com.srarquitecto.pong_v2.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.srarquitecto.pong_v2.fisicas.Cuerpos;
import com.srarquitecto.pong_v2.fisicas.Mundo;

public class Limites extends Actor{

	private Mundo mundo;
    private Cuerpos limiteInf, limiteSup;
	
	public Limites(Mundo mundo) {
		this.mundo = mundo;
		this.crearLimites();
	}
	
	
	private void crearLimites() {
		this.limiteInf=new Cuerpos();
		this.mundo = this.limiteInf.crearLinea(mundo, new Vector2(0f, 0f), new Vector2(0f, 0f), new Vector2(Gdx.graphics.getWidth(), 0), 0, 0, 0, 1, "porteriaIzq");
		this.limiteSup = new Cuerpos();
		this.mundo = this.limiteSup.crearLinea(mundo, new Vector2(0f, 0f), new Vector2(0f, Gdx.graphics.getHeight()), new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()), 0, 0, 0, 1, "porteriaDer");
	}
	/*
	
	public void crearLimiteInferior() {
		//Definimos el cuerpo y le damos una posicion.
		this.limiteInf = new BodyDef();
		this.limiteInf.position.set(0, 0);
		this.limiteInf.type = BodyType.StaticBody;
		
		//Creamos la linea que va desde la posicion (0, 0) a (1280, 0);
		this.lineaInf = new EdgeShape();
		this.lineaInf.set(0, 0, Gdx.graphics.getWidth(), 0);
		
		this.fixInf = new FixtureDef();
		this.fixInf.shape = this.lineaInf;
		this.fixInf.restitution = 1f;
		
		this.cuerpoInf = this.mundo.getMundo().createBody(this.limiteInf);
		this.cuerpoInf.createFixture(this.fixInf);
		
		this.lineaInf.dispose();
	}
	
	public void crearLimiteSuperior() {
		//Definimos el cuerpo y le damos una posicion.
		//La posición parece ser que es relativa al primer punto de la forma (en este caso, una linea).
		this.limiteSup = new BodyDef();
		this.limiteSup.position.set(0, 0);
		this.limiteSup.type = BodyType.StaticBody;
		
		//Creamos la linea que va desde la posicion (0, 0) a (1280, 720);
		this.lineaSup = new EdgeShape();
		this.lineaSup.set(0, Gdx.graphics.getHeight(), Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		this.fixSup = new FixtureDef();
		this.fixSup.shape = this.lineaSup;
		
		//Define las propiedades físicas del objeto. Restitution es el rebote (de 0f a 1f).
		this.fixSup.restitution = 1f;
		
		this.cuerpoSup = this.mundo.getMundo().createBody(this.limiteSup);
		this.cuerpoSup.createFixture(this.fixSup);
		
		this.lineaSup.dispose();
	}
	
	*/
}
