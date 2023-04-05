
package Swing

import java.awt.BorderLayout;
import javax.swing.JFrame;
import com.equo.chromium.ChromiumBrowser;

class Swing constructor() : JFrame() {
    init {
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    val browser: ChromiumBrowser = ChromiumBrowser.swing(getContentPane(), BorderLayout.CENTER,
			    "https://docs.equo.dev/main/getting-started/introduction.html");
	    setTitle("Sample Swing");
	    setSize(800, 600);
	    setVisible(true);
    }
}

fun main() {
    Swing();
}
