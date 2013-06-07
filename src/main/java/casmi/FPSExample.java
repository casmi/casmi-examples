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
import casmi.graphics.element.Circle;
import casmi.graphics.element.Text;
import casmi.graphics.element.TextAlign;

/**
 * Getting and setting FPS example.
 * <p>
 * The Left number is setting FPS, and the right one is working FPS.
 * Click anywhere to change FPS.
 *
 * @author T. Takeuchi
 *
 * @see casmi.Applet#getFPS()
 * @see casmi.Applet#setFPS(double)
 * @see casmi.Applet#getWorkingFPS()
 */
public class FPSExample extends Applet {

    Text fpsText, workingFPSText;
    Circle circle;

    int cnt = 0;
    int fps = 30;

    @Override
    public void setup() {
        setSize(440, 150);

        fpsText = new Text("30");
        fpsText.setAlign(TextAlign.CENTER);
        fpsText.setPosition(120, 30);
        fpsText.setStrokeColor(ColorSet.WHITE);
        addObject(fpsText);

        workingFPSText = new Text();
        workingFPSText.setAlign(TextAlign.CENTER);
        workingFPSText.setPosition(280, 30);
        workingFPSText.setStrokeColor(ColorSet.WHITE);
        addObject(workingFPSText);

        circle = new Circle(25);
        circle.setPosition(40, 100);
        addObject(circle);
    }

    @Override
    public void update() {
        circle.setX(40 + cnt * 40);

        workingFPSText.setText(String.format("%4.2f", getWorkingFPS()));

        if (10 <= ++cnt) cnt = 0;
    }

    @Override
    public void exit() {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {
        if (e == MouseEvent.CLICKED) {
            switch (fps) {
            case 30:
                setFPS(15.0);
                fpsText.setText("15");
                fps = 15;
                break;
            case 15:
                setFPS(10.0);
                fpsText.setText("10");
                fps = 10;
                break;
            case 10:
                setFPS(5.0);
                fpsText.setText("5");
                fps = 5;
                break;
            case 5:
                setFPS(30.0);
                fpsText.setText("30");
                fps = 30;
                break;
            }
        }
    }

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
		AppletRunner.run("casmi.FPSExample", "FPS Example");
	}

}
