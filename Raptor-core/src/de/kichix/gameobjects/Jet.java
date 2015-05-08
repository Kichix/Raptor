package de.kichix.gameobjects;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Peripheral;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Jet {

	private Vector2 position;
	private Vector2 acceleration;
	private Vector2 velocity;
	
	private int width;
	private int height;
	private int health, initHealth;
	private boolean isAlive;
	
	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
	public Jet(float x, float y, int width, int height) {
		this.width = width;
		this.height = height;
		position = new Vector2(x, y);
		velocity = new Vector2(0, 0);
		acceleration = new Vector2(0,0);
		health = 10;
		initHealth = 10;
		isAlive = true;
	}
	
    public void update(float delta) {
    	
    	if(Gdx.input.isPeripheralAvailable(Peripheral.Accelerometer)) {
        velocity.x = -30*Gdx.input.getAccelerometerX();
    	}

        velocity.add(acceleration.cpy().scl(delta));

        if(this.position.x < 0) {
       	 this.position.x = 0;
       	}
        
        if(this.position.x > 275 - this.width) {
        	this.position.x = 275 -  this.width;
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
    
    public void move(float y) {
    	this.velocity.x = y;
    }
    
    public void stop() {
    	this.velocity.x = 0;
    }
    
    public void shoot() {
    	Projectile p = new Projectile(this.position.x + this.width/2 - 1, this.position.y, 3, 7, -140);
    	projectiles.add(p);
    }
    
    public ArrayList getProjectiles() {
    	return projectiles;
    }
    
    public void hit(int dmg) {
    	this.health -= dmg;
    }
    
    public Rectangle getBounds() {
		Rectangle rect = new Rectangle(this.position.x, this.position.y, this.width, this.height);
		return rect; 
		}
    
    public boolean isAlive() {
    	return isAlive;
    }
    
    public int getHealth() {
    	return this.health;
    }
    
    public int getInitHealth() {
    	return initHealth;
    }
    
    public void kill() {
    	isAlive = false;
    }
    
}
