package com.deen812.zombie.object;

import org.anddev.andengine.engine.handler.IUpdateHandler;
import org.anddev.andengine.engine.handler.timer.ITimerCallback;
import org.anddev.andengine.engine.handler.timer.TimerHandler;
import org.anddev.andengine.entity.Entity;
import org.anddev.andengine.entity.layer.Layer;
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
import com.badlogic.gdx.physics.box2d.joints.DistanceJointDef;
import com.badlogic.gdx.physics.box2d.joints.PrismaticJointDef;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;
import com.deen812.zombie.Constants;
import com.deen812.zombie.Resource;
import com.deen812.zombie.main;
import com.deen812.zombie.scene.GameScene;

public class Boss3 {

	
	

    float x;
    int delay = 100;
    int delayI=0;
	private Resource mRes;
	private Scene mScene;
	
	int life = 200;
	int type = 0;
	private PhysicsWorld mPhysicsWorld;


	
	private int time_life = 200;
	private IUpdateHandler mainUpdateHandler;
	private boolean fDie = false;
	//private Sprite sprHand1;
	
	private Man man;
	private int napX;
	private int jumpForceY = 1000;
	private int jumpForceX = 4840;
	private TimerHandler timerh;
	private boolean f_died = false;
	
	private main game;
	private float step;
	private Body rect_body;
	private Layer cepLayer;
	private Entity cepEntity;
	private Rectangle Bulava_spr;
	private Body Bulava_bd;
	private Body Hand_body;
	private Rectangle body_rec;
	private int hookForce =  9500;
	//private Body Hand_bd;

	
	
   //==========================================================
    
    
	public void Update() {
//		sprLeg.animate(new long[] {200,200,200} ,new int[] {0,1,2},0);
	
	
		//	dog_body.setTransform(dog_body.getPosition().x + step, dog_body.getPosition().y, 0);
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
		rect_body.applyLinearImpulse(new Vector2(napX*jumpForceX,-100), rect_body.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
		
	}
	//------------------------------------------------------------------------------------------
	public Boss3(float x,float y,final GameScene mScene2, PhysicsWorld mPhysicsWorld, main game) {
		this.mRes =game.mRes;
		this.mScene = mScene2.mScene;
		this.mPhysicsWorld = mPhysicsWorld;
		this.man = mScene2.man;
		this.game = game;
		final FixtureDef objectFixtureDef2 = PhysicsFactory.createFixtureDef(100f, 0.1f, 1f);
		objectFixtureDef2.filter.categoryBits = 0x04;
		objectFixtureDef2.filter.maskBits = 0x0A;
		
		
		//ГОЛВА
		 delay = (int) (Math.random()*100)+60;
		 jumpForceY+=delay;
		// dog_spr = new AnimatedSprite(x , y , mRes.dog.clone());
		// animate1() ;
		 // this.mScene.attachChild(dog_spr);   
		// dog_body = PhysicsFactory.createBoxBody(mPhysicsWorld, dog_spr, BodyType.DynamicBody, objectFixtureDef2);
		// mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(dog_spr, dog_body, true, true));
		// dog_body.setUserData(this);
		// dog_body.getFixtureList().get(0).setUserData("zombie");
          
		 /*
		  *  ТЕЛО
		  */
		  body_rec = new Rectangle(x+300,y, 80, 150);
		  
		 body_rec.setColor(0, 1, 0);
		 body_rec.setAlpha(1f);
		 this.mScene.attachChild(body_rec);
		 rect_body = PhysicsFactory.createBoxBody(mPhysicsWorld, body_rec, BodyType.DynamicBody, objectFixtureDef2);
		 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(body_rec, rect_body, true, true));
		 rect_body.setUserData(this);
		 rect_body.setFixedRotation(true);
		 rect_body.getFixtureList().get(0).setUserData("zombie");
         
		 createCep();
		 
		 
	
		    
		    
		    

       float time = (float) (Math.random()*3+1);
       timerh =    new TimerHandler(time,true, new ITimerCallback(){

   			@Override
   			public void onTimePassed(TimerHandler pTimerHandler) {
   				if(man.getX()  < body_rec.getX()){
   					
   					to_left();
   					napX=-1;
   					step =-0.1f;
   				}else {
   				to_right();
   				napX = 1;
   				step =0.1f;
   				
   				}
   				
   			// if(  (Math.abs(man.getX()  - body_rec.getX())  < 160) && (man.getY() < body_rec.getY()) ){
   				 jump();
   				 hook();
   			// }
   			       
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
	
	
	
protected void hook() {
	Hand_body.applyLinearImpulse(new Vector2(napX*hookForce ,0), rect_body.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );

    	mScene.registerUpdateHandler(new TimerHandler(0.2f,true, new ITimerCallback(){

  			@Override
  			public void onTimePassed(TimerHandler pTimerHandler) {
  				mScene.unregisterUpdateHandler(pTimerHandler);
  				Bulava_bd.applyLinearImpulse(new Vector2(napX*500,-100), rect_body.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
  				Bulava_bd.applyAngularImpulse(1);
  			}
  			   
  		   })); 
    	
	
		
	}


private void createCep() {
	cepLayer = new Layer();
	cepEntity = new Entity();
	cepLayer.setPosition(200, 100);
	/*
	 * РУКА
	 */
	Rectangle R0 = new Rectangle(300,0,60,20);
	mScene.attachChild(R0);
	final FixtureDef objectFixtureDef2 = PhysicsFactory.createFixtureDef(10f, 0.8f, 1f);
	objectFixtureDef2.filter.categoryBits = 0x04;
	objectFixtureDef2.filter.maskBits = 0x0A;
	
	final FixtureDef objectFixtureDef3 = PhysicsFactory.createFixtureDef(500f, 0.8f, 1f);
	objectFixtureDef3.filter.categoryBits = 0x04;
	objectFixtureDef3.filter.maskBits = 0x0A;
	 Hand_body = PhysicsFactory.createBoxBody(mPhysicsWorld, R0, BodyType.DynamicBody, objectFixtureDef3);
	 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(R0, Hand_body, true, true));
	 Hand_body.setBullet(true);
	 
	 /*
	  * ЦЕПЬ 1 звено
	  * 
	  */
	 Rectangle R = new Rectangle(10,10,20,10);
	 R.setColor(1, 0, 0);
	 mScene.attachChild(R);
	 Body b = PhysicsFactory.createBoxBody(mPhysicsWorld, R, BodyType.DynamicBody, objectFixtureDef2);
	 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(R, Hand_body, true, true));
	 
	 Body lastBody = b;
	 createRevoluteJoint(Hand_body ,b, new Vector2(0,0), new Vector2(0,0));
	 
	 /*
	  * ЦЕПЬ
	  */
	for(int i = 0 ; i < 3 ; i++) {
		 Rectangle R2 = new Rectangle(10+i*10,10,20,10);
		 R2.setColor(1, i/10, 0);
		// cepLayer.attachChild(R2);
		 cepEntity.attachChild(R2);
		  Body b2 = PhysicsFactory.createBoxBody(mPhysicsWorld, R2, BodyType.DynamicBody, objectFixtureDef2);
		 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(R2, b2, true, true));
		 createRevoluteJoint(b2 , lastBody, new Vector2(R2.getWidth()/60,0), new Vector2(-R2.getWidth()/60,0));
		 lastBody = b2;
		// dog_body.setUserData(this);
		// dog_body.getFixtureList().get(0).setUserData("zombie");
		
	}
	
	/*
	 * БУЛАВА
	 */
	Bulava_spr = new Rectangle(0,0,40,40);
	Bulava_spr.setColor(1, 0, 1);
	mScene.attachChild(Bulava_spr);
	Bulava_bd = PhysicsFactory.createBoxBody(mPhysicsWorld, Bulava_spr, BodyType.DynamicBody, objectFixtureDef2);
	 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(Bulava_spr, Bulava_bd, true, true));
	 createRevoluteJoint(Bulava_bd , lastBody, new Vector2(1/2,0), new Vector2(-Bulava_spr.getWidth()/60,0));
	 Bulava_bd.getFixtureList().get(0).setUserData("zombie");
	
	//mScene.attachChild(cepLayer);
	mScene.attachChild(cepEntity);
	
	
	 /*
	 * 
	 */
	PrismaticJointDef lineJointDef = new PrismaticJointDef();
    lineJointDef.bodyA = Hand_body; //первое тело соединения
    lineJointDef.bodyB =  rect_body; //второе тело соединения
    lineJointDef.collideConnected = false; //тела не сталкиваются
    lineJointDef.localAnchorA.add(    new Vector2(0, 0f)   ); //якорная точка первого тела
    lineJointDef.localAnchorB.add(    new Vector2(0, -1f)   ); //якорная точка второго тела
    lineJointDef.enableLimit = true; //включаем пределы
    lineJointDef.lowerTranslation = -3f; //нижний предел
    lineJointDef.upperTranslation = 3f; //верхний предел
   // lineJointDef.motorSpeed = -50f;
   // lineJointDef.enableMotor = true;
    
    mPhysicsWorld.createJoint(lineJointDef);
    
    DistanceJointDef djf = new DistanceJointDef();
    djf.bodyA = Hand_body; //первое тело соединения
    djf.bodyB =  rect_body; //второе тело соединения
    djf.collideConnected = false; //тела не сталкиваются
    djf.dampingRatio  = 1f;
    djf.frequencyHz =1f;
    djf.length = 0f; //длина соединения
    mPhysicsWorld.createJoint(djf);
	
    
	
}

private RevoluteJoint createRevoluteJoint(Body bdLeg12, Body bdLeg22,
		Vector2 vector2, Vector2 vector22) {
	//	 bdLeg.setFixedRotation(true);
	 //КРЕПИМ НОГИ К ТЕЛУ
	RevoluteJointDef revoluteJointDef = new RevoluteJointDef();
       revoluteJointDef.bodyA =bdLeg12; //первое тело соединения
       revoluteJointDef.bodyB = bdLeg22; //второе тело соединения
       revoluteJointDef.collideConnected = false; //тела не сталкиваются
      // revoluteJointDef.motorSpeed = -5f;
      /// revoluteJointDef.maxMotorTorque=10f;
      // revoluteJointDef.enableLimit = true;
      // revoluteJointDef.upperAngle = 0.2f;
       //revoluteJointDef.lowerAngle = -0.2f;
       revoluteJointDef.localAnchorA.add( vector2 );//.obtain(0,0);
       revoluteJointDef.localAnchorB.add( vector22);

       revoluteJointDef.enableMotor = false;
       return (RevoluteJoint)  mPhysicsWorld.createJoint(revoluteJointDef);

}

	
	
   private void animate1() {
	//   dog_spr.animate(new long[] { 100,100,100,100}, new int[]{0,1,0,2}, -1);
   }
   private void animate2() {
	//   dog_spr.animate(new long[] {100,100}, new int[]{0,1,0,2}, -1);
   }
	public void beginContact( float power){
	//	Log.v("Zombiee","power="+power);
	
		if(fDie == false){

		 int power2 = (int) power;
		 life-=power2;
	
	 
	 if(life <= 1){
		 //sprHead.setAlpha(0.0f);
		 this.die();
		 fDie =true;
		// dog_spr.stopAnimation();
	//	 dog_spr.setCurrentTileIndex(0);
		
		 
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
            //	  mScene.detachChild(dog_spr);
            	//  mScene.detachChild(sprBody);
            	//  mScene.detachChild(sprLeg);
            	//  mScene.detachChild(sprHand1);
            	//  mScene.detachChild(sprHand2);
     
		        
                // mPhysicsWorld.destroyBody(bdHand1);
                // mPhysicsWorld.destroyBody(bdHand2);
		  //       mPhysicsWorld.destroyBody(dog_body);
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
		//this.dog_spr.getTextureRegion().setFlippedHorizontal(false);
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
	//	this.dog_spr.getTextureRegion().setFlippedHorizontal(true);
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
