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
import casmi.graph.data.LoadData2D;
import casmi.graph.data.MatrixData2D;
import casmi.graph.view.DynamicCircleGraph;
import casmi.graph.view.GraphTurn;

/**
 * DynamicCircleGraph example.
 * 
 * @see casmi.extension.graph.DynamicCircleGraph
 * @see casmi.extension.graph.GraphTurn
 * 
 * @author Y. Ban
 */

public class DynamicCircleGraphExample extends Applet{

	DynamicCircleGraph circleGraph;
	MatrixData2D m;
	static final URL CSV_PATH = Applet.class.getResource("data2D4circle.csv");
	
	
	@Override
	public void setup() {
		setSize(1024, 768);
		m =  LoadData2D.loadWithoutAxisName( CSV_PATH );
		circleGraph = new DynamicCircleGraph(m, 200, GraphTurn.CLOCKWISE);
		circleGraph.setPosition(getWidth()/2, getHeight()/2);
		addObject(circleGraph);
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		switch(e){
		case PRESSED:
			circleGraph.setTweenstart(true);
			break;
	}
		
	}

	@Override
	public void keyEvent(KeyEvent e) {
		if(e == KeyEvent.PRESSED){
			circleGraph.resetArc();
		}
		
	}
	
    public static void main(String[] args) {
        AppletRunner.run("casmi.graph.DynamicCircleGraphExample", "DynamicCircleGraph Example");
    }


}
