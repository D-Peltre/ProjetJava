package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import contract.IAffichable;
import contract.IWorld;

public class World implements IWorld{
    private ArrayList <IAffichable> al ;
    private Lorann lorann;
	public World(ArrayList <IAffichable> al){
		final World y=this;
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
	
	public void set_lorann(Lorann lorann){
		this.lorann=lorann;
	    }
	
	public void add(IAffichable object){
		this.al.add(object);
		object.registerWorld(this);
		object.set_hidden(false);
	    }
	
	public void remove(IAffichable object){
		//this.al.remove(object);
		object.set_hidden(true);
	    }
	
	public Lorann get_lorann(){
		return this.lorann;
	    }
	
	public void play(){
		for(IAffichable element:al){
			element.move();
		}
		
	}
	public IAffichable get_collision(int x, int y){
		for(IAffichable element:al){
			if(element.getX()==x && element.getY()==y && element.get_hidden()==false){
			   return element;
			   }
		    }
	    return null;
	    }

	public ArrayList <IAffichable> get_objects() {
		return this.al;
	}
}
