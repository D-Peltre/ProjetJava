package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;
import javax.swing.text.Element;

import contract.IAffichable;

public class World {
ArrayList <IAffichable> al ;
	public World(ArrayList <IAffichable> al){
		World y=this;
		this.al = al;
		for(IAffichable element:this.al){
			element.registerWorld(y);
		   }
		ActionListener taskPerformer = new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				
				y.play();
			}
		};
		new Timer(200, taskPerformer).start();
	}
	
	public void play(){
		for(IAffichable element:al){
			element.move();
		}
		
	}
	public IAffichable get_collision(int x, int y){
		for(IAffichable element:al){
			if(element.getX()==x && element.getY()==y){
			   return element;
			   }
		    }
	    return null;
	    }
}
