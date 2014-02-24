package com.srarquitecto.pong_v2;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.srarquitecto.pong_v2.pantallas.PantallaAbstracta;
import com.srarquitecto.pong_v2.pantallas.PantallaJuego;

public class Pong_V2 extends Game {

	public static final AssetManager MANAGER = new AssetManager();
	
	private PantallaAbstracta pantallaJuego;
	
	@Override
	//Cargamos en el AssetManager todos los recursos que utilizaremos para el juego.
	public void create() {		
		this.MANAGER.load("img/pala.png", Texture.class);
		this.MANAGER.load("img/bola.png", Texture.class);
		this.MANAGER.load("snd/sndLim.ogg", Sound.class);
		this.MANAGER.load("snd/sndPala.ogg", Sound.class);
		this.MANAGER.load("snd/sndPunto.ogg", Sound.class);
		this.MANAGER.load("fnt/8Bit.png", Texture.class);
		this.MANAGER.load("fnt/8Bit.fnt", BitmapFont.class);
		
		while(!this.MANAGER.update()) {
			System.out.println("CARGANDO...");
		}
		
		System.out.println("-----");
		
		this.pantallaJuego = new PantallaJuego(this);
		setScreen(pantallaJuego);
	}

	@Override
	public void dispose() {
		this.MANAGER.dispose();
		
	}
}
