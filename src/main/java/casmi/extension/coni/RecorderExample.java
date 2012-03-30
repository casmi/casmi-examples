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

import java.io.File;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.extension.coni.CONI;
import casmi.extension.coni.Player;
import casmi.extension.coni.Recorder;
import casmi.extension.coni.exception.CONIException;
import casmi.graphics.element.Texture;
import casmi.util.SystemUtil;

/**
 * Recorder example.
 * <p>
 * This example does not work now because of a bug of OpenNI jni.
 * 
 * @author T. Takeuchi
 */
public class RecorderExample extends Applet {

    static final String FILE_PATH = SystemUtil.JAVA_TMP_PATH + "test.oni"; 
    
    CONI     coni;
    Recorder recorder;
    Player   player;
    
    boolean recording = false;
    boolean playing   = false;
    
    Texture tex;
    
    @Override
    public void setup() {
        setSize(640, 480);
        
        coni = new CONI();
        coni.enableImage(640, 480, 30);
        coni.enableDepth(640, 480, 30);
        coni.setDepthViewpointToImage();
    }

    @Override
    public void update() {
        clearObject();
        
        try {
            if (!playing) {
                coni.update();
                
                tex = coni.getImageMap().getTexture();
                tex.setPosition(getWidth() / 2, getHeight() / 2);
                addObject(tex);
                
                tex = coni.getDepthMap().getTexture();
                tex.setPosition(getWidth() / 2, getHeight() / 2);
                addObject(tex);
            } else {
                player.update();
                
                tex = player.getImageMap().getTexture();
                tex.setPosition(getWidth() / 2, getHeight() / 2);
                addObject(tex);
                
                tex = player.getDepthMap().getTexture();
                tex.setPosition(getWidth() / 2, getHeight() / 2);
                addObject(tex);
            }
        } catch (CONIException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {}

    @Override
    public void keyEvent(KeyEvent e) {
        if (e == KeyEvent.PRESSED) {
            switch (getKey()) {
            case 'r':
                if (playing) break;
                if (!recording) {
                    try {
                        recorder = new Recorder(coni, new File(FILE_PATH));
                        recording = true;
                    } catch (CONIException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    recorder.close();
                    recorder = null;
                    recording = false;
                }
                break;
            case 'p':
                if (recording) break;
                if (!playing) {
                    try {
                        player = new Player(new File(FILE_PATH));
                        player.enableImage();
                        player.enableDepth();
                        player.setDepthViewpointToImage();
                        playing = true;
                    } catch (CONIException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    player = null;
                    playing = false;
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        AppletRunner.run("casmi.extension.coni.RecorderExample", "CONI (casmi OpenNI): Recorder Example");
    }

}
