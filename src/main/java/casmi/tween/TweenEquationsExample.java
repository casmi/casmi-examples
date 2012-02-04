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


import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.MouseButton;
import casmi.MouseEvent;
import casmi.graphics.Graphics;
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
import casmi.graphics.group.Group;
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

public class TweenEquationsExample extends Applet {

	Line l1 = new Line(100, 200, 600, 200);
	Line l2 = new Line(100, 550, 600, 550);
	Rect r = new Rect(150, 50);
	Ellipse el = new Ellipse(20);
	Font f, f2;
	Text t, t_in, t_out;
	private int eq = 0;
	private int io = 1;
	TweenElement te, te2;
	private TweenManager manager = new TweenManager(),
			manager2 = new TweenManager();
	private boolean tmstart = false, tmstart2 = false;
	private boolean modechange = false;
	Color pink, blue;
	MouseClickCallback mouseclickcb;
	MouseOverCallback mouseovercb;
	int s = 0;

	class EqRect extends Group {
		private int index;
		private Rect r;
		MouseClickCallback ccb;
		MouseOverCallback ocb;
		public EqRect(int index, Text t) {
			super();
			this.index = index;
			setup();

		}

		public Rect getRect() {
			return r;
		}

		public int getIndex() {
			return index;
		}

		@Override
		public void setup() {
			r = new Rect(150, 40);
			//r.setFill(false);
			r.setStroke(false);

			ccb = new MouseClickCallback() {

				@Override
				public void run(MouseClickTypes eventtype, Element element) {
					switch(eventtype){
					case CLICKED:
						System.out.println("test");
					}
					
				}
			
			};
			
			ocb = new MouseOverCallback() {
				
				@Override
				public void run(MouseOverTypes eventtype, Element element) {
					switch(eventtype){
					case ENTERED:
						System.out.println("test");
					}
					
				}
			};
			
			this.add(r);
			r.addMouseEventCallback(ccb);
			r.addMouseEventCallback(ocb);
			

		}

		@Override
		public void update() {
			// TODO Auto-generated method stub

		}
	}

	EqRect tr[] = new EqRect[11];
	Rect trr[] = new Rect[11];
	

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

		

		int index = 0;
		for (Rect r : trr) {
			//r = new EqRect(index, t);
			r = new Rect(150,40);
			r.setPosition(850, 618 + t.getHeight() / 2 - index * 50);
			addObject(r);
		//	r.addMouseEventCallback(mouseclickcb);
			r.addMouseEventCallback(mouseovercb);
			
			index++;
		}

		te2 = null;
		te2 = new TweenElement(r);
		te = null;
		te = new TweenElement(el);
	}

	@Override
	public void mouseEvent(MouseEvent e, MouseButton b) {
		if (e == MouseEvent.PRESSED) {
			if (s == 0) {

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

	@Override
	public void update(Graphics g) {
//		for (MouseOver m : mo) {
//			if (m.isMouseOver(getMouseX(), getMouseY())) {
//				cursor(CursorMode.HAND);
//				s++;
//				if (isMousePressed()) {
//					modechange = true;
//					eq = index;
//				}
//			}
//			g.render(m);
//			index++;
//		}


		if (modechange) {
			modechange = false;

			Tween changeTween = Tween.to(te2, TweenType.POSITION, 1000,
					Cubic.INOUT).target(r.getX(), -50 * eq);
			manager2.add(changeTween);
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

		if (isMousePressed() && s == 0) {
			te.reset();
			manager = null;
			manager = new TweenManager();

			if (io == 0) {
				switch (eq) {
				case 0:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Back.IN).target(
							el.getX(), el.getY() - 350)));
					break;
				case 1:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Bounce.IN).target(
							el.getX(), el.getY() - 350)));
					break;
				case 2:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Circ.IN).target(
							el.getX(), el.getY() - 350)));
					break;
				case 3:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Cubic.IN).target(
							el.getX(), el.getY() - 350)));
					break;
				case 4:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Elastic.IN).target(
							el.getX(), el.getY() - 350)));
					break;
				case 5:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Expo.IN).target(
							el.getX(), el.getY() - 350)));
					break;
				case 6:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Linear.INOUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 7:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Quad.IN).target(
							el.getX(), el.getY() - 350)));
					break;
				case 8:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Quart.IN).target(
							el.getX(), el.getY() - 350)));
					break;
				case 9:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Quint.IN).target(
							el.getX(), el.getY() - 350)));
					break;
				case 10:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Sine.IN).target(
							el.getX(), el.getY() - 350)));
					break;
				}
			}
			if (io == 1) {
				switch (eq) {
				case 0:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Back.OUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 1:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Bounce.OUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 2:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Circ.OUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 3:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Cubic.OUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 4:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Elastic.OUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 5:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Expo.OUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 6:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Linear.INOUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 7:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Quad.OUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 8:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Quart.OUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 9:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Quint.OUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 10:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Sine.OUT).target(
							el.getX(), el.getY() - 350)));
					break;
				}
			}
			if (io == 2) {
				switch (eq) {
				case 0:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Back.INOUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 1:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Bounce.INOUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 2:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Circ.INOUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 3:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Cubic.INOUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 4:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Elastic.INOUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 5:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Expo.INOUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 6:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Linear.INOUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 7:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Quad.INOUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 8:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Quart.INOUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 9:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Quint.INOUT).target(
							el.getX(), el.getY() - 350)));
					break;
				case 10:
					manager.add(TweenSerialGroup.create(Tween.to(te,
							TweenType.POSITION, 3000, Sine.INOUT).target(
							el.getX(), el.getY() - 350)));
					break;
				}
			}
			tmstart = true;
		}
		g.pushMatrix();
		if (tmstart == true)
			g.render(manager);
		if (tmstart2 == true)
			g.render(manager2);
		g.render(t_in);
		g.render(t_out);
		g.render(l1);
		g.render(l2);
		g.translate(350, 550);
		g.render(el);
		g.popMatrix();

		g.pushMatrix();
		g.translate(850, 618 + t.getHeight() / 2);
		g.render(r);
		g.popMatrix();

		g.pushMatrix();
		t.setText("Back");
		g.render(t);
		g.translate(0, -50);
		t.setText("Bounce");
		g.render(t);
		g.translate(0, -50);
		t.setText("Circ");
		g.render(t);
		g.translate(0, -50);
		t.setText("Cubic");
		g.render(t);
		g.translate(0, -50);
		t.setText("Elastic");
		g.render(t);
		g.translate(0, -50);
		t.setText("Expo");
		g.render(t);
		g.translate(0, -50);
		t.setText("Linear");
		g.render(t);
		g.translate(0, -50);
		t.setText("Quad");
		g.render(t);
		g.translate(0, -50);
		t.setText("Quart");
		g.render(t);
		g.translate(0, -50);
		t.setText("Quint");
		g.render(t);
		g.translate(0, -50);
		t.setText("Sine");
		g.render(t);
		g.popMatrix();
	}

	public static void main(String args[]) {
		AppletRunner.run("casmi.tween.TweenEquationsExample", "Example");
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
}
