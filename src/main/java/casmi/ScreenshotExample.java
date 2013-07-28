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

import casmi.callback.MouseClickCallback;
import casmi.callback.MouseClickEventType;
import casmi.callback.MouseOverCallback;
import casmi.callback.MouseOverEventType;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Bezier;
import casmi.graphics.element.Circle;
import casmi.graphics.element.Element;
import casmi.graphics.element.Rect;
import casmi.graphics.element.Text;
import casmi.graphics.element.TextAlign;
import casmi.image.Texture;
import casmi.util.SystemUtil;

/**
 * Screenshot example.
 *
 * @see casmi.Applet#capture(String)
 *
 * @author T. Takeuchi
 */
public class ScreenshotExample extends Applet {

    enum Mode {
        JPG, PNG, BMP, GIF
    }

    class HighlightCallback implements MouseOverCallback {
        @Override
        public void run(MouseOverEventType eventType, Element element) {
            switch (eventType) {
            case ENTERED:
            case EXISTED:
                if (element instanceof Text)
                    element.setStrokeColor(ColorSet.WHITE);
                break;
            case EXITED:
                if (element instanceof Text)
                    element.setStrokeColor(ColorSet.GRAY);
                break;
            }
        }
    }

    class ClickCallback implements MouseClickCallback {
        @Override
        public void run(MouseClickEventType eventtype, Element element) {
            if (eventtype == MouseClickEventType.CLICKED) {
                if (element == icon) screenshot();
                else if (element == textJPG) changeMode(Mode.JPG);
                else if (element == textPNG) changeMode(Mode.PNG);
                else if (element == textBMP) changeMode(Mode.BMP);
                else if (element == textGIF) changeMode(Mode.GIF);
            }
        }
    }

    static final String SAVE_DIR = SystemUtil.JAVA_TMP_PATH;

    Circle  circle  = new Circle(200, 200, 80);
    Rect    rect    = new Rect(600, 450, 200, 80);
    Bezier  bezier  = new Bezier(0, 400, 300, 600, 500, 0, 800, 200);

    Texture iconTexture = new Texture(getClass().getResource("/casmi/camera_icon.png").getPath());
    Rect    icon = new Rect(50, 50);

    Text    textJPG = new Text("JPG", 200, 20);
    Text    textPNG = new Text("PNG", 300, 20);
    Text    textBMP = new Text("BMP", 400, 20);
    Text    textGIF = new Text("GIF", 500, 20);

    Mode mode = Mode.JPG;
    HighlightCallback highlightCallback = new HighlightCallback();
    ClickCallback     clickCallback     = new ClickCallback();

    @Override
    public void setup() {
        setSize(800, 600);

        circle.setFillColor(ColorSet.RED);
        addObject(circle);

        rect.setFillColor(ColorSet.BLUE);
        addObject(rect);

        bezier.setFill(false);
        bezier.setStrokeColor(ColorSet.YELLOW);
        addObject(bezier);

        icon.setTexture(iconTexture);
        icon.setPosition(400, 570);
        icon.addMouseEventCallback(highlightCallback);
        icon.addMouseEventCallback(clickCallback);
        addObject(icon);

        textJPG.setStrokeColor(ColorSet.GRAY);
        textJPG.setAlign(TextAlign.CENTER);
        textJPG.addMouseEventCallback(highlightCallback);
        textJPG.addMouseEventCallback(clickCallback);
        addObject(textJPG);

        textPNG.setStrokeColor(ColorSet.GRAY);
        textPNG.setAlign(TextAlign.CENTER);
        textPNG.addMouseEventCallback(highlightCallback);
        textPNG.addMouseEventCallback(clickCallback);
        addObject(textPNG);

        textBMP.setStrokeColor(ColorSet.GRAY);
        textBMP.setAlign(TextAlign.CENTER);
        textBMP.addMouseEventCallback(highlightCallback);
        textBMP.addMouseEventCallback(clickCallback);
        addObject(textBMP);

        textGIF.setStrokeColor(ColorSet.GRAY);
        textGIF.setAlign(TextAlign.CENTER);
        textGIF.addMouseEventCallback(highlightCallback);
        textGIF.addMouseEventCallback(clickCallback);
        addObject(textGIF);
    }

    @Override
    public void update() {
        switch (mode) {
        case JPG:
            textJPG.setStrokeColor(ColorSet.AQUA);
            break;
        case PNG:
            textPNG.setStrokeColor(ColorSet.AQUA);
            break;
        case BMP:
            textBMP.setStrokeColor(ColorSet.AQUA);
            break;
        case GIF:
            textGIF.setStrokeColor(ColorSet.AQUA);
            break;
        }
    }

    @Override
    public void mouseEvent(MouseEvent event, MouseButton button, Mouse mouse) {}

    @Override
    public void keyEvent(KeyEvent event, Keyboard keyboard) {}

    @Override
    public void exit() {}

    private void changeMode(Mode mode) {
        this.mode = mode;

        textJPG.setStrokeColor(ColorSet.GRAY);
        textPNG.setStrokeColor(ColorSet.GRAY);
        textBMP.setStrokeColor(ColorSet.GRAY);
        textGIF.setStrokeColor(ColorSet.GRAY);

        switch (mode) {
        case JPG:
            textJPG.setStrokeColor(ColorSet.AQUA);
            break;
        case PNG:
            textPNG.setStrokeColor(ColorSet.AQUA);
            break;
        case BMP:
            textBMP.setStrokeColor(ColorSet.AQUA);
            break;
        case GIF:
            textGIF.setStrokeColor(ColorSet.AQUA);
            break;
        }
    }

    private void screenshot() {
        String file = SAVE_DIR + "casmi_screenshot";
        switch (mode) {
        case JPG:
            file += ".jpg";
            break;
        case PNG:
            file += ".png";
            break;
        case BMP:
            file += ".bmp";
            break;
        case GIF:
            file += ".gif";
            break;
        }
        capture(file);
        System.out.println("save a screenshot: " + file);
    }

    public static void main(String[] args) {
        AppletRunner.run("casmi.ScreenshotExample", "Screenshot Example");
    }
}
