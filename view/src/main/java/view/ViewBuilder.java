package view;

import java.awt.Color;

import java.awt.Graphics;
import java.util.ArrayList;

import contract.IAffichable;


public class ViewBuilder{
   private ArrayList <IAffichable> objects;
   private ViewPanel viewpanel;
   private int score=0;
   /**
    * The ViewBuilder.
    * This class is responsable for the rendering of the different objects.
    * @param viewpanel - the ViewPanel who creates it.
    */
   public ViewBuilder(ViewPanel viewpanel) {
	 this.viewpanel=viewpanel;
     }
   /**
    * This function takes the list of objects and fire the drawing procedure of it's parent viewpanel, if possible.
    * @param objectlist - The list of IAffichables that is going to get shown
    */
   public void update(ArrayList <IAffichable> objectlist) {	 
	   this.objects=objectlist;
	   try{
		   this.viewpanel.repaint();
	   	   }
	   catch(NullPointerException e){
		   System.err.println("Unable to get grip on my viewpanel");
	   	   }
       }
   /**
    * This function returns the current score
    * @return the current score
    */
   public int get_score(){
	   return this.score;
   	   }
   /**
    * This function return the current list of objects
    * @return the current list of objects
    */
   public ArrayList <IAffichable> get_objects(){
	   return this.objects;
       }
   /**
    * This function, as called by the viewpanel, is responsable of blitting the list of objects to the screen.
    * @param graphics - the graphics context (i.e. the parm of the ViewPanel.paintComponent
    */
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
   /**
    * This function register the score to draw
    * @param score - the score to draw
    */
   public void send_score(int score) {
     this.score=score;
     }
   }
