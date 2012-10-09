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

package casmi.timeline;

import casmi.graphics.element.Texture;

/**
 * Example of Timeline.
 * 
 * @author Y. Ban
 * 
 */

/**
 * 
 * @author Y. Ban
 */
public class Scene0 extends Scene {

    static final String IMAGE_PATH = casmi.Applet.class.getResource("logo.png").getPath();
    
    Texture tex;
    double rot = 0.0;
    
    public Scene0(String id) {
    	this(id, 0);
    }

    public Scene0(String id, double time) {
    	super(id, time);
        tex = new Texture(IMAGE_PATH);
        tex.setX(200);
        tex.setY(500);
        tex.setWidth(tex.getWidth() / 1.2);
        tex.setRotation(rot, 0.0, 1.0, 0.0);
        addObject(tex);
    }


    @Override
    public void update() {
        rot += 2.0;
        tex.setRotation(rot, 0.0, 1.0, 0.0);
    }
}
