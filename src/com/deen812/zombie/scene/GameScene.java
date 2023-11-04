package com.deen812.zombie.scene;

import java.util.Iterator;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.handler.timer.ITimerCallback;
import org.anddev.andengine.engine.handler.timer.TimerHandler;
import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.scene.background.SpriteBackground;
import org.anddev.andengine.entity.shape.Shape;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.entity.text.ChangeableText;
import org.anddev.andengine.entity.text.Text;
import org.anddev.andengine.extension.physics.box2d.PhysicsFactory;
import org.anddev.andengine.extension.physics.box2d.PhysicsWorld;
import org.anddev.andengine.input.touch.TouchEvent;
import org.anddev.andengine.ui.activity.BaseGameActivity;
import org.anddev.andengine.util.Debug;

import zombie_obj.Zomb;
import zombie_obj.ZombieHead;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Joint;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;

import com.deen812.zombie.Constants;
import com.deen812.zombie.MapManager;
import com.deen812.zombie.MapManager.EnemiesInLevelDef.EnemyType;
import com.deen812.zombie.MapManager.LevelDef;
import com.deen812.zombie.R;
import com.deen812.zombie.Resource;
import com.deen812.zombie.R.string;
import com.deen812.zombie.SceneManager.AllScenes;
import com.deen812.zombie.main;
import com.deen812.zombie.object.Boss1;
import com.deen812.zombie.object.Controller;

import com.deen812.zombie.object.Boss2;
import com.deen812.zombie.object.Box;
import com.deen812.zombie.object.Box.BoxType;
import com.deen812.zombie.object.Dog;
import com.deen812.zombie.object.LifeCtrl;
import com.deen812.zombie.object.Man;
import com.deen812.zombie.object.Man_hand;
import com.deen812.zombie.object.ProgressCtrl;
import com.deen812.zombie.object.Z1;
import com.deen812.zombie.object.Zombie;
import com.deen812.zombie.object.Zombie2;



import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


public class GameScene {

	/*
	 * 	 */
	public Scene mScene;
	private Constants mConst;
	private Resource mRes;
	private main game;
	private PhysicsWorld mPhysicsWorld;
	public Man man;
	private String TAG="GameScene";

	public LifeCtrl life_ctrl;
	public ProgressCtrl prg_ctrl;
	private LevelDef ldef;
	private MapManager mapmanager;
	private Text t2;
	private int CMD_CLOSE_SCENE;
	private boolean f_hook_play = true;

	public GameScene(main game) {
		mRes = game.mRes;
		this.game = game;
		this.mScene = new Scene(0);
        this.mScene.attachChild(new Entity());
        this.mScene.setBackgroundEnabled(true);
        mConst = Constants.getInstance();       
       
        this.mScene.setTouchAreaBindingEnabled(true);
 
        this.mPhysicsWorld = new PhysicsWorld(new Vector2(0, 10), false);
        mPhysicsWorld.setContactListener(createContactListener());
        mConst.mPhysicsWorld  = mPhysicsWorld;
       
      //  onLoadComplete();

	}

	
	
	/*
	 * START GAME
	 */
public void start_game() {
	System.gc();
	     Log.v(TAG,"start_game()");
	     game.f_man_die = false;
	     mapmanager = new MapManager();
	     /*
	      * ilevel ÏÂÌ¸¯Â Ì‡ 1 Ú‡Í Í‡Í Û Ï‡ÒÒË‚‡ 1 ˝ÎÂÏÂÌÚ ÔÓ‰ ÌÓÏÂÓÏ 0
	      */
	     int ilevel = mConst.SELECTED_MAP - 1;
	         mConst.CURRENT_ZOMBIE_I=0;
	         mConst.KILLED_ZOMBIE = 0;
	   //      ilevel = 0;
	    ldef =   mapmanager.GetLevel( ilevel );
	    int MAX_COL_MAP = ldef.Enemies.length;
	    if(mConst.SELECTED_MAP > 29) {
	    	/*
	    	 * ›ÒÎË ˝ÚÓ ÔÓÒÎÂ‰ÌËÈ ÛÓ‚ÂÌ¸
	    	 */
	    	mConst.SELECTED_MAP = 1;
	    	ilevel=0;
	    }
	 //----
	    Sprite backgrund = null;
	    if(ldef.bg.equals("bg2")) {
	    	 backgrund = new Sprite(0, 0, mRes.bg_home);
	    	 
	    }else {
	    	 backgrund = new Sprite(0, 0, mRes.mBackgroundTextureRegion);
	    }
	    
	    this.mScene.attachChild(backgrund);
	    
	    backgrund.setZIndex(0);
	    //mScene.sortChildren();
	    backgrund.setWidth(mConst.WORLD_WIDTH);
	    backgrund.setHeight(mConst.WORLD_HEIGHT-80);
	   /// mScene.setBackground(new SpriteBackground(backgrund));
	  //  mScene.setBackgroundEnabled(true);

	 
	final Shape ground = new Rectangle(0, mConst.WORLD_HEIGHT-96, mConst.WORLD_WIDTH,  250);
   // ground.setColor(0, 1, 0);
   // ground.setAlpha(0.3f);
    //mScene.attachChild(ground);
    final Shape roof = new Rectangle(0, -100, mConst.WORLD_WIDTH, 10);
    final Shape left = new Rectangle(0, -100, 0, mConst.WORLD_HEIGHT);
    final Shape right = new Rectangle(mConst.WORLD_WIDTH, -100, 0, mConst.WORLD_HEIGHT);
    
    final FixtureDef wallFixtureDef = PhysicsFactory.createFixtureDef(1, 0.1f,1f);
    wallFixtureDef.filter.categoryBits = 0x02;
    wallFixtureDef.filter.maskBits = -1;
    PhysicsFactory.createBoxBody(this.mPhysicsWorld, ground, BodyType.StaticBody, wallFixtureDef).setUserData("ground");
    PhysicsFactory.createBoxBody(this.mPhysicsWorld, roof, BodyType.StaticBody, wallFixtureDef).setUserData("");
    PhysicsFactory.createBoxBody(this.mPhysicsWorld, left, BodyType.StaticBody, wallFixtureDef).setUserData("");
    PhysicsFactory.createBoxBody(this.mPhysicsWorld, right, BodyType.StaticBody, wallFixtureDef).setUserData("");
   
    Sprite spr_ground = new Sprite(0,mConst.CAMERA_HEIGHT-96, mRes.wall1);
    mScene.attachChild(spr_ground);
    


   // new Box(100,100,this.mScene,this.mPhysicsWorld,BoxType.BOX);
   // new Box(100,100,this.mScene,this.mPhysicsWorld,BoxType.BOX);
  //  new Box(100,100,this.mScene,this.mPhysicsWorld,BoxType.BOX);
    
    

	man = new Man(300,100,this.mScene ,this.mPhysicsWorld,this.game );
    this.mScene.registerUpdateHandler(this.mPhysicsWorld);
    mConst.gameScene = this;
    mConst.CURRENT_SCENE = mScene;
    mScene.setIgnoreUpdate(false);
    mConst.MAN = man.head_spr;
    
    Controller ctrl =  Controller.getInstance(man, this.mScene,this.game);
    life_ctrl = new LifeCtrl(this.mScene,this.game,ctrl.getHUD());
    mConst.life_ctrl = life_ctrl;
    ctrl.getHUD().attachChild(life_ctrl.life);
    mConst.hud =ctrl.getHUD();
    mConst.hud.setIgnoreUpdate(false);
    prg_ctrl = new ProgressCtrl();
    prg_ctrl.register(  ctrl.getHUD() );
  
    mConst.prg_ctrl = prg_ctrl;
    CreateLevel();

    
    
    
    
    
	
}
//--------------------------------------------------------------



private ContactListener createContactListener() {
		ContactListener contactListener = new ContactListener()
        {
     
			@Override
            public void beginContact(Contact contact)
            {
            	//Log.v("BALL","CONTACT");
                final Fixture x1 = contact.getFixtureA();
                final Fixture x2 = contact.getFixtureB();
         
                Body b1 = x1.getBody();
                Body b2 = x2.getBody();
           //     String str1 = (String) b1.getUserData();
             //   String str2 = (String) b2.getUserData();
               if( (x1.getUserData()  instanceof String) && (x2.getUserData()  instanceof String)  ) {
            	              // –” ¿ œ≈–—ŒÕ¿∆¿ Ë «ŒÃ¡»
                            if(x1.getUserData().equals("zombie")&&x2.getUserData().equals("man_hand")) {
                            	contact_man_z(b2,b1);
                            }
                            
                            if(x2.getUserData().equals("zombie")&&x1.getUserData().equals("man_hand")) {
                            	contact_man_z(b1,b2);
                            }
                            
                            if(x2.getUserData().equals("zombiezh")&&x1.getUserData().equals("man_body")) {
                            	float power =b2.getLinearVelocity().lenManhattan();
                        		life_ctrl.MinusLife((int)power);
                        		//Log.v("BALL","man_body   zombie 1");
                            }
                            if(x1.getUserData().equals("zombiezh")&&x2.getUserData().equals("man_body")) {
                            	float power =b1.getLinearVelocity().lenManhattan();
                        		life_ctrl.MinusLife((int)power);;
                        		//Log.v("BALL","man_body   zombie 2");
                            }
            	   
               }
                //--------------------------------------
               
                if(x1.getUserData() instanceof String ) {
               // 	Log.v(TAG,"x1 = "+x1.getUserData());
                	if(x1.getUserData().equals("zombie")  && b2.getUserData() instanceof Man) {
                	//	Log.v(TAG,"”‰‡ËÎË MAN");
                		float power =b1.getLinearVelocity().lenManhattan();
                		life_ctrl.MinusLife((int)power);
                	}
                }
                if(x2.getUserData() instanceof String ) {
              //  	Log.v(TAG,"x2 = "+x1.getUserData());
                	if(x2.getUserData().equals("zombie")  && b1.getUserData() instanceof Man) {
                	//	Log.v(TAG,"”‰‡ËÎË MAN");
                		float power =b2.getLinearVelocity().lenManhattan();
                		life_ctrl.MinusLife((int)power/2);
                	}
                }
                
               /* 
                // Z1---- MAN
                if(b1.getUserData() instanceof Man_hand && b2.getUserData() instanceof Z1 ){
                	Z1 z1 = (Z1)b2.getUserData(); 
                	z1.man_contact();
                	game.mRes.man_hook1.play();
                //	Log.v(TAG,"man_z");
                	//Bomb b = (Bomb)b2.getUserData();

                 }
                if(b2.getUserData() instanceof Man_hand && b1.getUserData() instanceof Z1 ){
                	Z1 z1 = (Z1)b1.getUserData(); 
                	//Bomb b = (Bomb)b2.getUserData();
                	z1.man_contact();
                	game.mRes.man_hook1.play();
                //	Log.v(TAG,"man_z2");
                 }
                
                
                /*----------------------------------------------------------------------------
                 * ZOMBIE
                 */
                if(b1.getUserData() instanceof Man_hand && b2.getUserData() instanceof Zombie ){
                	Zombie z1 = (Zombie)b2.getUserData();                 	
                	float power =b1.getLinearVelocity().lenManhattan();
                	z1.beginContact( power );
                	PlayHook();
                 }
                if(b2.getUserData() instanceof Man_hand && b1.getUserData() instanceof Zombie ){
                	Zombie z1 = (Zombie)b1.getUserData(); 
                	float power =b1.getLinearVelocity().lenManhattan();
                	z1.beginContact( power );
                	PlayHook();
                 }
                 
                /*----------------------------------------------------------------------------
                 * BOSS1
                 */
                if(b1.getUserData() instanceof Man_hand && b2.getUserData() instanceof Boss1 ){
                	Boss1 z1 = (Boss1)b2.getUserData();                 	
                	float power =b1.getLinearVelocity().lenManhattan();
                	z1.beginContact( b2,power );
                	game.mRes.man_hook2.play();
                 }
                if(b1.getUserData() instanceof Man_hand && b1.getUserData() instanceof Boss1 ){
                	Boss1 z1 = (Boss1)b1.getUserData(); 
                	float power =b1.getLinearVelocity().lenManhattan();
                	z1.beginContact( b1,power );
                	game.mRes.man_hook2.play();
                 }
                
                /*
                 * ---------------------------------------------------------------------------
                 * 
                 */
      
                
                /*
                 * 
                 */
                
                //sensor
                if(b1.getUserData() instanceof String  && b2.getUserData() instanceof String ){
                	
                          String str1 = (String) b1.getUserData();
                          String str2 = (String) b2.getUserData();
                         // Log.v(TAG , "str1 ="+str1);
                          if(  (str1.equals(String.valueOf("man_sensor"))   && str2.equals(String.valueOf("ground")))  ||
                        	   (str2.equals(String.valueOf("man_sensor"))   && str1.equals(String.valueOf("ground")))   ) {
                          man.canJump = true;
                          man.canJump2 = true;
                          Log.v(TAG,"sensor ok");
                          }
                	
                 } 
   
       
            }

			@Override
            public void endContact(Contact contact) { 
		       
	            
			}
            @Override
            public void preSolve(Contact contact, Manifold oldManifold){ }
            @Override
            public void postSolve(Contact contact, final ContactImpulse impulse) { }};
           
            
            
            
            
            
            return contactListener;
	}



protected void contact_man_z(Body b_man_hand, Body b_z) {
	
	float power =b_man_hand.getLinearVelocity().lenManhattan();
	
	if(b_z.getUserData() instanceof Zombie2) {
		
		PlayHook();
		Log.v(TAG,"contact_man_z");
		Zombie2 z1 = (Zombie2)b_z.getUserData();                 	
    	z1.beginContact( power );
	}
	
if(b_z.getUserData() instanceof Dog) {
		
		PlayHook();
		Log.v(TAG,"contact_man_z");
		Dog z1 = (Dog)b_z.getUserData();                 	
    	z1.beginContact( power );
	}

if(b_z.getUserData() instanceof Boss2) {
	
	PlayHook();
	Log.v(TAG,"contact_man_z");
	Boss2 z1 = (Boss2)b_z.getUserData();                 	
	z1.beginContact( power );
}

if(b_z.getUserData() instanceof Zomb) {
	PlayHook();
	Zomb z1 = (Zomb)b_z.getUserData();                 	
	z1.beginContact( power );
}


	
}

//---------------------------------------------------------------------------------
public void PlayHook() {
	
	if( f_hook_play == false) return;
	

		game.mRes.man_hook1.play();
		f_hook_play  = false;

mScene.registerUpdateHandler(new IUpdateHandler() {  
			
			private int time = 0;

			@Override  
     public void onUpdate(float arg0) { 
			      if(time  > 5) {
			    	  f_hook_play  = true;  
				   mScene.unregisterUpdateHandler(this);
				   time=0;
			      }
			      time++;
		         }  

   @Override  
    public void reset() {   } 
	 });
	
	 
}

//----------------------------------------------------------------------------------
public void CreateLevel() {
   
 
    prg_ctrl.setZattackCol(ldef.Enemies.length);
    mConst.ZOMBIE_COL = ldef.Enemies.length;
    
   
    //---- œŒ ¿«€¬¿≈Ã Õ¿ƒœ»—‹  ¿ Œ… ”–Œ¬≈Õ‹--------------------
	 String  str=(String)Constants.getInstance().main_activity.getResources().getString(R.string.level);
	 str+= " "+ mConst.SELECTED_MAP;
	  t2 = new Text(0, 0, Resource.getInstance().mFont_Plok, str);
	  t2.setScale(8);
	  t2.setColor(0.2f, 0.6f, 0.1f);
	  t2.setPosition( (mConst.CAMERA_WIDTH - t2.getWidth() )/2,  (mConst.CAMERA_HEIGHT - t2.getHeight())/2  );
	  mScene.attachChild(t2);
    	 mRes.a_yah.play();
	  mScene.registerUpdateHandler(new IUpdateHandler() {  
			
			private float scale = 8;
			@Override  
     public void onUpdate(float arg0) { 
				
				if( scale <=2) {
					
				mScene.unregisterUpdateHandler(this);
				}
				else {
					scale  -=0.2f;
					t2.setScale(scale);
				}
		         }  
   @Override  
    public void reset() {   }  
 });  
   
    //-----------------------------------------------------
    mScene.registerUpdateHandler( new TimerHandler( 3,true, new ITimerCallback(){
		@Override
		public void onTimePassed(TimerHandler pTimerHandler) {
			mScene.unregisterUpdateHandler(pTimerHandler);
			mScene.detachChild(t2);
		
			CreateZombie();
		}		   
	   })); 
    

    
    
}//-----------------------------------------------------------------------------------

public void CreateZombie() {
	
	if(mConst.CURRENT_ZOMBIE_I <=(ldef.Enemies.length-1) ) {
	
		prg_ctrl.plus();
		EnemyType et =	ldef.Enemies[mConst.CURRENT_ZOMBIE_I].mEnemyType;
		if(et == EnemyType.ZBoss1) {
			mRes.d_zombie.play();
			//Z1(float x,float y,final GameScene mScene2, PhysicsWorld mPhysicsWorld, main game) 
			new Boss1(ldef.Enemies[mConst.CURRENT_ZOMBIE_I].mX,
					   ldef.Enemies[mConst.CURRENT_ZOMBIE_I].mY,
					   this ,
					   this.mPhysicsWorld,
					   this.game );
		}
		
	// œ–Œ—“Œ… «ŒÃ¡»	
	if(et == EnemyType.Zombie ) {
		mRes.a_zombie.play();
		new Zombie(ldef.Enemies[mConst.CURRENT_ZOMBIE_I].mX,
				   ldef.Enemies[mConst.CURRENT_ZOMBIE_I].mY,
				   this ,
				   this.mPhysicsWorld,
				   this.game );
		}
	 
	// ZOMBIE 2 ----------------
	    if(et == EnemyType.Zombie2 ) {mRes.a_zombie.play();
		new Zombie2(ldef.Enemies[mConst.CURRENT_ZOMBIE_I].mX,ldef.Enemies[mConst.CURRENT_ZOMBIE_I].mY,this ,this.mPhysicsWorld,this.game );
		}
	    
	    
	    //    new Dog(100f,100f,this,this.mPhysicsWorld, this.game);
	    
		// ZOMBIE 2 ----------------
	    if(et == EnemyType.Dog ) {mRes.a_zombie.play();
		new Dog(ldef.Enemies[mConst.CURRENT_ZOMBIE_I].mX,ldef.Enemies[mConst.CURRENT_ZOMBIE_I].mY,this ,this.mPhysicsWorld,this.game );
		}
	    
		// ZOMBIE 2 ----------------
	    if(et == EnemyType.Boss2 ) {mRes.a_zombie.play();
		new Boss2(ldef.Enemies[mConst.CURRENT_ZOMBIE_I].mX,ldef.Enemies[mConst.CURRENT_ZOMBIE_I].mY,this ,this.mPhysicsWorld,this.game );
		}
	    
	 // ZOMBIE 2 ----------------
	    if(et == EnemyType.ZomieHead ) {mRes.a_zombie.play();
		new ZombieHead(ldef.Enemies[mConst.CURRENT_ZOMBIE_I].mX,ldef.Enemies[mConst.CURRENT_ZOMBIE_I].mY);
		}
	    
	//Log.v("GAMESCENE","time="+ldef.Enemies[mConst.CURRENT_ZOMBIE_I].time +" I="+mConst.CURRENT_ZOMBIE_I + " len="+ldef.Enemies.length );	

	
	
   	mScene.registerUpdateHandler( new TimerHandler( ldef.Enemies[mConst.CURRENT_ZOMBIE_I].time,true, new ITimerCallback(){
			@Override
			public void onTimePassed(TimerHandler pTimerHandler) {
				mScene.unregisterUpdateHandler(pTimerHandler);
				mConst.CURRENT_ZOMBIE_I++;
				CreateZombie();
			}
			   
		   })); 
	}
	else {
		   mConst.F_ENEMY_END = true;
		   game.runOnUiThread(new Runnable() {
	        @Override
	        public void run() {
	     
		//	Toast.makeText(game, R.string.app_name, Toast.LENGTH_SHORT).show();
	        }
	    });
	}
	
}

public Scene getScene() {
		// TODO Auto-generated method stub
		return this.mScene;
	}






public void CloseScene() {
	Log.v("GameScene" ,"CloseScene() CloseScene ");
	mScene.setIgnoreUpdate(true);

	//
	 game.runOnUpdateThread(new Runnable() {

	        @Override
	        public void run() {
	        	//
	       	 //game.mSmoothCamera.getHUD().clearChildScene();
	         	// game.mSmoothCamera.getHUD().clearTouchAreas();
	         	// game.mSmoothCamera.getHUD().setVisible(false);
	         	game.mSmoothCamera.getHUD().setPosition(-1000, -1000);
	         	game.mSmoothCamera.getHUD().setIgnoreUpdate(true);
	         	game.mSmoothCamera.getHUD().clearTouchAreas();
	            game.mSmoothCamera.setCenterDirect(mConst.CAMERA_WIDTH/2, mConst.CAMERA_HEIGHT/2);

	            Dialog.getInstance().HideAll();
	            clearPhysicsWorld( mPhysicsWorld);
	            
	            mScene.detachChildren();
	            mScene.clearUpdateHandlers();
	            mScene.clearEntityModifiers();
	            
	       	 mScene.clearTouchAreas();
	       	 life_ctrl.dispose();
	       	 prg_ctrl.dispose();
	       	 t2 = null;
	       	// mScene=null;
	         System.gc();
	         if(CMD_CLOSE_SCENE == 1) {CMD_CLOSE_SCENE = 0;game.sceneManager.setCurrentScene(AllScenes.GAME);}
	         else game.sceneManager.setCurrentScene(AllScenes.MENU);

	        }
	    });
	 /*
	 mScene.registerUpdateHandler(new IUpdateHandler() {  
			
			@Override  
        public void onUpdate(float arg0) { 
			
				mScene.unregisterUpdateHandler(this);
				 
				 clearPhysicsWorld( mPhysicsWorld);
				
					 mScene.detachChildren();
					 life_ctrl.dispose();
					 prg_ctrl.dispose();
				//	mScene.clearUpdateHandlers();
				//	mScene.clearEntityModifiers();
				//	mScene.clearTouchAreas();
					
					 mScene=null;
                    System.gc();
               	 game.sceneManager.setCurrentScene(AllScenes.MENU);
               	
				    
				
		         }  

      @Override  
       public void reset() {   }  
    });  


	// System.gc();
	
	 /*mScene.registerUpdateHandler(new TimerHandler(2f,
				new ITimerCallback() {

					@Override
					public void onTimePassed(TimerHandler pTimerHandler) {
						Log.v("GAME","onTimePassed ");
						mScene.unregisterUpdateHandler(pTimerHandler);
						
					}
				}));
				*/
}
	
protected void clearPhysicsWorld(PhysicsWorld physicsWorld)
{
	
	Iterator<Joint> allMyJoints = physicsWorld.getJoints();
	while (allMyJoints.hasNext())
	{
		try
		{
			final Joint myCurrentJoint = allMyJoints.next();
			physicsWorld.destroyJoint(myCurrentJoint);
			Debug.d("DEL JOINT " );
		} 
		catch (Exception localException)
		{
			Debug.d("SPK - THE JOINT DOES NOT WANT TO DIE: " + localException);
		}
	}
	
	Iterator<Body> localIterator = physicsWorld.getBodies();
	while (true)
	{
		if (!localIterator.hasNext())
		{
			physicsWorld.clearForces();
			physicsWorld.clearPhysicsConnectors();
			physicsWorld.reset();
			physicsWorld.dispose();
			physicsWorld = null;
			return;
		}
		try
		{
			physicsWorld.destroyBody(localIterator.next());
		} 
		catch (Exception localException)
		{
			Debug.d("SPK - THE BODY DOES NOT WANT TO DIE: " + localException);
		}
	}
}






public void GameRestart() {
	CMD_CLOSE_SCENE = 1;
	CloseScene();
	
}

/*
 * ¬€«€¬¿≈“—ﬂ œ–» œ≈–≈’Œƒ≈
 * Õ¿ —À≈ƒ”ﬁŸ»… ”–Œ¬≈Õ‹
 */

public void NextLevel() {
	//mConst.SELECTED_MAP++;
	CMD_CLOSE_SCENE = 1;
	CloseScene();
	
	
	
}

/*
 * ” »√–Œ ¿ «¿ ¿Õ◊»¬¿≈“—ﬂ ∆»«Õ‹
 */

public void ManDie() {
	//mScene.setIgnoreUpdate(true);
	//Constants.getInstance().LIFE_CURRENT =Constants.getInstance().LIFE_CURRENT ;
	//Constants.getInstance().COL_HEART = Constants.getInstance().COL_HEART;
	mScene.setIgnoreUpdate(true);
	Dialog.getInstance().GamerLose();
	man.die();
	game.f_man_die = true;
	
}



public void PlayerWin() {
    mScene.setIgnoreUpdate(true);
	
}





}
