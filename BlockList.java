package com.mygdx.game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;

public class BlockList {

	private ArrayList<Blocks> BlockList = new ArrayList<Blocks>();
	
	
	Texture image = new Texture("blocks.png");
	File file = new File("BlockList.txt");
	

	
	public BlockList() throws Exception
	{

		Scanner input = new Scanner(file);
		
		while(input.hasNextLine())
		{
			
			String id = input.next();
			
			String name = input.next();
			
			int health = input.nextInt();
			
			int wall = input.nextInt();
			
			int groundAnimation = input.nextInt();
			
			BlockList.add(new Blocks(id, name, health, wall, groundAnimation));
			
		}
		
	}
	
}
