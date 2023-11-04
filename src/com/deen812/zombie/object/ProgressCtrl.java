package com.deen812.zombie.object;

import org.anddev.andengine.engine.camera.hud.HUD;
import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.Sprite;

import com.badlogic.gdx.math.Vector2;
import com.deen812.zombie.Constants;
import com.deen812.zombie.Resource;
import com.deen812.zombie.main;

public class ProgressCtrl {
    protected  float TARGET_WIDTH = 0;
	public Sprite z_prg_bg;
	private Sprite z_prg;
	private float x = 250;
	private int step;
	private int width = 400;
	
	
	//-----------------------------------------------------------
	public ProgressCtrl() {
		Resource mRes = Resource.getInstance();
		this.z_prg_bg = new Sprite(x,0,mRes.Z_PROGRESS_BG);
		this.z_prg = new Sprite(x,9,mRes.Z_PROGRESS);
		
		this.setWidth(30);
		
	}
	
	public void setWidth(float www) {
		this.z_prg.setWidth(www);
	}
	
	public void setZattackCol(int n) {
		this.step = this.width /n;
	}
	
	public void plus() {
		TARGET_WIDTH+=this.step;
		Constants.getInstance().CURRENT_SCENE.registerUpdateHandler(
				new IUpdateHandler() {  
					
					@Override  
		           public void onUpdate(float arg0) { 
						if(z_prg.getWidth() >=TARGET_WIDTH) {
						Constants.getInstance().CURRENT_SCENE.unregisterUpdateHandler(this);
						}
						else {
							z_prg.setWidth(z_prg.getWidth()+1);
						}
					  }  

		         @Override  
		          public void reset() {   }  
		       }
				);
		//this.z_prg.setWidth( this.z_prg.getWidth() + this.step );
		
	}
	
	
	
	public void register(HUD h) {
		
		h.attachChild(this.z_prg_bg);
		h.attachChild(this.z_prg);
	}


	
	public void dispose() {
		Constants.getInstance().hud.detachChild(z_prg_bg);
		Constants.getInstance().hud.detachChild(z_prg);
		
	}
}
