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

public class Game extends ApplicationAdapter {
	
	private static final int FOW_COLS = 4, FOW_ROWS = 1;
	private static final int LEF_COLS = 4, LEF_ROWS = 1;
	private static final int RIG_COLS = 4, RIG_ROWS = 1;
	
	Animation<TextureRegion> fowardAnimation;
	Animation<TextureRegion> stillAnimation;
	Animation<TextureRegion> leftAnimation;
	Animation<TextureRegion> rightAnimation;
	
	
	/*Tank player1 = new Tank(new Texture("TankFoward.png"), 
			new Texture("TankStill.png"), new Texture("TankLeft.png"), 
			new Texture("TankRight.png"), 4, 1);
	*/
	SpriteBatch batch;
	Texture tankFoward;
	Texture tankStill;
	Texture tankLeft;
	Texture tankRight;
	
	float stateTime;
	
	float x = 0f, y = 0f, deg = 0f;
	
	@Override
	public void create () {
		
		//player1.tankCreate();
		tankFoward = new Texture("TankFoward.png");
		tankStill = new Texture("TankStill.png");
		tankLeft = new Texture("TankLeft.png");
		tankRight = new Texture("TankRight.png");
		

		
		TextureRegion[][] tempTankFoward = TextureRegion.split(tankFoward, tankFoward.getWidth()/FOW_COLS,
				tankFoward.getHeight()/FOW_ROWS);
		
		TextureRegion[][] tempTankLeft = TextureRegion.split(tankLeft, tankLeft.getWidth()/LEF_COLS,
				tankLeft.getHeight()/LEF_ROWS);
		
		TextureRegion[][] tempTankRight = TextureRegion.split(tankRight, tankRight.getWidth()/RIG_COLS,
				tankRight.getHeight()/RIG_ROWS);
		
		TextureRegion[][] tempTankStill = TextureRegion.split(tankStill, tankStill.getWidth(), tankStill.getHeight());
		
		TextureRegion[] tankFoward = new TextureRegion[FOW_COLS * FOW_ROWS];
		TextureRegion[] tankLeft = new TextureRegion[FOW_COLS * FOW_ROWS];
		TextureRegion[] tankRight = new TextureRegion[RIG_COLS * RIG_ROWS];
		TextureRegion[] tankStill = new TextureRegion[1];
		
		tankStill[0] = tempTankStill[0][0];
		
		int index = 0;
		
		for(int i = 0; i < FOW_ROWS; i++)
		{
			
			for(int j = 0; j < FOW_COLS; j++)
			{
				tankRight[index] = tempTankRight[i][j];
				tankLeft[index] = tempTankLeft[i][j];
				tankFoward[index++] = tempTankFoward[i][j];
				
			}
			
		}
		
		fowardAnimation = new Animation<TextureRegion>(.1f, tankFoward);
		leftAnimation = new Animation<TextureRegion>(.1f, tankLeft);
		rightAnimation = new Animation<TextureRegion>(.1f, tankRight);
		stillAnimation = new Animation<TextureRegion>(1f, tankStill);
		
		
		
		
		batch = new SpriteBatch();
		stateTime = 0f;
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		

		
		stateTime += Gdx.graphics.getDeltaTime();
		
		//player1.tankRender(stateTime);
		
		TextureRegion tankFoward = fowardAnimation.getKeyFrame(stateTime, true);
		TextureRegion tankLeft = leftAnimation.getKeyFrame(stateTime, true);
		TextureRegion tankRight = rightAnimation.getKeyFrame(stateTime, true);
		TextureRegion tankStill = stillAnimation.getKeyFrame(stateTime, true);
		
		batch.begin();
		
		if(!Gdx.input.isKeyPressed(Input.Keys.W) && !Gdx.input.isKeyPressed(Input.Keys.A) 
				&& !Gdx.input.isKeyPressed(Input.Keys.D))
		{
			
			//batch.draw(player1.getStill(), x, y, 75, 75, 150, 150, 1, 1, deg);
			batch.draw(tankStill, x, y, 75, 75, 150, 150, 1, 1, deg);
			
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.A) && !Gdx.input.isKeyPressed(Input.Keys.W))
		{
			
			//batch.draw(player1.getLeft(), x, y, 75, 75, 150, 150, 1, 1, deg);
			batch.draw(tankLeft, x, y, 75, 75, 150, 150, 1, 1, deg);
			
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.D) && !Gdx.input.isKeyPressed(Input.Keys.W))
		{
			
			//batch.draw(player1.getRight(), x, y, 75, 75, 150, 150, 1, 1, deg);
			batch.draw(tankRight, x, y, 75, 75, 150, 150, 1, 1, deg);
			
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.W)
		||(Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.A))
		||(Gdx.input.isKeyPressed(Input.Keys.W) && Gdx.input.isKeyPressed(Input.Keys.D)))
		{
			
			//batch.draw(player1.getFoward(), x, y, 75, 75, 150, 150, 1, 1, deg);
			batch.draw(tankFoward, x, y, 75, 75, 150, 150, 1, 1, deg);

		}
		
		batch.end();
		
		
		if(Gdx.input.isKeyPressed(Input.Keys.W))
		{
			
			x += ((float) Math.cos(deg*(Math.PI/180)+(Math.PI/2))*200) * Gdx.graphics.getDeltaTime();
			y += ((float) Math.sin(deg*(Math.PI/180)+(Math.PI/2))*200) * Gdx.graphics.getDeltaTime();

			
		}
		if(Gdx.input.isKeyPressed(Input.Keys.D)) deg -= 100*Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.A)) deg += 100*Gdx.graphics.getDeltaTime();
		
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		

	}
	
}
