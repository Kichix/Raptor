package de.kichix.gameobjects;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Enemie {
	
	private final int MAX_SPEED = 80;
	private final int MIN_SPEED = 30;
	
	private Vector2 position;
	private Vector2 velocity;
	
	private int width;
	private int height;
	private int health;
	
	private Random r;
	
	private boolean isAlive;
	private boolean isHit;
	
	public Enemie (float y, int width, int height, float velo) {
	
    this.r = new Random();
	
	position = new Vector2(r.nextInt(250), y);
	velocity = new Vector2(r.nextInt(MAX_SPEED) + MIN_SPEED, velo);
	
	this.width = width;
	this.height = height;
	this.isAlive = true;
	this.health = 3;
	this.isHit = false;
	System.out.println(this.health);
	}
	
public void update(float delta) {

	if (this.position.y > 200) {
		this.velocity.y = -r.nextInt(MAX_SPEED) + MIN_SPEED;
		if(r.nextDouble() < 0.5) {
			this.velocity.x = r.nextInt(MAX_SPEED) + MIN_SPEED;
		}
		else {this.velocity.x = -r.nextInt(MAX_SPEED) + MIN_SPEED; }
	}
	
	if (this.position.y < 20) {
		this.velocity.y = r.nextInt(MAX_SPEED) + MIN_SPEED;
	}
	
	if(this.position.x < 20) {
		this.velocity.x = r.nextInt(MAX_SPEED) + MIN_SPEED;
	}
	
	if(this.position.x > 250) {
		this.velocity.x = -r.nextInt(MAX_SPEED) + MIN_SPEED;
	}
        position.add(velocity.cpy().scl(delta));
    }

	public float getX() {
		return position.x;
	}

	public float getY() {
	    return position.y;
	}
	
	public float getWidth() {
	    return width;
	}
	
	public float getHeight() {
	    return height;
	}

	public void kill() {
	isAlive = false;
	}
	
	public boolean alive() {
		return isAlive;
	}
	public Rectangle getBounds() {
		Rectangle rect = new Rectangle(this.position.x, this.position.y, this.width, this.height);
		return rect; 
		}
	    
	public int getHealth() {
		return this.health;
	}
	
	public void hit(int dmg) {
		this.health -= dmg;
		this.isHit = true;
	}
	
	public void unHit() {
		this.isHit = false;
	}
	
	public boolean isHit() {
		return isHit;
	}
	
	}
