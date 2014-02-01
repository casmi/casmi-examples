package casmi.ui;

import java.net.URL;

import casmi.Applet;
import casmi.AppletRunner;
import casmi.KeyEvent;
import casmi.Keyboard;
import casmi.Mouse;
import casmi.MouseButton;
import casmi.MouseEvent;


public class SystemTrayMenuExample extends Applet {

	private URL getTrayIcon() {
		String osName = System.getProperty("os.name");

		if (osName.startsWith("Windows")) {
			return this.getClass().getResource("/casmi/tray_icon_win.png");
		} else if (osName == "Mac OS X"){
			return this.getClass().getResource("/casmi/tray_icon_mac.png");
		} else {
			return this.getClass().getResource("/casmi/tray_icon.png");
		}
	}

    @Override
    public void setup() {
        SystemTrayMenu tray = new SystemTrayMenu(getTrayIcon(), "System Tray Example");
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

        tray.show();
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
