package casmi.graphics.object;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Element;
import casmi.graphics.element.Ellipse;
import casmi.graphics.element.MouseOverCallback;
import casmi.graphics.element.Rect;
import casmi.graphics.element.Triangle;
import casmi.graphics.group.Group;

class TriangleGroup extends Group {

    Triangle t1, t2;

    public TriangleGroup() {
        setup();
    }

    @Override
    public void setup() {
        t1 = new Triangle(100, 100, 200, 100, 150, 150);
        t2 = new Triangle(10, 10, 30, 10, 20, 20);
        t1.setStroke(false);
        t1.setFillColor(ColorSet.CYAN);
        t2.setStroke(false);
        t2.setFillColor(ColorSet.FIREBRICK);
        this.add(t1);
        this.add(t2);
      
    }

    @Override
    public void update() {}
}

public class RemoveExample extends Applet{
	
	TriangleGroup tg1,tg2;
	Ellipse el;
	Rect r1,r2;
	MouseOverCallback removeover;

	@Override
	public void setup() {
		setSize(800,600);
		tg1 = new TriangleGroup();
		tg2 = new TriangleGroup();
		el = new Ellipse(10);
		r1 = new Rect(100, 100);
		r2 = new Rect(200, 120);
		r1.setFillColor(ColorSet.ALICE_BLUE);
		r2.setFillColor(ColorSet.CHOCOLATE);
		el.setFillColor(ColorSet.DARK_RED);
		tg1.setPosition(300,300);
		tg2.setPosition(600,400);
		el.setPosition(200, 100);
		r1.setPosition(700,200);
		r2.setPosition(200,500);
		
		addObject(tg1);
		addObject(tg2);
		addObject(el);
		addObject(r2);
		addObject(r1);
		removeover = new MouseOverCallback() {
			
			@Override
			public void run(MouseOverTypes eventtype, Element element) {
				if(eventtype == MouseOverTypes.ENTERED)
					element.remove();
				
			}
		};
		r2.addMouseEventCallback(removeover);		
		
		
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
		if(e == KeyEvent.PRESSED){
			switch(getKey()){
			case 't':
				tg1.remove();
				break;
			case 'e':
				el.remove();
				break;
			case 'r':
				r1.remove();
				break;
			}
		}
		
	}
	
	public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.object.RemoveExample", "Remove Example");
    }


}
