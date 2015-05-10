package de.kichix.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class AssetLoader {

	public static Texture texture;
	public static Texture bgtexture;
	public static Texture logo;
	
	public static TextureRegion jet1, jet2;
	public static TextureRegion heli1, heli2;
	public static TextureRegion bul0, bul1, bul2, bul3;
	public static TextureRegion bg;
	public static TextureRegion heart;
	public static TextureRegion logoo;
	
	public static Array<TextureRegion> heli_death;
	public static Array<TextureRegion> UFO;
	
	public static Animation jetAnimation;
	public static Animation heliAnimation;
	public static Animation ufoAnimation;
	public static Animation heliDeathAnimation;
	public static Animation bulletHit;
	
	public static BitmapFont font, fontbg;
	
	public static void load() {
		
	loadTextures();	
	loadLogo();
	loadBackground();
	loadJet();
	loadHeli();
	loadBullet();
	loadFont();
	loadHeart();
	loadUFO();
	
		
	}
	
	public static void loadLogo() {
		logoo = new TextureRegion(logo, 0, 0, 125,50);
		logoo.flip(false, true);
	}
	
	public static void loadTextures() {
		
		logo = new Texture(Gdx.files.internal("Logo.png"));
		logo.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		texture = new Texture(Gdx.files.internal("Jet.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
		bgtexture = new Texture(Gdx.files.internal("Hintergrund.png"));
		bgtexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);
		
	}
	
	public static void loadUFO() {
		
		UFO = new Array<TextureRegion>(2);
		
		for (int i = 0; i < 3; i++) {
			UFO.add(new TextureRegion(texture,0 +64*i,93,64,64));
			
			ufoAnimation = new Animation(0.06f, UFO);
		}
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
		
		heli_death = new Array<TextureRegion>(10);
		
		for (int i = 0; i < 11; i++) {
			heli_death.add(new TextureRegion(texture, 73 + 40*i, 40, 40, 40));
			System.out.println(73+40*i);
		}
		
		heliDeathAnimation = new Animation(0.03f, heli_death);
		
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
		
		bul1 = new TextureRegion(texture, 2, 80, 5, 10);
		bul1.flip(false, true);
		
		bul2 = new TextureRegion(texture, 7, 80, 5, 10);
		bul2.flip(false, true);
		
		bul3 = new TextureRegion(texture, 13, 80, 5, 10);
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
	
	public static void loadHeart() {
		heart = new TextureRegion(texture, 29, 79, 15, 14);
		heart.flip(false,  true);
	}
	
	public static void dispose() {
		texture.dispose();
		bgtexture.dispose();
		font.dispose();
	}
}
