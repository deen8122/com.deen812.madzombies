package com.deen812.zombie.scene;

import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.input.touch.TouchEvent;


import com.deen812.zombie.Constants;
import com.deen812.zombie.R;
import com.deen812.zombie.Resource;
import com.deen812.zombie.SceneManager.AllScenes;
import com.deen812.zombie.main;




public class MainScene {

	/*
	 * 	 */
	private Scene mScene;
	private Constants mConst;
	private Resource mRes;
	private main game;


	public MainScene(main game) {
		mRes = game.mRes;
		this.game = game;
		this.mScene = new Scene(0);
        this.mScene.attachChild(new Entity());
        this.mScene.setBackgroundEnabled(true);
        mConst = Constants.getInstance();
        
        Sprite backgrund = new Sprite(0, 0, mRes.mBackgroundTextureRegion);
       // Sprite backgrund2 = new Sprite(170, -40, mRes.game_name);
      //  backgrund.attachChild(backgrund2);
        backgrund.setWidth(mConst.CAMERA_WIDTH);
        backgrund.setHeight(mConst.CAMERA_HEIGHT);
      //  float x = (mConst.CAMERA_WIDTH - backgrund.getWidth())/2;
     //   float y = (mConst.CAMERA_HEIGHT - backgrund.getHeight())/2;
      //  backgrund.setWidth(mConst.CAMERA_WIDTH-40);
      //  backgrund.setHeight(mConst.CAMERA_HEIGHT-40);
     //   backgrund.setPosition(20, 30);
        this.mScene.setTouchAreaBindingEnabled(true);
        this.mScene.attachChild(backgrund);
        createLayers();
        onLoadComplete();
        
        
      
	}
	public void createLayers(){
	 //select_level   = new AboutEntity(mScene);
		
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
                }
                if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
               	 this.setScale((float) 1.0);
               //	Process.killProcess(Process.thisMainScene.myPid());
              // 	 game.sceneManager.setCurrentScene(AllScenes.MENU);
               //	game.finish();
               	android.os.Process.killProcess(android.os.Process.myPid());

                }
                
                return true;
            }; 
     };
     mScene.attachChild(btn_exit2);
     this.mScene.registerTouchArea(btn_exit2);
     
		//	Animation animRotateIn_icon = AnimationUtils.loadAnimation(this,
			//		R.anim.rotate);
		  //   this.getCurrentFocus().startAnimation(animRotateIn_icon);
     /*
      * 
      *  ÕŒœ ¿ —“¿–“
      */
     
     
			 float xCenter = mConst.CAMERA_WIDTH/2  - mRes.txt_start.getWidth()/2;
		      Sprite btn_start  = new Sprite(xCenter , 120, mRes.txt_start) {
		    		 @Override
		             public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
		                 if (pSceneTouchEvent.isActionDown()     ) {
		                	 this.setScale((float) 1.2);
		                	 mRes.a_zombie.play();
		                 }
		                 if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
		                	 this.setScale((float) 1.0);
		                //	  game.vsm.play1();
		                	 //game.loadGameScene();
		                	 game.sceneManager.setCurrentScene(AllScenes.SELECT_LEVEL);
		                	// mScene.attachChild(select_level);
		                 }
		                 
		                 return true;
		             }; 
		      };
		      mScene.attachChild(btn_start);
		      this.mScene.registerTouchArea(btn_start);
		
		   
		      // Õ¿ƒœ»—‹ - Õ¿«¬¿Õ»≈ »√–€
		   //   this.game.getResources().getString(R.string..app_name);
		     String str=(String)Constants.getInstance().main_activity.getResources().getString(R.string.app_name);
			    
		     Text t2 = new Text(0, 0, Resource.getInstance().mFont_Plok, str);
		     t2.setPosition(mConst.CAMERA_WIDTH/2 - t2.getWidth()/2, 20);
		     t2.setScale(1.4f);
				  t2.setColor(0, (float)128/225, 0);
				  mScene.attachChild(t2);
		 	
				  
				  // «¬” 
			      final Sprite btn_no2  = new Sprite(0 , 0, mRes.btn_no);
			      Sprite btn_sound2  = new Sprite(60 , 220, mRes.btn_music) {
			    		 @Override
			             public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
			                 if (pSceneTouchEvent.isActionDown()     ) {
			                	 this.setScale((float) 1.2);
			                	 
	                          	 if(mConst.MUSIC_ON == 1) {
	                          		//mRes.m_pak.resume();
	                          		 mRes.m_pak.play();
			                		 this.attachChild(btn_no2);
			                		 mConst.mEngine.getSoundManager().setMasterVolume(0);
			                		 mConst.MUSIC_ON = 0;
			                		// mRes.mysound.pause();//.stop();
			                		 game.setSound2(0);
			                		 
			                	 }else {
			                		 this.detachChild(btn_no2);
			                		 mConst.mEngine.getSoundManager().setMasterVolume(1);
			                		 mConst.MUSIC_ON = 1;
			                		// mRes.mysound.play();
			                		 game.setSound2(1);
			                		 mRes.m_pak.play();
			                		 
			                	 }
			                	
			                 }
			                 if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
			                	 this.setScale((float) 1.0);
			             
			                	 
			                 }
			                 
			                 return true;
			             }; 
			      };
			      mScene.attachChild(btn_sound2);
			      this.mScene.registerTouchArea(btn_sound2);
			    //  if(game.vibro_enable == false) btn_vibro.attachChild(btn_no2);
			
			      if(mConst.MUSIC_ON == 0) {
			    	  btn_sound2.attachChild(btn_no2); 
			    	  mConst.mEngine.getSoundManager().setMasterVolume(0);
			    	  /*
			    	   * mActivity.getEngine().getMusicManager().setMasterVolume(0);
mActivity.getEngine().getSoundManager().setMasterVolume(0);
			    	   */
			      }else {
			    	  //mRes.mysound.play();
			      }  
				  
				  
				  
				  // «¬” 
		      final Sprite btn_no  = new Sprite(0 , 0, mRes.btn_no);
		      Sprite btn_sound  = new Sprite(60 , 320, mRes.btn_sound) {
		    		 @Override
		             public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
		                 if (pSceneTouchEvent.isActionDown()     ) {
		                	 this.setScale((float) 1.2);
		                	 
                          	 if(mConst.SOUND_ON == 1) {
                          		mRes.m_pak.resume();
                          		 mRes.m_pak.play();
		                		 this.attachChild(btn_no);
		                		 mConst.SOUND_ON = 0;
		                		 mRes.mysound.pause();//.stop();
		                		 game.setSound(0);
		                		 
		                	 }else {
		                		 this.detachChild(btn_no);
		                		 mConst.SOUND_ON = 1;
		                		 mRes.mysound.play();
		                		 game.setSound(1);
		                		 
		                	 }
		                	
		                 }
		                 if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
		                	 this.setScale((float) 1.0);
		             
		                	 
		                 }
		                 
		                 return true;
		             }; 
		      };
		      mScene.attachChild(btn_sound);
		      this.mScene.registerTouchArea(btn_sound);
		    //  if(game.vibro_enable == false) btn_vibro.attachChild(btn_no2);
		
		      if(mConst.SOUND_ON == 0) {
		    	  btn_sound.attachChild(btn_no); 
		      }else  mRes.mysound.play();
	
		  

		      
		     
		     //INFO
		      Sprite btn_info  = new Sprite(160 , 320, mRes.btn_info) {
		    		 @Override
		             public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
		                 if (pSceneTouchEvent.isActionDown()     ) {
		                	 this.setScale((float) 1.2);
		                	 mRes.m_pak.play();
		                	
		                 }
		                 if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
		                	 this.setScale((float) 1.0);
		              //  	 game.sceneManager.setCurrentScene(AllScenes.HELP);
		                	// game.sceneManager.createSettingScene();
		                	 game.sceneManager.setCurrentScene(AllScenes.ABOUT);
		                 }
		                 
		                 return true;
		             }; 
		      };
		      mScene.attachChild(btn_info);
		      this.mScene.registerTouchArea(btn_info);
		      
		      //---------------------------------------------------------------------------
		    
		      
			     //HELP ?
		      Sprite btn_info1  = new Sprite(260 , 320, mRes.btn_help) {
		    		 @Override
		             public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
		                 if (pSceneTouchEvent.isActionDown()     ) {
		                	 this.setScale((float) 1.2);
		                	 mRes.m_pak.play();
		                	
		                 }
		                 if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
		                	 this.setScale((float) 1.0);
		              //  	 game.sceneManager.setCurrentScene(AllScenes.HELP);
		                	// game.sceneManager.createSettingScene();
		                	 game.sceneManager.setCurrentScene(AllScenes.HELP);
		                 }
		                 
		                 return true;
		             }; 
		      };
		      mScene.attachChild(btn_info1);
		      this.mScene.registerTouchArea(btn_info1);
		      
		      //---------------------------------------------------------------------------  
		      
		      
		      
		      // BYE
		     
		      Sprite btn_bye  = new Sprite(360 , 320, mRes.btn_bye) {
		    		 @Override
		             public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
		                 if (pSceneTouchEvent.isActionDown()     ) {
		                	 this.setScale((float) 1.2);
		                	 mRes.m_pak.play();
		                 }
		                 if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
		                	 this.setScale((float) 1.0);
		                	// game.sceneManager.createSettingScene();
		                	// game.sceneManager.setCurrentScene(AllScenes.SETTING);
		                	 
		                	// MainScene.this.game.bye();
		                    //game.bye();
		                	// game.bye();
		                	 game.sceneManager.setCurrentScene(AllScenes.BYE);
		                    
		                 }
		                 
		                 return true;
		             }; 
		      };
		      
		      
		      mScene.attachChild(btn_bye);
		      this.mScene.registerTouchArea(btn_bye);
		      //------------------------------------------------------------------------------
		      
		      
		      
		      
		      //if(game.vibro_enable == false) btn_vibro.attachChild(btn_no2);
		      
		   /*   
		   
		      final Sprite btn_no3  = new Sprite(0 , 0, mRes.btn_no);
		      Sprite btn_music  = new Sprite(460 , 320, mRes.music) {
		    		 @Override
		             public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
		                 if (pSceneTouchEvent.isActionDown()     ) {
		                	 this.setScale((float) 1.2);
		                 }
		                 if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
		                	 this.setScale((float) 1.0);
		                	 //game.vsm.vibro();
		                	// game._vibrato.vibrate(500);
		                	 if(game.music_enable == false) {
		                		 this.detachChild(btn_no3);
		                		 game.music_enable = true;
		                	 }else {
		                		  this.attachChild(btn_no3);
		                		  game.music_enable = false;
		                	 }
		                	// game.mEngine.enableVibrator(this);
		                 }
		                 
		                 return true;
		             }; 
		      };
		      mScene.attachChild(btn_music);
		      this.mScene.registerTouchArea(btn_music);
		      */
		    //  CreateLevelBoxes();
			    //  this.mScene.attachChild(new Entity());
			      
			     // mScene.setOnSceneTouchListener(this);
		         // this.mScene.registerTouchArea(back_spr);//.setTouchAreaBindingEnabled(true);
			   //   mScene.attachChild(back_spr);
			      
			    //  levelsEntity = new Entity();
			    //  levelsEntity.setPosition(mConst.CAMERA_WIDTH,10);
			    //  mScene.attachChild(levelsEntity);
		   
		   
			
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
