import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import java.io.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
 
public class mp extends JFrame implements ActionListener  {
  private JTextArea ta = new JTextArea("", 0,0);
  private MenuBar menuBar = new MenuBar(); 
	private Menu file = new Menu();
	private Menu edit=new Menu();
	
	private MenuItem openFile = new MenuItem(); 
	private MenuItem saveFile = new MenuItem(); 
	private MenuItem close = new MenuItem(); 
	private MenuItem cut = new MenuItem(); 
	private MenuItem copy = new MenuItem(); 
	private MenuItem paste = new MenuItem(); 
	private MenuItem Selectall = new MenuItem(); 
	public mp() {
		this.setSize(500, 300); 
		this.setTitle("Java Notepad "); 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		this.ta.setFont(new Font("Century Gothic", Font.BOLD, 12)); 
		
		this.getContentPane().setLayout(new BorderLayout()); 
		this.getContentPane().add(ta);
 
		
		this.setMenuBar(this.menuBar);
		this.menuBar.add(this.file); 
		this.menuBar.add(this.edit); 
 
		
		this.file.setLabel("File");
		this.edit.setLabel("Edit");
		
 
		
		this.openFile.setLabel("Open"); 
		this.openFile.addActionListener(this); 
		this.openFile.setShortcut(new MenuShortcut(KeyEvent.VK_O, false));
		this.file.add(this.openFile); 
 
		
		this.saveFile.setLabel("Save");
		this.saveFile.addActionListener(this);
		this.saveFile.setShortcut(new MenuShortcut(KeyEvent.VK_S, false));
		this.file.add(this.saveFile);
 
		
		this.close.setLabel("Close");
		
		this.close.setShortcut(new MenuShortcut(KeyEvent.VK_F4, false));
		this.close.addActionListener(this);
		this.file.add(this.close);

		this.cut.setLabel("cut");
		this.cut.addActionListener(this);
		this.cut
		.setShortcut(new MenuShortcut(KeyEvent.VK_X, false));
		this.edit.add(this.cut);

		this.copy.setLabel("copy");
		this.copy.addActionListener(this);
		this.copy.setShortcut(new MenuShortcut(KeyEvent.VK_C, false));
		this.edit.add(this.copy);

		this.paste.setLabel("paste");
		this.paste.addActionListener(this);
		this.paste.setShortcut(new MenuShortcut(KeyEvent.VK_V, false));
		this.edit.add(this.paste);

		this.Selectall.setLabel("SelectAll");
		this.Selectall.addActionListener(this);
		this.Selectall.setShortcut(new MenuShortcut(KeyEvent.VK_A, false));
		this.edit.add(this.Selectall);

	}
 
	public void actionPerformed (ActionEvent e) {
		
		if (e.getSource() == this.close)
			this.dispose(); 
 
		
		else if (e.getSource() == this.openFile) {
			JFileChooser open = new JFileChooser(); 
			int option = open.showOpenDialog(this); 
			
			if (option == JFileChooser.APPROVE_OPTION) {
				this.ta.setText(""); 
				try {
					
					Scanner scan = new Scanner(new FileReader(open.getSelectedFile().getPath()));
					while (scan.hasNext())
						this.ta.append(scan.nextLine() + "\n"); 
				} catch (Exception ex) { 
					System.out.println(ex.getMessage());
				}
			}
		}
 
		
		else if (e.getSource() == this.saveFile) {
			JFileChooser save = new JFileChooser(); 
			int option = save.showSaveDialog(this); 
			if (option == JFileChooser.APPROVE_OPTION) {
				try {
					
					BufferedWriter out = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
					out.write(this.ta.getText()); 
					out.close(); 
				} catch (Exception ex) { 
					System.out.println(ex.getMessage());
				}
			}
		}
		else if(e.getSource()==cut){
			ta.cut();
		}
		else if(e.getSource()==paste){
			ta.paste();
		}
		else if(e.getSource()==copy){
			ta.copy();
		}
		else if(e.getSource()==Selectall){
			ta.selectAll();
		}
		
}
	
   
	public static void main(String args[]) {
        mp np = new mp();
        np.setVisible(true);
	
	
}
 }
    

