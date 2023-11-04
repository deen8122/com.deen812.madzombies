package com.deen812.zombie.object;

import org.anddev.andengine.engine.camera.hud.HUD;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.input.touch.TouchEvent;

import com.deen812.zombie.Constants;
import com.deen812.zombie.main;

public class GameGUI {



	public GameGUI(Scene mScene, main game) {
		

		
	}

	public GameGUI(Scene mScene, main game, HUD hud) {
		Constants mConst = Constants.getInstance();

		 
		 //BTN_PAUSE
		 Sprite btn_pause = new Sprite(mConst.CAMERA_WIDTH -game.mRes.btn_menu.getWidth()-10  ,10, game.mRes.btn_pause){
			 @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {
				 
                if (pSceneTouchEvent.isActionDown()     ) {
                	 this.setScale(1.1f);
                	
       
                }
                if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel() || pSceneTouchEvent.isActionOutside()) {
               	 this.setScale(1.0f);
               	// man.key_up();
                }
                return true;
            };
		};
	
		
		hud.attachChild(btn_pause);
		hud.registerTouchArea(btn_pause);
	}

}
