package com.deen812.zombie.scene;

import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.entity.layer.Layer;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.input.touch.TouchEvent;

import com.deen812.zombie.Resource;

public class AboutEntity extends Entity {

	public AboutEntity(final Scene mScene) {
		
		  Resource mRes = Resource.getInstance();
		  Sprite backgrund = new Sprite(0, 0, mRes.board){
			  @Override
	            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
	                if (pSceneTouchEvent.isActionDown()     ) {
	               	 this.setScale((float) 1.2);
	                }
	                if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
	               	 this.setScale((float) 1.0);
	               //	Process.killProcess(Process.thisMainScene.myPid());
	              // 	 game.sceneManager.setCurrentScene(AllScenes.MENU);
	               //	game.finish();
	              // 	android.os.Process.killProcess(android.os.Process.myPid());
	               	 mScene.detachChild(AboutEntity.this);

	                }
	                
	                return true;
	            }; 
		  };
		  this.attachChild(backgrund);
		 
		  
		   mScene.registerTouchArea(backgrund);
		
		
		
	}
	
	
	

}
