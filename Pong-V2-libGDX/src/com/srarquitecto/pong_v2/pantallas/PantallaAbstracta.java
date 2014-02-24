package com.srarquitecto.pong_v2.pantallas;

import com.badlogic.gdx.Screen;
import com.srarquitecto.pong_v2.Pong_V2;

public abstract class PantallaAbstracta implements Screen {

	protected Pong_V2 juego;
	
	public PantallaAbstracta(Pong_V2 juego) {
		this.juego = juego;
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}


}
