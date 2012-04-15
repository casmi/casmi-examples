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
        text.setStrokeColor(ColorSet.WHITE,10);
        
        line = new Line(200, 300 - text.getDescent(),
                        200 + text.getWidth(), 300 - text.getDescent());
        line.setStrokeColor(ColorSet.BLUE,0);
        
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
