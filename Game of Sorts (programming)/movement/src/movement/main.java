/**
 * 
 */
package movement;
import javax.swing.*;
import java.awt.*;

/**
 * @author curso
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Game window = new Game();

		
	    Thread t1 = new Thread(window);
	    t1.start();
	    
		
		
	}

}
