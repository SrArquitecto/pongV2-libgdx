package com.srarquitecto.pong_v2.actores;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.srarquitecto.pong_v2.Pong_V2;
import com.srarquitecto.pong_v2.fisicas.Cuerpos;
import com.srarquitecto.pong_v2.fisicas.Mundo;

public abstract class ActorPala extends Actor {

	protected Mundo mundo;
	protected Cuerpos pala;
	
	protected Vector2 posicion;
	
	protected TextureRegion region;
	
	protected float altoPala  = Pong_V2.MANAGER.get("img/pala.png", Texture.class).getHeight();
	protected float anchoPala = Pong_V2.MANAGER.get("img/pala.png", Texture.class).getWidth();
	
	public ActorPala(Mundo mundo) {
		this.mundo = mundo;
		this.region = new TextureRegion(Pong_V2.MANAGER.get("img/pala.png", Texture.class),(int) this.anchoPala, (int) this.altoPala);
	}
	
	public abstract void crearPala();
}
