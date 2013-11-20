package casmi.ui;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.Keyboard;
import casmi.Mouse;
import casmi.MouseButton;
import casmi.MouseEvent;


public class SystemTrayMenuExample extends Applet {

    @Override
    public void setup() {
        SystemTrayMenu tray = new SystemTrayMenu(this.getClass().getResource("/casmi/tray_icon.png"), "System Tray Example");
        tray.addMenuItem("Hello", new SystemTrayMenuActionListener() {
            @Override
            public void performed() {
                System.out.println("Hello World");
            }
        });

        tray.addSeparator();

        tray.addMenuItem("Exit", new SystemTrayMenuActionListener() {
            @Override
            public void performed() {
                System.exit(0);
            }
        });
    }

    @Override
    public void update() {

    }

    @Override
    public void exit() {

    }

    @Override
    public void mouseEvent(MouseEvent event, MouseButton button, Mouse mouse) {

    }

    @Override
    public void keyEvent(KeyEvent event, Keyboard keyboard) {

    }

    public static void main(String[] args) {
        AppletRunner.run("casmi.ui.SystemTrayMenuExample", "SystemTrayMenuExample");
    }
}
