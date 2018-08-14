package com.tron.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable{
	
	public static final int WIDTH = 1600;
	public static final int HEIGHT = 900;
	
	public static Player Player1;
	public static Player Player2;
	public static Game Game;
	public static Window Window;
	public static Menu Menu;
	public static enum STATE{
		MENU,
		OPTIONS,
		GAME
	};
	public static STATE State = STATE.MENU;
	
	private static final long serialVersionUID = 8983890120623797749L;
	private Thread thread;
	private boolean running = false;
		

	public static void main(String[] args) {
		Game = new Game();
	}
	
	public Game() {
		this.addKeyListener(new KeyInput());
		this.addMouseListener(new MouseInput());
		Window = new Window(WIDTH, HEIGHT, "TRON", this);
		Menu = new Menu();
		Player1 = new Player(8,5,ID.Player1);
		Player2 = new Player(18,5,ID.Player2);
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try {
			running = false;
			System.exit(1);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void reset() {
		System.out.println("resetting");
		State = STATE.MENU;
		GameObject.RemoveAllObjects();
		
		
		Player1 = new Player(9,5,ID.Player1);
		Player2 = new Player(19,5,ID.Player2);
		
		
		
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 10.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("fps: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		if(State == STATE.GAME) {
			GameObject.Tick();
		}
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		if(State == STATE.GAME) {
			GameObject.Render(g);
		} else if(State == STATE.MENU) {
			Menu.render(g);
		}
		
		g.dispose();
		bs.show();
		
	}
}
