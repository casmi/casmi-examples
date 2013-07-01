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

package casmi.graphics.element;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseStatus;
import casmi.graphics.color.ColorSet;

/**
 * TextBox example.
 *
 * @author T. Takeuchi
 */
public class TextBoxExample extends Applet {

    static final String SAMPLE_TEXT = "casmi is free software:\nyou can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.";

    TextBox textBox1, textBox2, textBox3;

    @Override
    public void setup() {
        setSize(800, 600);

        Text text1 = new Text(SAMPLE_TEXT);
        text1.setStrokeColor(ColorSet.WHITE);
        textBox1 = new TextBox(text1, 400, 500, 350, 150);
        addObject(textBox1);

        Text text2 = new Text(SAMPLE_TEXT);
        text2.setStrokeColor(ColorSet.PINK);
        text2.setAlign(TextAlign.CENTER);
        textBox2 = new TextBox(text2, 400, 300, 350, 150);
        textBox2.setFillColor(ColorSet.BLUE);
        textBox2.setFill(true);
        textBox2.setRotation(20);
        addObject(textBox2);

        Text text3 = new Text(SAMPLE_TEXT);
        text3.setStrokeColor(ColorSet.GREEN);
        text3.setAlign(TextAlign.RIGHT);
        textBox3 = new TextBox(text3, 400, 100, 350, 150);
        textBox3.setStrokeColor(ColorSet.AQUA);
        textBox3.setStroke(true);
        addObject(textBox3);
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
        AppletRunner.run("casmi.graphics.element.TextBoxExample", "TextBox Example");
    }

}
