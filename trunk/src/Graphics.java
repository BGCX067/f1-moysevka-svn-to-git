import javax.microedition.lcdui.Canvas;


public class Graphics extends Canvas implements Runnable {
	int position = 10;
	
	public Graphics (){
		super ();
	}
	boolean  z;
	public void start (){
		z= true;
		Thread t = new Thread ();
		t.start();
	}
	
public void run() {
		// TODO Auto-generated method stub
		 while (z)
	     {
	         position =+1*5;
	         repaint();
	         try { Thread.sleep(20); }
	         catch (java.lang.InterruptedException zxz) {}
	      }
		}
			public void  stop()
			{ 
				z   =   false; 
			} 
	protected void paint(javax.microedition.lcdui.Graphics g) {
		// TODO Auto-generated method stub
		// вычесляем область для перерисовки экрана
	       int x = g.getClipWidth();
	       int y = g.getClipHeight();
	       // устанавливаем белый цвет фона
	       g.setColor(0xffffff);
	       // назначаем перерисовку всему экрану
	       g.fillRect(0,0,x,y);
	       // устанавливается зеленный цвет квадрата
	       g.setColor(0, 0, 255);
	       // рисуем квадрат
	       g.fillRect(position,40, 20, 20);
	}
}
