package com.srarquitecto.pong_v2;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Pong-V2-libGDX";
		cfg.useGL20 = false;
		cfg.width = 1280;
		cfg.height = 720;
		//cfg.fullscreen = true;
		
		new LwjglApplication(new Pong_V2(), cfg);
	}
}
