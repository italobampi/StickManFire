package com.mygdx.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Particula extends Rectangle{

	public Color color;
	
	
	public int speed = 0;
	
	public int rotation = 0;
	
	public double xa,ya;
	public double dx,dy;
	
	public int timer = 0;
	
	
	public Particula(int x, int y, int width, int height,Color color) {
		super(x,y,width,height);
		xa = x;
		ya = y;
		this.color = color;
		
		dx = new Random().nextGaussian();
		dy = new Random().nextGaussian();
		
		speed = 6;
		
	}
	
	public void update() {
		
		xa+=dx*speed;
		ya+=dy*speed;
		
		timer++;
		
	}
	
	public void render(Graphics g) {
		update();
		g.setColor(this.color);
		g.fillRect((int)xa,(int) ya, width, height);
	}
	
	
}
