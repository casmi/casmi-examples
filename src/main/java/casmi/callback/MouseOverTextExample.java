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

package casmi.callback;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.CursorMode;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseStatus;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Element;
import casmi.graphics.element.Text;
import casmi.graphics.font.Font;
import casmi.graphics.font.FontStyle;

/**
 * An example of Mouseover of Text.
 *
 * @author Y. Ban
 */
public class MouseOverTextExample extends Applet {

    static final String SAMPLE_TEXT = "Move your mouse cursor on this text.";

    @Override
    public void setup() {
        setSize(800, 600);

        Font font = new Font("San-Serif", FontStyle.BOLD_ITALIC, 20);
        Text text = new Text(SAMPLE_TEXT, font, 220, 300);
        text.setStrokeColor(ColorSet.WHITE);
        text.addMouseEventCallback(new MouseOverCallback() {

            @Override
            public void run(MouseOverEventType eventType, Element element) {
                switch (eventType) {
                case ENTERED:
                    setCursor(CursorMode.HAND);
                    break;
                case EXITED:
                    setCursor(CursorMode.DEFAULT);
                    break;
                default:
                    break;
                }
            }
        });

        addObject(text);
    }

    @Override
    public void update() {}

    @Override
    public void exit() {}

    @Override
    public void mouseEvent(MouseStatus e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.callback.MouseOverTextExample", "MouseOverTextExample");
    }

}