package casmi;

import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Text;
import casmi.graphics.element.TextBox;

public class WheelExample extends Applet{

	TextBox tb;
	Text text = new Text();
	
	@Override
	public void setup() {
		setSize(250, 400);
		String s = new String("casmi solution is a total solution service for data analysis to data simulation, modeling, and visualization. casmi is an open-source free software Java library with OpenGL that can be in used in the production or development of 2D/3D visualization systems.\n It can work cross-platform and supports OpenGL which enables realtime rendering. It has various functions, including network access, data persistence, and parsers of XML and JSON, and can deal with Input / Output of various data formats. The library and sample codes are public in this site.\n With casmi, you can see results of data analysis visually. Using its realtime rendering function, you can browse and analyze the data interactively. casmi is suitable for information visualization with huge data sets, such as genome / biological information and literature information. It also suitable for development of systems to present information or advertisments in public displays such as a digital signage.");
		text.setText(s);
		text.setStrokeColor(ColorSet.AQUA);
		tb = new TextBox(text, 125, 250, 250, 1000);
		addObject(tb);
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

	@Override
	public void mouseWheelEvent() {
		tb.setY(tb.getY()+getMouseWheelRotation());
	}
	
    public static void main(String[] args) {
        AppletRunner.run("casmi.WheelExample", "Wheel Example");
    }

}
