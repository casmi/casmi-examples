package casmi.graphics;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.element.Circle;
import casmi.graphics.element.Texture;
import casmi.graphics.object.Mask;

public class MaskExample extends Applet{
	Mask mask;
	Circle circle;
	Texture tex;
    String imagePath = Applet.class.getResource("sora.png").getPath();
	@Override
	public void setup() {
		setSize(1024, 768);
		mask = new Mask();
		circle = new Circle(60);
		tex = new Texture(imagePath);
		circle.setPosition(300, 300);
		mask.add(circle);
		tex.setPosition(getWidth()/2,getHeight()/2);
		tex.setMask(mask);
		addObject(tex);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		if(e==MouseEvent.DRAGGED || e==MouseEvent.PRESSED){
			circle.setPosition(getMouseX(), getMouseY());
		}
		
	}

	@Override
	public void keyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	 public static void main(String[] args) {
	        AppletRunner.run("casmi.graphics.MaskExample", "Mask Example");
	    }

}
