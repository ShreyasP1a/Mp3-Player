package balcar.shreyas.Dossier.allSongs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import balcar.shreyas.Dossier.playSongs.playSongs;
import balcar.shreyas.Dossier.viewPlaylist.viewPlaylist;

public class allSongs extends JFrame {
	public static String selectedSong;

	private DefaultListModel listModel;
	public static int selectedSongIndex;
	

	private JPanel contentPane;

	
	public allSongs() {
		
		setBounds(100, 100, 350, 487);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("                    All Songs");
		lblNewLabel.setBounds(10, 11, 314, 28);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		File f =new File ("C:/Users/s07994809/Desktop/workspace/Dossier Project/music/");
		final ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 70, 279, 331);
		contentPane.add(scrollPane);
		final String[] values = names.toArray(new String[names.size()]);
		
		
		listModel = new DefaultListModel();
					
		
		
		
		for(String a : values){
			
			String str = (a.substring(0, a.length()-4));
			listModel.addElement(str);
		}
		
		
		
		
		
		final JList list = new JList(listModel);
		scrollPane.setViewportView(list);
		/*list.setModel(new AbstractListModel() {
			
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		*/
		
		
		JButton btnNewButton = new JButton("Play\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(list.getSelectedIndex()==-1){
					JOptionPane.showMessageDialog(null, "Please select a song!");
				}else{
				selectedSong = (String) list.getModel().getElementAt(list.getSelectedIndex());
				
				
				selectedSongIndex = list.getSelectedIndex();
				

				
				new playSongs();
				}
				}
		});
		btnNewButton.setBounds(220, 412, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnDeleteSong = new JButton("Delete Song\r\n");
		btnDeleteSong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.getSelectedValue() == null){
					JOptionPane.showMessageDialog(null, "You did not select a Song!");
				}else {
					
					
					
					
					Path path = Paths.get( "C:/Users/s07994809/Desktop/workspace/Dossier Project/Music/"+ list.getSelectedValue() +".mp3");
					try {
						 Files.delete(path);
						 System.out.println(true);
						//list.remove(list.getSelectedIndex());
						listModel.remove(list.getSelectedIndex());
						
	
						
						File f =new File ("C:/Users/s07994809/Desktop/workspace/Dossier Project/PlayList/");
						final ArrayList<String> playList = new ArrayList<String>(Arrays.asList(f.list()));
						final String[] array = playList.toArray(new String[playList.size()]);
						
						
						
						for(int i = 0; i < array.length;i++){
						
						File songs = new File("C:/Users/s07994809/Desktop/workspace/Dossier Project/PlayList/" + array[i]);
						
						 
						 Scanner sc = null;
						try {
							sc = new Scanner(songs);
						} catch (FileNotFoundException z) {
							// TODO Auto-generated catch block
							z.printStackTrace();
						}
						 
						 
							List<String> lines = new ArrayList<String>();
							while (sc.hasNextLine()) {
							  lines.add(sc.nextLine());
							}

							final String[] arr = lines.toArray(new String[0]);
						
							for(int j = 0; i< arr.length;i++){
									String a = arr[i];
									
									if(a.equals(list.getSelectedValue())){
										arr[i] = null;
									}
									
							}
							
							
						}	
						
						
						
						
						
						
						
					} catch (IOException t) {
						// TODO Auto-generated catch block
						t.printStackTrace();
					}
				}
			}
		});
		btnDeleteSong.setBounds(30, 412, 110, 23);
		contentPane.add(btnDeleteSong);
		setVisible(true);
	}
}
