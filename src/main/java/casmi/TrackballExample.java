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
import casmi.graphics.element.Box;
import casmi.graphics.element.Line;
import casmi.graphics.object.Camera;
import casmi.graphics.object.GraphicsObject;
import casmi.graphics.object.Perspective;

/**
 * Trackball example.
 * 
 * @author T. Takeuchi
 */
public class TrackballExample extends Applet {

    GraphicsObject group;
    Line[] lines = new Line[3];
    Box box;
    
    Trackball trackball;
    
    int prvMouseX = 0, prvMouseY = 0;
    
    Perspective p;
    Camera c;
    
    @Override
    public void setup() {
        setSize(800, 600);
    
        group = new GraphicsObject();
        
        lines[0] = new Line(0.0, 0.0, 0.0,
                            120.0, 0.0, 0.0);
        lines[0].setStrokeColor(ColorSet.RED);
        lines[1] = new Line(0.0, 0.0, 0.0,
                            0.0, 120.0, 0.0);
        lines[1].setStrokeColor(ColorSet.GREEN);
        lines[2] = new Line(0.0, 0.0, 0.0,
                            0.0, 0.0, 120.0);
        lines[2].setStrokeColor(ColorSet.BLUE);
        group.add(lines[0]);
        group.add(lines[1]);
        group.add(lines[2]);
        
        box = new Box(1.0);
        box.setStrokeColor(ColorSet.GRAY);
        box.setFillColor(ColorSet.WHITE);
        group.add(box);
        
       // group.setPosition(getWidth() / 2.0, getHeight() / 2.0);
        
        addObject(group);
        
        p = new Perspective(30.0, (double)getWidth() / (double)getHeight(), 1.0, 100.0);
        c = new Camera(3.0, 4.0, 5.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0);
        
        setPerspective(p);
        setCamera(c);
        
        // Create Trackball object.
        trackball = new Trackball(this);
    }

    @Override
    public void update() {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {
        if (e == MouseEvent.PRESSED) {
            prvMouseX = getMouseX();
            prvMouseY = getMouseY();
        }
        
        if (e == MouseEvent.DRAGGED && b == MouseButton.LEFT) {
            int mouseX = getMouseX();
            int mouseY = getMouseY();
            
            // Update Trackball.
            trackball.update(mouseX, mouseY, prvMouseX, prvMouseY);
            
            // Rotate an object with Trackball.
            trackball.rotate(group);
            
            prvMouseX = mouseX;
            prvMouseY = mouseY;
        }
    }

    @Override
    public void keyEvent(KeyEvent e) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.TrackballExample", "TrackballExample");
    }
    
}
