import java.io.IOException;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemCommandListener;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDletStateChangeException;

public class PlayerScr extends Form implements CommandListener,
		ItemCommandListener {

	private SteerGauge steerGauge;
	private MyListTires listTires;
	private MyListChassis listChassis;

	private Command exitMidlet = new Command("�����", Command.EXIT, 1);
	private Command perexodGauge = new Command("�������������", Command.SCREEN,
			3);
	private Command perexodTires = new Command("�������� ����", Command.SCREEN,
			3);
	private Command perexodChassis = new Command("�������� �����",
			Command.SCREEN, 3);
	private Command perexodDraw = new Command("�������", Command.SCREEN, 3);
	private Command perexod;
	private Command perexodResult = new Command("�����", Command.SCREEN, 3);

	protected StringItem buttonTires, buttonChassis, buttonSteer;
	double s;
	protected TextField nameOne;
	private Games games;

	private Raschet raschet = new Raschet();
	Player player = new Player();
	private Displayable window;

	public PlayerScr(String title, Games games) {
		super(title);
		// TODO Auto-generated constructor stub
		// listTires = new MyListTires(this, this, games);
		this.games = games;

		nameOne = new TextField("��� ������� ������", "", 15, TextField.ANY);
		append(nameOne);
		buttonTires = new StringItem("������", "����", Item.BUTTON);
		append(buttonTires);
		buttonChassis = new StringItem("������", "�����", Item.BUTTON);
		append(buttonChassis);
		buttonSteer = new StringItem("������", "�������������", Item.BUTTON);
		append(buttonSteer);

		buttonTires.setDefaultCommand(perexodTires);
		buttonTires.setItemCommandListener(this);
		buttonChassis.setDefaultCommand(perexodChassis);
		buttonChassis.setItemCommandListener(this);
		buttonSteer.setDefaultCommand(perexodGauge);
		buttonSteer.setItemCommandListener(this);

		this.addCommand(exitMidlet);
		
		this.addCommand(perexodDraw);
		this.setCommandListener(this);
		// games.gamer1.addCommand(perexod);
		// this.setCommandListener((CommandListener) perexod);
		// games.gamer2.addCommand(perexodPlayerOne);
		// this.setCommandListener(this);
	}

	public void setPerexodCommand(String text, Displayable window) {
		this.window = window;
		this.perexod = new Command(text, Command.SCREEN, 3);
		this.addCommand(perexod);

	}

	public void setPlayer(Player player) {

		// player.tiresD = listTires.tiresD;
		// player.chassiS = listChassis.chassiS;
		// player.gaugeG = steerGauge.gaugeG;
	}

	public void commandAction(Command c, Displayable d) {
		// TODO Auto-generated method stub

		if (c == exitMidlet) {

			try {
				Games.getMIDlet().quit();
			} catch (MIDletStateChangeException e) {

			}
		}

		if (c == perexodDraw) {

			games.gp.start();
			games.gp.addCommand(perexodResult);
			
			games.gp.addCommand(exitMidlet);
			
			games.showWin(games.gp);

		}
		if (c == perexod) {
			games.showWin(this.window);
			s = raschet.raschet(player);
			System.out.println(s);
		}

		if (c == perexodResult) {
			games.rs.result();
			games.showWin(games.rs);

		}

	}

	public void commandAction(Command c, Item item) {

		if (c == perexodGauge) {

			steerGauge = new SteerGauge(this, this, games);
			games.showWin(steerGauge);
		} else if (c == perexodTires) {

			listTires = new MyListTires(this, this, games);
			games.showWin(listTires);

		} else if (c == perexodChassis) {
			listChassis = new MyListChassis(this, this, games);
			games.showWin(listChassis);
		}
		/*
		 * if (c == perexodDraw) { try { draw = new Draw (); } catch
		 * (IOException e) { e.printStackTrace(); } draw.start();
		 * games.showWin(draw); }
		 */

	}
}
