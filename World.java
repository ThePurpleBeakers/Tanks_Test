package com.mygdx.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class World{
	
	SpriteBatch batch;
	
	static TextureRegion[][] blockSheet;
	
	private static TextureRegion[] blockImages;
	
	static Texture blocks = new Texture("blocks.png");
	static File fileBlock = new File("BlockList.txt");
	
	static Scanner inputBlock;
	static Scanner inputWorld;
	
	static int worldWidth;
	static int worldHeight;
	
	private static ArrayList<Blocks> blockList = new ArrayList<Blocks>();
	
	private static String[][] worldText;
	
	private static String name;
	
	static File fileWorld;
	
	private final static int BLOCK_WIDTH = 3;
	private final static int BLOCK_HEIGHT = 1;
	
	public World(String name) throws FileNotFoundException
	{
		
		this.name = name;
		
		createWorld();
		
		System.out.println("World Created");
		
	}
	
	public void renderWorld() throws FileNotFoundException
	{
		
		int windowWidth = 800;
		int windowHeight = 600;
		
		System.out.println("Window info Complete");
		
		int widthInc = windowWidth/worldWidth;
		int heightInc = windowHeight/worldHeight;
		
		int x = 0, y = 0;
		
		for(int i = 0; i < worldHeight; i++)
		{
			
			y += heightInc;
			
			for(int j = 0; j < worldWidth; j++)
			{
				
				batch.draw(blockImages[translateBlock(worldText[i][j])], x, y);
				
				x += widthInc;
				
			}
			
		}
		
	}
	
	public static void createWorld() throws FileNotFoundException
	{
		
		fileWorld = new File("src/TestWorld.txt");
		
		inputWorld = new Scanner(fileWorld);
		
		worldWidth = inputWorld.nextInt();
		worldHeight = inputWorld.nextInt();
		
		worldText = new String[worldWidth][worldHeight];
		
		for(int i = 0; i < worldHeight; i++)
		{
			
			for(int j = 0; j < worldWidth; j++)
			{
				
				worldText[i][j] = inputWorld.next();
				
			}
			
		}
		
	}
	
	public static int translateBlock(String test)
	{
		
		int neededIndex = 0;
		
		for(int i = 0; i < blockList.size(); i++ )
		{
			
			if(test.equals(blockList.get(i)))
				neededIndex = blockList.get(i).getNumber();
			
		}
		
		return neededIndex;
		
	}

	public static void createBlockList() throws FileNotFoundException
	{
		
		inputBlock = new Scanner(fileBlock);
		
		while(inputBlock.hasNextLine())
		{
			
			int number = inputBlock.nextInt();
			
			String id = inputBlock.next();
			
			String name = inputBlock.next();
			
			int health = inputBlock.nextInt();
			
			int wall = inputBlock.nextInt();
			
			int groundAnimation = inputBlock.nextInt();
			
			blockList.add(new Blocks(number, id, name, health, wall, groundAnimation));
			
		}
		
		blockSheet = TextureRegion.split(blocks, blocks.getWidth()/BLOCK_WIDTH, blocks.getHeight()/BLOCK_HEIGHT);
		
		blockImages = new TextureRegion[blockSheet.length * blockSheet[0].length];
		
		for(int i = 0; i < blockSheet.length; i++)
		{
			
			for(int j = 0; j < blockSheet[0].length; j++)
			{
				
				blockImages[j] = blockSheet[i][j];
				
			}
			
		}

		
	}
	
}
