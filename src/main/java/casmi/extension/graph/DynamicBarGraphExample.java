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


package casmi.extension.graph;

import java.net.URL;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.extension.graph.data.LoadData2D;
import casmi.extension.graph.data.MatrixData2D;
import casmi.extension.graph.view.DynamicBarGraph;
import casmi.extension.graph.view.GraphAxis;
import casmi.graphics.color.ColorSet;
import casmi.graphics.color.RGBColor;

/**
 * DynamicBarGraph example.
 * 
 * @see casmi.extension.graph.DynamicBarGraph
 * @see casmi.extension.graph.Graph
 * 
 * @author Y. Ban
 */

public class DynamicBarGraphExample extends Applet{

	DynamicBarGraph barGraph;
	MatrixData2D m;
	static final URL CSV_PATH = Applet.class.getResource("data2D.csv");
	
	@Override
	public void setup() {
		setSize(1024, 768);
		m =  LoadData2D.load( CSV_PATH );
		barGraph = new DynamicBarGraph(800, 600, m, 600, 0);
		barGraph.setPosition(100, 100);
		barGraph.setDivisionSpace(GraphAxis.VERTICAL, 50);
		barGraph.setRectColor(new RGBColor(ColorSet.ORANGE));
		addObject(barGraph);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		switch(e){
			case PRESSED:
				barGraph.setTweenstart(true);
				break;
		}
		
	}

	@Override
	public void keyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
    public static void main(String[] args) {
        AppletRunner.run("casmi.extension.graph.DynamicBarGraphExample", "DynamicBarGraph Example");
    }

}
