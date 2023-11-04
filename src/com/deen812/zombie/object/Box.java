package com.deen812.zombie.object;

import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.extension.physics.box2d.PhysicsConnector;
import org.anddev.andengine.extension.physics.box2d.PhysicsFactory;
import org.anddev.andengine.extension.physics.box2d.PhysicsWorld;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.deen812.zombie.Constants;

public class Box {
	public enum BoxType {
		BOX,
		BREAK,
		BOARD
	}
	private Sprite box_spr;
	private Body box_bd;
	public Box(int x, int y, Scene mScene, PhysicsWorld mPhysicsWorld,BoxType boxtype) {
		
		box_spr = new Sprite(x , y , Constants.getInstance().main_activity.mRes.box);
		mScene.attachChild(box_spr);
		  final FixtureDef wallFixtureDef = PhysicsFactory.createFixtureDef(10, 0.1f,1f);
		    wallFixtureDef.filter.categoryBits = 0x02;
		    wallFixtureDef.filter.maskBits = -1;
		 box_bd = PhysicsFactory.createBoxBody(mPhysicsWorld, box_spr, BodyType.DynamicBody, wallFixtureDef);
		 mPhysicsWorld.registerPhysicsConnector(new PhysicsConnector(box_spr, box_bd, true, true));
		 box_bd.getFixtureList().get(0).setUserData("box");

		
	}

}
