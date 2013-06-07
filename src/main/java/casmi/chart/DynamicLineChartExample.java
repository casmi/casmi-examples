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
import casmi.chart.view.ChartAxis;
import casmi.chart.view.DynamicLineChart;

/**
 * DynamicBarChat example.
 *
 * @see casmi.chart.view.DynamicLineChart
 *
 * @author Y. Ban
 */
public class DynamicLineChartExample extends Applet {

    static final URL CSV_PATH = Applet.class.getResource("data2D.csv");

    DynamicLineChart lineGraph;
    MatrixData2D     mat;

    @Override
    public void setup() {
        setSize(1024, 768);

        mat = new MatrixData2D();

        mat.setAxis("year", "data");

        mat.appendData("1996", 50);
        mat.appendData("2001", 140);
        mat.appendData("2004", 340);
        mat.appendData("2005", 40);
        mat.appendData("2007", 280);
        mat.appendData("2009", 480);
        mat.appendData("2010", 580);
        mat.appendData("2011", 400);
        mat.appendData("2012", 599);
        mat.appendData("2013", 200);

        mat.calculate();

        lineGraph = new DynamicLineChart(800, 600, mat, 600, 0);
        lineGraph.setDivisionSpace(ChartAxis.VERTICAL, 50);
        lineGraph.setPosition(100, 100);
        lineGraph.setTweenMilliSec(2000);

        addObject(lineGraph);
    }

    @Override
    public void update() {}

    @Override
    public void exit() {}

    @Override
    public void mouseEvent(MouseEvent e, MouseButton b) {
        if (e == MouseEvent.PRESSED)
            lineGraph.startTween();
    }

    @Override
    public void keyEvent(KeyEvent e) {
        if (getKey() == 'r')
            lineGraph.resetTween();
    }

    public static void main(String[] args) {
        AppletRunner.run("casmi.chart.DynamicLineChartExample", "DynamicLineChart Example");
    }
}
