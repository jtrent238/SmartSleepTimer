//Andrew Shay
//http://shayconcepts.com
//v 1.0.0
//Changes: 
import java.awt.Desktop;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class AboutWindow {

	JFrame frmAboutSystemState;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AboutWindow window = new AboutWindow();
					window.frmAboutSystemState.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws URISyntaxException 
	 */
	public AboutWindow() throws URISyntaxException {
		try {
	        // Set System L&F
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws URISyntaxException 
	 */
	private void initialize() throws URISyntaxException {
		frmAboutSystemState = new JFrame();
		frmAboutSystemState.setResizable(false);
		frmAboutSystemState.setIconImage(Toolkit.getDefaultToolkit().getImage(AboutWindow.class.getResource("/icon.png")));
		frmAboutSystemState.setTitle("About " + Main.getProgramName());
		frmAboutSystemState.setBounds(100, 100, 450, 207);
		frmAboutSystemState.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAboutSystemState.getContentPane().setLayout(null);
		
		JLabel lblComicdownloaderheader = new JLabel(Main.getProgramName());
		lblComicdownloaderheader.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblComicdownloaderheader.setBounds(177, 11, 216, 25);
		frmAboutSystemState.getContentPane().add(lblComicdownloaderheader);
		
		JLabel label = new JLabel("1.0.1");
		label.setBounds(180, 47, 46, 14);
		frmAboutSystemState.getContentPane().add(label);
		
		JLabel lblCreatedby = new JLabel("created by Andrew Shay");
		lblCreatedby.setBounds(180, 82, 206, 14);
		frmAboutSystemState.getContentPane().add(lblCreatedby);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(AboutWindow.class.getResource("/logo.png")));
		lblLogo.setBounds(10, 11, 157, 147);
		frmAboutSystemState.getContentPane().add(lblLogo);
		

		final URI uri = new URI("http://shayConcepts.com");
		
		JLabel lblHi = new JLabel("<html><a href=\"http://shayConcepts.com\">http://shayConcepts.com</a></html>");
		lblHi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				open(uri);
			}
		});
		lblHi.setBounds(180, 64, 179, 14);
		frmAboutSystemState.getContentPane().add(lblHi);
	}

	public static void open(final URI uri) {
	    if (Desktop.isDesktopSupported()) {
	      try {
	        Desktop.getDesktop().browse(uri);
	      } catch (IOException e) { 
	    	  JOptionPane.showMessageDialog(null,
				        "About Window 2: " + e,
				        "Error",
				        JOptionPane.ERROR_MESSAGE);
	      }
	    } else { 
	    	JOptionPane.showMessageDialog(null,
			        "Cannot launch website",
			        "Error",
			        JOptionPane.ERROR_MESSAGE);
	    }
	  }
}
