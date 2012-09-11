package casmi.graphics;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.element.Rect;
import casmi.util.SystemUtil;

public class RectRotateExample extends Applet{

	Rect rect = new Rect(100,100);
	int r;
	@Override
	public void setup() {
		setFPS(30);
		setSize(800,600);
		rect.setPosition(400, 300);
		addObject(rect);
		
	}

	@Override
	public void update() {
		r++;
		if(r>=360)
			r=0;
		rect.setRotation(r);
		
	}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
        if (e == MouseEvent.PRESSED) {
            capture("rsrc" + SystemUtil.FILE_SEPARATOR + "rectrotate.png", true);
        }
		
	}

	@Override
	public void keyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.RectRotateExample", "RectRotateExample");
    }

}
