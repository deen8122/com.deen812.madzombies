package com.deen812.zombie.scene;

import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import com.deen812.zombie.Constants;
import com.deen812.zombie.R;
import com.deen812.zombie.Resource;
import com.deen812.zombie.SceneManager.AllScenes;
import com.deen812.zombie.main;


import android.content.Intent;
import android.text.Spanned;

public class HelpScene {

	/*
	 * 	 */
	private Scene mScene;
	private Constants mConst;
	private Resource mRes;
	private main game;

	public HelpScene(main game) {
		mRes = game.mRes;
		this.game = game;
		this.mScene = new Scene(0);
        this.mScene.attachChild(new Entity());
        this.mScene.setBackgroundEnabled(true);
        mConst = Constants.getInstance();
        
        Sprite backgrund = new Sprite(0, 0, mRes.mBackgroundTextureRegion);
     //   Sprite backgrund2 = new Sprite(170, -40, mRes.game_name);
       // backgrund.attachChild(backgrund2);
        backgrund.setWidth(mConst.CAMERA_WIDTH);
        backgrund.setHeight(mConst.CAMERA_HEIGHT);
      //  float x = (mConst.CAMERA_WIDTH - backgrund.getWidth())/2;
     //   float y = (mConst.CAMERA_HEIGHT - backgrund.getHeight())/2;
      //  backgrund.setWidth(mConst.CAMERA_WIDTH-40);
      //  backgrund.setHeight(mConst.CAMERA_HEIGHT-40);
     //   backgrund.setPosition(20, 30);
        this.mScene.setTouchAreaBindingEnabled(true);
        this.mScene.attachChild(backgrund);
        onLoadComplete();
        
        
      
	}
	
	public void onLoadComplete() {
		
		// TextView tvBottom = (TextView) findViewById(R.id.tvBottom);
		 //String dtr = findViewById(R.id.hello);
		//R.string.hello;
	//	this.getText(R.string.hello);
	//	this.getResources().getString(R.string.app_name)
		
		
		Sprite btn_exit2  = new Sprite(mConst.CAMERA_WIDTH - 80 , 30, mRes.btn_exit) {
   		 @Override
            public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
                if (pSceneTouchEvent.isActionDown()     ) {
               	 this.setScale((float) 1.2);
               	 mRes.m_pak.play();
                }
                if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
               	 this.setScale((float) 1.0);
               //	Process.killProcess(Process.thisMainScene.myPid());
               	 game.sceneManager.setCurrentScene(AllScenes.MENU);
               //	game.finish();
           //    	android.os.Process.killProcess(android.os.Process.myPid());

                }
                
                return true;
            }; 
     };
     mScene.attachChild(btn_exit2);
     this.mScene.registerTouchArea(btn_exit2);
     
	
     Sprite btn_exit21  = new Sprite(100  , 80, mRes.how_play);
     btn_exit21.setScale(1.4f);
     mScene.attachChild(btn_exit21);
     
     String str=(String)game.getResources().getString(R.string.u_uprav);            
     Text t = new Text(330, 50, mRes.mFont, str);
     t.setColor(1, 0, 0);
 	 this.mScene.attachChild(t);
 	 
 	 str=(String)game.getResources().getString(R.string.u_b);            
     t = new Text(330, 95, mRes.mFont, str);
     t.setColor(1, 1, 0);
	 this.mScene.attachChild(t);
	 
	 str=(String)game.getResources().getString(R.string.u_a);            
     t = new Text(330, 140, mRes.mFont, str);
     t.setColor(1, 0, 1);
	 this.mScene.attachChild(t);
	 
	 str=(String)game.getResources().getString(R.string.u_a_d);            
     t = new Text(330, 195, mRes.mFont, str);
     t.setColor(0, 1, 0);
	 this.mScene.attachChild(t);
	 
	 
	 str=(String)game.getResources().getString(R.string.u_bye);            
     t = new Text(330, 245, mRes.mFont, str);
     t.setColor(0, 0, 1);
	 this.mScene.attachChild(t);
	 

     
			
		}

	private String findViewById(int text1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Scene getScene() {
		// TODO Auto-generated method stub
		return this.mScene;
	}
	

}
