package de.kichix.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	public static Texture texture;
	public static TextureRegion jet1, jet2;
	public static TextureRegion heli1, heli2;
	public static TextureRegion bul0, bul1, bul2, bul3;
	
	public static Texture bgtexture;
	public static TextureRegion bg;
	
	public static Animation jetAnimation;
	public static Animation heliAnimation;
	public static Animation bulletHit;
	
	public static BitmapFont font, fontbg;
	
	public static void load() {
		
	loadTextures();	
	loadBackground();
	loadJet();
	loadHeli();
	loadBullet();
	loadFont();
		
	}
	
	public static void loadTextures() {
		
		texture = new Texture(Gdx.files.internal("Jet.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		bgtexture = new Texture(Gdx.files.internal("Hintergrund.png"));
		bgtexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
	}
	
	public static void loadBackground() {
		
		bg = new TextureRegion(bgtexture, 0, 0, 320, 640);
		bg.flip(false, true);
		
	}
	
	public static void loadJet() {
		
		jet1 = new TextureRegion(texture, 0, 0, 40, 40);
		jet1.flip(false, true);
		
		jet2 = new TextureRegion(texture, 40, 0, 40, 40);
		jet2.flip(false, true);
		
		TextureRegion[] jets = {jet1, jet2};
		jetAnimation = new Animation(0.06f, jets);
		jetAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
		
	}
	
	public static void loadHeli() {
		
		heli1 = new TextureRegion(texture, 0, 39, 32, 36);
		heli1.flip(false, true);
		
		heli2 = new TextureRegion(texture, 39, 39, 32, 34);
		heli2.flip(false,  true);
		
		
		
		TextureRegion[] helis = {heli1, heli2};
		heliAnimation = new Animation(0.06f, helis);
		heliAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
	
	}
	
	public static void loadBullet() {
		
		bul0 = new TextureRegion(texture, 20, 80, 5, 10);
		bul0.flip(false,  true);
		
		bul1 = new TextureRegion(texture, 4, 80, 5, 10);
		bul1.flip(false, true);
		
		bul2 = new TextureRegion(texture, 9, 80, 5, 10);
		bul2.flip(false, true);
		
		bul3 = new TextureRegion(texture, 15, 80, 5, 10);
		bul3.flip(false, true);
		
		TextureRegion[] bullets = {bul1, bul2, bul3};
		bulletHit = new Animation(0.05f, bullets);
		bulletHit.setPlayMode(Animation.PlayMode.NORMAL);
		
	}
	
	public static void loadFont() {
		font = new BitmapFont(Gdx.files.internal("font.fnt"));
		font.setScale(.6f, -.6f);
		
		fontbg = new BitmapFont(Gdx.files.internal("fontbg.fnt"));
		fontbg.setScale(.6f, -.6f);
	}
	
	public static void dispose() {
		texture.dispose();
		bgtexture.dispose();
		font.dispose();
	}
}
