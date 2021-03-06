/**
 * @author Cludio Menghi
 *  
 */
package se.gu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.plaf.ColorUIResource;

import se.gu.gui.panels.CurrentMissionPanel;
import se.gu.gui.panels.MissionLibraryPanel;
import se.gu.gui.panels.PatternSelectionPanel;
import se.gu.model.RobotLibrary;
import se.gu.model.Workspace;

public class Co4robotsGUI extends javax.swing.JFrame {

	public static final Color REDCO4ROBOTS = new Color(157, 15, 0);
	public static final Color GRAYCO4ROBOTS = new Color(105, 105, 105);
	public static final Font FONT = new Font("Arial", Font.PLAIN, 16);
	public static final Font FONTTITLE = new Font("Arial", Font.BOLD, 16);

	private Workspace model;

	public static JTabbedPane tabbedPane;
	private javax.swing.JPanel patternJPanel;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static String TITLE = "PsAlM: Pattern bAsed MIssion Specifier";

	private static Subscriber sub;

	public final static Color BACKGROUNDCOLOR = Color.WHITE;

	public Co4robotsGUI() throws IOException {
		super();

		this.model = Workspace.getModel();
		UIManager.put("ComboBox.background", new ColorUIResource(Color.WHITE));

		initComponents();
		System.out.println("GUI loaded");

	}

	public void showEditor() {
		setLocationRelativeTo(null); // center?
		setVisible(true);

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 * 
	 * @throws IOException
	 */
	private void initComponents() throws IOException {
		setLayout(new BorderLayout());

		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);

		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		JMenuItem loadRobotLibrary = new JMenuItem("Load robot library");

		loadRobotLibrary.setBorder(new EmptyBorder(0, 10, 0, 10));
		fileMenu.add(loadRobotLibrary);

		loadRobotLibrary.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setDialogTitle("Select the file containing the robot library: ");
				jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					if (jfc.getSelectedFile().isFile()) {
						System.out.println("You  the file: " + jfc.getSelectedFile());
						RobotLibrary l = RobotLibrary.loadRobotLibrary(jfc.getSelectedFile().getPath());
						l.setPath(jfc.getSelectedFile().getParentFile().toString());
						System.out.println(l);
						model.setRobotLibrary(l);

					}
				}

			}
		});


	
		patternJPanel = new javax.swing.JPanel();

		getContentPane().setBackground(BACKGROUNDCOLOR);
		patternJPanel.setBackground(BACKGROUNDCOLOR);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle(TITLE);

		setResizable(true);

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Co4robotsGUI.BACKGROUNDCOLOR);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(mainPanel);
		mainPanel.setLayout(layout);

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.createSequentialGroup();

		setBounds(0, 0, (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
				(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());

		this.getContentPane().setBackground(BACKGROUNDCOLOR);
		this.getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

		this.getContentPane().add(mainPanel);
		setVisible(false);

		this.setBackground(BACKGROUNDCOLOR);
		
		CurrentMissionPanel currentMissionPanel= new CurrentMissionPanel(model, "Robot");
		this.getContentPane().add(currentMissionPanel);
		
		
		
		this.getContentPane().setBackground(BACKGROUNDCOLOR);
		this.setResizable(true);
		
		model.addAction("call_for_loading");
		model.addAction("call_for_unloading");
		model.addAction("col_loading");
		model.addAction("col_unloading");
		
		model.addLocation("l1");
		model.addLocation("l2");
		model.addLocation("l3");
		model.addLocation("l4");

	}

	public static void main(String args[]) throws IOException {
		/* Create and display the form */

		Co4robotsGUI c4gui = new Co4robotsGUI();
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				(c4gui).showEditor();
			}
		});

	}

}
