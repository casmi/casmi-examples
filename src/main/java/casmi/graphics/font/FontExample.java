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
import casmi.graphics.Graphics;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Line;
import casmi.graphics.element.Text;
import casmi.graphics.font.Font;

/**
 * Example of casmi Font
 * 
 * @author takashi
 * 
 */
public class FontExample extends Applet {

    Font f = null;
    Line l;
    Text t;

    public void setup() {
        setSize(1024, 768);
        f = new Font("San-Serif");

        t = new Text("This is test for font rendering", 100, 300, f);
        t.setStrokeColor(Color.color(ColorSet.LIGHTBLUE));
        
        l = new Line(100,300-t.textDescent(),100+t.textWidth(),300-t.textDescent());
        l.setStrokeColor(Color.color(ColorSet.LIGHTBLUE));
       
    }

    @Override
    public void draw(Graphics g) {
        g.render(t);
        g.render(l);
    }

    public static void main(String args[]) {
        AppletRunner.run("casmi.graphics.font.FontExample", "Example");
    }
}
