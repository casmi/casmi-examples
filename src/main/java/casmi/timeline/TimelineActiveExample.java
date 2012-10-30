package casmi.timeline;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;

public class TimelineActiveExample extends Applet{

	
    Timeline tl;
    SceneTop st;
    Scene1 s1;
    Scene2 s2;
    Scene3 s3;
    Scene4 s4;
    
	@Override
	public void setup() {
        setSize(1024, 768);
        
        tl = new Timeline();
        addObject(tl);
        
        
        st = new SceneTop("Top");
        s1 = new Scene1("scene1");
        s2 = new Scene2("scene2");
        s3 = new Scene3("scene3");
        s4 = new Scene4("scene4");
        
        tl.appendScene(st);
        tl.appendScene(s1);
        tl.appendScene(s2);
        tl.appendScene(s3);
        tl.appendScene(s4);

        tl.startTimer();
        
		
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
        AppletRunner.run("casmi.timeline.TimelineActiveExample", "Timeline Active Example");
    }

}
