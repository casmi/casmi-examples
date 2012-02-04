package casmi.graphics;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Text;
import casmi.graphics.element.TextAlign;
import casmi.graphics.element.TextBox;

/**
 * TextBox example.
 * 
 * @author T. Takeuchi
 */
public class TextBoxExample extends Applet {

    private static final String SAMPLE_TEXT = "casmi is free software:\nyou can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.";
    
    private TextBox textBox1, textBox2, textBox3;
    
    @Override
    public void setup() {
        setSize(800, 600);
        
        Text text1 = new Text(SAMPLE_TEXT);
        text1.setStrokeColor(Color.color(ColorSet.WHITE));
        textBox1 = new TextBox(text1, 400, 500, 350, 150);
        addObject(textBox1);
        
        Text text2 = new Text(SAMPLE_TEXT);
        text2.setStrokeColor(Color.color(ColorSet.RED));
        text2.setAlign(TextAlign.CENTER);
        textBox2 = new TextBox(text2, 400, 300, 350, 150);
        textBox2.setFillColor(Color.color(ColorSet.BLUE));
        textBox2.setFill(true);
        addObject(textBox2);
        
        Text text3 = new Text(SAMPLE_TEXT);
        text3.setStrokeColor(Color.color(ColorSet.GREEN));
        text3.setAlign(TextAlign.RIGHT);
        textBox3 = new TextBox(text3, 400, 100, 350, 150);
        textBox3.setStrokeColor(Color.color(ColorSet.AQUA));
        textBox3.setStroke(true);
        addObject(textBox3);
    }

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.TextBoxExample", "TextBox Example");
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
