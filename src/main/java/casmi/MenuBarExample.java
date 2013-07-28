package casmi;

import casmi.callback.MenuItemSelectCallback;
import casmi.graphics.color.ColorSet;
import casmi.graphics.element.Text;
import casmi.graphics.element.TextAlign;


/**
 * @author takashi
 *
 */
public class MenuBarExample extends Applet {

    Text text = new Text("Select MenuBar");
    Callback callback = new Callback();

    class Callback implements MenuItemSelectCallback {

        @Override
        public void run(MenuItem menuItem) {
            text.setText(menuItem.getTitle());
        }
    }

    @Override
    public void setup() {
        setSize(400, 300);

        text.setPosition(200, 150);
        text.setAlign(TextAlign.CENTER);
        text.setStrokeColor(ColorSet.WHITE);
        addObject(text);

        MenuBar menuBar = new MenuBar();

        Menu menu1 = new Menu("File");

        MenuItem item1 = new MenuItem("New");
        item1.addSelectCallback(callback);
        menu1.addMenuItem(item1);

        MenuItem item2 = menu1.addMenuItem("Open File...");
        item2.addSelectCallback(callback);

        menu1.addSeparator();

        MenuItem item3 = new MenuItem("Close");
        item3.addSelectCallback(callback);
        menu1.addMenuItem(item3);
        menuBar.addMenu(menu1);

        menuBar.addMenu(new Menu("Edit"));
        menuBar.addMenu(new Menu("Source"));

        setMenuBar(menuBar);
    }

    @Override
    public void update() {}

    @Override
    public void exit() {}

    @Override
    public void mouseEvent(MouseEvent event, MouseButton button, Mouse mouse) {}

    @Override
    public void keyEvent(KeyEvent event, Keyboard keyboard) {}

    public static void main(String[] args) {
        AppletRunner.run("casmi.MenuBarExample", "MenuBarExample");
    }
}
