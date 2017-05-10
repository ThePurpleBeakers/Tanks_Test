package com.mygdx.game;

import java.io.File;
import java.io.FileNotFoundException;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Runner extends ApplicationAdapter{

	float stateTime;
	
	SpriteBatch batch;
	
	Tank player1;
	
	World testWorld;
	
	public void create()
	{
		
		try {
			testWorld = new World("src/TestWorld.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		player1 = new Tank(new Texture("data/TankComplete.png"));
		
		player1.tankCreate();
		
		batch = new SpriteBatch();
		stateTime = 0f;
		
	}
	
	Controller player1Controls = new Controller("keyboard1");
	
	public void render()
	{
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		

		
		stateTime += Gdx.graphics.getDeltaTime();
		
		player1.tankRender(stateTime);
		
		batch.begin();
		
		try {
			testWorld.renderWorld();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		player1Controls.controllerActionsTank(player1, batch);
		
		batch.end();
		
		player1Controls.controllerFunctionsTank();
		
	}
	
	public void dispose()
	{
		
		
		
	}
	
}
