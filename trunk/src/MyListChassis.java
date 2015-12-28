import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.Screen;

public class MyListChassis extends List implements CommandListener {
	PlayerScr playerScr;
	Screen backScr;
	private Games games;
	//private Player player = new Player();
	Command nazad = new Command("Назад", Command.BACK, 1);
	private Command OK = new Command("OK", Command.OK, 1);
	static String[] chassis = { "Red Bull", "McLaren", "Ferrari" };
	double chassiS;

	public MyListChassis(PlayerScr playerScr, Screen backScr, Games games) {
		super("Шасси", Choice.EXCLUSIVE, chassis, null);

		this.addCommand(OK);
		this.addCommand(nazad);
		this.setCommandListener(this);
		this.backScr = backScr;
		this.playerScr = playerScr;
		this.games = games;

	}

	public void commandAction(Command c, Displayable d) {
		
		if (c == nazad) {
			games.showWin(backScr);
		} else if (c == OK) {

			int i = this.getSelectedIndex();

			if (i == 1) {
				chassiS = 0.81;//рврв
				System.out.println("" + chassiS);
				playerScr.player.chassiS = chassiS;
			} else if (i == 0) {
				chassiS = 0.8;
				System.out.println("" + chassiS);
				playerScr.player.chassiS = chassiS;
			} else if (i == 2) {
				chassiS = 0.79;
				System.out.println("" + chassiS);
				playerScr.player.chassiS = chassiS;

			}

		}
	}
}
