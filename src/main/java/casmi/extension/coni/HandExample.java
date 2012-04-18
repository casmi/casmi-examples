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
import casmi.extension.coni.exception.CONIException;
import casmi.extension.coni.listener.GestureListener;
import casmi.extension.coni.listener.HandListener;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Line;
import casmi.graphics.element.Texture;
import casmi.graphics.object.GraphicsObject;
import casmi.matrix.Vertex;

/**
 * CONI (casmi OpenNI) hand tracking example.
 * 
 * @see casmi.extension.coni.CONI#enableGesture(Gesture...)
 * @see casmi.extension.coni.CONI#enableHand()
 * 
 * @author T. Takeuchi
 */
public class HandExample extends Applet implements GestureListener, HandListener {

    CONI coni;
    GraphicsObject handsObject;
    Vertex prvPosition;
    
    @Override
    public void setup() {
        setSize(640, 480);
        
        coni = new CONI();
        
        coni.enableDepth(640, 480, 30);
        coni.enableGesture(Gesture.CLICK, Gesture.WAVE);
        coni.enableHand();
        
        coni.addGestureListener(this);
        coni.addHandListener(this);
        
        Texture tex = coni.getDepthMap().getTexture();
        tex.setPosition(getWidth() / 2, getHeight() / 2);
        addObject(tex);
        
        handsObject = new GraphicsObject();
        addObject(handsObject);
    }
    
    @Override
    public void update() {
        try {
            coni.update();
        } catch (CONIException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {}
    
    @Override
    public void gestureRecognized(CONI coni, Gesture gesture, Vertex idPosition, Vertex endPosition) {
        try {
            coni.startHandTracking(endPosition);
        } catch (CONIException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void gestureProgress(CONI coni, Gesture gesture, Vertex position, float progress) {}
    
    @Override
    public void handCreate(CONI coni, int userID, Vertex position, float time) {}

    @Override
    public void handDestroy(CONI coni, int userID, float time) {        
        handsObject.clear();
        
        try {
            coni.stopHandTracking(userID);
        } catch (CONIException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handUpdate(CONI coni, int userID, Vertex position, float time) {
        position = coni.convertRealWorldToProjective(position);
        position.setY(getHeight() - position.getY());
        
        if (prvPosition != null) {
            Line l = new Line(prvPosition, position);
            l.setStrokeColor(ColorSet.YELLOW);
            handsObject.add(l);
        }
        
        prvPosition = position;
    }

    public static void main(String[] args) {
        AppletRunner.run("casmi.extension.coni.HandExample", "CONI (casmi OpenNI): Hand Tracking Example");
    }

}
