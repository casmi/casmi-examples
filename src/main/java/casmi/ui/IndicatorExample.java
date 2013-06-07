/*
 *   casmi examples
 *   http://casmi.github.com/
 *   Copyright (C) 2012, Xcoo, Inc.
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

package casmi.ui;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;

/**
 * Example of {@link casmi.ui.Indicator} class.
 *
 * @author T. Takeuchi
 *
 * @see casmi.ui.Indicator
 */
public class IndicatorExample extends Applet {

    Indicator indicator;

    @Override
    public void setup() {
        setSize(200, 200);

        indicator = new Indicator();
        indicator.setPosition(getWidth() / 2.0, getHeight() / 2.0);
        indicator.setHideWhenStopped(true);
        addObject(indicator);

        indicator.start();
    }

    @Override
    public void update() {}

    @Override
    public void exit() {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {
        if (e == MouseEvent.CLICKED) {
            if (indicator.isAnimating()) {
                indicator.stop();
            } else {
                indicator.start();
            }
        }
    }

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.ui.IndicatorExample", "Indicator Example");
    }
}
