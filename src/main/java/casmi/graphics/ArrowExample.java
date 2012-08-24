package casmi.graphics;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.element.Arrow;
import casmi.graphics.element.ArrowAlign;
import casmi.graphics.color.ColorSet;
import casmi.matrix.Vertex;

/**
 * Arrow example.
 * 
 * @see casmi.extension.graphics.Arrow
 * @see casmi.extension.graphics.ArrowAlign
 * 
 * @author Y. Ban
 */


public class ArrowExample extends Applet{

	Arrow arrow;
	Arrow arrow2;
	
	@Override
	public void setup() {
		setSize(800, 600);
		arrow2 = new Arrow(30, new Vertex(200, 150), new Vertex(600, 450));
		arrow2.setFillColor(ColorSet.ORANGE);
		addObject(arrow2);
		
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
		if(e == MouseEvent.DRAGGED){
			arrow2.setCorner(arrow2.getStartCorner(),new Vertex(getMouseX(), getMouseY()));
		}
		
	}

	@Override
	public void keyEvent(KeyEvent e) {
		
	}
	
	public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.ArrowExample", "Arrow Example");
    }
	

}
