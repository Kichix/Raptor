package de.kichix.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Projectile {

 private Vector2 position;
 private Vector2 velocity;
 
 private int width;
 private int height;
 private boolean visible;
 private boolean col;
	
public Projectile(float x, float y, int width, int height, int speed) {
	
	this.width = width;
	this.height = height;
	
	position = new Vector2(x, y);
	velocity = new Vector2(0, speed);
	
	visible = true;
	col = false;
}

public void update(float delta) {
	
   position.add(velocity.cpy().scl(delta));
   if (position.y < 0) {
	   visible = false;
   }
}

public boolean getCol() {
	return col;
}

public void colli() {
	col = true;
}

public boolean getVis() {
	return this.visible;
}
public float getX() {
	return position.x;
}

public float getY() {
	return position.y;
}

public int getHeight() {
	return this.height;
}

public int getWidth() {
	return this.width;
}

public void stop() {
	this.velocity.x = 0;
	this.velocity.y = 0;
}

public Rectangle getBounds() {
	Rectangle rect = new Rectangle(this.position.x, this.position.y, this.width, this.height);
	return rect;
}
}
