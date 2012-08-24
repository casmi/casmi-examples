/*
 *   casmi
 *   http://casmi.github.com/
 *   Copyright (C) 2011, Xcoo, Inc.
 *
 *  casmi is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package casmi.graph;

import java.net.URL;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graph.data.*;
import casmi.graph.view.GraphAxis;
import casmi.graph.view.LineGraph;

/**
 * DynamicBarGraph example.
 * 
 * @see casmi.extension.graph.LineGraph
 * @see casmi.extension.graph.Graph
 * 
 * @author Y. Ban
 */

public class LineGraphExample extends Applet{

	LineGraph lineGraph;
	MatrixData2D m;
	static final URL CSV_PATH = Applet.class.getResource("data2D.csv");
	
	@Override
	public void setup() {
		setSize(1024, 768);
		m =  LoadData2D.load( CSV_PATH );
		lineGraph = new LineGraph(800, 600, m, 600, 0);
		lineGraph.setDivisionSpace(GraphAxis.VERTICAL, 50);
		lineGraph.setPosition(100, 100);
		addObject(lineGraph);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
    public static void main(String[] args) {
        AppletRunner.run("casmi.graph.LineGraphExample", "LineGraph Example");
    }


}
