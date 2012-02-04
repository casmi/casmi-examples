package casmi.tween;

import java.net.URL;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.element.Texture;
import casmi.tween.equations.Bounce;
import casmi.util.SystemUtil;

public class TweenRepeatExample  extends Applet{

    Texture tex = null;
    TweenElement te;  
    
    URL imagePath = Applet.class.getResource("logo.png");
    
    
    
    
    @Override
    public void setup(){
        setSize(1024, 768);
        System.out.println(SystemUtil.USER_DIR);
       tex = new Texture(imagePath);
       tex.setPosition(200, 500);
       addObject(tex);
		te = new TweenElement(tex);
		addTween(Tween.to(te, TweenType.POSITION, 3000, Bounce.OUT).targetRelative(45,0).addDelay(1000).repeat(-1, 300));
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
		AppletRunner.run("casmi.tween.TweenRepeatExample", "Example");
	}

}
