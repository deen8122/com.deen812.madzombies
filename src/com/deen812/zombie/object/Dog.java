package com.deen812.zombie.object;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.handler.timer.ITimerCallback;
import org.anddev.andengine.engine.handler.timer.TimerHandler;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.AnimatedSprite;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.extension.physics.box2d.PhysicsConnector;
import org.anddev.andengine.extension.physics.box2d.PhysicsFactory;
import org.anddev.andengine.extension.physics.box2d.PhysicsWorld;

import android.util.Log;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;
import com.deen812.zombie.Constants;
import com.deen812.zombie.Resource;
import com.deen812.zombie.main;
import com.deen812.zombie.scene.GameScene;

public class Dog {

	
	

    float x;
    int delay = 100;
    int delayI=0;
	private Resource mRes;
	private Scene mScene;
	
	int life = 200;
	int type = 0;
	private PhysicsWorld mPhysicsWorld;
	private AnimatedSprite dog_spr;
	private Body dog_body;
	
	private int time_life = 200;
	private IUpdateHandler mainUpdateHandler;
	private boolean fDie = false;
	//private Sprite sprHand1;
	
	private Man man;
	private int napX;
	private int jumpForceY = 1000;
	private int jumpForceX = 340;
	private TimerHandler timerh;
	private boolean f_died = false;
	
	private main game;
	private float step;

	
	
   //==========================================================
    
    
	public void Update() {
//		sprLeg.animate(new long[] {200,200,200} ,new int[] {0,1,2},0);
	
	
			dog_body.setTransform(dog_body.getPosition().x + step, dog_body.getPosition().y, 0);
		//	dog_body.applyLinearImpulse(new Vector2(napX*jumpForceX,0), dog_body.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
		 
		//	bdBody.applyLinearImpulse(new Vector2(0,-jumpForceY), bdBody.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
		//	bdLeg.applyLinearImpulse(new Vector2(napX*jumpForceX,0), bdBody.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
			//bdHead.applyLinearImpulse(new Vector2(0,-jumpForceY), bdBody.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
				
			
		//if(delayI<1){
			
		//	bdBody.applyLinearImpulse(new Vector2(-delay,-delay), bdBody.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
		//	delayI = delay;
	//	}
	//	delayI--;
	}
	
	
	public void jump() {
		Log.v("DOG","JUMP()");
		dog_body.applyLinearImpulse(new Vector2(napX*jumpForceX,-jumpForceY), dog_body.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
		
	}
	//------------------------------------------------------------------------------------------
	public Dog(float x,float y,final GameScene mScene2, PhysicsWorld mPhysicsWorld, main game) {
		this.mRes =game.mRes;
		this.mScene = mScene2.mScene;
		this.mPhysicsWorld = mPhysicsWorld;
		this.man = mScene2.man;
		this.game = game;
		final FixtureDef objectFixtureDef2 = PhysicsFactory.createFixtureDef(10f, 0.1f, 1f);
		objectFixtureDef2.filter.categoryBits = 0x04;
		objectFixtureDef2.filter.maskBits = 0x0A;
		
		
		//√ќЋ¬ј
		 delay = (int) (Math.random()*100)+60;
		 jumpForceY+=delay;
		 dog_spr = new AnimatedSprite(x , y , mRes.dog.clone());
		 animate1() ;
		  this.mScene.attachChild(dog_spr);   
		 dog_body = PhysicsFactory.createBoxBody(mPhysicsWorld, dog_spr, BodyType.DynamicBody, objectFixtureDef2);
		 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(dog_spr, dog_body, true, true));
		 dog_body.setUserData(this);
		 dog_body.getFixtureList().get(0).setUserData("zombie");


       float time = (float) (Math.random()*3+1);
       timerh =    new TimerHandler(time,true, new ITimerCallback(){

   			@Override
   			public void onTimePassed(TimerHandler pTimerHandler) {
   				if(man.getX()  < dog_spr.getX()){
   					
   					to_left();
   					napX=-1;
   					step =-0.1f;
   				}else {
   				to_right();
   				napX = 1;
   				step =0.1f;
   				
   				}
   				
   			 if(  (Math.abs(man.getX()  - dog_spr.getX())  < 160) && (man.getY() < dog_spr.getY()) ){
   				 jump();
   			 }
   			       
   			//	 Update();
   			}
   			   
   		   });
     	mScene.registerUpdateHandler(timerh); 
        
     	mScene.registerUpdateHandler(new IUpdateHandler() {  

			@Override  
             public void onUpdate(float arg0) { 
			       //  mScene.unregisterUpdateHandler(mainUpdateHandler);
				 Update();
		         }  

           @Override  
            public void reset() {   }  
         });  
        
	}
	
	
   private void animate1() {
	   dog_spr.animate(new long[] { 100,100,100,100}, new int[]{0,1,0,2}, -1);
   }
   private void animate2() {
	//   dog_spr.animate(new long[] {100,100}, new int[]{0,1,0,2}, -1);
   }
	public void beginContact( float power){
	//	Log.v("Zombiee","power="+power);
		if(!dog_spr.isAnimationRunning()) {
			 dog_spr.animate(new long[] { 100+delay,500+delay,500+delay,500+delay}, new int[]{0,1,2,3}, -1);
				
		}
		if(fDie == false){

		 int power2 = (int) power;
		 life-=power2;
	
	 
	 if(life <= 1){
		 //sprHead.setAlpha(0.0f);
		 this.die();
		 fDie =true;
		 dog_spr.stopAnimation();
		 dog_spr.setCurrentTileIndex(0);
		
		 
	 }

		}	
	}


	private void die() {
		game.mRes.uuu.play();
		//GameParam.getInstance().test--;
		
		 mScene.registerUpdateHandler(new IUpdateHandler() {  
			 private boolean fOne = true;

			@Override  
              public void onUpdate(float arg0) { 
				if(fOne ){
				//	 mPhysicsWorld.destroyJoint(head_body_joint);
			     //    mPhysicsWorld.destroyJoint(leg_body_joint);
			    //     mPhysicsWorld.destroyJoint(hand1_body_joint);
			   //      mPhysicsWorld.destroyJoint(hand2_body_joint);
			         fOne = false;
			         Constants.getInstance().life_ctrl.PlusZombieKill();
			         mScene.unregisterUpdateHandler(mainUpdateHandler);
			         
				}
              
              
              time_life--;
              if(time_life < 0){
            	  mScene.detachChild(dog_spr);
            	//  mScene.detachChild(sprBody);
            	//  mScene.detachChild(sprLeg);
            	//  mScene.detachChild(sprHand1);
            	//  mScene.detachChild(sprHand2);
     
		        
                // mPhysicsWorld.destroyBody(bdHand1);
                // mPhysicsWorld.destroyBody(bdHand2);
		         mPhysicsWorld.destroyBody(dog_body);
		         //mPhysicsWorld.destroyBody(bdBody);
		        // mPhysicsWorld.destroyBody(bdLeg);
		         mScene.unregisterUpdateHandler(this);
		     
              }
		         }  

            @Override  
             public void reset() {   }  
          });  
         

		 
		
		 
		
	}

	
	public void to_left() {
	//	vectorHook = vectorHookLeft;
		//selected_body_hook = this.hand_body_left;
		if(napX !=-1){
		this.dog_spr.getTextureRegion().setFlippedHorizontal(false);
	//	this.sprBody.getTextureRegion().setFlippedHorizontal(false);
	//	sprLeg.getTextureRegion().setFlippedHorizontal(false);
		}
		
	}
	
	public void key_up() {
	//	f_moved = false;
	//	mScene.unregisterUpdateHandler(moveHandler);
	}
	public void to_right() {
		if(napX !=1){
	//	x_step  = 0.1f;
	//	vectorHook = vectorHookRight;
		//selected_body_hook = this.hand_body_right;
	//	this.body_body.applyLinearImpulse(new Vector2( 1000 , 0), body_body.getWorldCenter());
		this.dog_spr.getTextureRegion().setFlippedHorizontal(true);
	//	this.sprBody.getTextureRegion().setFlippedHorizontal(true);
	//	sprLeg.getTextureRegion().setFlippedHorizontal(true);
		}

	}

	
	

	public void setImpulse(float f) {
		// TODO Auto-generated method stub
	//float[] imp = 	impulse.getNormalImpulses();
	//impulse.
//	String S= "";
//	int ff = (int) imp[1];
	
	}


	public void man_contact() {
		
		if(f_died   == false){
			f_died = true;
		//	 die() ;
			
	  
		}
		
	}
	
	
}
/*
 *//*hero.mm Ч герой
...
heroFixtureFilter.categoryBits = 0x08;
heroFixtureFilter.maskBits = 0x07;
...
villain.mm Ч злодей
...
villainFixtureFilter.categoryBits = 0x04;
villainFixtureFilter.maskBits = 0x0ј;
...
obstacle.mm Ч преп€тствие дл€ всех
...
obstacleFixtureFilter.categoryBits = 0x02;
obstacleFixtureFilter.maskBits = 0x0C;
...
heroOnlyObstacle.mm Ч преп€тствие только дл€ геро€
...
heroOnlyObstacleFixtureFilter.categoryBits = 0x01;
heroOnlyObstacleFixtureFilter.maskBits = 0x08;
...
 * */
