package casmi.graphics.font;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Text;

public class FontExample extends Applet {

    private Text text;
    private String[] fontnames;
    
    @Override
    public void setup() {
        
        setSize(300, 500);
        
        text = new Text();
        text.setStrokeColor(ColorSet.WHITE);
        text.setX(5);
        fontnames = Font.getAvailableFontFamilyNames();
        
        int i = 0;
        for (int y = getHeight(); 0 < y; y -= 16, i++) {
            Font f = new Font(fontnames[i], FontStyle.PLAIN, 14);
            text.setFont(f);
            text.setText(fontnames[i]);
            text.setY(y);
            
            try {
                addObject(text);
            } catch (ArrayIndexOutOfBoundsException e) {
                // ignore
            }
        }
    }

    
    public static void main(String[] args) {
        
        AppletRunner.run("casmi.graphics.font.FontExample", "Font Example");
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
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
