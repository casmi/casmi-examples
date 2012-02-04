package casmi.graphics.mouseover;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.CursorMode;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Element;
import casmi.graphics.element.MouseOverCallback;
import casmi.graphics.element.Text;
import casmi.graphics.font.Font;
import casmi.graphics.font.FontStyle;

public class MouseOverTextExample extends Applet {
	

	private static final String SAMPLE_TEXT = "This is a test for Text element.";
    private Text text;
    
    MouseOverCallback tcb;
	@Override
	public void setup() {
		 setSize(800, 600);
	        
	        Font font = new Font("San-Serif", FontStyle.BOLD_ITALIC, 20);
	        text = new Text(SAMPLE_TEXT, font, 200, 300);
	        text.setStrokeColor(Color.color(ColorSet.WHITE));
	        tcb = new MouseOverCallback(){

				@Override
				public void run(MouseOverTypes eventtype,
						Element element) {
					switch(eventtype){
	        		case ENTERED:
	        				cursor(CursorMode.HAND);
	        			break;
	        		case EXITED:
	        			cursor(CursorMode.DEFAULT);
	        			break;
	        		}
					
				}
	        	
	        };
	        text.addMouseEventCallback(tcb);
	        addObject(text);
		
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
        AppletRunner.run("casmi.graphics.mouseover.MouseOverTextExample", "Example");
    }
}
