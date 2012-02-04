package casmi.graphics;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;

public class BackGroundColorExample extends Applet{

	@Override
	public void setup() {
		setSize(800,600);
		setBackGroundColor(ColorSet.AQUA);
		
		
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
        AppletRunner.run("casmi.graphics.BackGroundColorExample", "BackGroundColor Example");
    }


}
