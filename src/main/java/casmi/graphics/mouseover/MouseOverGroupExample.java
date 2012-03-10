package casmi.graphics.mouseover;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.CursorMode;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Circle;
import casmi.graphics.element.Element;
import casmi.graphics.element.MouseOverCallback;
import casmi.graphics.element.Rect;
import casmi.graphics.element.Triangle;
import casmi.graphics.group.Group;
/**
 * MouseOverGroup example.
 * 
 * @author Y. Ban
 */
public class MouseOverGroup extends Applet{
	
	Circle circle = new Circle(20);
	
	
	class Triangles extends Group{
		Triangle t1,t2;
		MouseOverCallback mouseovertriangle;
		
		public Triangles(){
			setup();
		}

		@Override
		public void setup() {
			t1 = new Triangle(100,100,200,100,150,150);
			t2 = new Triangle(10,10,30,10,20,20);
			t1.setStroke(false);
			t1.setFillColor(ColorSet.CYAN);
			t2.setStroke(false);
			t2.setFillColor(ColorSet.FIREBRICK);
			this.add(t1);
			this.add(t2);
			mouseovertriangle = new MouseOverCallback(){

				@Override
				public void run(MouseOverTypes eventtype,
						Element element) {
					switch(eventtype){
					case ENTERED:
		        			if(element == t1){
		        				cursor(CursorMode.WAIT);
		        			}
		        			if(element == t2){
		        				cursor(CursorMode.TEXT);
		        			}
		        			break;
		        		case EXITED:
		        			cursor(CursorMode.DEFAULT);
		        			break;
					}
				}
				
			};

			t1.addMouseEventCallback(mouseovertriangle);
			t2.addMouseEventCallback(mouseovertriangle);
			
		}

		@Override
		public void update() {
			// TODO Auto-generated method stub
			
		}
	}
	
	class Elements extends Group{
		
		Rect r1,r2;
		
		MouseOverCallback mouseoverrect;
		
		public Elements(){
			setup();
		}

		@Override
		public void setup() {
			r1 = new Rect(100,100);
			r1.setStroke(false);
			r1.setFillColor(ColorSet.CHARTREUSE);
			r2 = new Rect(100,200);
			r2.setStroke(false);
			r2.setFillColor(ColorSet.TOMATO);
			
			r1.setPosition(300, 300);
			r2.setPosition(500, 200);
			
			mouseoverrect = new MouseOverCallback(){

				@Override
				public void run(MouseOverTypes eventtype,
						Element element) {
					switch(eventtype){
	        		case ENTERED:
	        			if(element == r1){
	        				cursor(CursorMode.HAND);
	        			}
	        			if(element == r2){
	        				cursor(CursorMode.CROSS);
	        			}
	        			element.setFillColor(ColorSet.WHITE);
	        			break;
	        		case EXITED:
	        			cursor(CursorMode.DEFAULT);
	        			break;
	        		}
					
				}
				
			};
			
			r1.addMouseEventCallback(mouseoverrect);
			r2.addMouseEventCallback(mouseoverrect);
			
			this.add(r1);
			this.add(r2);
			
		}

		@Override
		public void update() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	Elements el,el2;
	Triangles ts,ts2;
	MouseOverCallback mouseoverCircle,mouseoverTriangles;
	@Override
	public void setup() {
        setSize(800, 600);
        el2 = new Elements();
        el = new Elements();
        ts = new Triangles();
        ts2 = new Triangles();
        circle.setFillColor(ColorSet.DARK_VIOLET);
        el.setPosition(0, 0);
        el2.setPosition(200,100);
        mouseoverTriangles = new MouseOverCallback() {
			
			@Override
			public void run(MouseOverTypes eventtype, Element element) {
				switch(eventtype){
				case ENTERED:
					circle.setScaleX(1.5);
					break;
				case EXITED:
					circle.setScaleX(1.0);
					break;
				}
				
			}
		};
		ts2.addMouseEventCallback(mouseoverTriangles);
        mouseoverCircle = new MouseOverCallback() {
			
			@Override
			public void run(MouseOverTypes eventtype, Element element) {
				switch(eventtype){
				case ENTERED:
					cursor(CursorMode.CROSS);
					element.setFillColor(ColorSet.WHEAT);
					break;
        		case EXITED:
        			cursor(CursorMode.DEFAULT);
        			element.setFillColor(ColorSet.DARK_VIOLET);
        			break;
					
				}
				
			}
		};
		circle.addMouseEventCallback(mouseoverCircle);
		ts2.setPosition(200,200);
        addObject(el2);
        addObject(el);
        circle.setPosition(300, 100);
        addObject(circle);
        addObject(ts);
        addObject(ts2);
		
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
        AppletRunner.run("casmi.graphics.mouseover.MouseOverGroup", "Example");
    }

	@Override
	public void mouseWheelEvent() {
		// TODO Auto-generated method stub
		
	}


}
