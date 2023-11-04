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

public class Boss2 {

	
	

    float x;
    int delay = 100;
    int delayI=0;
	private Resource mRes;
	private Scene mScene;
	
	int life = 5000;
	int type = 0;
	private PhysicsWorld mPhysicsWorld;


	
	private int time_life = 300;
	private IUpdateHandler mainUpdateHandler;
	private boolean fDie = false;
	//private Sprite sprHand1;
	
	private Man man;
	private int napX;
	private int jumpForceY = 1000;
	private int jumpForceX = 5000;
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
	private RevoluteJoint HandRJ;
	private Vector2 vectorHook;
	//private Body Hand_bd;
	private Vector2 vectorHookRight;
	private Vector2 vectorHookLeft;
	private Vector2 vectorCenter;
	private Body b222;
	private Sprite Bulava_spr2;
	private AnimatedSprite head_aspr;
	private Body head_body;
	private Rectangle lr2;
	private int life_step;
	private Layer LifeLayer;
	private RevoluteJoint headBody;
	private Sprite head_aspr2;
	private AnimatedSprite body_aspr;
	private Body Hand_body2;
	private RevoluteJoint HandRJ2;
	private Sprite R00;

	
	
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
		rect_body.applyLinearImpulse(new Vector2(napX*jumpForceX,-200), rect_body.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
		
	}
	//------------------------------------------------------------------------------------------
	public Boss2(float x,float y,final GameScene mScene2, PhysicsWorld mPhysicsWorld, main game) {
		this.mRes =game.mRes;
		this.mScene = mScene2.mScene;
		this.mPhysicsWorld = mPhysicsWorld;
		this.man = mScene2.man;
		this.game = game;
		final FixtureDef objectFixtureDef2 = PhysicsFactory.createFixtureDef(100f, 0.1f, 1f);
		objectFixtureDef2.filter.categoryBits = 0x04;
		objectFixtureDef2.filter.maskBits = 0x0A;
		
		  R00 = new Sprite(0,0, mRes.boss2_hand);
		 mScene.attachChild(R00);
		//ГОЛВА
		 delay = (int) (Math.random()*100)+60;
		 jumpForceY+=delay;
		 head_aspr = new AnimatedSprite(x , y , mRes.boss2_head.clone());
		 head_aspr.animate(300);
		// animate1() ;
		// head_aspr.attachChild(head_aspr2);
		 head_body = PhysicsFactory.createBoxBody(mPhysicsWorld, head_aspr, BodyType.DynamicBody, objectFixtureDef2);
		 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(head_aspr, head_body, true, true));
		 head_body.setUserData(this);
		 head_body.getFixtureList().get(0).setUserData("zombie");
          
		 /*
		  *  ТЕЛО
		  */
		  body_rec = new Rectangle(x+300,y, 80, 130);
		   body_aspr = new AnimatedSprite(0,0, mRes.boss2_body);
		  body_aspr.animate(200);
		 body_rec.setColor(0, 1, 0);
		 body_rec.attachChild(body_aspr);
		 body_rec.setAlpha(0f);
		 this.mScene.attachChild(body_rec);
		  this.mScene.attachChild(head_aspr);   
		 rect_body = PhysicsFactory.createBoxBody(mPhysicsWorld, body_rec, BodyType.DynamicBody, objectFixtureDef2);
		 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(body_rec, rect_body, true, true));
		 rect_body.setUserData(this);
		 rect_body.setFixedRotation(true);
		 rect_body.getFixtureList().get(0).setUserData("zombie");
		 life_create();
		 createCep();
		 
		 /*
		  * ГОЛВА С ТУЛОВИЩЕМ
		  */
		     RevoluteJointDef revoluteJointDef = new RevoluteJointDef();
		    revoluteJointDef.bodyA =head_body; //первое тело соединения
		    revoluteJointDef.bodyB = rect_body; //второе тело соединения
		    revoluteJointDef.collideConnected = false; //тела не сталкиваются
		   revoluteJointDef.enableMotor=true;//.motorSpeed = -5f;
		   /// revoluteJointDef.maxMotorTorque=10f;
		    revoluteJointDef.enableLimit = true;
		    revoluteJointDef.upperAngle = 0.2f;
		    revoluteJointDef.lowerAngle = -0.2f;
		    revoluteJointDef.localAnchorA.add( new Vector2(0 ,head_aspr.getHeight()/85));//.obtain(0,0);
		    revoluteJointDef.localAnchorB.add( new Vector2(0,-body_rec.getHeight()/69));

		    revoluteJointDef.enableMotor = false;
		  headBody  = (RevoluteJoint) mPhysicsWorld.createJoint(revoluteJointDef);
		    
		    
		    

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
	
	
protected void life_create(){
	Rectangle lr1 = new Rectangle(0,0,50,10);
	lr1.setColor(0,0,1);
	
	 lr2 = new Rectangle(0,0,50,10);
	lr2.setColor(0,1,0);

	 life_step = this.life/50;
	 LifeLayer = new Layer();
	 LifeLayer.attachChild(lr1);
	 LifeLayer.attachChild(lr2);
	 LifeLayer.setPosition(0, -80);
	 body_rec.attachChild(LifeLayer);
	 
	 
}

protected void minus_life(){
	lr2.setWidth(this.life/life_step);
}
 protected void hook() {
	

	b222.applyLinearImpulse(this.vectorHook, b222.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );

	/*
    	mScene.registerUpdateHandler(new TimerHandler(0.2f,true, new ITimerCallback(){

  			@Override
  			public void onTimePassed(TimerHandler pTimerHandler) {
  				mScene.unregisterUpdateHandler(pTimerHandler);
  				//Bulava_bd.applyLinearImpulse(new Vector2(napX*500,-100), rect_body.getWorldCenter());//.setTransform(x,bodyBody.getPosition().y , );
  				Bulava_bd.applyAngularImpulse(1);
  			}
  			   
  		   })); 
    	
	*/
		
	}


private void createCep() {
	cepLayer = new Layer();
	cepEntity = new Entity();
	cepLayer.setPosition(200, 100);
	/*
	 * РУКА
	 */
	//Rectangle R0 = new Rectangle(300,0,80,20);
	Sprite R0 = new Sprite(0,0, mRes.boss2_hand);
	
	final FixtureDef objectFixtureDef2 = PhysicsFactory.createFixtureDef(10f, 0.8f, 1f);
	objectFixtureDef2.filter.categoryBits = 0x04;
	objectFixtureDef2.filter.maskBits = 0x0A;
	
	final FixtureDef objectFixtureDef3 = PhysicsFactory.createFixtureDef(500f, 0.8f, 1f);
	objectFixtureDef3.filter.categoryBits = 0x04;
	objectFixtureDef3.filter.maskBits = 0x0A;
	 Hand_body = PhysicsFactory.createBoxBody(mPhysicsWorld, R0, BodyType.DynamicBody, objectFixtureDef3);
	 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(R0, Hand_body, true, true));
	 //Hand_body.setBullet(false);
	 

	 
	 mScene.attachChild(R0);
	 
	 Hand_body2 = PhysicsFactory.createBoxBody(mPhysicsWorld, R00, BodyType.DynamicBody, objectFixtureDef3);
	 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(R00, Hand_body2, true, true));
	 Hand_body2.getFixtureList().get(0).setUserData("zombie");
	 RevoluteJointDef revoluteJointDef = new RevoluteJointDef();
	    revoluteJointDef.bodyA =Hand_body2; //первое тело соединения
	    revoluteJointDef.bodyB = rect_body; //второе тело соединения
	    revoluteJointDef.collideConnected = false; //тела не сталкиваются
	   revoluteJointDef.enableMotor=true;//.motorSpeed = -5f;
	   /// revoluteJointDef.maxMotorTorque=10f;
	   // revoluteJointDef.enableLimit = true;
	   // revoluteJointDef.upperAngle = 0.2f;
	    //revoluteJointDef.lowerAngle = -0.2f;
	    revoluteJointDef.localAnchorA.add( new Vector2(-R0.getWidth()/60 ,0));//.obtain(0,0);
	    revoluteJointDef.localAnchorB.add( new Vector2(0.1f,-body_rec.getHeight()/80));
	    HandRJ2  = (RevoluteJoint) mPhysicsWorld.createJoint(revoluteJointDef);
	 /*
	  * ЦЕПЬ 1 звено
	  * 
	  */
	 Rectangle R = new Rectangle(10,10,20,10);
	 R.setColor(1, 0, 0);
	 mScene.attachChild(R);
	  b222 = PhysicsFactory.createBoxBody(mPhysicsWorld, R, BodyType.DynamicBody, objectFixtureDef2);
	 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(R, Hand_body, true, true));
	 
	 Body lastBody = b222;
	 createRevoluteJoint(Hand_body ,b222, new Vector2(R0.getWidth()/60,0), new Vector2(0,0));
	 
	 /*
	  * ЦЕПЬ
	  */
	for(int i = 0 ; i < 3 ; i++) {
		 Rectangle R2 = new Rectangle(10+i*10,10,20,10);
		 R2.setColor(0, 0, 0);
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
	Bulava_spr2 = new Sprite(0,0,mRes.bulava);
	Bulava_spr.setColor(1, 0, 1);
	mScene.attachChild(Bulava_spr2);
	
	Bulava_bd = PhysicsFactory.createBoxBody(mPhysicsWorld, Bulava_spr2, BodyType.DynamicBody, objectFixtureDef2);
	 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(Bulava_spr2, Bulava_bd, true, true));
	 createRevoluteJoint(Bulava_bd , lastBody, new Vector2(1/2,0), new Vector2(-Bulava_spr2.getWidth()/60,0));
	 Bulava_bd.getFixtureList().get(0).setUserData("zombie");
	
	//mScene.attachChild(cepLayer);
	mScene.attachChild(cepEntity);
	
	/*
	 * РУКА С ТУЛОВИЩЕМ
	 */
	 revoluteJointDef = new RevoluteJointDef();
    revoluteJointDef.bodyA =Hand_body; //первое тело соединения
    revoluteJointDef.bodyB = rect_body; //второе тело соединения
    revoluteJointDef.collideConnected = false; //тела не сталкиваются
   revoluteJointDef.enableMotor=true;//.motorSpeed = -5f;
   /// revoluteJointDef.maxMotorTorque=10f;
   // revoluteJointDef.enableLimit = true;
   // revoluteJointDef.upperAngle = 0.2f;
    //revoluteJointDef.lowerAngle = -0.2f;
    revoluteJointDef.localAnchorA.add( new Vector2(-R0.getWidth()/60 ,0));//.obtain(0,0);
    revoluteJointDef.localAnchorB.add( new Vector2(0,-body_rec.getHeight()/84));

    revoluteJointDef.enableMotor = false;
  HandRJ  = (RevoluteJoint) mPhysicsWorld.createJoint(revoluteJointDef);
  
  this.vectorHookLeft  = new Vector2(2000 , -10000);
  this.vectorHookRight  = new Vector2(-2000 , -10000);
  vectorCenter = new Vector2(0,0);
  this.to_left();
  //HandRJ.setMaxMotorTorque(50);
	 /*
	 * 
	
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
	 */
    
	
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
		 this.life-=power2;
		 minus_life();
		 if(life < 100){
				
				Log.v("Zombie2","beginContact f_j1");
				mScene.postRunnable(new Runnable() {
			        @Override
			        public void run() {
			        	  
					   //      mPhysicsWorld.destroyJoint(HandRJ2);
			        }
			    });
				
		 }
	 if(life <= 0){
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
					//HandRJ
					//LifeLayer
					 mScene.detachChild(LifeLayer);
					 mPhysicsWorld.destroyJoint(HandRJ);
					 mPhysicsWorld.destroyJoint(HandRJ2);
					 rect_body.setFixedRotation(false);
					 rect_body.applyLinearImpulse(-1, -100, 0, 0);
					 head_body.applyLinearImpulse(new Vector2(0, -200), head_body.getWorldCenter());
					 //headBody
					 mPhysicsWorld.destroyJoint(headBody);
			         fOne = false;
			         Constants.getInstance().life_ctrl.PlusZombieKill();
			         mScene.unregisterUpdateHandler(mainUpdateHandler);
			         
				}
              
              
              time_life--;
              if(time_life < 0){
            //	  mScene.detachChild(dog_spr);
            	  mScene.detachChild(R00);
            	  mScene.detachChild(head_aspr);
            	  mScene.detachChild(body_rec);
            	  mScene.detachChild(body_aspr);
            	//  cepEntity
            	  mScene.detachChild(cepEntity);
		        //Bulava_bd
                 mPhysicsWorld.destroyBody(head_body);
                 mPhysicsWorld.destroyBody(rect_body);
		  //       mPhysicsWorld.destroyBody(dog_body);
		         mPhysicsWorld.destroyBody(Hand_body2);
		         mPhysicsWorld.destroyBody(Hand_body);
		         mScene.unregisterUpdateHandler(this);
		     
              }
		         }  

            @Override  
             public void reset() {   }  
          });  
         

		 
		
		 
		
	}

	
	public void to_left() {
		vectorHook = vectorHookLeft;
		//selected_body_hook = this.hand_body_left;
		if(napX !=-1){
		this.head_aspr.getTextureRegion().setFlippedHorizontal(false);
		this.body_aspr.getTextureRegion().setFlippedHorizontal(false);
	//	this.sprBody.getTextureRegion().setFlippedHorizontal(false);
	//	sprLeg.getTextureRegion().setFlippedHorizontal(false);
		}
		
	}
	
	public void key_up() {
	//	f_moved = false;
	//	mScene.unregisterUpdateHandler(moveHandler);
	}
	public void to_right() {
		vectorHook = vectorHookRight;
		if(napX !=1){
	//	x_step  = 0.1f;
			this.head_aspr.getTextureRegion().setFlippedHorizontal(true);
			//body_aspr
			this.body_aspr.getTextureRegion().setFlippedHorizontal(true);
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
