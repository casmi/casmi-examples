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

package casmi.chart;

import java.net.URL;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.chart.data.MatrixData2D;
import casmi.chart.view.ChartTurnType;
import casmi.chart.view.DynamicCircleChart;

/**
 * DynamicCircleChart example.
 * 
 * @see casmi.chart.view.DynamicCircleChart
 * @see casmi.chart.view.ChartTurnType
 * 
 * @author Y. Ban
 */
public class DynamicCircleChartExample extends Applet {

    static final URL CSV_PATH = Applet.class.getResource("data2D4circle.csv");

    DynamicCircleChart circleGraph;
    MatrixData2D       mat;

    @Override
    public void setup() {
        setSize(1024, 768);
        
        mat = new MatrixData2D();
        
        mat.appendData("A", 60);
        mat.appendData("B", 25);
        mat.appendData("c", 15);

        mat.calculate();
        
        circleGraph = new DynamicCircleChart(mat, 200, ChartTurnType.CLOCKWISE);
        circleGraph.setPosition(getWidth() / 2, getHeight() / 2);
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
        AppletRunner.run("casmi.chart.DynamicCircleChartExample", "DynamicCircleChart Example");
    }
}
