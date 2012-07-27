package casmi.extension.graphics;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.extension.graphics.Arrow;
import casmi.extension.graphics.ArrowAlign;
import casmi.graphics.color.ColorSet;

public class ArrowExample extends Applet{

	Arrow arrow;
	
	@Override
	public void setup() {
		setSize(800, 600);
		arrow = new Arrow(30, 150);
		arrow.setFillColor(ColorSet.ALICE_BLUE);
		arrow.setAlign(ArrowAlign.CENTER);
		arrow.setPosition(getWidth()/2, getHeight()/2);
		addObject(arrow);
		
	}

	@Override
	public void update() {
		arrow.setRotation(arrow.getRotation()-3);
		
	}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
        AppletRunner.run("casmi.extension.graphics.ArrowExample", "Arrow Example");
    }
	

}
