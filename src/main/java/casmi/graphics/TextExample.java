package casmi.graphics;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Line;
import casmi.graphics.element.Text;
import casmi.graphics.font.Font;
import casmi.graphics.font.FontStyle;

public class TextExample extends Applet {

    private static final String SAMPLE_TEXT = "This is a test for Text element.";
    
    private Text text;
    private Line line;
    
    @Override
    public void setup() {
        setSize(800, 600);
        
        Font font = new Font("San-Serif", FontStyle.BOLD_ITALIC, 20);
        text = new Text(SAMPLE_TEXT, font);
        text.setPosition(200, 300);
        text.setStrokeColor(ColorSet.WHITE);
        
        line = new Line(200, 300 - text.getDescent(),
                        200 + text.getWidth(), 300 - text.getDescent());
        line.setStrokeColor(ColorSet.LIGHT_BLUE);
        
        addObject(text);
        addObject(line);
    }

    @Override
    public void update() {}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {}


	@Override
	public void keyEvent(KeyEvent e) {}
	
	public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.TextExample", "Text Example");
    }
}
