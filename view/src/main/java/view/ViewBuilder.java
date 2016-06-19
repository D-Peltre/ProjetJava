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
	   this.viewpanel.repaint();
       }
   public void render(Graphics graphics){
	 graphics.clearRect(0, 0, this.viewpanel.getWidth(), this.viewpanel.getHeight());
	 graphics.setColor(new Color(0,0,0));
	 graphics.fillRect(0, 0, this.viewpanel.getWidth(), this.viewpanel.getHeight());
	 graphics.setColor(new Color(255,255,255));
	 for(IAffichable object:this.objects){
		   /*System.out.print("X:");
		   System.out.print(object.getX());
		   System.out.print(" Y:");
		   System.out.print(object.getY());
		   System.out.print(" TypeObject:'");
		   System.out.print(object.get_type());
		   System.out.println("'");*/
		   graphics.drawImage(object.getSprite(), object.getX()*32, object.getY()*32, viewpanel);
		   }
	 graphics.drawString("Score: "+this.score, 10, this.viewpanel.getHeight()-8);
	 }
   public void send_score(int score) {
     this.score=score;
     }
   }
