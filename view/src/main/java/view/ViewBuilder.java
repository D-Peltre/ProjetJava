package view;

import java.awt.Color;

import java.awt.Graphics;
import java.util.ArrayList;

import contract.IAffichable;

/**
 * The ViewBuilder
 * @author Yvar de Goffau
 */

/*
 * A little info. At each refresh, the viewbuilder gets a list of objects to draw. Those objects all implements the IAffichable interface, with the functions getX, getY and getSprite. Using those 3, the ViewBuilder can render an image as soon as it's ViewPanel is ready for it.
 */
public class ViewBuilder{
	/* the current list of objects */
   private ArrayList <IAffichable> objects;
    /* the underlying ViewPanel */
   private ViewPanel viewpanel;
    /* the current score to draw */
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
	   this.objects=objectlist; /* Saves the list of objects for when the time is ready */
	   try{
		   this.viewpanel.repaint(); /* Try to repaint */
	   	   }
	   catch(NullPointerException e){ /* ... if a ViewPanel exists */
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
	   /* Clear the screen */
	 graphics.clearRect(0, 0, this.viewpanel.getWidth(), this.viewpanel.getHeight());
	   /* Fill the screen in black */
	 graphics.setColor(new Color(0,0,0));
	 graphics.fillRect(0, 0, this.viewpanel.getWidth(), this.viewpanel.getHeight());
	 graphics.setColor(new Color(255,255,255));
	   /* For each object in the list of objects... */
	 for(IAffichable object:this.objects){
	   /* ... draw the object */
		   graphics.drawImage(object.getSprite(), object.getX()*32, object.getY()*32, viewpanel);
		   }
	   /* Draw the score */
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
