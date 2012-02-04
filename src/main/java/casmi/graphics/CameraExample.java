package casmi.graphics;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Line;
import casmi.graphics.element.Sphere;
import casmi.graphics.object.Camera;

public class CameraExample extends Applet{

	Sphere s;
	Camera camera;
	Line lx,ly,lz;
	@Override
	public void setup() {
		setSize(800, 600);
		lx = new Line(0,0,0,1,0,0);
		lx.setStrokeColor(ColorSet.RED);
		lx.setStrokeWidth(2);
		ly = new Line(0,0,0,0,1,0);
		ly.setStrokeColor(ColorSet.BLUE);
		lx.setStrokeWidth(2);
		lz = new Line(0,0,0,0,0,1);
		lz.setStrokeColor(ColorSet.GREEN);
		lx.setStrokeWidth(2);
		s = new Sphere(1);
		s.setStrokeColor(ColorSet.AQUA,100);
		s.setFill(false);
		setPerspective(30, (double)getWidth()/(double)getHeight(), 1.0, 100);
        camera = new Camera(2.4, 3.2, 4.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
        setCamera(camera);
        addObject(lx);
        addObject(ly);
        addObject(lz);
        addObject(s);
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
        AppletRunner.run( "casmi.graphics.CameraExample", "Example");
    }

}
