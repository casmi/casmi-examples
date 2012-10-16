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
import casmi.graph.view.DynamicBarGraph;
import casmi.graph.view.DynamicBarGraphTweenType;
import casmi.graph.view.GraphAxis;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;

/**
 * DynamicBarGraph example.
 * 
 * @see casmi.graph.view.DynamicBarGraph
 * 
 * @author Y. Ban
 */
public class DynamicBarGraphExample extends Applet {

    static final URL CSV_PATH = Applet.class.getResource("data2D.csv");

    DynamicBarGraph barGraph;
    MatrixData2D    mat;
 
    @Override
    public void setup() {
        setSize(1024, 768);

        mat = LoadData2D.load(CSV_PATH);

        barGraph = new DynamicBarGraph(800, 600, mat, 600, 0);
        barGraph.setPosition(100, 100);
        barGraph.setDivisionSpace(GraphAxis.VERTICAL, 150);
        barGraph.setBarColor(new RGBColor(ColorSet.ORANGE));
        barGraph.setTweenType(DynamicBarGraphTweenType.ORDER);
        barGraph.setDelayMilliSec(100);
        barGraph.setTweenMilliSec(500);
        addObject(barGraph);
    }

    @Override
    public void update() {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {
        if (e == MouseEvent.PRESSED)
            barGraph.startTween();
    }

    @Override
    public void keyEvent(KeyEvent e) {
        if (getKey() == 'r')
            barGraph.resetTween();
    }

    public static void main(String[] args) {
        AppletRunner.run("casmi.graph.DynamicBarGraphExample", "DynamicBarGraph Example");
    }
}
