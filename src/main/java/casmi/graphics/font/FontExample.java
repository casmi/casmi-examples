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

package casmi.graphics.font;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Text;

/**
 * Font example.
 * 
 * @author T. Takeuchi
 *
 * @see casmi.graphics.font.Font
 */
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

    @Override
	public void update() {}
    
    @Override
	public void mouseEvent(MouseEvent e, MouseButton b) {}

	@Override
	public void keyEvent(KeyEvent e) {}
	
    
    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.font.FontExample", "Font Example");
    }

}
