package de.kichix.helpers;

import java.util.ArrayList;
import java.util.Random;

import de.kichix.gameobjects.Enemie;
import de.kichix.gameobjects.Projectile;

public class EnemieSpawner {

	public ArrayList<Enemie> enemies = new ArrayList<Enemie>();
	private ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
	private Random r;
	
	public EnemieSpawner() {
		r = new Random();
		
	}
	
	public void spawn() {
	
		int rr = r.nextInt(4);
		
		for(int i=0; i<rr; i++) {
		Enemie e = new Enemie(-30, 20, 40, 40);
    	enemies.add(e); }
	}
	
	public ArrayList getEnemies() {
    	return enemies;
    }
	
	 public void shoot() {
		 for(int i=0; i<enemies.size(); i++) {
			 Enemie e = (Enemie) enemies.get(i);
		 if(r.nextDouble() < 0.01) {
	    	Projectile p = new Projectile(e.getX() + e.getWidth()/2 - 1, e.getY(), 2, 2, 100);
	    	projectiles.add(p);
		 }
	    }
	 }
	    
	    public ArrayList getProjectiles() {
	    	return projectiles;
	    }
	
	
}
