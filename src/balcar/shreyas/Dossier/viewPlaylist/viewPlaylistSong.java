package balcar.shreyas.Dossier.viewPlaylist;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import balcar.shreyas.Dossier.MainMenu.MainMenu;

public class viewPlaylistSong extends JFrame {

	private JPanel contentPane;
	private DefaultListModel listModel;

	 viewPlaylistSong() {
		
		setBounds(100, 100, 300, 509);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 264, 360);
		contentPane.add(scrollPane);
		
		
		
		listModel = new DefaultListModel();

		 File f = new File("C:/Users/s07994809/Desktop/workspace/Dossier Project/PlayList/" + viewPlaylist.selectedPlaylist+".txt");
		
		 
		 Scanner sc = null;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
			List<String> lines = new ArrayList<String>();
			while (sc.hasNextLine()) {
			  lines.add(sc.nextLine());
			}

			final String[] arr = lines.toArray(new String[0]);
		
			
		
		
			for(String a : arr){
				
				String str = (a.substring(0, a.length()-4));
				listModel.addElement(str);
			}
		
		sc.close();
		final JList list = new JList(listModel);
		
		
		
		
		/*list.setModel(new AbstractListModel() {
			
			public int getSize() {
				return arr.length;
			}
			public Object getElementAt(int index) {
				return arr[index];
			}
		});
		*/
		scrollPane.setViewportView(list);
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("View Songs\r\n\r\n");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 249, 26);
		contentPane.add(lblNewLabel);
		
		
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(150, 437, 89, 23);
		contentPane.add(btnPlay);
		System.out.println(viewPlaylist.selectedPlaylist);
		JLabel playListName = new JLabel(viewPlaylist.selectedPlaylist);
		playListName.setHorizontalAlignment(SwingConstants.CENTER);
		playListName.setBounds(10, 41, 249, 14);
		contentPane.add(playListName);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println(list.getSelectedValue());
				if(list.getSelectedValue() == null){
					JOptionPane.showMessageDialog(null, "You did not select a Song!");
					
				}else {
					
					
					
					
					listModel.remove(list.getSelectedIndex());
				
				
					File f = new File("C:/Users/s07994809/Desktop/workspace/Dossier Project/PlayList/" + viewPlaylist.selectedPlaylist+".txt");
				
					 PrintWriter writer;
						try {
							
							
							if (!f.exists()) {
								// Create the file
								f.createNewFile();
								
							}
							writer = new PrintWriter(f, "UTF-8");
				

						for(int i = 0; i< listModel.getSize(); i++){
							writer.print(listModel.getElementAt(i));
							writer.println();
							System.out.println(listModel.getElementAt(i));
						}
							
							
							writer.close();
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
				
				}
				
			}
		});
		btnDelete.setBounds(20, 437, 89, 23);
		contentPane.add(btnDelete);
		setVisible(true);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
	
	
		
	 
	 
	 
	 }
}
