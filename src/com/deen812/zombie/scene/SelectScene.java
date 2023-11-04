package com.deen812.zombie.scene;

import java.util.ArrayList;

import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.entity.layer.Layer;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.ui.activity.BaseGameActivity;

import com.deen812.zombie.Constants;
import com.deen812.zombie.R;
import com.deen812.zombie.Resource;
import com.deen812.zombie.SceneManager.AllScenes;
import com.deen812.zombie.main;


import android.content.Intent;
import android.util.Log;

public class SelectScene {

	/*
	 * 	 */
	private Scene mScene;
	private Constants mConst;
	private Resource mRes;
	private main game;
	private ChangeableText col_coin;
	private ChangeableText col_heart;
	private ChangeableText col_hummer;
	private ChangeableText col_snow;
	private Sprite btn_prev;
	private Sprite btn_next;
	private ArrayList<Entity> layer;
	private int zz =0;
	private float xx;
	private float yy;
	private ArrayList<AnimatedSprite> arr_list;
	
	private Sprite play_spr;
	private float mMinY = 0;
    private float mMaxY = 0;
    private float mCurrentY = 0;
    private int iLevelClicked = -1;
	private int leftPadding;
	private int mMaxLevelReached = 10;
   
    protected static int FONT_SIZE = 35;

    protected static int LEVELS = 15;
    protected static int LEVEL_COLUMNS_PER_SCREEN = 5;
    protected static int LEVEL_ROWS_PER_SCREEN = 3;
    protected static int LEVEL_PADDING = 10;
    
    
	/*
	 * 
	 * 
	 * 
	 */
	public SelectScene(final main game) {
		mRes = game.mRes;
		this.game = game;
		this.mScene = new Scene(0);
        this.mScene.attachChild(new Entity());
        this.mScene.setBackgroundEnabled(true);
        mConst = Constants.getInstance();
        
        
        
       
        
        Sprite backgrund = new Sprite(0, 0, mRes.mBackgroundTextureRegion);
        Sprite backgrund2 = new Sprite(30, 20, mRes.board);
     //   Sprite backgrund2 = new Sprite(170, -40, mRes.game_name);
        
        backgrund2.setWidth(mConst.CAMERA_WIDTH-60);
        backgrund2.setHeight(mConst.CAMERA_HEIGHT-40);
        backgrund.setWidth(mConst.CAMERA_WIDTH);
        backgrund.setHeight(mConst.CAMERA_HEIGHT);
        backgrund.attachChild(backgrund2);
        this.mScene.setTouchAreaBindingEnabled(true);
        this.mScene.attachChild(backgrund);
      
        // onLoadComplete();
        mMaxLevelReached = mConst.LEVEL;
        
        
        mMaxLevelReached =10;
      
        
        //BTN_PREV
        btn_prev  = new Sprite(10 , 220, mRes.btn_back) {
  		 @Override
           public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
               if (pSceneTouchEvent.isActionDown()     ) {
              	 this.setScale((float) 1.2);
               }
               if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
              	 this.setScale((float) 1.0);
              	 //game.mRes.mysound.play();
              	// game.vsm.play1();
              	 back();
               }
               
               return true;
           }; 
    };
    mScene.attachChild(btn_prev);
    this.mScene.registerTouchArea(btn_prev);

    
    //BTN_NEXT
    btn_next  = new Sprite(mConst.CAMERA_WIDTH-90 , 220, mRes.btn_next) {
  		 @Override
           public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
               if (pSceneTouchEvent.isActionDown()     ) {
              	 this.setScale((float) 1.2);
               }
               if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
              	 this.setScale((float) 1.0);
              	 next();
              	//  game.vsm.play1();
              	 //game.loadGameScene();
              	// game.sceneManager.setCurrentScene(AllScenes.SELECT_LEVEL);
               }
               
               return true;
           }; 
    };
    mScene.attachChild(btn_next);
    this.mScene.registerTouchArea(btn_next);
    
  
    
    
    // ÕŒœ ¿ Ã¿√¿«»Õ
    Sprite btn_bye  = new Sprite(mConst.CAMERA_WIDTH-90 , 350, mRes.btn_bye) {
  		 @Override
           public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y)  {	 
               if (pSceneTouchEvent.isActionDown()     ) {
              	 this.setScale((float) 1.2);
              	 mRes.m_pak.play();
               }
               if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()) {
              	 this.setScale((float) 1.0);
              	 //next();
              	//  game.vsm.play1();
              	 //game.loadGameScene();
              	 game.sceneManager.setCurrentScene(AllScenes.BYE);
               }
               
               return true;
           }; 
    };
    mScene.attachChild(btn_bye);
    this.mScene.registerTouchArea(btn_bye);
    
    
    
    layer = new ArrayList<Entity>(3);
    layer.add(new Layer());
    layer.add(new Layer());
   // new Layer();
    layer.add(new Layer());
       onLoadComplete();
       CreateLevelBoxes();
	}
/*
 * —Œ«ƒ¿≈Ã ”–Œ¬Õ»
 * 
 * 	
 */
    private void CreateLevelBoxes() {

    	arr_list = new ArrayList<AnimatedSprite>();
        // calculate the amount of required columns for the level count
        int totalRows = (LEVELS / LEVEL_COLUMNS_PER_SCREEN);

        // Calculate space between each level square
        int spaceBetweenRows = (int) ((mConst.CAMERA_HEIGHT / LEVEL_ROWS_PER_SCREEN) - LEVEL_PADDING);
        int spaceBetweenColumns = (int) (( (mConst.CAMERA_WIDTH )/ LEVEL_COLUMNS_PER_SCREEN) - LEVEL_PADDING);
        spaceBetweenRows -= 40;
        spaceBetweenColumns -=50;
        //Current Level Counter
         int iLevel = 1;
         leftPadding = 100;
        // boxX = 20;
        //Create the Level selectors, one row at a time.
       
        
 for(int z = 0; z < 3; z++){    
	 int boxX = leftPadding, boxY = LEVEL_PADDING+40;
        for (int y = 0; y < totalRows; y++) {
                for (int x = 0; x < LEVEL_COLUMNS_PER_SCREEN; x++) {
                        final int levelToLoad = iLevel;
                         AnimatedSprite  Bspr = new AnimatedSprite(boxX, boxY, mRes.menu_level.clone()){
                                @Override
                                public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {                                	
                                	//game.map = levelToLoad;
                        
                            		mConst.SELECTED_MAP = levelToLoad;
                                	if(pSceneTouchEvent.isActionDown()){
                                    	//  this.setScale(1.0f);
                                		 game.sceneManager.setCurrentScene(AllScenes.GAME);
                                  	    //game.loadGameScene();
                                    Log.v("SELELECTSCREEN","isActionDown levelToLoad="+levelToLoad);	 
                                      }
                                      if (pSceneTouchEvent.isActionUp() || pSceneTouchEvent.isActionCancel()){
                                    	 // this.setScale(1.0f);
                                    	  Log.v("SELELECTSCREEN","isActionUp levelToLoad="+levelToLoad);
                                    	  
                                      }
                                   //   if (levelToLoad >= mMaxLevelReached)
                                  //        iLevelClicked = -1;
                                  //    else { game.map = levelToLoad; iLevelClicked = levelToLoad;                                        
                                  ///   }
                                        return false;
                                }
                            };
                            
                            
                        //this.mScene.attachChild(Bspr);
                            
                            layer.get(z).attachChild(Bspr);

                        if (iLevel >  mMaxLevelReached){ 
                        	       arr_list.add(Bspr);   
                        	       Bspr.setCurrentTileIndex(0);
                        	       
                        }
                        else { 
                        	 //  Log.v("SELELECTSCREEN","registerTouchArea");
                        	   Bspr.setCurrentTileIndex(1);
                               this.mScene.registerTouchArea(Bspr);
                               }
                        
                    float x2=0;
                    if(iLevel < 10)x2=8;
                    
                    layer.get(z).attachChild(new Text(boxX + 31+x2, boxY + 30, mRes.mFont, String.valueOf(iLevel)));
                        iLevel++;
                        boxX += spaceBetweenColumns + LEVEL_PADDING;
                        //if (iLevel > LEVELS)break;
                }
              //  if (iLevel > LEVELS) break;
                boxY += spaceBetweenRows + LEVEL_PADDING;
                boxX = leftPadding;
        }
        mMaxY = boxY - mConst.CAMERA_HEIGHT + 200;
}
 
 
 mScene.attachChild(layer.get(0));
 xx = layer.get(zz).getX();
 yy = layer.get(zz).getY();
 zz=0;
 layer.get(1).setPosition(-10000, -1000);
 layer.get(2).setPosition(-10000, -1000);
 
    }//
    

	
	
	
	
	
	
	// ÌÓÔÍË Ì‡Á‡‰ Ë ‚ÔÂÂ‰
	protected void next() {
		 mRes.m_pak.play();
		 layer.get(zz).setPosition(-10000, -1000);
		 mScene.detachChild(layer.get(zz));
		 //mScene.registerTouchArea(layer.get(zz));
		 zz++;
		 if(zz ==3)zz=0;
		 mScene.attachChild(layer.get(zz));
		 layer.get(zz).setPosition(xx, yy);
		
	}
	protected void back() {
		 mRes.m_pak.play();
		 layer.get(zz).setPosition(-10000, -1000);
		 mScene.detachChild(layer.get(zz));
		 zz--;
		 if(zz < 0)zz=2;
		 mScene.attachChild(layer.get(zz));
		 layer.get(zz).setPosition(xx, yy);
		
	}
	
	
	public void onLoadComplete() {
		
		// TextView tvBottom = (TextView) findViewById(R.id.tvBottom);
		 //String dtr = findViewById(R.id.hello);
		//R.string.hello;
	//	this.getText(R.string.hello);
	//	this.getResources().getString(R.string.app_name)
	//	String str=(String)game.getResources().getString(R.string.about);
		             
		//Text t = new Text(0, 0, mRes.mFont, str);
		//this.mScene.attachChild(t);
		Sprite btn_exit2  = new Sprite(mConst.CAMERA_WIDTH - 80 , 30, mRes.btn_exit.clone()) {
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
     
	
			
		}

	private String findViewById(int text1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Scene getScene() {
		// TODO Auto-generated method stub
		return this.mScene;
	}
	

	public void updateLevels() {
		Log.v("SelectScene"," mConst.LEVEL="+mConst.LEVEL);
		if(mConst.LEVEL > mMaxLevelReached) {
			Log.v("SG","checkLevels");
			int m = mConst.LEVEL - mMaxLevelReached-1;
			int n = arr_list.size();
			for(int i =0; i < n; i++) {
				if(arr_list.get(i)==null) continue;
				arr_list.get(i).setCurrentTileIndex(1);
			
				this.mScene.registerTouchArea(arr_list.get(i));
				//arr_list.remove(i);
				if(m==i) break;
			}
			
		}
	}
}
