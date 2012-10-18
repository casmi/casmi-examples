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

package casmi.graph;

import java.net.URL;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graph.data.LoadData2D;
import casmi.graph.data.MatrixData2D;
import casmi.graph.view.DynamicCircleGraph;
import casmi.graph.view.GraphTurnType;

/**
 * DynamicCircleGraph example.
 * 
 * @see casmi.graph.view.DynamicCircleGraph
 * @see casmi.graph.view.GraphTurnType
 * 
 * @author Y. Ban
 */
public class DynamicCircleGraphExample extends Applet {

    static final URL CSV_PATH = Applet.class.getResource("data2D4circle.csv");

    DynamicCircleGraph circleGraph;
    MatrixData2D       mat;

    @Override
    public void setup() {
        setSize(1024, 768);
        
        mat = LoadData2D.loadWithoutAxisName(CSV_PATH);

        circleGraph = new DynamicCircleGraph(mat, 200, GraphTurnType.CLOCKWISE);
        circleGraph.setPosition(getWidth() / 2, getHeight() / 2);
        circleGraph.setAnimation(false);
        addObject(circleGraph);
    }

    @Override
    public void update() {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {
        if (e == MouseEvent.PRESSED)
            circleGraph.startTween();
    }

    @Override
    public void keyEvent(KeyEvent e) {
        if (getKey() == 'r')
            circleGraph.resetTween();
    }

    public static void main(String[] args) {
        AppletRunner.run("casmi.graph.DynamicCircleGraphExample", "DynamicCircleGraph Example");
    }
}
