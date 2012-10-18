package casmi.graphics.gradation;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Box;
import casmi.graphics.element.GradationMode3D;
import casmi.graphics.object.Camera;
import casmi.graphics.object.Perspective;

public class GradationBoxExample extends Applet{

	 Box b1 = new Box(1.0);

	    
	    Perspective p;
	    Camera c;

	@Override
	public void setup() {
        setSize(800, 600);

        b1.setStrokeWidth(1.0);
        b1.setFillColor(new RGBColor(0.4, 0.4, 0.4));
        b1.setStroke(false);
        b1.setGradationColor(GradationMode3D.Y_AXIS,ColorSet.AQUA, ColorSet.ORANGE_RED);
          
        p = new Perspective(30.0, (double)getWidth() / (double)getHeight(), 1.0, 100.0);
        c = new Camera(3.0, 4.0, 5.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
          
        setPerspective(p);
        setCamera(c);
        
        addObject(b1);
		
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
	
    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.gradation.GradationBoxExample", "Gradation Box Example");
    }

}
