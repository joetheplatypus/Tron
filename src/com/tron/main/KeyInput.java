package com.tron.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	
	public KeyInput() {
		
	}
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(Game.State == Game.STATE.GAME) {
			if(key == KeyEvent.VK_W) {
				Game.Player1.setDirection("up");
			}
			if(key == KeyEvent.VK_S) {
				Game.Player1.setDirection("down");
			}
			if(key == KeyEvent.VK_A) {
				Game.Player1.setDirection("left");
			}
			if(key == KeyEvent.VK_D) {
				Game.Player1.setDirection("right");
			}
			
			if(key == KeyEvent.VK_UP) {
				Game.Player2.setDirection("up");
			}
			if(key == KeyEvent.VK_DOWN) {
				Game.Player2.setDirection("down");
			}
			if(key == KeyEvent.VK_LEFT) {
				Game.Player2.setDirection("left");
			}
			if(key == KeyEvent.VK_RIGHT) {
				Game.Player2.setDirection("right");
			}
		}
				
		
				
	
	}
}
