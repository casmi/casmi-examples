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
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Text;
import casmi.graphics.element.TextBox;

/**
 * TextBox example.
 * 
 * @author T. Takeuchi
 */
public class TextBoxExample extends Applet {

    private static final String SAMPLE_TEXT = "casmi is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.";
    
    private TextBox textBox;
    
    @Override
    public void setup() {

        setSize(800, 600);
        
        Text text = new Text(SAMPLE_TEXT);
        text.setStrokeColor(Color.color(ColorSet.WHITE));
        textBox = new TextBox(text, 400, 300, 350, 150);
        textBox.setFillColor(Color.color(ColorSet.BLUE));
        textBox.setStrokeColor(Color.color(ColorSet.AQUA));
    }

    @Override
    public void draw(Graphics g) {

        g.render(textBox);
    }

    public static void main(String[] args) {
        
        AppletRunner.run("casmi.graphics.TextBoxExample", "TextBox Example");
    }
}
