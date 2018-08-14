package com.tron.main;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Deque;
import java.util.LinkedList;

public class Player extends GameObject {
	
	private Deque<PlayerTail> cells = new LinkedList<PlayerTail>();
	private PlayerTail head;

	public Player(int x, int y, ID id) {
		super(x, y, id);
		this.direction = "down";
		this.head = new PlayerTail(x, y, this, ID.PlayerTail);
		this.cells.add(this.head);
		
	}

	public void tick() {

		Point nextPos = new Point();
		nextPos.setLocation(this.head.getCoords());
		if(this.direction == "up") {
			nextPos.translate(0, -1);
		} else if(this.direction == "down") {
			nextPos.translate(0, 1);
		} else if(this.direction == "right") {
			nextPos.translate(1, 0);
		} else if(this.direction == "left") {
			nextPos.translate(-1, 0);
		}
		this.head = new PlayerTail((int) (nextPos.getX()), (int) (nextPos.getY()), this, ID.PlayerTail);
		this.cells.add(this.head);
		
		this.x = this.head.getX();
		this.y = this.head.getY();
		
		if(this.x <= 0 || this.x >= 132 || this.y <= 0 || this.y >= 72) {
			Game.Game.reset();
		}
		
	}

	public void render(Graphics g) {
		
	}
	
	public Rectangle getHitbox() {
		return new Rectangle(this.x, this.y,1,1);
	}

	@Override
	public void onCollision(GameObject collider) {
		if(collider.getId() == ID.PlayerTail && collider != this.head) {
			System.out.println(collider);
			System.out.println(this.head);
			Game.Game.reset();
		}
		
	}

	


}
