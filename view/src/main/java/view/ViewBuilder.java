package view;

import java.awt.Color;

import java.awt.Graphics;
import java.util.ArrayList;

import contract.IAffichable;

/****
- = mur horizontal
| = mur vertical
o = mur diagonal
{ = porte
* = bulle d'énergie
d = démon
$ = bourse
L = Lorann
****/

public class ViewBuilder{
   private ArrayList <IAffichable> objects;
   private ViewPanel viewpanel;
   private int score=0;
   public ViewBuilder(ViewPanel viewpanel) {
	 this.viewpanel=viewpanel;
     }
   public void update(ArrayList <IAffichable> object) {	 
	   this.objects=object;
	   try{
		   this.viewpanel.repaint();
	   	   }
	   catch(NullPointerException e){
		   System.err.println("Unable to get grip on my viewpanel");
	   	   }
       }
   public int get_score(){
	   return this.score;
   	   }
   public ArrayList <IAffichable> get_objects(){
	   return this.objects;
       }
   public void render(Graphics graphics){
	 graphics.clearRect(0, 0, this.viewpanel.getWidth(), this.viewpanel.getHeight());
	 graphics.setColor(new Color(0,0,0));
	 graphics.fillRect(0, 0, this.viewpanel.getWidth(), this.viewpanel.getHeight());
	 graphics.setColor(new Color(255,255,255));
	 for(IAffichable object:this.objects){
		   graphics.drawImage(object.getSprite(), object.getX()*32, object.getY()*32, viewpanel);
		   }
	 graphics.drawString("Score: "+this.score, 10, this.viewpanel.getHeight()-8);
	 }
   public void send_score(int score) {
     this.score=score;
     }
   }
