package balcar.shreyas.Dossier.createPlaylist;

import java.awt.Font;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import balcar.shreyas.Dossier.MainMenu.MainMenu;

public class createPlaylist extends JFrame {

	private JPanel contentPane;
	java.util.List selectedValuesList;


	public createPlaylist() {
		setLocationRelativeTo(null);
		setBounds(100, 100, 350, 500);
		
		
		
		JOptionPane.showMessageDialog(null, "To select multiple songs just hold control(Ctrl) and select all of the songs that you want to have in your playlist");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("            Create a Playlist\r\n");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(0, 11, 324, 22);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel(MainMenu.playlistName);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.ITALIC, 15));
		label.setBounds(91, 44, 173, 22);
		contentPane.add(label);
		
		
		final String OS = System.getProperty("os.name").toUpperCase();
		
		
		
		
		
		
		
		File f = null;
		
		
		if(OS.equals("WINDOWS 7")){
		 f =new File ("C:/Users/s07994809/Desktop/workspace/Dossier-Project/music/");
		
		}else {
			 f =new File ("/Users/shreyas/Desktop/Dossier-Project/music/");

		}
		 
		 
		 final ArrayList<String> names = new ArrayList<String>(Arrays.asList(f.list()));	
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 77, 261, 333);
		contentPane.add(scrollPane);
		
		
		final String[] values = names.toArray(new String[names.size()]);
		
		
		
		
		
		
		
		
		
		
		for(int i = 0; i < values.length; i++){
			String test = values[i];
			if(test.startsWith(".")) {
				values[i] = null;
			}
		}
		final JList<String> list = new JList<String>();
		scrollPane.setViewportView(list);
		list.setModel(new AbstractListModel() {
			
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
	list.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                selectedValuesList = list.getSelectedValuesList();
               
            }
        }
    });
		
		
		
		
		
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int a;
				 a = JOptionPane.showConfirmDialog(null, "Are you sure this is all of the songs in your playlist? ");
				 if(a ==0){
					 dispose();
					 PrintWriter writer;
					try {
						File f = new File("PlayList/" + MainMenu.playlistName + ".txt");
						
						if (!f.exists()) {
							// Create the file
							f.createNewFile();
							
						}
						writer = new PrintWriter(f, "UTF-8");
						
						Object[] array = selectedValuesList.toArray();

						System.out.println("*** iterating over the array ***");
						for (Object str : array) {
							
							writer.print(str);
							writer.println();
							System.out.println(str);
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
				
					
				 }else {
					 
				 }
			}
		});
		btnOk.setBounds(121, 428, 89, 23);
		contentPane.add(btnOk);
		
		
		
	}
}