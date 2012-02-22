/*
 *   casmi examples
 *   http://casmi.github.com/
 *   Copyright (C) 2011-2012, Xcoo, Inc.
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

package casmi.tween;

import java.util.ArrayList;
import java.util.List;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.CursorMode;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.color.Color;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Element;
import casmi.graphics.element.Ellipse;
import casmi.graphics.element.Line;
import casmi.graphics.element.MouseClickCallback;
import casmi.graphics.element.MouseOverCallback;
import casmi.graphics.element.Rect;
import casmi.graphics.element.Text;
import casmi.graphics.element.TextAlign;
import casmi.graphics.font.Font;
import casmi.tween.equations.Back;
import casmi.tween.equations.Bounce;
import casmi.tween.equations.Circ;
import casmi.tween.equations.Cubic;
import casmi.tween.equations.Elastic;
import casmi.tween.equations.Expo;
import casmi.tween.equations.Linear;
import casmi.tween.equations.Quad;
import casmi.tween.equations.Quart;
import casmi.tween.equations.Quint;
import casmi.tween.equations.Sine;

/**
 * Example of Tween.
 * 
 * @author Y. Ban
 * 
 */
public class TweenEquationsExample extends Applet {
	
	String eqName[] = {"Back","Bounce","Circ","Cubic","Elastic","Expo","Linear","Quad","Quart","Quint","Sine"};
	Line l1 = new Line(100, 200, 600, 200);
	Line l2 = new Line(100, 550, 600, 550);
	Rect r = new Rect(150, 50);
	Ellipse el = new Ellipse(20);
	Font f, f2;
	Text t, t_in, t_out;
	private int eq = 0;
	private int io = 1;
	TweenElement te, te2;
	
	private boolean tmstart = false, tmstart2 = false;
	private boolean modechange = false;
	Color pink, blue;
	MouseClickCallback mouseclickcb;
	MouseOverCallback mouseovercb;
	int start = 0;
	
	class EqRect {
		private int index;
		private Rect r;
		MouseClickCallback ccb;
		MouseOverCallback ocb;
		public EqRect(int index, Text t) {
			
			this.index = index;
			r = new Rect(850, 618 + t.getHeight() / 2 - index * 50, 150, 40);
			r.setStroke(false);
			Color c = new Color(ColorSet.BLACK, 1);
			r.setFillColor(c);
		}

		public Rect getRect() {
			return r;
		}

		public int getIndex() {
			return index;
		}
	}

	List<EqRect> tr = new ArrayList<EqRect>();

	@Override
	public void setup() {
		pink = Color.color(ColorSet.LIGHT_PINK);
		blue = Color.color(ColorSet.LIGHT_BLUE);
		setSize(1024, 768);
		l1.setStrokeColor(ColorSet.AQUAMARINE);
		l2.setStrokeColor(Color.color(ColorSet.AQUAMARINE));
		el.setFillColor(Color.color(ColorSet.ORANGE));

		f = new Font("San-Serif");
		f2 = new Font("San-Serif");
		f.setSize(40);
		f2.setSize(25);
		t = new Text("Back", f, 850, 620);
		t.setStrokeColor(Color.color(ColorSet.WHITE));
		t.setAlign(TextAlign.CENTER);

		t_in = new Text("IN", f2, 100, 550 + 5);
		pink.setA(100);
		t_in.setStrokeColor(pink);
		t_in.getSceneStrokeColor().setA(100);
		t_out = new Text("OUT", f2, 100, 200 + 5);
		t_out.setStrokeColor(blue);
		r.setFill(false);
		r.setStrokeColor(Color.color(ColorSet.LIGHT_BLUE));
		
		
		addObject(t_in);
		addObject(t_out);
		addObject(l1);
		addObject(l2);
		el.setPosition(350, 550);
		addObject(el);

		r.setPosition(850, 618 + t.getHeight() / 2);
		addObject(r);

		
		Text tmpt; int index = 0;
		for(String name : eqName){
			tmpt = (Text) t.clone();
			tmpt.setPosition(t.getX(), t.getY()-50*index);
			tmpt.setText(name);
			addObject(tmpt);
			index ++;
		}
		
		

		for (int i=0;i<11; i++){
			EqRect eq = new EqRect(i, t);
			tr.add(eq);
		}

	    index = 0;
		for (final EqRect r : tr) {
			addObject(r.getRect());
			mouseclickcb = new MouseClickCallback() {
				@Override
				public void run(MouseClickTypes eventtype, Element element) {				
					if (eventtype == MouseClickTypes.CLICKED) {
							modechange = true;
							eq = r.getIndex();
							start = 1;
						}
					}

			};
			
			mouseovercb = new MouseOverCallback() {

				@Override
				public void run(MouseOverTypes eventtype, Element element) {
					switch(eventtype){
					case ENTERED:
						cursor(CursorMode.HAND);
						break;
					case EXITED:
						cursor(CursorMode.DEFAULT);
						break;
					}
				}
				
			};
			
			r.getRect().addMouseEventCallback(mouseclickcb);
			r.getRect().addMouseEventCallback(mouseovercb);
			
			index++;
		}

		te2 = null;
		te2 = new TweenElement(r);
		te = null;
		te = new TweenElement(el);
		
		
	}

	@Override
	public void update() {
		if (modechange) {
			modechange = false;

			Tween changeTween = Tween.to(te2, TweenType.POSITION, 1000,
					Cubic.INOUT).target(r.getX(), tr.get(eq).getRect().getY());
			addTween(changeTween);
			tmstart2 = true;
			if (io == 0) {
				r.setStrokeColor(Color.color(ColorSet.LIGHT_PINK));
				pink.setA(255);
				blue.setA(100);
				t_in.setStrokeColor(pink);
				t_out.setStrokeColor(blue);
			}
			if (io == 1) {
				r.setStrokeColor(Color.color(ColorSet.LIGHT_BLUE));
				pink.setA(100);
				blue.setA(255);
				t_in.setStrokeColor(pink);
				t_out.setStrokeColor(blue);
			}
			if (io == 2) {
				r.setStrokeColor(Color.color(ColorSet.LIGHT_GREEN));
				pink.setA(255);
				blue.setA(255);
				t_in.setStrokeColor(pink);
				t_out.setStrokeColor(blue);
			}
		}

	}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		if (e == MouseEvent.PRESSED) {
			if (start == 0) {
				clearTween();
				el.setPosition(350, 550);
				te.reset();
				if (io == 0) {
					switch (eq) {
					case 0:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Back.IN).target(
								el.getX(), 200));
						break;
					case 1:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Bounce.IN).target(
								el.getX(), 200));
						break;
					case 2:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Circ.IN).target(
								el.getX(), 200));
						break;
					case 3:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Cubic.IN).target(
								el.getX(), 200));
						break;
					case 4:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Elastic.IN).target(
								el.getX(), 200));
						break;
					case 5:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Expo.IN).target(
								el.getX(), 200));
						break;
					case 6:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Linear.INOUT).target(
								el.getX(), 200));
						break;
					case 7:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Quad.IN).target(
								el.getX(), 200));
						break;
					case 8:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Quart.IN).target(
								el.getX(), 200));
						break;
					case 9:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Quint.IN).target(
								el.getX(), 200));
						break;
					case 10:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Sine.IN).target(
								el.getX(), 200));
						break;
					}
				}
				if (io == 1) {
					switch (eq) {
					case 0:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Back.OUT).target(
								el.getX(), 200));
						break;
					case 1:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Bounce.OUT).target(
								el.getX(), 200));
						break;
					case 2:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Circ.OUT).target(
								el.getX(), 200));
						break;
					case 3:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Cubic.OUT).target(
								el.getX(), 200));
						break;
					case 4:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Elastic.OUT).target(
								el.getX(), 200));
						break;
					case 5:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Expo.OUT).target(
								el.getX(), 200));
						break;
					case 6:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Linear.INOUT).target(
								el.getX(), 200));
						break;
					case 7:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Quad.OUT).target(
								el.getX(), 200));
						break;
					case 8:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Quart.OUT).target(
								el.getX(), 200));
						break;
					case 9:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Quint.OUT).target(
								el.getX(), 200));
						break;
					case 10:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Sine.OUT).target(
								el.getX(), 200));
						break;
					}
				}
				if (io == 2) {
					switch (eq) {
					case 0:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Back.INOUT).target(
								el.getX(), 200));
						break;
					case 1:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Bounce.INOUT).target(
								el.getX(), 200));
						break;
					case 2:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Circ.INOUT).target(
								el.getX(), 200));
						break;
					case 3:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Cubic.INOUT).target(
								el.getX(), 200));
						break;
					case 4:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Elastic.INOUT).target(
								el.getX(), 200));
						break;
					case 5:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Expo.INOUT).target(
								el.getX(), 200));
						break;
					case 6:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Linear.INOUT).target(
								el.getX(), 200));
						break;
					case 7:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Quad.INOUT).target(
								el.getX(), 200));
						break;
					case 8:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Quart.INOUT).target(
								el.getX(), 200));
						break;
					case 9:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Quint.INOUT).target(
								el.getX(), 200));
						break;
					case 10:
						addTween(Tween.to(te,
								TweenType.POSITION, 3000, Sine.INOUT).target(
								el.getX(), 200));
						break;
					}
				}
			}
			else {
				start = 0;
				
			}
		}

	}

	@Override
	public void keyEvent(KeyEvent e) {
		switch (e) {
		case PRESSED:
			if (getKeycode() == 37) {
				io--;
				if (io < 0)
					io = 0;
				modechange = true;
			}
			if (getKeycode() == 39) {
				io++;
				if (io > 2)
					io = 2;
				modechange = true;
			}
			break;
		}


	}

	public static void main(String args[]) {
		AppletRunner.run("casmi.tween.TweenEquationsExample", "Example");
	}

}
