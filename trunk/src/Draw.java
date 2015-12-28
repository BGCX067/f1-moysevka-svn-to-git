/**
   ����� Draw 
   ���� Draw.java
   @author ��������� ��������
 */

import java.io.IOException;

import javax.microedition.lcdui.*;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import javax.microedition.midlet.MIDletStateChangeException;

public class Draw extends GameCanvas implements Runnable {
	private Sprite bol;
	private Sprite ferrari;
	private LayerManager lm;
	private LayerManager fer;
	private Games games;
	

	
	// ������� ��� ����������� ��������
	int position = 1;
	double positionOne = 1;

	// �����������
	public Draw(Games games) throws IOException {
		super(true);
		Image imM = Image.createImage("/v_mercedes.gif");
		Image imF = Image.createImage("/v_redbull.gif");
		bol = new Sprite(imM, 80, 30);
		ferrari = new Sprite(imF, 80, 30);
		bol.setPosition(0, 40);
		ferrari.setPosition(0, 80);
		lm = new LayerManager();
		fer = new LayerManager();
		lm.append(bol);
		fer.append(ferrari);
		this.games = games;
		
	}

	boolean z;

	public void start() {
		z = true;
		// ������� � ��������� �����
		Thread t = new Thread(this);
		t.start();
	}

	public void stop() {
		z = false;
	}

	// ����� run ���������� Runnable
	public void run() {
		int a = 20;
		int b = 10;

		Graphics g = getGraphics();
		// ����������� ����
		while (z) {
			// ����������� ������� �� 1
			positionOne = positionOne + 1.1;
			position++;
			init(g);
			// ��������� �����
			repaint();
			// ������������� ���� �� 20 ����������
			try {
				Thread.sleep(a);
			} catch (java.lang.InterruptedException zxz) {
			}
//			System.out.println("�� ����!");
		}

	}

	/*
	 * protected void paint(javax.microedition.lcdui.Graphics g) { // TODO
	 * Auto-generated method stub // ��������� ������� ��� ����������� ������
	 * int x = g.getClipWidth(); int y = g.getClipHeight(); // �������������
	 * ����� ���� ���� g.setColor(0xffffff); // ��������� ����������� �����
	 * ������ g.fillRect(0,0,x,y); // ��������������� �������� ���� ��������
	 * g.setColor(0, 0, 255); // ������ ������� // g.fillRect(position,40, 20,
	 * 20); g.setColor(255, 0, 0); g.fillRect((int) positionOne,80, 20, 20); }
	 */
	protected void init(Graphics g) {
		// TODO Auto-generated method stub
		// ����� ���� ����
		g.setColor(0xffffff);
		// �������������� �����
		g.fillRect(0, 0, getWidth(), getHeight());
		// ����� ������� � ����� 0,0
		lm.paint(g, position, 0);
		fer.paint(g, (int) positionOne, 0);
		// ������� �����������
		flushGraphics();
	}

	
	}