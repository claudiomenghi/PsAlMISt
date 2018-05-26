/**
 * @author Cludio Menghi
 *  
 */
package se.got;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.ColorUIResource;

import se.got.ltl.LTLFormula;
import se.got.ltl.LTLIGlobally;
import se.got.ltl.atoms.LTLIPropositionalAtom;
import se.got.ltl.visitors.LTLFormulaToStringVisitor;
import se.got.panels.MissionLibraryPanel;
import se.got.panels.MissionLibraryRender;
import se.got.panels.PatternSelectionPanel;

public class Co4robotsGUI extends javax.swing.JFrame {

	private static final Color redCo4robots = new Color(157, 15, 0);
	private static final Color grayCo4robots = new Color(105, 105, 105);
	private static final Font font = new Font("Arial", Font.PLAIN, 16);
	private static final Font fonttitle = new Font("Arial", Font.BOLD, 16);

	public static DefaultListModel<String> missionLibraryModel = new DefaultListModel<>();
	public static JList<String> missionLibrary = new JList<String>();

	public static String currentMission = "";

	private static JTextField ipTextField;
	private static JTextField portTextField;
	private static JTextField publisherportTextField;

	private JPanel remotePanel;
	private javax.swing.JButton sendMission;

	private javax.swing.JButton stopMission;
	private javax.swing.JButton subscribe;

	public static JLabel selectedMissionJLabel;
	private javax.swing.JButton fEE;
	private javax.swing.JCheckBox fEName;
	private javax.swing.JCheckBox fESpec;
	private javax.swing.JTextArea fMapping;
	private javax.swing.JButton fNE;
	private javax.swing.JTextPane fSELP;
	private javax.swing.JButton fSEs;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;

	private javax.swing.JPanel patternJPanel;
	private javax.swing.JPanel optionJPanel;
	private javax.swing.JPanel jPanelLogo;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JPanel eventJPanel;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static String TITLE = "PsAlMISt: Pattern bAsed MIssion Specifier";
	private final static String SEND_MISSION = "Send mission";

	private static Subscriber sub;

	private final PatternSelectionPanel patternSelectionPanel;

	public final static Color BACKGROUNDCOLOR = Color.WHITE;

	public Co4robotsGUI(String ip, String port) {
		super();

		patternSelectionPanel = new PatternSelectionPanel();
		UIManager.put("ComboBox.background", new ColorUIResource(Color.WHITE));

		initComponents(ip, port);
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
	 */
	private void initComponents(String ip, String port) {
		setLayout(new BorderLayout());

		patternJPanel = new javax.swing.JPanel();
		optionJPanel = new javax.swing.JPanel();
		jPanelLogo = new javax.swing.JPanel();
		fEName = new javax.swing.JCheckBox();
		fESpec = new javax.swing.JCheckBox();
		this.sendMission = new javax.swing.JButton();
		this.subscribe = new javax.swing.JButton();
		jPanel5 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		fSELP = new javax.swing.JTextPane();
		jScrollPane2 = new javax.swing.JScrollPane();
		fMapping = new javax.swing.JTextArea();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		eventJPanel = new javax.swing.JPanel();
		fNE = new javax.swing.JButton();
		fSEs = new javax.swing.JButton();
		fEE = new javax.swing.JButton();
		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(optionJPanel);

		getContentPane().setBackground(BACKGROUNDCOLOR);
		patternJPanel.setBackground(BACKGROUNDCOLOR);
		optionJPanel.setBackground(BACKGROUNDCOLOR);
		jPanelLogo.setBackground(BACKGROUNDCOLOR);
		fEName.setBackground(BACKGROUNDCOLOR);
		fESpec.setBackground(BACKGROUNDCOLOR);
		jPanel5.setBackground(BACKGROUNDCOLOR);
		jScrollPane1.setBackground(BACKGROUNDCOLOR);
		fSELP.setBackground(BACKGROUNDCOLOR);
		jScrollPane2.setBackground(BACKGROUNDCOLOR);
		fMapping.setBackground(BACKGROUNDCOLOR);
		jLabel1.setBackground(BACKGROUNDCOLOR);
		jLabel2.setBackground(BACKGROUNDCOLOR);
		eventJPanel.setBackground(BACKGROUNDCOLOR);
		fNE.setBackground(BACKGROUNDCOLOR);
		fSEs.setBackground(BACKGROUNDCOLOR);
		fEE.setBackground(BACKGROUNDCOLOR);
		jPanelLogo.setBackground(Color.WHITE);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle(TITLE);
		setResizable(true);

		optionJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Options"));

		this.sendMission.setText(SEND_MISSION);
		this.subscribe.setText("Subscribe");

		this.sendMission.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				if (Co4robotsGUI.selectedMissionJLabel.getText().equals("No mission selected")) {
					JOptionPane.showMessageDialog(null, "No mission selected");
				} else {

					MissionSender sender = new MissionSender();
					try {
						LTLFormula f = LTLFormula.TRUE;
						for (int i = 0; i < PatternSelectionPanel.locationsModel.size(); i++) {
							for (int j = i + 1; j < PatternSelectionPanel.locationsModel.size(); j++) {

								if (i != j) {
									System.out.println(PatternSelectionPanel.locationsModel.getElementAt(i));
									f = LTLFormula.and(f,
											LTLFormula.not(LTLFormula.and(
													new LTLIPropositionalAtom(
															PatternSelectionPanel.locationsModel.getElementAt(i)),
													new LTLIPropositionalAtom(
															PatternSelectionPanel.locationsModel.getElementAt(j)))));
								}
							}
						}
						System.out.println(f);

						sender.send(

								LTLFormula.and(MissionLibrary.mapSpecificationFormula.get(Co4robotsGUI.currentMission),
										new LTLIGlobally(f)).accept(new LTLFormulaToStringVisitor()),
								ipTextField.getText(), portTextField.getText());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		});

		this.stopMission = new JButton("Stop mission");

		this.stopMission.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				MissionSender sender = new MissionSender();

				sender.send("stop",ipTextField.getText(), portTextField.getText());
			}

		});

		this.subscribe.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				sub = new Subscriber(ipTextField.getText(), Integer.parseInt(publisherportTextField.getText()),
						PatternSelectionPanel.availableActions, PatternSelectionPanel.actionsModel);
				Thread t = new Thread(sub);
				t.start();
			}
		});

		optionJPanel.setLayout(jPanel3Layout);

		jPanelLogo.setLayout(new BorderLayout());

		BufferedImage myPicture;
		try {
			// myPicture =
			// ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/co4robotsLogo.png"));
			myPicture = ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/PsAlMIStLogo.png"));

			// PsAlMIStLogo.png
			ImageIcon icon = new ImageIcon(myPicture);
			icon = new ImageIcon(icon.getImage().getScaledInstance(icon.getIconWidth() / 3, icon.getIconHeight() / 3,
					java.awt.Image.SCALE_SMOOTH));
			JLabel picLabel = new JLabel(icon);
			jPanelLogo.add(picLabel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// capturing the main panel
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(BACKGROUNDCOLOR);
		getContentPane().add(mainPanel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(mainPanel);
		// end capturing

		remotePanel = new JPanel();

		ipTextField = new JTextField(15);
		ipTextField.setText(ip);
		ipTextField.setColumns(15);

		portTextField = new JTextField(5);
		portTextField.setText("13000");

		publisherportTextField = new JTextField(5);
		publisherportTextField.setText("13001");

		JLabel ipLabel = new JLabel("IP:");
		ipLabel.setForeground(grayCo4robots);
		ipLabel.setFont(fonttitle);

		JLabel portLabel = new JLabel("Server PORT:");
		portLabel.setForeground(grayCo4robots);
		portLabel.setFont(fonttitle);

		JLabel publisherLabel = new JLabel("Publisher PORT:");
		publisherLabel.setForeground(grayCo4robots);
		publisherLabel.setFont(fonttitle);

		javax.swing.GroupLayout memotePalenlLayout = new javax.swing.GroupLayout(remotePanel);

		JPanel p1 = new JPanel();
		p1.setBackground(BACKGROUNDCOLOR);
		p1.add(ipTextField);

		JPanel p2 = new JPanel();
		p2.setBackground(BACKGROUNDCOLOR);
		p2.add(publisherportTextField);

		JPanel p3 = new JPanel();
		p3.setBackground(BACKGROUNDCOLOR);
		p3.add(portTextField);

		JLabel missionJLabel = new JLabel("Mission:");
		missionJLabel.setForeground(grayCo4robots);
		missionJLabel.setFont(fonttitle);

		selectedMissionJLabel = new JLabel("No mission selected");

		JPanel p4 = new JPanel();
		p4.setBackground(BACKGROUNDCOLOR);
		p4.add(missionJLabel);
		p4.add(selectedMissionJLabel);

		JPanel clientServer = new JPanel();
		clientServer.setBackground(BACKGROUNDCOLOR);
		FlowLayout f = new FlowLayout();

		clientServer.setLayout(f);
		clientServer.add(ipLabel);
		clientServer.add(p1);
		clientServer.add(portLabel);
		clientServer.add(p3);
		clientServer.add(this.sendMission);


		JPanel stopMissionPanel = new JPanel();
		stopMissionPanel.setBackground(BACKGROUNDCOLOR);

		FlowLayout f1 = new FlowLayout();

		stopMissionPanel.setLayout(f1);
		stopMissionPanel.add(this.stopMission);

		JPanel pubSub = new JPanel();
		pubSub.setBackground(BACKGROUNDCOLOR);
		FlowLayout pubsublayout = new FlowLayout();
		pubSub.setLayout(pubsublayout);
		pubSub.add(publisherLabel);
		pubSub.add(p2);
		pubSub.add(this.subscribe);

		memotePalenlLayout.setHorizontalGroup(memotePalenlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(memotePalenlLayout.createSequentialGroup().addComponent(p4))
				.addGroup(memotePalenlLayout.createSequentialGroup().addComponent(clientServer))
				.addGroup(memotePalenlLayout.createSequentialGroup().addComponent(stopMissionPanel))
				.addGroup(memotePalenlLayout.createSequentialGroup().addComponent(pubSub)));

		memotePalenlLayout.setVerticalGroup(memotePalenlLayout.createSequentialGroup()
				.addGroup(memotePalenlLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(p4))
				.addGroup(memotePalenlLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(clientServer))
				.addGroup(memotePalenlLayout.createSequentialGroup().addComponent(stopMissionPanel))
				.addGroup(memotePalenlLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(pubSub)));

		remotePanel.setLayout(memotePalenlLayout);

		remotePanel.setBackground(BACKGROUNDCOLOR);

		TitledBorder titleBorder = javax.swing.BorderFactory.createTitledBorder(null, "Robot network settings", 2, 2,
				font, redCo4robots);
		remotePanel.setBorder(titleBorder);

		missionLibrary.setCellRenderer(new MissionLibraryRender());
		missionLibrary.setBackground(grayCo4robots);
		missionLibrary.setForeground(Color.white);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(mainPanel);
		mainPanel.setLayout(layout);

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.createSequentialGroup();

		MissionLibraryPanel missionLibraryPanel = new MissionLibraryPanel(missionLibrary, missionLibraryModel);

		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(jPanelLogo)
				.addGroup(layout.createParallelGroup().addComponent(remotePanel).addComponent(patternSelectionPanel)
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(missionLibraryPanel))));

		layout.setVerticalGroup(layout.createSequentialGroup().addComponent(jPanelLogo).addComponent(remotePanel)
				.addComponent(patternSelectionPanel).addComponent(missionLibraryPanel));

		setBounds(0, 0, (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
				(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());

		this.getContentPane().setBackground(BACKGROUNDCOLOR);
		this.getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());

		setVisible(false);

		this.setBackground(BACKGROUNDCOLOR);
		this.getContentPane().setBackground(BACKGROUNDCOLOR);
		this.setResizable(true);
	}

	public static void main(String args[]) {
		/* Create and display the form */
		final String ip = args.length > 0 ? args[0] : "10.42.0.1";
		final String port = args.length > 0 ? args[1] : "13000";

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				(new Co4robotsGUI(ip, port)).showEditor();
			}
		});
	}

}
