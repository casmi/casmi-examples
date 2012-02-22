/*
 *   casmi examples
 *   http://casmi.github.com/
 *   Copyright (C) 2011, Xcoo, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package casmi;

import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Line;
import casmi.graphics.element.Rect;
import casmi.graphics.element.Text;
import casmi.graphics.element.TextAlign;
import casmi.graphics.font.Font;
import casmi.graphics.font.FontStyle;

/**
 * Keyboard example.
 * 
 * @see casmi.Applet
 * 
 * @author Y.Ban
 */
public class KeyboardExample extends Applet {

    private static final int LINE_NUM = 9;

    Rect r    = new Rect(640, 480);
    Line line = new Line();
    Line c    = new Line();
    Font f, ft;
    Text df_text, text;

    String content = "";

    @Override
    public void setup() {
        setSize(800, 600);
        
        r.setFill(false);
        r.setStrokeColor(ColorSet.GRAY);
        r.setPosition(getWidth() / 2, getHeight() / 2);
        
        line.setStrokeColor(ColorSet.GRAY);
        line.setStrokeWidth(1.1);
        
        c.setStrokeColor(ColorSet.LIGHT_CORAL);

        f = new Font("Times New Roman");
        f.setSize(40);
        df_text = new Text("KeyBoard Example", f,
                           getWidth()  / 2,
                           getHeight() / 2 + r.getHeight() / 2 - r.getHeight() / (LINE_NUM + 1));
        df_text.setAlign(TextAlign.CENTER);
        df_text.setStrokeColor(ColorSet.LIGHT_CORAL);
        df_text.setY((int)(df_text.getY() + df_text.getDescent() + 3));

        ft = new Font("Times New Roman", FontStyle.ITALIC, 40);
        text = new Text(content, ft,
                        getWidth()  / 2 - (r.getWidth() / 2 - 20),
                        getHeight() / 2 + r.getHeight() / 2 - 2 * r.getHeight() / (LINE_NUM + 1) + 5);
        text.setStrokeColor(ColorSet.LIGHT_BLUE);
        text.setLeading(r.getHeight() / (LINE_NUM + 1));
        
        addObject(r);
        for (int i = 0; i < LINE_NUM; i++) {
        	Line l = (Line) line.clone();
            l.set(getWidth() / 2 - (r.getWidth() / 2 - 20), getHeight() / 2 + r.getHeight() / 2 - ((i + 1) * r.getHeight() / (LINE_NUM + 1)),
                  getWidth() / 2 + (r.getWidth() / 2 - 20), getHeight() / 2 + r.getHeight() / 2 - ((i + 1) * r.getHeight() / 10));
            addObject(l);
        }
        addObject(df_text);
        addObject(text);
        addObject(c);
    }
    
    @Override
    public void update() {}
    
    @Override 
    public void keyEvent(KeyEvent e){
    	if (e == KeyEvent.PRESSED) {
            if (44 <= getKeycode() || getKeycode() == 32) {
                content += getKey();
            } else if (getKeycode() == java.awt.event.KeyEvent.VK_ENTER) {
                content += "\n";
            } else if (getKeycode() == 8&&content.length()>0) {
                content = content.substring(0, content.length() - 1);
            }
            text.setText(content);
        }
    	c.set(text.getX() + text.getWidth(text.getLine()  - 1) + 2,
                text.getY() - text.getLeading() * (text.getLine() - 2) - 10,
                text.getX() + text.getWidth(text.getLine()  - 1) + 2,
                text.getY() - text.getLeading() * (text.getLine() - 1) - 1);
    }

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}    

    public static void main(String[] args) {
        AppletRunner.run("casmi.KeyboardExample", "Keyboard Example");
    }

	@Override
	public void mouseWheelEvent() {
		// TODO Auto-generated method stub
		
	}
}
