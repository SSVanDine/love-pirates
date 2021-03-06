package com.pirates.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class LootScreen {
	private static Skin skin;
	static CStage stage;
	static final int width = 200;
	static final int height = 20;
	static final int offset = (int) (width/1.5);
	static TextButton crewb;
	static TextButton cargob;
	static TextButton weponb;
	static TextButton tresureb;
	LootScreen(Skin skin, CStage stage) {
		LootScreen.skin = skin;
		LootScreen.stage = stage;
	}
	static void killLootScreen() {
		stage.clear();
	}
	static void makeLootScreen(final Ship s, final Ship looter) {
		stage.clear();
		float xCenterPos = (s.getPos().x-LovePirates.playerShip.getPos().x)*
				LovePirates.TILESIZE+LovePirates.width/2;
		float yCenterPos = (s.getPos().y-LovePirates.playerShip.getPos().y)*
				LovePirates.TILESIZE+LovePirates.height/2;
		crewb = new TextButton("Conscript enemy crew", skin, "default");
		cargob = new TextButton("Loot cargo", skin, "default");
		weponb = new TextButton("Try to steal enemy cannons", skin, "default");
		tresureb = new TextButton("Just take the treasure", skin, "default");
	    crewb.setWidth(width);
	    crewb.setHeight(height);
	    crewb.setPosition(xCenterPos+offset,yCenterPos+offset);
	    crewb.addListener(new ClickListener(){
	        @Override 
	        public void clicked(InputEvent event, float x, float y){
	        	System.out.println("wololol");
	    		killLootScreen();
	        	crewb.setText("You clicked the button");
	        }
	    });
	    	    
	    cargob.setWidth(width);
	    cargob.setHeight(height);
	    cargob.setPosition(xCenterPos-offset,yCenterPos+offset);
	    
	    cargob.addListener(new ClickListener(){
	        @Override 
	        public void clicked(InputEvent event, float x, float y){
	        	System.out.println("wololol");
	        	looter.getLoot("repair supplies", (int) Math.ceil(s.getSize()[0]*s.getSize()[1]/5));
	        	killLootScreen();
	        }
	    });
	    
	    weponb.setWidth(width);
	    weponb.setHeight(height);
	    weponb.setPosition(xCenterPos+offset,yCenterPos-offset);
	    
	    weponb.addListener(new ClickListener(){
	        @Override 
	        public void clicked(InputEvent event, float x, float y){
	        	System.out.println("wololol");

	        	killLootScreen();
	        }
	    });
	    
	    tresureb.setWidth(width);
	    tresureb.setHeight(height);
	    tresureb.setPosition(xCenterPos-offset,yCenterPos-offset);
	    
	    tresureb.addListener(new ClickListener(){
	        @Override 
	        public void clicked(InputEvent event, float x, float y){
	        	System.out.println("wololol");
	        	killLootScreen();
	        }
	    });
	    stage.addActor(crewb);
	    stage.addActor(cargob);
	    stage.addActor(weponb);
	    stage.addActor(tresureb);
		}
	
}
