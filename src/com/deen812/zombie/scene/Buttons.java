package com.deen812.zombie.scene;

import com.deen812.zombie.Resource;

public class Buttons {

	
	private static Buttons instance;

	  public static Buttons getInstance() {
	    if(instance == null) {
	      instance = new Buttons();
	    }
	    return instance;
	  }

	  private Buttons() {
		  
		 // this.sprite_btn = AnimatedSprite(0,0);
		  
		    
	  }
	 
	  
}
