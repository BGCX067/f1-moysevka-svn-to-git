import java.io.IOException;

import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class Games extends MIDlet // implements CommandListener
{
	// private Form myForm, rezultat, igrok2;

	/**
	 * private Command exitMidlet = new Command("Выход", Command.EXIT, 1);
	 * private Command start = new Command("Старт", Command.SCREEN, 2); private
	 * Command igrok1perexod = new Command("Игрок1", Command.SCREEN, 2); private
	 * Command igrok2perexod = new Command("Игрок2", Command.SCREEN, 2); private
	 * Command poexali = new Command("Поехали", Command.SCREEN, 2); private
	 * Command nazad = new Command("Назад", Command.SCREEN, 2); private Command
	 * finich = new Command("Финиш", Command.OK, 2);
	 **/
	private static Games midlet;
	private static PlayerScr instance;

	private Display myDisplay;
	double s;

	// public TextField sila1, sila2, skorost1, skorost2, rezultatIgrok1,
	// rezultatIgrok2, pobedil;
	protected PlayerScr gamer1;
	// private PlayerTwo igrok2;
	// private Player player;
	private int nomZapuska = 0;

	Draw gp;
	PlayerScr gamer2;
	Result rs;

	public Games() {
		myDisplay = Display.getDisplay(this);
		setInstance(gamer1);
		midlet = this;
	}

	public void showWin(Displayable win) {
		myDisplay.setCurrent(win);
	}

	public static Games getMIDlet() {
		return midlet;
	}

	void quit() throws MIDletStateChangeException {
		destroyApp(true);
		notifyDestroyed();
	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {
		// TODO Auto-generated method stub

		if (gp != null) {
			gp.stop();
		}
		setInstance(null);
		gamer1 = null;
	}

	protected void pauseApp() {
		System.out.println("Вызвана пауза");
	}

	protected void startApp() throws MIDletStateChangeException {

		if (nomZapuska == 0) {
			System.out.println("Запущено приложение, созданы формы");
			/*
			 * myForm = new Form("вход в игру"); StringItem s = new
			 * StringItem("Он-лайн Игра Менеджер Ф1", ""); myForm.append(s);
			 * myForm.addCommand(exitMidlet); myForm.addCommand(start);
			 * myForm.setCommandListener(this);
			 */
			gamer1 = new PlayerScr("Меню Первого пилота", this);
			gamer2 = new PlayerScr("Меню Второго пилота", this);
			gamer1.setPerexodCommand("Второй пилот", gamer2);
			gamer2.setPerexodCommand("Первый пилот", gamer1);
			myDisplay.setCurrent(gamer1);
			try {
				gp = new Draw(this);

				rs = new Result(null, this);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out
					.println("Пауза завершена, НЕ созданы формы. Номер запуска "
							+ nomZapuska);
		}
		nomZapuska++;
	}

	/**
	 * public void commandAction(Command c, Displayable d) { // TODO
	 * Auto-generated method stub
	 * 
	 * if (c == exitMidlet) { try { destroyApp(false); } catch
	 * (MIDletStateChangeException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } notifyDestroyed(); }
	 * 
	 * 
	 * if (c == start) { // igrok1.addCommand(exitMidlet);
	 * 
	 * igrok1.addCommand(igrok2perexod); igrok1.setCommandListener(this);
	 * myDisplay.setCurrent(igrok1); }
	 * 
	 * if (c == igrok2perexod) { // igrok2 = new PlayerTwo
	 * ("Меню Второго Инрока"); sila2 = new TextField("Ведите мощность карта",
	 * "0.0", 5, TextField.DECIMAL); skorost2 = new
	 * TextField("Ведите макс скорость карта", "0.0", 5, TextField.DECIMAL);
	 * igrok2.append(sila2); igrok2.append(skorost2);
	 * 
	 * igrok2.addCommand(poexali); igrok2.addCommand(igrok1perexod);
	 * igrok2.setCommandListener(this); myDisplay.setCurrent(igrok2); } if (c ==
	 * igrok1perexod) { myDisplay.setCurrent(igrok1); } if (c == poexali) {
	 * 
	 * try { gp = new Draw(); } catch (IOException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } gp.start(); gp.addCommand(finich);
	 * gp.addCommand(exitMidlet); gp.setCommandListener(this);
	 * myDisplay.setCurrent(gp);
	 * 
	 * }
	 * 
	 * if (c == finich) {
	 * 
	 * player = new Player(); String sil2 = sila2.getString(); double xSil2 =
	 * Double.parseDouble(sil2); String sk2 = skorost2.getString(); double xSk2
	 * = Double.parseDouble(sk2);
	 * 
	 * Raschet raschet = new Raschet(); igrok1.setPlayer(player); s =
	 * raschet.raschet(player);
	 * 
	 * myDisplay.setCurrent(rezultat); rezultat = new Form("Результаты");
	 * rezultatIgrok1 = new TextField("Результат первого карта", "", 30,
	 * TextField.ANY); rezultatIgrok2 = new TextField("Результат второго карта",
	 * "0.0", 30, TextField.ANY); pobedil = new TextField("Победитель", "", 10,
	 * TextField.ANY); rezultat.append(rezultatIgrok1);
	 * rezultat.append(rezultatIgrok2); rezultat.append(pobedil);
	 * rezultat.addCommand(nazad); rezultat.addCommand(exitMidlet);
	 * rezultat.setCommandListener(this); rezultatIgrok1.setString("" + s);
	 * 
	 * gp.stop(); } if (c == nazad) { myDisplay.setCurrent(igrok2);
	 * 
	 * } }
	 **/

	public static void setInstance(PlayerScr instance) {
		Games.instance = instance;
	}

	public static PlayerScr getInstance() {
		return instance;
	}
}