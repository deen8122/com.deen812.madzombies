package com.deen812.zombie.object;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.handler.timer.ITimerCallback;
import org.anddev.andengine.engine.handler.timer.TimerHandler;
import org.anddev.andengine.entity.primitive.Rectangle;
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

public class Zombie2 {

	
	

    float x;
    int delay = 100;
    int delayI=0;
	private Resource mRes;
	private Scene mScene;
	
	int life = 400;
	int type = 0;
	private PhysicsWorld mPhysicsWorld;
	private AnimatedSprite sprHead;
	private Body bdHead;
	private AnimatedSprite sprBody;
	private Body bdBody;
	private RevoluteJoint head_body_joint;
	//private AnimatedSprite sprLeg;
	//private Body bdLeg;
	//private RevoluteJoint leg_body_joint;
	
	private int time_life = 200;
	private IUpdateHandler mainUpdateHandler;
	private boolean fDie = false;
	private Sprite sprHand1;
	private Body bdHand1;
	private RevoluteJoint hand1_body_joint;
	private Body bdHand2;
	private Sprite sprHand2;
	private RevoluteJoint hand2_body_joint;
	private Man man;
	private int napX;
	private int jumpForceY = 110;
	private int jumpForceX = 190;
	private TimerHandler timerh;
	private boolean f_died = false;
	private Object vectorHook;
	private main game;
	private Body bdLeg1;
	private Body bdLeg2;
	private Body bdLeg3;
	private Body bdLeg4;
	private RevoluteJoint jointL1L2;
	private RevoluteJoint jointL3L4;
	private RevoluteJoint jointL1B;
	private RevoluteJoint jointL3B;
	private AnimatedSprite leg_rect1;
	private AnimatedSprite leg_rect2;
	private AnimatedSprite leg_rect3;
	private AnimatedSprite leg_rect4;
	private AnimatedSprite leg_rect5;
	private AnimatedSprite leg_rect6;
	private Body bdLeg6;
	private Body bdLeg5;
	private RevoluteJoint jointL2L5;
	private RevoluteJoint jointL4L6;
	private boolean f_j1 = true;
	private boolean f_j2 = true;
	private boolean f_j3 = true;
	private boolean f_j4 = true;

	
	
   //==========================================================
    
    
	public void Update() {
//		sprLeg.animate(new long[] {200,200,200} ,new int[] {0,1,2},0);
			if(this.man.getX()  < this.sprHead.getX()){
				
				to_left();
				napX=-1;
			}else {
			to_right();
			napX = 1;
			
			}
			//sprLeg.animate(new long[] {200,200,200} ,new int[] {0,1,2},0);
			//bdLeg.setTransform(bdLeg.getPosition().x, bdLeg.getPosition().y, 0);
			bdBody.applyLinearImpulse(new Vector2(napX*jumpForceX,-jumpForceY), bdBody.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
			
		//	bdBody.applyLinearImpulse(new Vector2(0,-jumpForceY), bdBody.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
		//	bdLeg.applyLinearImpulse(new Vector2(napX*jumpForceX,0), bdBody.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
			//bdHead.applyLinearImpulse(new Vector2(0,-jumpForceY), bdBody.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
				
			
		//if(delayI<1){
			
		//	bdBody.applyLinearImpulse(new Vector2(-delay,-delay), bdBody.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
		//	delayI = delay;
	//	}
	//	delayI--;
	}
	
	
	//------------------------------------------------------------------------------------------
	public Zombie2(float x,float y,final GameScene mScene2, PhysicsWorld mPhysicsWorld, main game) {
		this.mRes =game.mRes;
		this.mScene = mScene2.mScene;
		this.mPhysicsWorld = mPhysicsWorld;
		this.man = mScene2.man;
		this.game = game;
		final FixtureDef objectFixtureDef2 = PhysicsFactory.createFixtureDef(0.3f, 0.1f, 1f);
		objectFixtureDef2.filter.categoryBits = 0x04;
		objectFixtureDef2.filter.maskBits = 0x0A;
		
		
		
		
		//ГОЛВА
		 delay = (int) (Math.random()*100)+60;
		 sprHead = new AnimatedSprite(x , y , mRes.z2_head.clone());
		 sprHead.animate(new long[] { 100+delay,500+delay,500+delay,500+delay}, new int[]{0,1,2,3}, -1);
		 sprHead.setCullingEnabled(true);    
		 bdHead = PhysicsFactory.createBoxBody(mPhysicsWorld, sprHead, BodyType.DynamicBody, objectFixtureDef2);
		 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(sprHead, bdHead, true, true));
		 bdHead.setUserData(this);
		 bdHead.getFixtureList().get(0).setUserData("zombie");
		 
		 
		 
		 
		 //ТЕЛО
		 sprBody = new AnimatedSprite(x , y , mRes.z1_body);		
		 mScene.attachChild(sprBody);
		 mScene.attachChild(sprHead);
		 bdBody = PhysicsFactory.createBoxBody(mPhysicsWorld, sprBody, BodyType.DynamicBody, objectFixtureDef2);
		 bdBody.setUserData(this);
		 bdBody.getFixtureList().get(0).setUserData("zombie");
		 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(sprBody, bdBody, true, true));
		 //bdBody.setFixedRotation(true); 
		
		 //КРЕПИМ ГОЛОВУ К ТЕЛУ
		   RevoluteJointDef  revoluteJointDef = new RevoluteJointDef();
	       revoluteJointDef.bodyA =bdHead; //первое тело соединения
	       revoluteJointDef.bodyB = bdBody; //второе тело соединения
	       revoluteJointDef.collideConnected = false; //тела не сталкиваются
	       revoluteJointDef.motorSpeed = -10f;
	       revoluteJointDef.maxMotorTorque=10f;
	       revoluteJointDef.enableLimit = true;
	       revoluteJointDef.upperAngle = 0.3f;
	       revoluteJointDef.lowerAngle = -0.3f;
	       revoluteJointDef.localAnchorA.add(new Vector2(0f, sprHead.getHeight()/80));//.obtain(0,0);
	       revoluteJointDef.localAnchorB.add(new Vector2(0f,  - sprBody.getHeight()/70 ));
	       //revoluteJointDef.initialize(bodyB, bodyG,  new Vector2(0,(float) 0.1));
	       revoluteJointDef.enableMotor = true;
           head_body_joint = (RevoluteJoint)  mPhysicsWorld.createJoint(revoluteJointDef);
	      
           
           
           
           
           
	     // LEG
          leg_rect1 = new AnimatedSprite(0,0,mRes.z2_leg);
         
       //  leg_rect1.setColor(0, 0, 0);
         
         leg_rect2 = new AnimatedSprite(0,0,mRes.z2_leg.clone());
      //   leg_rect2.setColor(0, 0, 0);
         
         leg_rect3 = new AnimatedSprite(0,0,mRes.z2_leg.clone());
      //   leg_rect3.setColor(0, 0, 0);
         
         leg_rect4 = new AnimatedSprite(0,0,mRes.z2_leg.clone());
      //   leg_rect4.setColor(0, 0, 0);
         
         leg_rect5 = new AnimatedSprite(0,0,mRes.z2_leg.clone());
         //   leg_rect3.setColor(0, 0, 0);
            
        leg_rect6 = new AnimatedSprite(0,0,mRes.z2_leg.clone());
        
         mScene.attachChild(leg_rect1);
         mScene.attachChild(leg_rect2);
         mScene.attachChild(leg_rect3);
         mScene.attachChild(leg_rect4);
         mScene.attachChild(leg_rect5);
         mScene.attachChild(leg_rect6);
         
         leg_rect1.setCurrentTileIndex(0);
         leg_rect3.setCurrentTileIndex(0);
         
         leg_rect2.setCurrentTileIndex(4);
         leg_rect4.setCurrentTileIndex(4);
         
         leg_rect5.setCurrentTileIndex(8);
         leg_rect5.setRotation(-90f);
         
         leg_rect6.setCurrentTileIndex(8);
         leg_rect6.setRotation(-90f);
         
  
		 final FixtureDef objectFixtureDef3 = PhysicsFactory.createFixtureDef(13f, 0.1f, 1f);
			objectFixtureDef3.filter.categoryBits = 0x04;
			objectFixtureDef3.filter.maskBits = 0x0A;
			
			
		 bdLeg1 = PhysicsFactory.createBoxBody(mPhysicsWorld, leg_rect1, BodyType.DynamicBody, objectFixtureDef3);
		 bdLeg1.getFixtureList().get(0).setUserData("zombie");
		 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(leg_rect1, bdLeg1, true, true));
		 
		 bdLeg2 = PhysicsFactory.createBoxBody(mPhysicsWorld, leg_rect2, BodyType.DynamicBody, objectFixtureDef3);
		 bdLeg2.getFixtureList().get(0).setUserData("zombie");
		 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(leg_rect2, bdLeg2, true, true));
		 
		 bdLeg3 = PhysicsFactory.createBoxBody(mPhysicsWorld, leg_rect3, BodyType.DynamicBody, objectFixtureDef3);
		 bdLeg3.getFixtureList().get(0).setUserData("zombie");
		 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(leg_rect3, bdLeg3, true, true));
		 
		 bdLeg4 = PhysicsFactory.createBoxBody(mPhysicsWorld, leg_rect4, BodyType.DynamicBody, objectFixtureDef3);
		 bdLeg4.getFixtureList().get(0).setUserData("zombie");
		 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(leg_rect4, bdLeg4, true, true));
		 
		 bdLeg6 = PhysicsFactory.createBoxBody(mPhysicsWorld, leg_rect6, BodyType.DynamicBody, objectFixtureDef3);
		 bdLeg6.getFixtureList().get(0).setUserData("zombie");
		 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(leg_rect6, bdLeg6, true, true));
		 bdLeg6.setTransform(bdLeg6.getPosition(), -0.1f);
		 
		 bdLeg5 = PhysicsFactory.createBoxBody(mPhysicsWorld, leg_rect5, BodyType.DynamicBody, objectFixtureDef3);
		 bdLeg5.getFixtureList().get(0).setUserData("zombie");
		 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(leg_rect5, bdLeg5, true, true));
		 
		 jointL1L2 =  createRevoluteJoint(bdLeg1,bdLeg2,new Vector2(0, (leg_rect1.getHeight()-5)/60),new Vector2(0,-leg_rect2.getHeight()/60));
		 jointL3L4 =  createRevoluteJoint(bdLeg3,bdLeg4,new Vector2(0,(leg_rect1.getHeight()-5)/60),new Vector2(0,-leg_rect2.getHeight()/60));
	
		 jointL2L5 =  createRevoluteJoint(bdLeg4,bdLeg5,new Vector2(0, (leg_rect2.getHeight()-12)/60),new Vector2(0,-leg_rect5.getHeight()/60));
		 jointL4L6 =  createRevoluteJoint(bdLeg2,bdLeg6,new Vector2(0,(leg_rect4.getHeight()-12)/60),new Vector2(0,-leg_rect6.getHeight()/60));
		 
		 
		 jointL1B =  createRevoluteJoint(bdLeg1,bdBody,new Vector2(0, -(leg_rect1.getHeight()-5)/60),new Vector2(0.15f,sprBody.getHeight()/60));
		 jointL3B =  createRevoluteJoint(bdLeg3,bdBody,new Vector2(0, -(leg_rect1.getHeight()-5)/60),new Vector2(-0.15f,sprBody.getHeight()/60));
	       
		 
		 
	      //РУКИ
	         sprHand1 = new Sprite(x , y , mRes.z_hand);
			 mScene.attachChild(sprHand1);

			 bdHand1 = PhysicsFactory.createBoxBody(mPhysicsWorld, sprHand1, BodyType.DynamicBody, objectFixtureDef2);
			 //bdHand1.setUserData(this);
			 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(sprHand1, bdHand1, true, true));
			 bdHand1.getFixtureList().get(0).setUserData("zombie");
			 //КРЕПИМ 
			   revoluteJointDef = new RevoluteJointDef();
		       revoluteJointDef.bodyA =bdBody; //первое тело соединения
		       revoluteJointDef.bodyB = bdHand1; //второе тело соединения
		       revoluteJointDef.collideConnected = false; //тела не сталкиваются
		       revoluteJointDef.motorSpeed = -5f;
		       revoluteJointDef.referenceAngle = 1.5f;
		       revoluteJointDef.maxMotorTorque=10f;
		       //revoluteJointDef.enableLimit = true;
		       revoluteJointDef.upperAngle = 0.2f;
		       revoluteJointDef.lowerAngle = -0.2f;
		       revoluteJointDef.localAnchorA.add( new Vector2(0f,   -0.4f )    );//.obtain(0,0);
		       revoluteJointDef.localAnchorB.add( new Vector2(0f,  - sprHand1.getHeight()/70 ));
		       //revoluteJointDef.initialize(bodyB, bodyG,  new Vector2(0,(float) 0.1));
		       revoluteJointDef.enableMotor = true;
		       hand1_body_joint = (RevoluteJoint)  mPhysicsWorld.createJoint(revoluteJointDef);
	       
		       sprHand2 = new Sprite(x , y , mRes.z_hand);
				 mScene.attachChild(sprHand2);
				 sprHand2.setZIndex(0);
				 bdHand2 = PhysicsFactory.createBoxBody(mPhysicsWorld, sprHand2, BodyType.DynamicBody, objectFixtureDef2);
				 //bdHand2.setUserData(this);
				 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(sprHand2, bdHand2, true, true));
				 bdHand2.getFixtureList().get(0).setUserData("zombie");
				 //КРЕПИМ 
				   revoluteJointDef = new RevoluteJointDef();
			       revoluteJointDef.bodyA =bdBody; //первое тело соединения
			       revoluteJointDef.bodyB = bdHand2; //второе тело соединения
			       revoluteJointDef.collideConnected = false; //тела не сталкиваются
			       revoluteJointDef.motorSpeed = 5f;
			       revoluteJointDef.referenceAngle = 1.4f;
			       revoluteJointDef.maxMotorTorque=10f;
			     //  revoluteJointDef.enableLimit = true;
			       revoluteJointDef.upperAngle = 0.3f;
			       revoluteJointDef.lowerAngle = -0.3f;
			       revoluteJointDef.localAnchorA.add( new Vector2(0f,   -0.4f )    );//.obtain(0,0);
			       revoluteJointDef.localAnchorB.add( new Vector2(0.2f,  - sprHand2.getHeight()/75 ));
			       //revoluteJointDef.initialize(bodyB, bodyG,  new Vector2(0,(float) 0.1));
			       revoluteJointDef.enableMotor = true;
			       hand2_body_joint = (RevoluteJoint)  mPhysicsWorld.createJoint(revoluteJointDef);
			       
			       
			       
	       
		//sprite  = new AnimatedSprite(x , y , res.z0.clone());
		
		
		//sprite.animate(delay*10);
		//mScene.attachChild(sprite);
		
		
       // bodyBody = PhysicsFactory.createBoxBody(mPhysicsWorld, sprite, BodyType.DynamicBody, objectFixtureDef2);
       // bodyBody.setUserData(this);
       // mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(sprite, bodyBody, true, true));  
       this.x = bdBody.getPosition().x;
       float time = (float) (Math.random()*5+3);
       timerh =    new TimerHandler(time,true, new ITimerCallback(){

   			@Override
   			public void onTimePassed(TimerHandler pTimerHandler) {
                          
   				 Update();
   			}
   			   
   		   });
     	mScene.registerUpdateHandler(timerh); 
        
        
        
	}
	
	
	private RevoluteJoint createRevoluteJoint(Body bdLeg12, Body bdLeg22,
			Vector2 vector2, Vector2 vector22) {
		//	 bdLeg.setFixedRotation(true);
		 //КРЕПИМ НОГИ К ТЕЛУ
		RevoluteJointDef revoluteJointDef = new RevoluteJointDef();
	       revoluteJointDef.bodyA =bdLeg12; //первое тело соединения
	       revoluteJointDef.bodyB = bdLeg22; //второе тело соединения
	       revoluteJointDef.collideConnected = false; //тела не сталкиваются
	       revoluteJointDef.motorSpeed = -5f;
	       revoluteJointDef.maxMotorTorque=10f;
	       revoluteJointDef.enableLimit = true;
	       revoluteJointDef.upperAngle = 0.2f;
	       revoluteJointDef.lowerAngle = -0.2f;
	       revoluteJointDef.localAnchorA.add( vector2 );//.obtain(0,0);
	       revoluteJointDef.localAnchorB.add( vector22);

	       revoluteJointDef.enableMotor = true;
	       return (RevoluteJoint)  mPhysicsWorld.createJoint(revoluteJointDef);
	
	}


	//---------------------------------------------------------------------------------------------------

	
	public void beginContact( float power){
		
		if( fDie) return ;
		
		mScene.postRunnable(new Runnable() {
	        @Override
	        public void run() {

	        }
	    }); 
		
	//	Log.v("Zombiee","power="+power);
		if(!sprHead.isAnimationRunning()) {
			 sprHead.animate(new long[] { 100+delay,500+delay,500+delay,500+delay}, new int[]{0,1,2,3}, -1);
				
		}
		if(fDie == false){

		 int power2 = (int) power;
		 life-=power2;
		 Log.v("Zombie2","life="+life);
		if(life < 340 && f_j1  == true){
			f_j1 = false;
			Log.v("Zombie2","beginContact f_j1");
			mScene.postRunnable(new Runnable() {
		        @Override
		        public void run() {
		        	  
				         mPhysicsWorld.destroyJoint(jointL2L5);
		        }
		    });
			/*
			 mScene.registerUpdateHandler(new IUpdateHandler() {  
				@Override  
	              public void onUpdate(float arg0) { 		
			         mScene.unregisterUpdateHandler(this);
			         f_j1 = false;
			         mPhysicsWorld.destroyJoint(jointL2L5);
			         }  
	            @Override  
	             public void reset() {   }  
	          });  
			*/ 
		}
		if(life < 240 && f_j2  == true){
			Log.v("Zombie2","beginContact f_j2");
			 f_j2 = false;
			mScene.postRunnable(new Runnable() {
		        @Override
		        public void run() {
		        	  
				         mPhysicsWorld.destroyJoint(jointL3L4);
		        }
		    });
			/*
			 mScene.registerUpdateHandler(new IUpdateHandler() {  
					@Override  
		              public void onUpdate(float arg0) { 		
				         mScene.unregisterUpdateHandler(this);
				         f_j2 = false;
				         mPhysicsWorld.destroyJoint(jointL3L4);
				         }  
		            @Override  
		             public void reset() {   }  
		          }); 
		          */
			// mPhysicsWorld.destroyJoint(this.jointL3L4);
		}
		
		if(life < 140 && f_j3  == true){
			Log.v("Zombie2","beginContact f_j3");
			f_j3 = false;
			mScene.postRunnable(new Runnable() {
		        @Override
		        public void run() {
		        	  
				         mPhysicsWorld.destroyJoint(jointL1B);
		        }
		    });
			
			/*
			 mScene.registerUpdateHandler(new IUpdateHandler() {  
					@Override  
		              public void onUpdate(float arg0) { 		
				         mScene.unregisterUpdateHandler(this);
				         f_j3 = false;
				         mPhysicsWorld.destroyJoint(jointL1B);
				         }  
		            @Override  
		             public void reset() {   }  
		          }); 
		          */
			 //mPhysicsWorld.destroyJoint(this.jointL1B);
		}
	
	
	 if(life < 100 && life > 1 && f_j4  == true){
		 Log.v("Zombie2","beginContact f_j4");
		 f_j4 = false;
		 mScene.postRunnable(new Runnable() {
		        @Override
		        public void run() {
		        	

			         mPhysicsWorld.destroyJoint(head_body_joint);
		        }
		    });
/*		 
		 mScene.registerUpdateHandler(new IUpdateHandler() {  
				@Override  
	              public void onUpdate(float arg0) { 
					 f_j4 = false;
			         mScene.unregisterUpdateHandler(this);
			         mPhysicsWorld.destroyJoint(head_body_joint);
			         }  
	            @Override  
	             public void reset() {   }  
	          }); 
	          */
		 //mPhysicsWorld.destroyJoint(head_body_joint);
	  }
	 
	 if(life <= 1){
		 //sprHead.setAlpha(0.0f);
		 this.die();
		 fDie =true;
		 sprHead.stopAnimation();
		 sprHead.setCurrentTileIndex(6);
		
		 
	 }
	//	this.sprite.setScale(2f);
		//new Effect(this.sprite.getX(),this.sprite.getY(),"-"+life , this.mScene , this.mRes);
		//new Effect(this.sprHead.getX(),this.sprHead.getY(),"-"+life , this.mScene , this.mRes);
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
					// mPhysicsWorld.destroyJoint(head_body_joint);
			        // mPhysicsWorld.destroyJoint(leg_body_joint);
			         mPhysicsWorld.destroyJoint(hand1_body_joint);
			         mPhysicsWorld.destroyJoint(hand2_body_joint);
			         fOne = false;
			         Constants.getInstance().life_ctrl.PlusZombieKill();
			         mScene.unregisterUpdateHandler(mainUpdateHandler);
			         
				}
              
              
              time_life--;
              if(time_life < 0){
            	  mScene.detachChild(sprHead);
            	  mScene.detachChild(sprBody);
            	  //mScene.detachChild(sprLeg);
            	  mScene.detachChild(sprHand1);
            	  mScene.detachChild(sprHand2);
     
		        
                 mPhysicsWorld.destroyBody(bdHand1);
                 mPhysicsWorld.destroyBody(bdHand2);
		         mPhysicsWorld.destroyBody(bdHead);
		         mPhysicsWorld.destroyBody(bdBody);
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
		this.sprHead.getTextureRegion().setFlippedHorizontal(false);
		this.sprBody.getTextureRegion().setFlippedHorizontal(false);
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
		this.sprHead.getTextureRegion().setFlippedHorizontal(true);
		this.sprBody.getTextureRegion().setFlippedHorizontal(true);
		//sprLeg.getTextureRegion().setFlippedHorizontal(true);
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
 *//*hero.mm — герой
...
heroFixtureFilter.categoryBits = 0x08;
heroFixtureFilter.maskBits = 0x07;
...
villain.mm — злодей
...
villainFixtureFilter.categoryBits = 0x04;
villainFixtureFilter.maskBits = 0x0А;
...
obstacle.mm — препятствие для всех
...
obstacleFixtureFilter.categoryBits = 0x02;
obstacleFixtureFilter.maskBits = 0x0C;
...
heroOnlyObstacle.mm — препятствие только для героя
...
heroOnlyObstacleFixtureFilter.categoryBits = 0x01;
heroOnlyObstacleFixtureFilter.maskBits = 0x08;
...
 * */
