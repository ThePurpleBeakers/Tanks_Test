package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tank {
	
	//Makes Textures
	private Texture tankTexture;
	
	public Tank(Texture tankTexture)
	{
		
		this.tankTexture = tankTexture;
		
	}
	
	//Makes Animation
	private Animation<TextureRegion> fowardAnimation;
	private Animation<TextureRegion> stillAnimation;
	private Animation<TextureRegion> leftAnimation;
	private Animation<TextureRegion> rightAnimation;
	
	//Makes Texture Regions
	private TextureRegion[] tankFoward = new TextureRegion[4];
	private TextureRegion[] tankLeft = new TextureRegion[4];
	private TextureRegion[] tankRight = new TextureRegion[4];
	private TextureRegion[] tankStill = new TextureRegion[4];
	
	public void tankCreate()
	{
		
		TextureRegion[][] tempTank = TextureRegion.split(tankTexture, tankTexture.getWidth()/4,
				tankTexture.getHeight()/4);
		
		for(int i = 0; i < 4; i++)
		{
			
			for(int j = 0; j < 4; j++)
			{
				
				if(i == 0)
					tankStill[j] = tempTank[j][i];
				else if(i == 1)
					tankFoward[j] = tempTank[j][i];
				else if(i == 2)
					tankLeft[j] = tempTank[j][i];
				else
					tankRight[j] = tempTank[j][i];
				
				
			}
			
		}

		
		fowardAnimation = new Animation<TextureRegion>(.1f, tankFoward);
		leftAnimation = new Animation<TextureRegion>(.1f, tankLeft);
		rightAnimation = new Animation<TextureRegion>(.1f, tankRight);
		stillAnimation = new Animation<TextureRegion>(1f, tankStill);
		
	}
	
	private TextureRegion rendTankFoward;
	private TextureRegion rendTankLeft;
	private TextureRegion rendTankRight;
	private TextureRegion rendTankStill;
	
	public void tankRender(float stateTime)
	{
		
		rendTankFoward = fowardAnimation.getKeyFrame(stateTime, true);
		rendTankLeft = leftAnimation.getKeyFrame(stateTime, true);
		rendTankRight = rightAnimation.getKeyFrame(stateTime, true);
		rendTankStill = stillAnimation.getKeyFrame(stateTime, true);
		
	}
	
	public TextureRegion getFoward()
	{
		
		return rendTankFoward;
		
	}
	
	public TextureRegion getStill()
	{
		
		return rendTankStill;
		
	}
	
	public TextureRegion getLeft()
	{
		
		return rendTankLeft;
		
	}
	
	public TextureRegion getRight()
	{
		
		return rendTankRight;
		
	}
	
}
