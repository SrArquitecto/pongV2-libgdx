package com.srarquitecto.pong_v2.fisicas;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;

public class Mundo {
	
	private World mundo;
	private Box2DDebugRenderer debug = new Box2DDebugRenderer();
	
	//private Cuerpos cuerpoAux;
	//private Iterator<Cuerpos> iterador;
	//private Array<Cuerpos> arrayCuerpos;

	//private int maxNumeroElementos;
	//private int contadorElementos;
	
	private static final float factorConversionMetro = 1f;
	private static final float factorConversionPixel = 0.5f;
	
	//private static final float ALTO  = Gdx.graphics.getHeight();
	//private static final float ANCHO = Gdx.graphics.getWidth();
	
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
	
	public Mundo(Vector2 gravedad, Boolean dormir) { //, int maxNumeroElementos) {
		this.mundo = new World(gravedad, dormir);
		//this.maxNumeroElementos = maxNumeroElementos;
		//this.arrayCuerpos = new Array(this.maxNumeroElementos);
		//this.contadorElementos = 0;

	}
	
	/* CREAR LINEA:
	 * 
	 *  Este método permite crear una linea. Para ello, se necesitará la posición donde se empezará a dibujar la linea (posX y posY)
	 *  así como los dos vectores que definen a la linea (V1-> poxXV1 y posYV1, V2-> posXV2 y posYV2). La posición indicada por el
	 *  vector, será relativa a la posición en la que se comienza a dibujar la linea.
	 *  
	 *  EJEMPLO: Dibujar linea horizontal en la posición (0, 0) que cruce la pantalla por debajo
	*/
	
	public Mundo crearPoligono(Mundo mundo, Vector2 posicion, Vector2 posicionVector1, Vector2 posicicionVector2, int tipoCuerpo, float densidad, float friccion, float rebote, String nombre) {
		
		return mundo;
	}
	
	/*
	
	public Mundo crearLinea(Mundo mundo, float posX, float posY, float posXV1, float posYV1, float posXV2, float posYV2, int tipoCuerpo, float densidad, float friccion, float rebote, String nombre) {
		Cuerpos nuevoCuerpo = new Cuerpos();
		nuevoCuerpo.crearLinea(mundo, posX, posY, posXV1, posYV1, posXV2, posYV2, tipoCuerpo, densidad, friccion, rebote, nombre);
		
		this.arrayCuerpos.add(nuevoCuerpo);
		System.out.println(this.arrayCuerpos.get(this.contadorElementos).getCuerpo().getPosition().x);
		
		this.contadorElementos++ ;
	
		return mundo;
	}
	
	public Vector2 obtenerPosicionCuerpo(String nombre) {
		this.iterador = this.arrayCuerpos.iterator();
		
		while(this.iterador.hasNext()) {
			this.cuerpoAux = this.iterador.next();
			if(this.cuerpoAux.getNombre() == nombre) {
				return this.cuerpoAux.getCuerpo().getPosition();
			}
		}
		return null;
	}
	
	*/
	
	public void dispose() {
		this.mundo.dispose();
		this.debug.dispose();
		
		//Produce un error grave al cerra la VM de Java.
		//this.cuerpoAux.getRecta().dispose();
	}
}
