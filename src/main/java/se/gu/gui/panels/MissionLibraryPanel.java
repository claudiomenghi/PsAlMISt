package se.gu.gui.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import se.gu.Co4robotsGUI;
import se.gu.model.Workspace;

public class MissionLibraryPanel extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String currentMission = "";

	public final static Color BACKGROUNDCOLOR = Color.WHITE;

	private JPanel missionLibraryPanel = new JPanel();

	private JButton loadLibrary = new JButton("Load mission library");

	private JButton saveLibrary = new JButton("Save mission library");

	private JButton selectMission = new JButton("Select mission");

	private JPanel missionLibraryAction = new JPanel();

	private DefaultListModel<String> missionLibraryModel;

	private Workspace model;

	private JList<String> missionLibrary;

	private CurrentMissionPanel currentMissionPanel;

	public MissionLibraryPanel(CurrentMissionPanel currentMissionPanel, PatternSelectionPanel patternSelectionPanel,
			Workspace model, String robotName) {

		super();
		this.setName(robotName);
		this.model = model;

		this.currentMissionPanel = currentMissionPanel;
		missionLibrary = new JList<>();

		missionLibraryModel = new DefaultListModel<String>();
		final Workspace tmpModel = model;
		TitledBorder missionLibraryBorder = javax.swing.BorderFactory.createTitledBorder(null, "Missions Library", 2, 2,
				Co4robotsGUI.FONT, Co4robotsGUI.REDCO4ROBOTS);

		missionLibraryPanel.setBorder(missionLibraryBorder);
		missionLibraryPanel.setBackground(Co4robotsGUI.BACKGROUNDCOLOR);

		JPanel p = new JPanel();

		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

		JScrollPane scrollPane_1 = new JScrollPane(missionLibrary);

		p.add(scrollPane_1);
		p.setBackground(Co4robotsGUI.GRAYCO4ROBOTS);

		missionLibraryPanel.setLayout(new BoxLayout(missionLibraryPanel, BoxLayout.Y_AXIS));

		missionLibraryPanel.add(p);

		this.setLayout(new BorderLayout());

		missionLibraryAction.add(loadLibrary);
		missionLibraryAction.add(saveLibrary);
		missionLibraryAction.add(selectMission);

		missionLibrary.setBackground(Co4robotsGUI.GRAYCO4ROBOTS);

		saveLibrary.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				JFileChooser fc = new JFileChooser();

				fc.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
				fc.showSaveDialog(missionLibraryPanel);

				String path = fc.getSelectedFile().getAbsolutePath();

				FileOutputStream out;
				try {
					out = new FileOutputStream(path);
					ObjectOutputStream o = new ObjectOutputStream(out);

					o.writeObject(tmpModel);
					o.close();
					out.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		selectMission.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				currentMissionPanel.setCurrentMission(missionLibrary.getSelectedValue());

			}
		});

		this.add(missionLibraryPanel, BorderLayout.CENTER);
		this.add(missionLibraryAction, BorderLayout.EAST);

		missionLibrary.setForeground(Co4robotsGUI.GRAYCO4ROBOTS);
		this.setBackground(Co4robotsGUI.REDCO4ROBOTS);
		missionLibraryAction.setLayout(new BoxLayout(missionLibraryAction, BoxLayout.PAGE_AXIS));

		missionLibraryAction.setBackground(Co4robotsGUI.BACKGROUNDCOLOR);
		missionLibrary.setBackground(Co4robotsGUI.GRAYCO4ROBOTS);
		this.missionLibrary.setCellRenderer(new MissionLibraryRender());
		this.missionLibrary.setModel(missionLibraryModel);
	}

	@Override
	public void update(Observable o, Object arg) {

	
		this.missionLibrary.setCellRenderer(new MissionLibraryRender());
		
		this.missionLibraryModel=new DefaultListModel<String>();

		for (String e : model.getMissions()) {
			missionLibraryModel.addElement(e);

			
		}
		this.missionLibrary.setModel(missionLibraryModel);
		this.missionLibrary.repaint();
	}

}
