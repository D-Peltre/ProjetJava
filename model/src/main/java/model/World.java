package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;
import javax.swing.text.Element;

import contract.IAffichable;

public class World {
ArrayList <IAffichable> al ;
	World y=this;
	public World(ArrayList <Object> al){
		this.al = al;
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
	
}
