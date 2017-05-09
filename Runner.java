package com.mygdx.game;

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
	
	public void create()
	{
		
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
		
		player1Controls.controllerActionsTank(player1, batch);
		
		batch.end();
		
		player1Controls.controllerFunctionsTank();
		
	}
	
	public void dispose()
	{
		
		
		
	}
	
}
