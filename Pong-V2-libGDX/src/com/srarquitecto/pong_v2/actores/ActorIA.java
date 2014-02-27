package com.srarquitecto.pong_v2.actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.srarquitecto.pong_v2.fisicas.Cuerpos;
import com.srarquitecto.pong_v2.fisicas.Mundo;

public class ActorIA extends ActorPala {

	private Vector2 posicion;
	
	public ActorIA(Mundo mundo) {
		super(mundo);
		this.crearPala();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		this.posicion = super.pala.getCuerpo().getPosition();
		batch.draw(super.region, this.posicion.x - anchoPala/2, this.posicion.y - altoPala/2, 0, 0, getWidth(), getHeight(), 1, 1, getRotation());
	}
	
	public void crearPala() {
		
		super.setHeight(super.altoPala);
		super.setWidth(super.anchoPala);
		
		Vector2 posicion = new Vector2(Gdx.graphics.getWidth() -50, Gdx.graphics.getHeight()/2 );
		Vector2 radio = new Vector2(super.anchoPala/2, super.altoPala/2);
		int tipoCuerpo = 1;
		float densidad = 0;
		float friccion = 0;
		float rebote = 1;
		String nombre = "IA";
		
		super.pala = new Cuerpos();

		super.pala.crearRectangulo(mundo, posicion , radio, tipoCuerpo, densidad, friccion, rebote, nombre);

	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
	}
}
