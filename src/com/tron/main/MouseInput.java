package com.tron.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInput implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		if(mx >= Game.Menu.playButton.getX() && mx <= Game.Menu.playButton.getX() + Game.Menu.playButton.getWidth()) {
			if(my >= Game.Menu.playButton.getY() && my <= Game.Menu.playButton.getY() + Game.Menu.playButton.getHeight()) {
				Game.State = Game.STATE.GAME;
			}
		}
		
		if(mx >= Game.Menu.optionsButton.getX() && mx <= Game.Menu.optionsButton.getX() + Game.Menu.optionsButton.getWidth()) {
			if(my >= Game.Menu.optionsButton.getY() && my <= Game.Menu.optionsButton.getY() + Game.Menu.optionsButton.getHeight()) {
				//
			}
		}
		
		if(mx >= Game.Menu.quitButton.getX() && mx <= Game.Menu.quitButton.getX() + Game.Menu.quitButton.getWidth()) {
			if(my >= Game.Menu.quitButton.getY() && my <= Game.Menu.quitButton.getY() + Game.Menu.quitButton.getHeight()) {
				Game.Game.stop();
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
