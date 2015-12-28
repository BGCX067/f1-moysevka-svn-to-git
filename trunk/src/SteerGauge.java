import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.Screen;

public class SteerGauge extends Form implements CommandListener {
	PlayerScr playerScr;
	Displayable backScr;
	private Games games;
	protected double gaugeG;
	Gauge gauge;
	
	Command nazad = new Command("Назад", Command.BACK, 1);
	private Command OK = new Command("OK", Command.OK, 1);

	public SteerGauge(PlayerScr playerScr, Displayable backScr, Games games) {
		super("Поворачиваемость");
		// TODO Auto-generated constructor stub

		gauge = new Gauge("Управляемость", true, 5, 2);
		this.append(gauge);
		this.addCommand(OK);
		this.addCommand(nazad);
		this.setCommandListener(this);
		this.backScr = backScr;
		this.playerScr = playerScr;
		this.games = games;

	}

	public void commandAction(Command c, Displayable d) {
		// TODO Auto-generated method stub
		if (c == nazad) {
			games.showWin(backScr);
		}
		if (c == OK) {
			int i = gauge.getValue();
			if (i == 0) {
				gaugeG = 0.81;
				System.out.println("" + gaugeG);
				playerScr.player.gaugeG = gaugeG;
			}
			if (i == 1) {
				gaugeG = 0.8;
				System.out.println("" + gaugeG);
				playerScr.player.gaugeG = gaugeG;
			}
			if (i == 2) {
				gaugeG = 0.79;
				System.out.println("" + gaugeG);
				playerScr.player.gaugeG = gaugeG;
			}
			if (i == 3) {
				gaugeG = 0.8;
				System.out.println("" + gaugeG);
				playerScr.player.gaugeG = gaugeG;
			}
			if (i == 4) {
				gaugeG = 0.81;
				System.out.println("" + gaugeG);
				playerScr.player.gaugeG = gaugeG;
			}
			if (i == 5) {
				gaugeG = 0.82;
				System.out.println("" + gaugeG);
				playerScr.player.gaugeG = gaugeG;
			}

		}
	}

}
