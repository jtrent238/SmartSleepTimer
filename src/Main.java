//Andrew Shay
//http://shayConcepts.com
//v1.0.1
//Changes:
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Timer;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;


public class Main {

	private JFrame frmHolder;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmHolder.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		try {
	        // Set System L&F
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	    	JOptionPane.showMessageDialog(null,
			        "UnsupportedLookAndFeel: " + e,
			        "Error",
			        JOptionPane.ERROR_MESSAGE);
	    }
	    catch (ClassNotFoundException e) {
	    	JOptionPane.showMessageDialog(null,
			        "ClassNotFound: " + e,
			        "Error",
			        JOptionPane.ERROR_MESSAGE);
	    }
	    catch (InstantiationException e) {
	    	JOptionPane.showMessageDialog(null,
			        "Instantiation: " + e,
			        "Error",
			        JOptionPane.ERROR_MESSAGE);
	    }
	    catch (IllegalAccessException e) {
	    	JOptionPane.showMessageDialog(null,
			        "IllegalAcess: " + e,
			        "Error",
			        JOptionPane.ERROR_MESSAGE);
	    }
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private static JRadioButton rdbtnSleep;
	private static JRadioButton rdbtnHibernate;
	private static JRadioButton rdbtnShutDown;
	@SuppressWarnings("rawtypes")
	private JComboBox hourBox;
	@SuppressWarnings("rawtypes")
	private JComboBox minuteBox;
	@SuppressWarnings("rawtypes")
	private JComboBox ampmBox;
	@SuppressWarnings("rawtypes")
	private JComboBox dayBox;
	private Calendar date;
	private JButton btnQuestion;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmHolder = new JFrame();
		frmHolder.setResizable(false);
		frmHolder.setTitle(getProgramName());
		frmHolder.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/icon.png")));
		frmHolder.setBounds(100, 100, 272, 346);
		frmHolder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHolder.getContentPane().setLayout(null);
		
		rdbtnSleep = new JRadioButton("Sleep");
		rdbtnSleep.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rdbtnHibernate.setSelected(false);
				rdbtnShutDown.setSelected(false);
				rdbtnSleep.setSelected(true);
			}
		});
		rdbtnSleep.setBounds(6, 7, 109, 23);
		frmHolder.getContentPane().add(rdbtnSleep);
		
		rdbtnHibernate = new JRadioButton("Hibernate");
		rdbtnHibernate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnSleep.setSelected(false);
				rdbtnShutDown.setSelected(false);
				rdbtnHibernate.setSelected(true);
			}
		});
		rdbtnHibernate.setBounds(6, 33, 109, 23);
		frmHolder.getContentPane().add(rdbtnHibernate);
		
		rdbtnShutDown = new JRadioButton("Shut Down");
		rdbtnShutDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnSleep.setSelected(false);
				rdbtnHibernate.setSelected(false);
				rdbtnShutDown.setSelected(true);
			}
		});
		rdbtnShutDown.setBounds(6, 59, 109, 23);
		frmHolder.getContentPane().add(rdbtnShutDown);
		
		hourBox = new JComboBox();
		hourBox.setModel(new DefaultComboBoxModel(new String[] {"Hour", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		hourBox.setBounds(6, 89, 94, 20);
		frmHolder.getContentPane().add(hourBox);
		
		//This for loop will create all the minutes
		String[] minutes = new String[61];
		minutes[0] = "Minute";
		for(int i = 0; i < 60; i++){
			minutes[i+1] = Integer.toString(i);
		}
		
		minuteBox = new JComboBox();
		minuteBox.setModel(new DefaultComboBoxModel(minutes));
		minuteBox.setBounds(161, 89, 94, 20);
		frmHolder.getContentPane().add(minuteBox);
		
		ampmBox = new JComboBox();
		ampmBox.setModel(new DefaultComboBoxModel(new String[] {"PM", "AM"}));
		ampmBox.setBounds(6, 120, 94, 20);
		frmHolder.getContentPane().add(ampmBox);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(hourBox.getSelectedIndex() == 0 || minuteBox.getSelectedIndex() == 0){
					JOptionPane.showMessageDialog(null,
					        "Select and hour and minute",
					        "Error",
					        JOptionPane.ERROR_MESSAGE);
				}
				else if(rdbtnSleep.isSelected() == false && rdbtnHibernate.isSelected() == false && rdbtnShutDown.isSelected() == false){
					System.out.println("error2");
					JOptionPane.showMessageDialog(null,
					        "Select: Sleep, Hibernate, or ShutDown",
					        "Error",
					        JOptionPane.ERROR_MESSAGE);
				}
				else{
					//Create the new calendar and timer
					Timer timer = new Timer();
				    date = Calendar.getInstance();
				    
				    
				    if(dayBox.getSelectedItem().equals("Monday")){
				    	date.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
					}
				    
				    else if(dayBox.getSelectedItem().equals("Tuesday")){
				    	date.set(Calendar.DAY_OF_WEEK,Calendar.TUESDAY);
					}
				    
				    else if(dayBox.getSelectedItem().equals("Wednesday")){
				    	date.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
					}
				    
				    else if(dayBox.getSelectedItem().equals("Thursday")){
				    	date.set(Calendar.DAY_OF_WEEK,Calendar.THURSDAY);
					}
				    
				    else if(dayBox.getSelectedItem().equals("Friday")){
				    	date.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
					}
				    
				    else if(dayBox.getSelectedItem().equals("Saturday")){
				    	date.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
					}
				    
				    else if(dayBox.getSelectedItem().equals("Sunday")){
				    	date.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
					}
				    else{
				    	System.out.println("Error One");
				    }
				    
				    if(ampmBox.getSelectedItem().equals("PM")){
				    	date.set(Calendar.AM_PM,Calendar.PM);
				    } 
				    
				    else if(ampmBox.getSelectedItem().equals("AM")){
				    	date.set(Calendar.AM_PM,Calendar.AM);
				    }  
				    else{
				    	System.out.println("Error Two");
				    }
				    
				    //This will set the hour to 0, if the user chose 12
				    int hour;
				    if(Integer.parseInt((String) hourBox.getSelectedItem()) == 12){
				    	hour = 0;
				    }
				    else{
				    	hour = Integer.parseInt((String) hourBox.getSelectedItem());
				    }
				    
				    date.set(Calendar.HOUR, hour);
				    date.set(Calendar.MINUTE, Integer.parseInt((String)minuteBox.getSelectedItem()));
				    date.set(Calendar.SECOND, 0);
				    date.set(Calendar.MILLISECOND, 0);
				 
  
				    timer.schedule(new SetTime(),date.getTime());
				    
				    if(getState() == 1){
				    	JOptionPane.showMessageDialog(null,
						        "Your system will Sleep",
						        "Sleep",
						        JOptionPane.INFORMATION_MESSAGE);
					}
					
					else if(getState() == 2){
						JOptionPane.showMessageDialog(null,
						        "Your system will Hibernate",
						        "Hibernate",
						        JOptionPane.INFORMATION_MESSAGE);
					}
					
					else if(getState() == 3){
						JOptionPane.showMessageDialog(null,
						        "Your system will Shut Down",
						        "Shut Down",
						        JOptionPane.INFORMATION_MESSAGE);
					}
				    
				}
			}
		});
		btnStart.setBounds(86, 151, 89, 23);
		frmHolder.getContentPane().add(btnStart);
		
		dayBox = new JComboBox();
		dayBox.setModel(new DefaultComboBoxModel(new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}));
		dayBox.setBounds(161, 120, 94, 20);
		frmHolder.getContentPane().add(dayBox);
		
		JButton btnSleepnow = new JButton("Sleep Now");
		btnSleepnow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				States.Sleepy();     	
			}
		});
		btnSleepnow.setBounds(6, 279, 115, 23);
		frmHolder.getContentPane().add(btnSleepnow);
		
		JButton btnHibernateNow = new JButton("Hibernate Now");
		btnHibernateNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				States.Hibernate();
			}
		});
		btnHibernateNow.setBounds(140, 279, 115, 23);
		frmHolder.getContentPane().add(btnHibernateNow);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 183, 245, 85);
		frmHolder.getContentPane().add(scrollPane);
		
		JTextPane txtpnMessage = new JTextPane();
		txtpnMessage.setText("*Note*\r\nThis program runs a command to Sleep and Hibernate. In Windows, in order to Hibernate, Sleep must be disabled. In order to Sleep, Hibernate must be disabled.  This program will automatically enable and disable what is needed. You must run this program as Administrator.");
		scrollPane.setViewportView(txtpnMessage);
		
		btnQuestion = new JButton("");
		btnQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					AboutWindow about = new AboutWindow();
					about.frmAboutSystemState.setVisible(true);
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnQuestion.setBorderPainted(false);
		btnQuestion.setContentAreaFilled(false);
		btnQuestion.setIcon(new ImageIcon(Main.class.getResource("/info.png")));
		btnQuestion.setBounds(225, 7, 34, 32);
		frmHolder.getContentPane().add(btnQuestion);
	}
	
	public static String getProgramName(){
		return "Smart Sleep Timer";
	}
	
	public static int getState(){
		if(rdbtnSleep.isSelected()){
			return 1;
		}
		
		else if(rdbtnHibernate.isSelected()){
			return 2;
		}
		
		else if(rdbtnShutDown.isSelected()){
			return 3;
		}
		else{
			return 1;
		}
	}
}
