package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Controller {
	
	private String type;
	
	private float x = 0f, y = 0f, deg = 0f;
	
	public Controller(String type)
	{
		
		this.type = type;
		
	}
	
	public void controllerFunctionsTank()
	{
		
		if(type.equals("keyboard1"))
		{
			
			if(Gdx.input.isKeyPressed(Input.Keys.W))
			{
				
				x += ((float) Math.cos(deg*(Math.PI/180)+(Math.PI/2))*200) * Gdx.graphics.getDeltaTime();
				y += ((float) Math.sin(deg*(Math.PI/180)+(Math.PI/2))*200) * Gdx.graphics.getDeltaTime();

				
			}
			if(Gdx.input.isKeyPressed(Input.Keys.D)) deg -= 100*Gdx.graphics.getDeltaTime();
			if(Gdx.input.isKeyPressed(Input.Keys.A)) deg += 100*Gdx.graphics.getDeltaTime();
			
		}
		
	}

	public void controllerActionsTank(Tank tank, SpriteBatch batch)
	{
		
		
		if(type.equals("keyboard1"))
		{
			if(!Gdx.input.isKeyPressed(Input.Keys.W) && !Gdx.input.isKeyPressed(Input.Keys.A) 
				&& !Gdx.input.isKeyPressed(Input.Keys.D))
			{
			
				//batch.draw(player1.getStill(), x, y, 75, 75, 150, 150, 1, 1, deg);
				batch.draw(tank.getStill(), x, y, 75, 75, 150, 150, 1, 1, deg);
			
			}
		
			if(Gdx.input.isKeyPressed(Input.Keys.A) && !Gdx.input.isKeyPressed(Input.Keys.W))
			{
			
				//batch.draw(player1.getLeft(), x, y, 75, 75, 150, 150, 1, 1, deg);
				batch.draw(tank.getLeft(), x, y, 75, 75, 150, 150, 1, 1, deg);
			
			}
		
			if(Gdx.input.isKeyPressed(Input.Keys.D) && !Gdx.input.isKeyPressed(Input.Keys.W))
			{
			
				//batch.draw(player1.getRight(), x, y, 75, 75, 150, 150, 1, 1, deg);
				batch.draw(tank.getRight(), x, y, 75, 75, 150, 150, 1, 1, deg);
			
			}
		
			if(Gdx.input.isKeyPressed(Input.Keys.W)
					||(Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.A))
					||(Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.D)))
			{
			
				//batch.draw(player1.getFoward(), x, y, 75, 75, 150, 150, 1, 1, deg);
				batch.draw(tank.getFoward(), x, y, 75, 75, 150, 150, 1, 1, deg);

			}
			
		}
		
	}
	
}
