package com.tron.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

public class PlayerTail extends GameObject{

	private Player player;
	
	public PlayerTail(int x, int y, Player player, ID id) {
		super(x, y, id);
		this.player = player;
	}
	
	public void onCollision(GameObject collider) {
		
		
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		if(player.getId() == ID.Player1) {
			g.setColor(Color.blue);
		} else {
			g.setColor(Color.red);
		}
		
		g.fillRect(this.x*12, this.y*12, 12, 12);
	}
	
	public Point getCoords() {
		return new Point(this.x, this.y);
	}
	
	public void setCoords(Point point) {
		this.x = (int) (point.getX());
		this.y = (int) (point.getY());
	}
	
	public Rectangle getHitbox() {
		return new Rectangle(this.x, this.y,1,1);
	}

}
