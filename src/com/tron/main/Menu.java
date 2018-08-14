package com.tron.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	
	public Rectangle playButton = new Rectangle(Game.WIDTH / 2 - 120, 250, 200, 50);
	public Rectangle optionsButton = new Rectangle(Game.WIDTH / 2 - 120, 350, 200, 50);
	public Rectangle quitButton = new Rectangle(Game.WIDTH / 2 - 120, 450, 200, 50);
	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		Font font1 = new Font("arial", Font.BOLD, 50);
		Font font2 = new Font("arial", Font.BOLD, 30);
		
		g.setFont(font1);
		g.setColor(Color.black);
		g.drawString("TRON", Game.WIDTH/2 - 90, 100);
		
		g2d.draw(playButton);
		g2d.draw(optionsButton);
		g2d.draw(quitButton);
		g.setFont(font2);
		g.drawString("Play", playButton.x + 70, playButton.y + 35);
		g.drawString("Options", optionsButton.x + 50, optionsButton.y + 35);
		g.drawString("Quit", quitButton.x + 70, quitButton.y + 35);
	}
	
}
