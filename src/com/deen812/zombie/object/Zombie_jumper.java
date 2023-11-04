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

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;
import com.deen812.zombie.Resource;
import com.deen812.zombie.main;
import com.deen812.zombie.scene.GameScene;

public class Zombie_jumper {

	
	

    float x;
    int delay = 100;
    int delayI=0;
	private Resource mRes;
	private Scene mScene;
	
	int life = 50;
	int type = 0;
	private PhysicsWorld mPhysicsWorld;
	private AnimatedSprite sprHead;
	private Body bdHead;
	private AnimatedSprite sprBody;
	private Body bdBody;
	private RevoluteJoint head_body_joint;
	private AnimatedSprite sprLeg;
	private Body bdLeg;
	private RevoluteJoint leg_body_joint;
	
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
	private int jumpForceY = 160;
	private int jumpForceX = 200;
	private TimerHandler timerh;
	private boolean f_died = false;
	private Object vectorHook;

	
	
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
			sprLeg.animate(new long[] {200,200,200} ,new int[] {0,1,2},0);
		//	bdBody.applyLinearImpulse(new Vector2(napX*jumpForceX,-jumpForceY), bdBody.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
			
			bdBody.applyLinearImpulse(new Vector2(0,-jumpForceY), bdBody.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
			bdLeg.applyLinearImpulse(new Vector2(napX*jumpForceX,0), bdBody.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
				
			
		//if(delayI<1){
			
		//	bdBody.applyLinearImpulse(new Vector2(-delay,-delay), bdBody.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
		//	delayI = delay;
	//	}
	//	delayI--;
	}
	
	
	//------------------------------------------------------------------------------------------
	public Zombie_jumper(float x,float y,final GameScene mScene2, PhysicsWorld mPhysicsWorld, main game) {
		this.mRes =game.mRes;
		this.mScene = mScene2.mScene;
		this.mPhysicsWorld = mPhysicsWorld;
		this.man = mScene2.man;
		final FixtureDef objectFixtureDef2 = PhysicsFactory.createFixtureDef(0.3f, 0.1f, 1f);
		objectFixtureDef2.filter.categoryBits = 0x04;
		objectFixtureDef2.filter.maskBits = 0x0A;
		
		
		//ГОЛВА
		delay = (int) (Math.random()*100)+60;
		 sprHead = new AnimatedSprite(x , y , mRes.z_head.clone());
		 sprHead.animate(new long[] { 100+delay,500+delay,500+delay,500+delay}, new int[]{0,1,2,3}, -1);
		     
		 bdHead = PhysicsFactory.createBoxBody(mPhysicsWorld, sprHead, BodyType.DynamicBody, objectFixtureDef2);
		 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(sprHead, bdHead, true, true));
		 bdHead.setUserData(this);
		 
		 //ТЕЛО
		 sprBody = new AnimatedSprite(x , y , mRes.z1_body);
		
		 mScene.attachChild(sprBody);
		 mScene.attachChild(sprHead);
		 bdBody = PhysicsFactory.createBoxBody(mPhysicsWorld, sprBody, BodyType.DynamicBody, objectFixtureDef2);
		 bdBody.setUserData(this);
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
	     sprLeg = new AnimatedSprite(x , y , mRes.z_leg.clone());
		 mScene.attachChild(sprLeg);

		 final FixtureDef objectFixtureDef3 = PhysicsFactory.createFixtureDef(10f, 0.1f, 1f);
			objectFixtureDef3.filter.categoryBits = 0x04;
			objectFixtureDef3.filter.maskBits = 0x0A;
			
			
		 bdLeg = PhysicsFactory.createBoxBody(mPhysicsWorld, sprLeg, BodyType.DynamicBody, objectFixtureDef3);
		 bdLeg.setUserData(this);
		 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(sprLeg, bdLeg, true, true));
		// bdLeg.setFixedRotation(true);
		 //КРЕПИМ НОГИ К ТЕЛУ
		   revoluteJointDef = new RevoluteJointDef();
	       revoluteJointDef.bodyA =bdBody; //первое тело соединения
	       revoluteJointDef.bodyB = bdLeg; //второе тело соединения
	       revoluteJointDef.collideConnected = false; //тела не сталкиваются
	       revoluteJointDef.motorSpeed = -5f;
	       revoluteJointDef.maxMotorTorque=10f;
	       revoluteJointDef.enableLimit = true;
	       revoluteJointDef.upperAngle = 0.2f;
	       revoluteJointDef.lowerAngle = -0.2f;
	       revoluteJointDef.localAnchorA.add( new Vector2(0f,   sprBody.getHeight()/70 )    );//.obtain(0,0);
	       revoluteJointDef.localAnchorB.add( new Vector2(0f,  - sprLeg.getHeight()/70 ));
	       //revoluteJointDef.initialize(bodyB, bodyG,  new Vector2(0,(float) 0.1));
	       revoluteJointDef.enableMotor = true;
	       leg_body_joint = (RevoluteJoint)  mPhysicsWorld.createJoint(revoluteJointDef);
	       
	      //РУКИ
	         sprHand1 = new Sprite(x , y , mRes.z_hand);
			 mScene.attachChild(sprHand1);

			 bdHand1 = PhysicsFactory.createBoxBody(mPhysicsWorld, sprHand1, BodyType.DynamicBody, objectFixtureDef3);
			 //bdHand1.setUserData(this);
			 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(sprHand1, bdHand1, true, true));

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
				 bdHand2 = PhysicsFactory.createBoxBody(mPhysicsWorld, sprHand2, BodyType.DynamicBody, objectFixtureDef3);
				 //bdHand2.setUserData(this);
				 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(sprHand2, bdHand2, true, true));

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
       float time = (float) (Math.random()*5+1);
       timerh =    new TimerHandler(time,true, new ITimerCallback(){

   			@Override
   			public void onTimePassed(TimerHandler pTimerHandler) {
                          
   				 Update();
   			}
   			   
   		   });
     	mScene.registerUpdateHandler(timerh); 
        
        
        
	}
	
	
	//---------------------------------------------------------------------------------------------------
	public void contactCat() {
		if(sprHead.isAnimationRunning()) {
		 sprHead.stopAnimation();
		 sprHead.setCurrentTileIndex(5);
		}
	}
	public void beginContact(Body b2, float power){
		
		if(!sprHead.isAnimationRunning()) {
			 sprHead.animate(new long[] { 100+delay,500+delay,500+delay,500+delay}, new int[]{0,1,2,3}, -1);
				
		}
		if(fDie == false){

		 int power2 = (int) power;
		 life-=power2;
		 
		if(life < 80 && life > 50){
			
		}
		
	  if(life < 50 && life > 30){
		
		}
	
	
	 if(life < 30 && life > 1){
		 
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
		//GameParam.getInstance().test--;
		 mScene.registerUpdateHandler(new IUpdateHandler() {  
			 private boolean fOne = true;

			@Override  
              public void onUpdate(float arg0) { 
				if(fOne ){
					 mPhysicsWorld.destroyJoint(head_body_joint);
			         mPhysicsWorld.destroyJoint(leg_body_joint);
			         mPhysicsWorld.destroyJoint(hand1_body_joint);
			         mPhysicsWorld.destroyJoint(hand2_body_joint);
			         fOne = false;
			         mScene.unregisterUpdateHandler(mainUpdateHandler);
			         
				}
              
              
              time_life--;
              if(time_life < 0){
            	  mScene.detachChild(sprHead);
            	  mScene.detachChild(sprBody);
            	  mScene.detachChild(sprLeg);
            	  mScene.detachChild(sprHand1);
            	  mScene.detachChild(sprHand2);
     
		        
                 mPhysicsWorld.destroyBody(bdHand1);
                 mPhysicsWorld.destroyBody(bdHand2);
		         mPhysicsWorld.destroyBody(bdHead);
		         mPhysicsWorld.destroyBody(bdBody);
		         mPhysicsWorld.destroyBody(bdLeg);
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
		sprLeg.getTextureRegion().setFlippedHorizontal(false);
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
		sprLeg.getTextureRegion().setFlippedHorizontal(true);
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
			//this.die();
			
	  
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
