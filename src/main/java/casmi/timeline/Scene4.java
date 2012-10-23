package casmi.timeline;

import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Box;
import casmi.graphics.element.GradationMode3D;
import casmi.graphics.element.Text;
import casmi.graphics.font.Font;
import casmi.graphics.group.Group;
import casmi.graphics.object.Camera;
import casmi.graphics.object.Ortho;
import casmi.graphics.object.Perspective;

public class Scene4 extends Scene{

	Box b1 = new Box(1.0);
	double rot = 0.0;
    
    Perspective p;
    Camera c;
    BoxName boxName;
    
    class BoxName extends Group {
    	Ortho ortho;
    	Text t;
    	Font f = null;
    	public BoxName() {
    		ortho = new Ortho();
			addPerse(ortho);
    		f = new Font("San-Serif");
            f.setSize(70);
            t = new Text("Box", f, 750, 600);
            t.setStrokeColor(ColorSet.WHITE);
	        add(t);
    	}
		@Override
		public void update() {
			// TODO Auto-generated method stub
			
		}
    	
    }
    
	public Scene4(String id) {
		super(id);
		boxName = new BoxName();
		b1.setStrokeWidth(1.0);
        b1.setFillColor(new RGBColor(0.4, 0.4, 0.4));
        b1.setStrokeColor(new RGBColor(1.0, 1.0, 1.0));
        b1.setRotation(rot, 1, 3, 5);
        b1.setGradationColor(GradationMode3D.Y_AXIS,ColorSet.AQUA, ColorSet.ORANGE_RED);
        
        p = new Perspective(30.0, (double)1024 / (double)768, 1.0, 100.0);
        c = new Camera(3.0, 4.0, 5.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
          
        setPerspective(p);
        setCamera(c);
        
        addObject(b1);
        addObject(boxName);

		
	}

	@Override
	public void update() {
        rot += 0.1;
        b1.setRotation(rot, 1, 3, 5);
		
	}

	@Override
	public void keyEvent(KeyEvent e) {
		switch (e) {
		case PRESSED:
			if(getKey()=='b')
				goNextScene("Top", DissolveMode.BLACK, 3);
		}
		
	}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		// TODO Auto-generated method stub
		
	}

}
