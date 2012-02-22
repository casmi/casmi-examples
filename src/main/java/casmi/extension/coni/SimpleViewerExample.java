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

package casmi.extension.coni;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.extension.coni.CONI;
import casmi.extension.coni.exception.CONIException;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Text;
import casmi.graphics.element.TextAlign;
import casmi.graphics.element.Texture;
import casmi.graphics.object.GraphicsObject;

/**
 * CONI (casmi OpenNI) simple viewer example.
 * <p>
 * This example shows image and depth views from NI sensors (e.g. Xtion, Kinect, etc).
 * You can change image and depth views by clicking a window.
 * 
 * @author T. Takeuchi
 */
public class SimpleViewerExample extends Applet {

    enum ScreenMode {
        IMAGE,
        DEPTH
    }
    
    private CONI coni;
    private Text text;
    private ScreenMode screenMode = ScreenMode.IMAGE;
    private GraphicsObject group = new GraphicsObject();
    
    @Override
    public void setup() {
        setSize(640, 480);
        
        coni = new CONI();
        coni.enableImage(640, 480, 30);
        coni.enableDepth(640, 480, 30);
        
        text = new Text("MODE: IMAGE");
        text.setPosition(630, 10);
        text.setAlign(TextAlign.RIGHT);
        text.setStrokeColor(ColorSet.WHITE);
        addObject(text);
    }

    @Override
    public void update() {
        // update sensor data
        try {
            coni.update();
        } catch (CONIException e) {
            e.printStackTrace();
            return;
        }

        // rendering
        group.clear();
        if (screenMode == ScreenMode.IMAGE) {
            Texture tex = coni.getImageMap().getTexture();
            tex.setPosition(getWidth() / 2, getHeight() / 2);
            group.add(tex);
        } else if (screenMode == ScreenMode.DEPTH) {
            Texture tex = coni.getDepthMap().getTexture();
            tex.setPosition(getWidth() / 2, getHeight() / 2);
            group.add(tex);
        }
        addObject(0, group);
    }

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {
        if (e == MouseEvent.CLICKED) changeMode();        
    }

    @Override
    public void keyEvent(KeyEvent e) {
        if (e == KeyEvent.TYPED) changeMode();
    }
    
    private void changeMode() {
        switch (screenMode) {
        case IMAGE:
            text.setText("MODE: DEPTH");
            screenMode = ScreenMode.DEPTH;
            break;
        case DEPTH:
            text.setText("MODE: IMAGE");
            screenMode = ScreenMode.IMAGE;
            break;
        }
    }
    
    public static void main(String[] args) {
        AppletRunner.run("casmi.extension.coni.SimpleViewerExample", "CONI (casmi OpenNI): simple example");
    }

	@Override
	public void mouseWheelEvent() {
		// TODO Auto-generated method stub
		
	}
}
