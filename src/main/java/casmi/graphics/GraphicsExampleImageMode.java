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
import casmi.image.Image;
import static casmi.image.Image.ImageMode.*;
import casmi.util.SystemUtil;

/**
 * Example of Graphics.
 * 
 * @author Y. BAN
 * 
 */
public class GraphicsExampleImageMode extends Applet {

    Image image = null;
        
    String imagePath = ".." + SystemUtil.FILE_SEPARATOR + "rsrc" + SystemUtil.FILE_SEPARATOR + "logo.png";  // TODO can not work when running as Java Application
   // String imagePath = "rsrc" + SystemProperty.FILE_SEPARATOR + "logo.png";
    
    double rot = 0.0;
    
    public void setup(){
        setSize(1024, 768);
        System.out.println(SystemUtil.USER_DIR);
        image = new Image(imagePath);
    }
    
    @Override
    public void draw(Graphics g) {
        image.imageMode(CORNER);
        g.image(image, 300, 300);
        image.imageMode(CENTER);
        g.image(image, 300, 300);
    }
    
    public static void main(String args[]) {
        AppletRunner.run( "casmi.graphics.GraphicsExampleImageMode", "Example");
    }
}
