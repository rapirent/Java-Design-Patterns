package imageProxy;

import java.net.URL;
import java.net.MalformedURLException;
import javax.swing.*;
import java.util.Hashtable;
import java.util.Enumeration;

public class ImageProxyTestDrive {
    protected ImageComponent imageComponent = null;
    protected Hashtable<String, String> cds = new Hashtable<String, String>();
    protected JMenuBar menuBar = null;
    protected JMenu menu = null;
    protected JFrame frame = null;
    public static void main (String[] args) throws Exception {
        ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
    }

    public ImageProxyTestDrive() throws Exception {
        cds.put("Karma", "https://m.media-amazon.com/images/I/71GxnVswKGL._SS500_.jpg");
        cds.put("The Last Stand", "https://m.media-amazon.com/images/I/81B2HUS2y7L._SS500_.jpg");

        frame = new JFrame("Album Cover Viewer");
        menuBar = new JMenuBar();
        menu = new JMenu("Favorite cds");
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        URL initialURL = new URL((String)cds.get("Karma"));
        //https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/Enumeration.html
        for (Enumeration<String> e = cds.keys(); e.hasMoreElements();) {
            String name = (String)e.nextElement();
            JMenuItem menuItem = new JMenuItem(name);
            menu.add(menuItem);
            //https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
            menuItem.addActionListener(event -> {
                imageComponent.setIcon(new ImageProxy(getAlbumUrl(event.getActionCommand())));
                frame.repaint();
            });
        }
        Icon icon = new ImageProxy(initialURL);
        imageComponent = new ImageComponent(icon);
        frame.getContentPane().add(imageComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    private URL getAlbumUrl(String name) {
        try {
            return new URL((String)cds.get(name));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
