package de.kichix.gameworld;

import java.util.ArrayList;

import com.badlogic.gdx.math.Intersector;

import de.kichix.gameobjects.Enemie;
import de.kichix.gameobjects.Jet;
import de.kichix.gameobjects.Projectile;
import de.kichix.helpers.EnemieSpawner;

public class GameWorld {

	private Jet jet;
	private EnemieSpawner spawner;
	private ArrayList enemies;
	
	private boolean jetHit;
	
	private int score;

    public GameWorld() {
    	
    	jet = new Jet(136, 350, 40, 40);
    	this.score = 0;
    	spawner = new EnemieSpawner();
    	spawner.spawn();
    }

    public void update(float delta) {
        jet.update(delta);
        ArrayList enemies = spawner.getEnemies();
       	ArrayList projectiles = jet.getProjectiles();
        ArrayList Eprojectiles = spawner.getProjectiles();
        
      //Update Jet-Projectiles
        
      		for (int i = 0; i < projectiles.size(); i++) {
      			Projectile p = (Projectile) projectiles.get(i);
      			if (p.getVis() == true) {
      				p.update(delta);
      				for (int j = 0; j < enemies.size(); j++) {
      					Enemie e = (Enemie) enemies.get(j);
      					
      					
      		//Check Collisions on Enemies
      				if(!p.getCol()) {
      					if(Intersector.overlaps(e.getBounds(), p.getBounds())) {
      					e.hit(1);
      					p.colli();
      					}
      				}
      					if(e.getHealth() <= 0) {
      					e.kill();
      				}
      				else{e.unHit();}
      				}
      			} else {
      				projectiles.remove(i);
      			}
      		}	          
          
		//Update Enemies
		if(enemies.isEmpty()) {
			spawner.spawn();
		}
		else {for (int i = 0; i < enemies.size(); i++) {
			Enemie e = (Enemie) enemies.get(i);
			if (e.alive() == true) {
				e.update(delta);
			} else {
				score += 10;
				enemies.remove(i);
			}
		}
		
		//Enemie Shot
		spawner.shoot();
		
		//Update Enemie Shots
		
		for(int i = 0; i < Eprojectiles.size(); i++) {
			Projectile p = (Projectile) Eprojectiles.get(i);
			p.update(delta);
			jetHit = false;
			if (Intersector.overlaps(jet.getBounds(), p.getBounds())) {
				jet.hit(1);
				jetHit = true;
				Eprojectiles.remove(i);
			}
		}
		
		}
		
    }
    
    public boolean jetHit() {
		return jetHit;
	}
    
    public Jet getJet() {
        return jet;
    }
    
    public ArrayList getEnemies() {
    	return enemies;
    }
    
    public EnemieSpawner getSpawner() {
    	return spawner;
    }
    
    public int getScore() {
    	return this.score;
    }
    
}