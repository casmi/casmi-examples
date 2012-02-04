package casmi.graphics.object;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Line;

public class ObjectExample extends Applet {

    Line l1 = new Line(200, 200, 600, 400);
    Line l2 = new Line(200, 400, 600, 200);

    @Override
    public void setup() {
        setSize(800, 600);
        
        l1.setStrokeColor(ColorSet.WHITE);
        l2.setStrokeColor(ColorSet.WHITE);
        
        l1.setStrokeWidth(25);
        l2.setStrokeWidth(25);
        
        addObject(l1);
        addObject(l2);
    }


    public static void main(String args[]) {
        AppletRunner.run("casmi.graphics.object.ObjectExample", "Object Example");
    }


	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
