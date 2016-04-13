import java.awt.*; 
import javax.swing.*;
	 
	 public class CTestFrame extends JFrame
	 {
			public CTestFrame()
			{
				setTitle("Collider Test");
				setSize(1366,768);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				add(new ColliderTester());
				setVisible(true);			
			}
	 }