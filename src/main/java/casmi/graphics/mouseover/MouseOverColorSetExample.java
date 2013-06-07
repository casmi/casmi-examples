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

package casmi.graphics.mouseover;

import java.util.ArrayList;
import java.util.List;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;
import casmi.graphics.element.Element;
import casmi.graphics.element.MouseOverCallback;
import casmi.graphics.element.RoundRect;
import casmi.graphics.element.Text;
import casmi.graphics.element.TextAlign;
import casmi.graphics.font.Font;
import casmi.graphics.font.FontStyle;

/**
 * Example of MouseOver.
 *
 * @author Y. Ban
 *
 */
public class MouseOverColorSetExample extends Applet {

    List<RoundRect> rrList = new ArrayList<RoundRect>();
    List<ColorRoundrect> crList = new ArrayList<ColorRoundrect>();
    Font f;
    Text text;
    int index;

    class ColorRoundrect {

        String colorName;
        RoundRect roundRect;
        ColorSet colorSet;
        int index;

        ColorRoundrect(ColorSet colorSet) {
            this.colorSet = colorSet;
            roundRect = new RoundRect(6, 0, 0, 52, 52);
            colorName = colorSet.toString();
            roundRect.setFillColor(colorSet);
            roundRect.setStrokeColor(ColorSet.WHITE);
            roundRect.setStrokeWidth(2.0);
            roundRect.setStroke(false);
        }
    }

    @Override
    public void setup() {
        setSize(1024, 768);
        final float w = 65.0f;
        final float h = 65.0f;

        int numRows = 14;
        index = 0;

        for (ColorSet set : ColorSet.values()) {
            ColorRoundrect cr = new ColorRoundrect(set);
            crList.add(cr);
        }
        f = new Font("San-Serif", FontStyle.BOLD_ITALIC, 43);
        text = new Text("", f);
        text.setAlign(TextAlign.CENTER);
        text.setStrokeColor(ColorSet.WHITE);
        text.setPosition(770, 710);

        index = 0;
        for (final ColorRoundrect cr : crList) {
            cr.roundRect.addMouseEventCallback(new MouseOverCallback() {

                @Override
                public void run(MouseOverTypes eventtype, Element element) {
                    switch (eventtype) {
                    case ENTERED:
                    case EXISTED:
                    {
                        element.setStroke(true);
                        text.setText(cr.colorName);
                        Color c = new RGBColor(cr.colorSet);
                        if (0.1 < c.getRed() || 0.1 < c.getBlue() || 0.1 < c.getGreen()) {
                            text.setStrokeColor(cr.colorSet);
                        } else {
                            text.setStrokeColor(ColorSet.WHITE);
                        }
                        break;
                    }
                    case EXITED:
                        element.setStroke(false);
                        text.setText("");
                        break;
                    default:
                        break;
                    }
                }
            });
            cr.roundRect.setPosition(w * (index % numRows) + 100, h * (index / numRows) + 70);
            cr.index = index;
            addObject(cr.roundRect);
            index++;
        }
        addObject(text);
    }

    @Override
    public void update() {}

    @Override
    public void exit() {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.graphics.mouseover.MouseOverColorSetExample", "MouseOverColorSetExample");
    }

}
