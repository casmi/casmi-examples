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

import java.awt.event.KeyEvent;

import casmi.graphics.Graphics;
import casmi.graphics.color.Color;
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
 * @author Y.Ban
 */
public class KeyboardExample extends Applet {

    private static final int LINE_NUM = 9;

    Rect r = new Rect(640, 480);
    Line l = new Line();
    Line c = new Line();
    Font f, ft;
    Text df_text, text;

    String content = "";

    public void setup() {
        setSize(800, 600);
        
        r.setFillColor(ColorSet.WHITE);
        r.setStrokeColor(ColorSet.GRAY);
        r.setXY(getWidth() / 2, getHeight() / 2);
        
        l.setStrokeColor(ColorSet.GRAY);
        l.setStrokeWidth(1.1);
        
        c.setStrokeColor(ColorSet.LIGHTCORAL);

        f = new Font("Times New Roman");
        f.setSize(40);
        df_text = new Text("KeyBoard Example", f,
                           getWidth()  / 2,
                           getHeight() / 2 + r.getHeight() / 2 - r.getHeight() / (LINE_NUM + 1));
        df_text.setAlign(TextAlign.CENTER);
        df_text.setStrokeColor(ColorSet.LIGHTCORAL);
        df_text.setY((int)(df_text.getY() + df_text.getDescent() + 3));

        ft = new Font("Times New Roman", FontStyle.ITALIC, 40);
        text = new Text(content, ft,
                        getWidth()  / 2 - (r.getWidth() / 2 - 20),
                        getHeight() / 2 + r.getHeight() / 2 - 2 * r.getHeight() / (LINE_NUM + 1) + 5);
        text.setStrokeColor(Color.color(ColorSet.LIGHTBLUE));
        text.setLeading(r.getHeight() / (LINE_NUM + 1));
    }

    @Override
    public void draw(Graphics g) {
        g.render(r);
        
        for (int i = 0; i < LINE_NUM; i++) {
            l.set(getWidth() / 2 - (r.getWidth() / 2 - 20), getHeight() / 2 + r.getHeight() / 2 - ((i + 1) * r.getHeight() / (LINE_NUM + 1)),
                  getWidth() / 2 + (r.getWidth() / 2 - 20), getHeight() / 2 + r.getHeight() / 2 - ((i + 1) * r.getHeight() / 10));
            g.render(l);
        }
        
        g.render(df_text);
        
        if (isKeyPressed()) {
            if (44 <= getKeycode() || getKeycode() == 32) {
                content += getKey();
            } else if (getKeycode() == KeyEvent.VK_ENTER) {
                content += "\n";
            } else if (getKeycode() == 8) {
                content = content.substring(0, content.length() - 1);
            }
            text.setText(content);
        }
        g.render(text);
        
        c.set(text.getX() + text.getWidth(text.getLine()  - 1) + 2,
              text.getY() - text.getLeading() * (text.getLine() - 2) - 10,
              text.getX() + text.getWidth(text.getLine()  - 1) + 2,
              text.getY() - text.getLeading() * (text.getLine() - 1) - 1);
        g.render(c);
    }

    public static void main(String args[]) {
        AppletRunner.run("casmi.KeyboardExample", "Keyboard Example");
    }
}
