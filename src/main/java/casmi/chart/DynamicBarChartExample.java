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
import casmi.chart.data.LoadData2D;
import casmi.chart.data.MatrixData2D;
import casmi.chart.view.ChartAxis;
import casmi.chart.view.DynamicBarChart;
import casmi.chart.view.DynamicBarChartTweenType;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;

/**
 * DynamicBarChart example.
 * 
 * @see casmi.chart.view.DynamicBarChart
 * 
 * @author Y. Ban
 */
public class DynamicBarChartExample extends Applet {

    static final URL CSV_PATH = Applet.class.getResource("data2D.csv");

    DynamicBarChart barGraph;
    MatrixData2D    mat;
 
    @Override
    public void setup() {
        setSize(1024, 768);

        mat = LoadData2D.load(CSV_PATH);

        barGraph = new DynamicBarChart(800, 600, mat, 600, 0);
        barGraph.setPosition(100, 100);
        barGraph.setDivisionSpace(ChartAxis.VERTICAL, 150);
        barGraph.setBarColor(new RGBColor(ColorSet.ORANGE));
        barGraph.setTweenType(DynamicBarChartTweenType.ORDER);
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
        AppletRunner.run("casmi.graph.DynamicBarChartExample", "DynamicBarChart Example");
    }
}
