package view;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/*
- = mur horizontal
| = mur vertical
o = mur diagonal
{ = porte
* = bulle d'énergie
d = démon
$ = bourse
L = Lorann
*/

public class ViewBuilder{
   private ArrayList objects;
   private ViewPanel viewpanel;
   public ViewBuilder(ViewPanel viewpanel) {
	 this.viewpanel=viewpanel;
     }
   public void update(ArrayList object) {	 
	   this.objects=object;
       }
   public void render(Graphics graphics){
	 graphics.clearRect(0, 0, this.viewpanel.getWidth(), this.viewpanel.getHeight());
	 graphics.drawString("Score: 15", 10, this.viewpanel.getHeight()-8);
	 //for(Object object:objects){
		   //int x=object.get_pos()[0];
		   //int y=object.get_pos()[1];
		   //graphics.drawImage(object.getsprite(), x, y, 8,8);
	//	   }
	  }
   }
