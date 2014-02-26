package com.srarquitecto.pong_v2.fisicas;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class Mundo {
	
	private World mundo;
	private Box2DDebugRenderer debug = new Box2DDebugRenderer();
	private Array<Cuerpos> arrayCuerpos;
	
	private BodyDef defCuerpo ;
	private FixtureDef fixture;
	private Body cuerpo;
	
	private EdgeShape cuerda ;
	//private PolygonShape [] arrayPoligono ;
	
	//private Array<Body> arrayCuerpos;
	
	//private String [] nombre;
	
	private int contador;
	
	
	
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
	
	public Mundo(Vector2 gravedad, Boolean dormir, int numCuerpos) {
		this.mundo = new World(gravedad, dormir);
		
		this.arrayCuerpos = new Array(numCuerpos);
		this.contador = 0;

		
		//this.arrayCuerpos = new Array<Cuerpos>();
		//this.arrayDefCuerpo = new BodyDef [numCuerpos];
		//this.arrayFixture   = new FixtureDef [numCuerpos];
		//this.arrayCuerda = new EdgeShape [numCuerpos];
		//this.nombre = new String [numCuerpos];
		
		for(int i = 0; i<numCuerpos; i++) {
			//this.arrayCuerpo.addAll(Body);
			//this.arrayDefCuerpo[i] = null;
			//this.arrayFixture[i] = null;
			//this.arrayCuerda[i] = null;
			
		}
			
		//this.arrayCuerpo = null;

	}
	
	/* CREAR LINEA:
	 * 
	 *  Este método permite crear una linea. Para ello, se necesitará la posición donde se empezará a dibujar la linea (posX y posY)
	 *  así como los dos vectores que definen a la linea (V1-> poxXV1 y posYV1, V2-> posXV2 y posYV2). La posición indicada por el
	 *  vector, será relativa a la posición en la que se comienza a dibujar la linea.
	 *  
	 *  EJEMPLO: Dibujar linea horizontal en la posición (0, 0) que cruce la pantalla por debajo
	 * 
	 *
	 *
	 *
	public Mundo crearLinea(float posX, float posY, float posXV1, float posYV1, float posXV2, float posYV2, int tipoCuerpo, float densidad, float friccion, float rebote, String nombre, Mundo mundo) {
		this.añadirCuerpo(posXV2, posYV2, tipoCuerpo, densidad, friccion, rebote, nombre);
		
		this.arrayCuerda [this.contador] = new EdgeShape();
		this.arrayCuerda [this.contador].set(posXV1, posYV1, posXV2, posYV2);
		
		this.arrayFixture [this.contador].shape = this.arrayCuerda [this.contador];
		
		this.arrayCuerpo = this.mundo.createBody(this.arrayDefCuerpo [this.contador]);
		this.arrayCuerpo.createFixture(this.arrayFixture [this.contador]);
		
		this.arrayCuerda [this.contador].dispose();
		
		this.contador++;
		
		return mundo;
	}
	
	private void añadirCuerpo(float posX, float posY, int tipoCuerpo, float densidad, float friccion, float rebote, String nombre) {
		this.arrayDefCuerpo [this.contador] = new BodyDef();
		this.arrayDefCuerpo [this.contador].position.set(posX, posY);
		
		switch(tipoCuerpo) {
		case 0:
			this.arrayDefCuerpo [this.contador].type = BodyType.StaticBody;
			break;
		
		case 1:
			this.arrayDefCuerpo [this.contador].type = BodyType.KinematicBody;
			break;
		
		case 2:
			this.arrayDefCuerpo [this.contador].type = BodyType.DynamicBody;
			break;
		}
		
		this.arrayFixture [this.contador] = new FixtureDef();
		this.arrayFixture [this.contador].density     = densidad;
		this.arrayFixture [this.contador].friction    = friccion;
		this.arrayFixture [this.contador].restitution = rebote;
		
		this.nombre [contador] = nombre;
	}
	
	public void dispose() {
		this.mundo.dispose();
		this.debug.dispose();
	}
	
	
	
	*/
	
	/*
	public Mundo crearLinea(float posX, float posY, float posXV1, float posYV1, float posXV2, float posYV2, int tipoCuerpo, float densidad, float friccion, float rebote, String nombre, Mundo mundo) {
		this.añadirCuerpo(posXV2, posYV2, tipoCuerpo, densidad, friccion, rebote, nombre);
		
		this.cuerda = new EdgeShape();
		this.cuerda.set(posXV1, posYV1, posXV2, posYV2);
		
		this.fixture.shape = this.cuerda;
		
		this.cuerpo = this.mundo.createBody(this.defCuerpo);
		this.cuerpo.createFixture(this.fixture);
		
		this.cuerda.dispose();
		
		//this.contador++;
		
		return mundo;
	}
	
	private void añadirCuerpo(float posX, float posY, int tipoCuerpo, float densidad, float friccion, float rebote, String nombre) {
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
		
		this.fixture= new FixtureDef();
		this.fixture.density     = densidad;
		this.fixture.friction    = friccion;
		this.fixture.restitution = rebote;
		
		//this.nombre [contador] = nombre;
	}
	
	*/
	
	public void dispose() {
		this.mundo.dispose();
		this.debug.dispose();
	}
	
	
	
	public Mundo crearLinea(Mundo mundo, float posX, float posY, float posXV1, float posYV1, float posXV2, float posYV2, int tipoCuerpo, float densidad, float friccion, float rebote, String nombre) {
		Cuerpos nuevoCuerpo;
		nuevoCuerpo = new CuerpoLinea();
		nuevoCuerpo.CuerpoLinea(mundo, posX, posY, posXV1, posYV1, posXV2, posYV2, tipoCuerpo, densidad, friccion, rebote, nombre);
		
		this.arrayCuerpos.add(nuevoCuerpo);
		System.out.println(this.arrayCuerpos.get(this.contador).getCuerpo().getPosition().x);

		this.contador++ ;
		
//		cuerpos.getDefCuerpo().position.set(posX, posY);
		
//		switch(tipoCuerpo) {
//		case 0:
//			cuerpos.getDefCuerpo().type = BodyType.StaticBody;
//			break;
		
//		case 1:
//			cuerpos.getDefCuerpo().type = BodyType.KinematicBody;
//			break;
		
//		case 2:
//			cuerpos.getDefCuerpo().type = BodyType.DynamicBody;
//			break;	
//		}
//		
//		cuerpos.getRecta().set(posXV1, posYV1, posXV2, posYV2);
		
//		cuerpos.getFixture().shape = cuerpos.getRecta();
//		cuerpos.getFixture().density = densidad;
//		cuerpos.getFixture().friction = friccion;
//		cuerpos.getFixture().restitution = rebote;
		
//		Body cuerpo = cuerpos.getCuerpo();
//		cuerpo = mundo.getMundo().createBody(cuerpos.getDefCuerpo());
//		cuerpo.createFixture(cuerpos.getFixture());
				
		return mundo;
	}
}
