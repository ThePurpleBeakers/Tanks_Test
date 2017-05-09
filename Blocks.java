package com.mygdx.game;

public class Blocks {

	private String id; //int for 0 - infinity that finds different blocks
	private String name; //File name
	private int health; //Health. If -1 invincible
	private int wall; //Tells whether or not you can run into it.
	private int groundAnimation; //Tells if there is a dirt or water animation needed to be played. 
	
	/**
	 * 
	 * @param id = the code to find the block 
	 * @param name = name of block for helpfulness
	 * @param health = Health of block. If -1 invincible
	 * @param wall = Can pass through or not 0 = false, 1 = true
	 * @param groundAni = get image id. -1 if none
	 */
	public Blocks(String id, String name, int health, int wall, int groundAnimation)
	{
		
		this.id = id;
		this.name = name;
		this.health = health;
		this.wall = wall;
		this.groundAnimation = groundAnimation;
		
	}
	
	public String getId()
	{
		
		return id;
		
	}
	
	
}
