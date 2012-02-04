package casmi.tween;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Rect;
import casmi.tween.equations.Bounce;

public class TweenGroupRepeatExample extends Applet{

	Rect r1 = new Rect(200, 200);
	TweenElement te;
	
	@Override
	public void setup() {
		setSize(800,600);
		r1.setFillColor(ColorSet.AQUA);
		addObject(r1);
		r1.setPosition(150, 150);
		te = new TweenElement(r1);
		TweenSerialGroup ts = (TweenSerialGroup) TweenSerialGroup.create(
					Tween.to(te, TweenType.POSITION, 1000, Bounce.OUT).target(550,150),
					Tween.to(te, TweenType.POSITION, 1000, Bounce.OUT).target(550,550),
					Tween.to(te, TweenType.POSITION, 1000, Bounce.OUT).target(150,550),
					Tween.to(te, TweenType.POSITION, 1000, Bounce.OUT).target(150,150)
				).addDelay(1000).repeat(10,300);
		addTween(ts);	
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String args[]) {
		AppletRunner.run("casmi.tween.TweenGroupRepeatExample", "Example");
	}

}
