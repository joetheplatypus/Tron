package com.tron.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public abstract class GameObject {
	
	protected ID id;
	protected int x;
	protected int y;
	protected int velX;
	protected int velY;
	protected String direction;
	protected int length;
	
	public static List<GameObject> List = new ArrayList<GameObject>();
	private static List<GameObject> toRemove = new ArrayList<GameObject>();

	public GameObject(int x, int y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
		List.add(this);
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	public abstract void onCollision(GameObject collider);

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		if((direction == "up" && this.direction == "down") || (direction == "left" && this.direction == "right") || (direction == "down" && this.direction == "up") || (direction == "right" && this.direction == "left")) {
			return;
		}
		System.out.println(this.getY());
		this.direction = direction;
	}
	
	public Rectangle getHitbox() {
		return new Rectangle(this.x, this.y, 1, 1);
	}
	
	public static void Tick() {
		for(int i = 0; i < List.size(); i++) {
			GameObject object = List.get(i);
			object.tick();
			checkCollisions(object, i);
		}
	}
	
	public static void Render(Graphics g) {
		for(int i = 0; i < List.size(); i++) {
			GameObject object = List.get(i);
			object.render(g);			
		}
	}
	
	
	public static void RemoveObject(GameObject object) {
		toRemove.add(object);
	}
	
	public static void RemoveAllObjects() {
		System.out.println(List);
		for(int i = 0; i < List.size(); i++) {
			GameObject object = List.get(i);
			List.remove(object);
		}
		List.clear();
		System.out.println(List);
		for(int i = 0; i < toRemove.size(); i++) {
			toRemove.remove(toRemove.get(i));
		}
	}
	
	public static void checkCollisions(GameObject object, int i) {
		for(int j = 0; j < List.size(); j++) {
			if(object.getHitbox().intersects(List.get(j).getHitbox())) {
				if(j == i) {
					//
				} else {
					object.onCollision(List.get(j));
					if(Game.State == Game.STATE.GAME) {
						List.get(j).onCollision(object);
					}
					
				}
				
			}
		}
	}
	
	
	
}
