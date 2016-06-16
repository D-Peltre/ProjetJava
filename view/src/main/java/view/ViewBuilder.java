package view;

import java.awt.Color;

import java.awt.Graphics;
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
   private IAffichable[] objects;
   private ViewPanel viewpanel;
   public ViewBuilder(ViewPanel viewpanel) {
	 this.viewpanel=viewpanel;
     }
   public void update(IAffichable[] object) {	 
	   this.objects=object;
       }
   public void render(Graphics graphics){
	 graphics.clearRect(0, 0, this.viewpanel.getWidth(), this.viewpanel.getHeight());
	 graphics.setColor(new Color(0,0,0));
	 graphics.fillRect(0, 0, this.viewpanel.getWidth(), this.viewpanel.getHeight());
	 graphics.setColor(new Color(255,255,255));
	 for(IAffichable object:this.objects){
		   graphics.drawImage(object.getSprite(), object.getX()*32, object.getY()*32, 8,8, viewpanel);
		   }
	 graphics.drawString("Score: 15", 10, this.viewpanel.getHeight()-8);
	 }
   }
