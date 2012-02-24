package casmi.extension.cpop;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;

public class CPopExample extends Applet{
	
	CPopupMenu menu;
	RGBColor color;

	RGBColor white;

	@Override
	public void setup() {
		setSize(200, 200);

		white = new RGBColor(ColorSet.WHITE);
		color = white;

		menu = new CPopupMenu(this);
		menu.addMenuItem("clear", "clearColor");
		menu.addSeparator();
		menu.addMenuItem("red", "changeColor", new RGBColor(ColorSet.RED));
		menu.addMenuItem("green", "changeColor", new RGBColor(ColorSet.GREEN));
		menu.addMenuItem("blue", "changeColor", new RGBColor(ColorSet.BLUE));
	}

	public void clearColor() {
		this.color = white;
	}

	public void changeColor(RGBColor color) {
		this.color = color;
	}

	@Override
	public void update() {
		setBackGroundColor(color);
	}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		if (b.equals(MouseButton.RIGHT))
			menu.show();
	}

	@Override
	public void keyEvent(KeyEvent e) {
	}

	@Override
	public void mouseWheelEvent() {
	}

	public void main(String[] args) {
		AppletRunner.run("casmi.extension.cpop.CPopExample",
				"CPopExample");
	}
}