package model;

import java.awt.image.BufferedImage;


public interface DaemonAI {
	  public int getNextX(int x, int y, int lorannX, int lorannY);
	  public int getNextY(int x, int y, int lorannX, int lorannY);
	  public BufferedImage getSprite();
	  public void collided();
      }
