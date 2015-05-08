package de.kichix.gameworld;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;

import de.kichix.gameobjects.Enemie;
import de.kichix.gameobjects.Jet;
import de.kichix.gameobjects.Projectile;
import de.kichix.helpers.AssetLoader;
import de.kichix.helpers.EnemieSpawner;

public class GameRenderer {

	private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    private SpriteBatch batcher;
    private EnemieSpawner mySpawner;
    
    private Vector2 i, j;
    private float d;
    
    public GameRenderer(GameWorld world) {
        myWorld = world;
        
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 300, 408);

        i = new Vector2(0,0);
    	j = new Vector2(30,0);
    	d = 0;
    	
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }

    public void render(float runTime, float delta) {

    	Jet jet = myWorld.getJet();
    	
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (i.x >= 640) {
        	i.x = 0;
        }
        
        i.add(j.cpy().scl(delta)) ;
        
        shapeRenderer.begin(ShapeType.Filled);
        batcher.begin();
        
        renderEShots();
        renderBackground(delta, i.x);
        renderBorder();
        renderHealth();
        renderScore();
        renderEnemies(runTime);
        renderJet(runTime, delta);
        batcher.end();
        shapeRenderer.end();
        
    }
    
    private void renderBackground(float delta, float y) {
    		
    	batcher.disableBlending();
    	batcher.draw(AssetLoader.bg, 0, 0+y, 320, 640);
    	batcher.draw(AssetLoader.bg, 0, -640+y, 320, 640);
    	
    }
    
    private void renderBorder() {
    
    	shapeRenderer.setColor(0,0,0,1);
    	//shapeRenderer.rect(0, 0, 300, 25);
    	shapeRenderer.rect(280, 0, 25, 408);

    }
    
    private void renderJet(float runTime, float delta) {
    	
    	Jet jet = myWorld.getJet();
    	
    	if (jet.isAlive()) {
    		
    	batcher.enableBlending();
        batcher.draw(AssetLoader.jetAnimation.getKeyFrame(runTime), jet.getX(), jet.getY(), jet.getWidth(), jet.getHeight());	
    	
        ArrayList projectiles = jet.getProjectiles();
		for (int i = 0; i < projectiles.size(); i++) {
			 Projectile p = (Projectile) projectiles.get(i);
			 if (p.getVis() == true) {
				 
	     if(!p.getCol()) {
		 batcher.draw(AssetLoader.bul0, p.getX(), p.getY(), p.getWidth(), p.getHeight());
	     }
	     
			if(p.getCol()) {
				d += delta;
				batcher.draw(AssetLoader.bulletHit.getKeyFrame(d), p.getX(), p.getY(), p.getWidth()+5, p.getHeight()+5);
				p.stop();
				if(AssetLoader.bulletHit.isAnimationFinished(d)) {
					d=0;
					projectiles.remove(i);
				
				}
							}
			 }
		}
    }
    }
    
    private void renderHealth() {
    	
    	Jet jet = myWorld.getJet();
    	shapeRenderer.setColor(255, 0, 0, 1);
    	
    	
    	//shapeRenderer.rect(277.5f, 400f, 20.5f, (200 + (jet.getHealth()*(200/jet.getInitHealth()))));
    	shapeRenderer.rect(282.5f, 400f, 15f, -(100 + (jet.getHealth()*(100/jet.getInitHealth()))));
    	
    }
    
    private void renderEnemies(float runTime) {
    	
    	int color;
    	
        mySpawner = myWorld.getSpawner();
        ArrayList enemies = mySpawner.enemies;
        
		for (int i = 0; i < enemies.size(); i++) {
			Enemie e = (Enemie) enemies.get(i);
				        
			if (e.alive() == true) {
	    		batcher.enableBlending();
	        	batcher.draw(AssetLoader.heliAnimation.getKeyFrame(runTime), e.getX(), e.getY(), e.getWidth(), e.getHeight());
			}
		}
    }
    
    
    private void renderEShots() {
    	shapeRenderer.setColor(255,0,0,1);
    	
    	mySpawner = myWorld.getSpawner();
        ArrayList EProjectiles = mySpawner.getProjectiles();
        
        for (int i = 0; i < EProjectiles.size(); i++) {
        	Projectile p = (Projectile) EProjectiles.get(i);
        	shapeRenderer.rect(p.getX(), p.getY(), p.getWidth(), p.getHeight());
        } 
    }
    
    private void renderScore() {
    	String score = myWorld.getScore() + "";
    	batcher.enableBlending();
    	AssetLoader.fontbg.draw(batcher, "" + myWorld.getScore(), (float) (250 - 6*score.length())+1 , 6 );
    	AssetLoader.font.draw(batcher, "" + myWorld.getScore(), (float) 250 - 6*score.length() , 5 );
    	System.out.println(score.length());
    	//AssetLoader.font.draw(batcher, "" + myWorld.getScore(), 10, 10 );
    }
    
}
