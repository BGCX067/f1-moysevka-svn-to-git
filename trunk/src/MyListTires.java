import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.Screen;

public class MyListTires extends List implements CommandListener {

	static String[] buses = { "SuperSoft", "Medium", "Hard" };
	Command tires = new Command("Шины", Command.SCREEN, 1);
	Command nazad = new Command("Назад", Command.BACK, 1);
	private Command OK = new Command("OK", Command.OK, 1);
	PlayerScr playerScr;
	private Displayable backScr;
	protected double tiresD;
	private Games games;
	

	public MyListTires(PlayerScr playerScr, Displayable win, Games games) {
		super("Шины", Choice.EXCLUSIVE, buses, null);

		this.init();
		this.addCommand(OK);
		this.addCommand(nazad);
		this.setCommandListener(this);
		this.backScr = win;
		this.playerScr = playerScr;
		this.games = games;

	}

	public void init() {

	}

	public void commandAction(Command c, Displayable d) {
		if (c == nazad) {
			games.showWin(backScr);
		}
		/*
		 * else if (c == exitMidlet) { try { games.destroyApp(true); } catch
		 * (MIDletStateChangeException e) { e.printStackTrace(); } }/* else if
		 * (c == tires) { this.deleteAll(); for (int q = buses.length - 1; q >=
		 * 0; --q) { this.append(buses[q], null); }
		 * 
		 * this.removeCommand(tires); this.addCommand(chassis);
		 * this.addCommand(OK); }
		 * 
		 * else if (c == chassis) { this.deleteAll();
		 * 
		 * chassi = new Chassis(this, this.disp, this.backScr);
		 * disp.setCurrent(chassi); /* silaList = new List("Мощность",
		 * Choice.EXCLUSIVE, sila, null); for (int q = sila.length - 1; q >= 0;
		 * --q) { this.append(sila[q], null); }
		 */
		// this.removeCommand(chassis);
		// this.addCommand(tires);
		// this.addCommand(OK);
		if (c == OK) {

			/*
			 * Alert al = new Alert(null, "  Информационное уведомление" +
			 * tiresD, null, null);
			 * 
			 * disp.setCurrent(al);
			 */

			int i = this.getSelectedIndex();

			if (i == 1) {
				tiresD = 0.79;

				System.out.println("" + tiresD);
				playerScr.player.tiresD = tiresD;
			} else if (i == 0) {
				tiresD = 0.8;

				System.out.println("" + tiresD);
				playerScr.player.tiresD = tiresD;
			} else if (i == 2) {
				tiresD = 0.81;
				System.out.println("" + tiresD);
				playerScr.player.tiresD = tiresD;
			}

		}
	}

}
