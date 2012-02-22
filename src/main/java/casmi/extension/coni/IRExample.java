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
import casmi.graphics.element.Texture;

/**
 * CONI (casmi OpenNI) IR example.
 * <p>
 * This example shows an infrared rays (IR) view. 
 * 
 * @author T. Takeuchi
 */
public class IRExample extends Applet {

    CONI coni;
    Texture tex;
    
    @Override
    public void setup() {
        setSize(640, 480);
        
        coni = new CONI();
        coni.enableIR(640, 480, 30);
    }

    @Override
    public void update() {
        clearObject();
        
        try {
            coni.update();
            tex = coni.getIRMap().getTexture();
            tex.setPosition(getWidth() / 2, getHeight() / 2);
        } catch (CONIException e) {
            e.printStackTrace();
        }
        
        addObject(tex);
    }
    
    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.extension.coni.IRExample", "CONI (casmi OpenNI): IR Example");
    }

	@Override
	public void mouseWheelEvent() {
		// TODO Auto-generated method stub
		
	}
}
