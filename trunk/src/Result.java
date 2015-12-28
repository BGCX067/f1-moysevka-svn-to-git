import java.util.Random;

import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;

public class Result extends Form {
	private String nameOne;
	private String nameTwo;
	protected TextField nameTw, nameOn, nameOnTime, nameTwTime;
	double timeTwo;
	double timeOne;
	private Games games;

	public Result(String title, Games games) {
		super("���������� ������");
		nameOn = new TextField("��� ������� ������", "", 24, TextField.ANY);
		append(nameOn);
		nameOnTime = new TextField("����� ������� ������", "", 32,
				TextField.DECIMAL);
		append(nameOnTime);
		nameTw = new TextField("��� ������� ������", "", 24, TextField.ANY);
		append(nameTw);
		nameTwTime = new TextField("����� ������� ������", "", 32,
				TextField.ANY);
		append(nameTwTime);
		this.games = games;
	}

	public void result() {
		nameOne = games.gamer1.nameOne.getString();
		nameTwo = games.gamer2.nameOne.getString();
		timeOne = games.gamer1.s;
		timeTwo = games.gamer2.s;
		Random a = new Random(); // FIXME ������
		this.nameOn.setString("" + nameOne);
		this.nameTw.setString("" + nameTwo);

		double timeOneR = (((int) (timeOne * 1000 + 0.5)) / 1000.);

		this.nameOnTime.setString("" + timeOneR);
		this.nameTwTime.setString("" + timeTwo);

	}
}
