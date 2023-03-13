//Jesse McNary 2023
package gui;

import store.*;
import java.util.*;

import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;

import javax.swing.JFrame;           // for main window
import javax.swing.JOptionPane;      // for standard dialogs
// import javax.swing.JDialog;          // for custom dialogs (for alternate About dialog)
import javax.swing.JMenuBar;         // row of menu selections
import javax.swing.JMenu;            // menu selection that offers another menu
import javax.swing.JMenuItem;        // menu selection that does something
import javax.swing.JToolBar;         // row of buttons under the menu
import javax.swing.JButton;          // regular button
import javax.swing.JToggleButton;    // 2-state button
import javax.swing.BorderFactory;    // manufacturers Border objects around buttons
import javax.swing.Box;              // to create toolbar spacer
import javax.swing.UIManager;        // to access default icons
import javax.swing.JLabel;           // text or image holder
import javax.swing.ImageIcon;        // holds a custom icon
import javax.swing.SwingConstants;   // useful values for Swing method calls
import javax.swing.JComboBox;

import javax.imageio.ImageIO;        // loads an image from a file

import java.io.File;                 // opens a file
import java.io.IOException;          // reports an error reading from a file

import java.awt.BorderLayout;        // layout manager for main window
import java.awt.FlowLayout;          // layout manager for About dialog

import java.awt.Color;               // the color of widgets, text, or borders
import java.awt.Font;                // rich text in a JLabel or similar widget
import java.awt.image.BufferedImage; // holds an image loaded from a file

public class MainWin extends JFrame {
    private Store store;// = new Store("Elsa");
    private JLabel display = new JLabel();
    private File filename;
    
    public MainWin(String title) {
        
        
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        
        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();
        
        JMenu     file = new JMenu("File");
        JMenuItem quit = new JMenuItem("Quit");
        JMenuItem newClick = new JMenuItem("New");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem saveAs = new JMenuItem("Save As");




        JMenu     insert = new JMenu("Insert");
        JMenuItem customer  = new JMenuItem("Customer");
        JMenuItem option  = new JMenuItem("Option");   
        JMenuItem computer = new JMenuItem("Computer"); 
        JMenuItem order = new JMenuItem("Order");

        JMenu     view = new JMenu("View");
        JMenuItem viewCust = new JMenuItem("Customer");
        JMenuItem viewOption = new JMenuItem("Option");
        JMenuItem viewComputer = new JMenuItem("Computer");
        JMenuItem viewOrder = new JMenuItem("Order");
        
        JMenu     help = new JMenu("Help");
        JMenuItem about = new JMenuItem("About");

        quit.addActionListener(event -> onQuitClick());
        newClick.addActionListener(event -> onNewClick());
        open.addActionListener(event -> onOpenClick());
        save.addActionListener(event -> onSaveClick());
        saveAs.addActionListener(event -> onSaveAsClick());
        file.add(quit);
        file.add(newClick);
        file.add(open);
        file.add(save);
        file.add(saveAs);
        

        customer.addActionListener(event -> onInsertCustomerClick());
        option.addActionListener(event -> onInsertOptionClick());
        computer.addActionListener(event -> onInsertComputerClick());
        
        insert.add(customer);
        insert.add(option);
        insert.add(computer);
        insert.add(order);

        viewCust.addActionListener(event -> onViewClick(Record.CUSTOMER));
        viewOption.addActionListener(event -> onViewClick(Record.OPTION));
        viewComputer.addActionListener(event -> onViewClick(Record.COMPUTER));
        
        view.add(viewCust);
        view.add(viewOption);
        view.add(viewComputer);
        view.add(viewOrder);

        about.addActionListener(event -> onAboutClick());   
        help.add(about);

        menubar.add(file);
        menubar.add(insert);
        menubar.add(view);
        menubar.add(help);

        setJMenuBar(menubar);

        setVisible(true);

        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        //Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("ELSA BAR");
        
        //Insert Customer Button
        ImageIcon i = new ImageIcon("gui/toolbarPhotos/customer.jpg");      
        
        JButton buttonAddCustomer = new JButton(i);
    
        buttonAddCustomer.setActionCommand("Add New Customers");
        buttonAddCustomer.setToolTipText("Use this to add a name and email for a new customer!");
        buttonAddCustomer.addActionListener(event -> onInsertCustomerClick());
        toolbar.add(buttonAddCustomer);
        
        toolbar.add(Box.createHorizontalStrut(10));

        //Insert Option Button
        ImageIcon ii = new ImageIcon("gui/toolbarPhotos/options.jpg");
        JButton buttonAddOption = new JButton(ii);
        buttonAddOption.setActionCommand("Add New Options");
        buttonAddOption.setToolTipText("Use this to add option name and price");
        buttonAddOption.addActionListener(event -> onInsertOptionClick());
        toolbar.add(buttonAddOption);
        
        toolbar.add(Box.createHorizontalStrut(10));

        //Insert Computer Button
        ImageIcon iii = new ImageIcon("gui/toolbarPhotos/computer.png");
        JButton buttonAddComputer = new JButton(iii);
        buttonAddComputer.setActionCommand("Add New Computer");
        buttonAddComputer.setToolTipText("Use this to add a computers name, model and options");
        buttonAddComputer.addActionListener(event -> onInsertComputerClick());
        toolbar.add(buttonAddComputer);
        
        toolbar.add(Box.createHorizontalStrut(30));
        //View Customer Button
        ImageIcon iv = new ImageIcon("gui/toolbarPhotos/viewCustomer.png");
        
        JButton buttonViewCustomer = new JButton(iv);    
        buttonViewCustomer.setActionCommand("View All Customers");
        buttonViewCustomer.addActionListener(event -> onViewClick(Record.CUSTOMER));
        buttonViewCustomer.setToolTipText("Use this to view all current customers");
        toolbar.add(buttonViewCustomer);

        toolbar.add(Box.createHorizontalStrut(10));

        
        //View Options Button
        ImageIcon v = new ImageIcon("gui/toolbarPhotos/viewOptions.jpg");
        JButton buttonViewOptions = new JButton(v);    
        buttonViewOptions.setActionCommand("View All Options");
        buttonViewOptions.addActionListener(event -> onViewClick(Record.OPTION));
        buttonViewOptions.setToolTipText("Use this to view all computer options");
        toolbar.add(buttonViewOptions);
        
        toolbar.add(Box.createHorizontalStrut(10));
        
        ImageIcon vi = new ImageIcon("gui/toolbarPhotos/viewComputers.png");
        JButton buttonViewComputers = new JButton(vi);    
        buttonViewComputers.setActionCommand("View All Computers");
        buttonViewComputers.addActionListener(event -> onViewClick(Record.COMPUTER));
        buttonViewComputers.setToolTipText("Use this to view all current computers");
        toolbar.add(buttonViewComputers);
        
        toolbar.add(Box.createHorizontalStrut(30));

        ImageIcon vii = new ImageIcon("gui/toolbarPhotos/new.jpg");
        JButton buttonNew = new JButton(vii);    
        buttonNew.setActionCommand("New Store");
        buttonNew.addActionListener(event -> onNewClick());
        buttonNew.setToolTipText("Use to create a new Store");
        toolbar.add(buttonNew);
        
        toolbar.add(Box.createHorizontalStrut(10));

        ImageIcon viii = new ImageIcon("gui/toolbarPhotos/open.png");
        JButton buttonOpen = new JButton(viii);    
        buttonOpen.setActionCommand("Open Existing Store Data");
        buttonOpen.addActionListener(event -> onOpenClick());
        buttonOpen.setToolTipText("Use this to open existing store files");
        toolbar.add(buttonOpen);
        
        toolbar.add(Box.createHorizontalStrut(10));

        ImageIcon ix = new ImageIcon("gui/toolbarPhotos/save.png");
        JButton buttonSave = new JButton(ix);    
        buttonSave.setActionCommand("Save Current Store Data");
        buttonSave.addActionListener(event -> onSaveClick());
        buttonSave.setToolTipText("Use this to save current Store Data");
        toolbar.add(buttonSave);
        
        toolbar.add(Box.createHorizontalStrut(10));

        ImageIcon xx = new ImageIcon("gui/toolbarPhotos/saveAs.png");
        JButton buttonSaveAs = new JButton(xx);    
        buttonSaveAs.setActionCommand("Save as File Name");
        buttonSaveAs.addActionListener(event -> onSaveAsClick());
        buttonSaveAs.setToolTipText("Use this to save current store data with prefered name ");
        toolbar.add(buttonSaveAs);
        
        

        
        getContentPane().add(toolbar, BorderLayout.PAGE_START);
    
    }
        protected void onNewClick(){
            
            String name = JOptionPane.showInputDialog(this,"New Store Name");
            store = new Store(name);
        }
        protected void onOpenClick(){
            
            final JFileChooser fc = new JFileChooser("io");
            
            FileFilter filter = new FileNameExtensionFilter("Elsa Files", "elsa");
            fc.addChoosableFileFilter(filter);
            fc.setFileFilter(filter);

            int result = fc.showOpenDialog(this);
            if(result == JFileChooser.APPROVE_OPTION){
                filename = fc.getSelectedFile();
                try(BufferedReader br = new BufferedReader(new FileReader(filename))){
                    store = new Store(br);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(this, "Unable to open " +  filename + "\n" + e ,"Failed", 
                    JOptionPane.ERROR_MESSAGE);
                }
               
            }




        }
        protected void onSaveClick(){
            if (filename == null){
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("io/default.elsa"))) {
                    store.save(bw);
                } catch (Exception e) {
                    System.err.println("Failed to write: " + e); System.exit(-1);
                }
            
            }else{
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
                    store.save(bw);
                } catch (Exception e) {
                    System.err.println("Failed to write: " + e); System.exit(-1);
                }
            }
            filename = null;
        }
        protected void onSaveAsClick(){
            FileSystemView fsv = FileSystemView.getFileSystemView();
            
            final JFileChooser fc = new JFileChooser("io");
            
            FileFilter filter = new FileNameExtensionFilter("Elsa", "elsa");
            fc.addChoosableFileFilter(filter);
            fc.setFileFilter(filter);
           

            int result = fc.showSaveDialog(this);
            if(result == JFileChooser.APPROVE_OPTION){
                filename = fc.getSelectedFile();
                if(!filename.getAbsolutePath().endsWith(".elsa")){
                    filename = new File(filename.getAbsolutePath() + ".elsa");
                }
                onSaveClick();
            }

            
        }


        protected void onQuitClick(){
            System.exit(0);
        }
        
        protected void onInsertCustomerClick(){
            
            try{
                String name = JOptionPane.showInputDialog(this,"Customer name");
                String email = JOptionPane.showInputDialog(this,"Customer email");
                
                //JOptionPane.showMessageDialog(null, "Hello "+name + "\nYour email is " + email);
                Customer customer = new Customer(name, email);
                store.add(customer);
            }catch(IllegalArgumentException e){
                System.err.println(e.getMessage());
            }
            
        }

        protected void onInsertOptionClick(){
            String name = JOptionPane.showInputDialog(this,"Option name");
            String priceStr = JOptionPane.showInputDialog(this,"Option price");

            double price = Double.parseDouble(priceStr);
            long priceLong = (long) price;
    
            priceLong = priceLong * 100;
            //JOptionPane.showMessageDialog(this, "Option "+name + "\nPrice " + priceLong);
            Option option = new Option(name, priceLong);
            store.add(option);

        }
        
        protected void onInsertComputerClick(){
            
            String name = JOptionPane.showInputDialog(this,"Computer Name");
            String model = JOptionPane.showInputDialog(this,"Computer Model");
            Computer computer = new Computer(name, model);
        
            JComboBox cb = new JComboBox<Object>(store.options());
            int input = 0;
            while (input != JOptionPane.CANCEL_OPTION){
                
                input = JOptionPane.showConfirmDialog(this,cb, "Select Options", JOptionPane.OK_CANCEL_OPTION);
                if (input == JOptionPane.OK_OPTION){
                    computer.addOption((Option)cb.getSelectedItem());
                }

                //System.out.println(computer);   
            }
            store.add(computer);        

        }

        protected void onViewClick(Record r){
            String header;

            this.display.setText(" ");
            if(r == Record.CUSTOMER){
                // optionHeader.setVisible(false);
                // custLabel.setVisible(true);
                

                Object[] cust = store.customers();
                header = "Customers of Elsa";
                
                
                
                StringBuilder custSb = new StringBuilder();
                custSb.append("<html>\n"
                +"\n<p><font size=+2> " + header + "</font></p>\n"
                +"</br>");
                for (Object i: cust){
                    // String a = optionHeader.getText();
                   custSb.append("\n  <li> " + i + "</li>");
                }                    
                custSb.append("\n</ol>" + "\n</html>");    
                    
                display.setText(custSb.toString());
                System.out.println(custSb.toString());
                add(display);
            }else if(r == Record.OPTION){
                
                Object[] opt = store.options();
                header = "Options for Computers";
                    
                StringBuilder a = new StringBuilder();
                a.append("<html>\n"
                +"\n<p><font size=+2> " + header + "</font></p>\n"
                +"</br>");
                

                // String a = optionHeader.getText();
                    
                for (Object i: opt){
                    // String a = optionHeader.getText();
                   a.append("\n  <li> " + i + "</li>");
                }
                a.append("\n</ol>" + "\n</html>");    
                    
                display.setText(a.toString());
                System.out.println(a.toString());
                add(display);
            
            }else if (r == Record.COMPUTER){
                
                Object[] comp = store.computers();
                System.out.println(comp);
                header = "Computers";
                    
                StringBuilder b = new StringBuilder();
                
                b.append("<html>\n"
                +"\n<p><font size=+2> " + header + "</font></p>\n"
                +"</br>");
            
                // String a = optionHeader.getText();
                    
                for (Object i: comp){
                    // String a = optionHeader.getText();
                   b.append("\n  <li> " + i + "</li>");
                }
                b.append("\n</ol>" + "\n</html>");    
                
                display.setText(b.toString());
                System.out.println(b.toString());
                add(display);


            }else if (r == Record.ORDER){
                header = "Orders";
                Object[] ord = store.orders();  
                
                StringBuilder a = new StringBuilder();
                a.append("<html>\n"
                +"\n<p><font size=+2> " + header + "</font></p>\n"
                +"</br>");
                // String a = optionHeader.getText();
                    
                for (Object i: ord){
                    // String a = optionHeader.getText();
                   a.append("\n  <li> " + i + "</li>");
                   System.out.println(i);
                }
                a.append("\n</ol>" + "\n</html>");    
                    
                display.setText(a.toString());
                System.out.println(a.toString());
                add(display);
                
                
            }
            
                

        }

        protected void onAboutClick(){
        //   try {
        //     //BufferedImage myPicture = ImageIO.read(new File("128px-Pyramidal_matches.png"));
        //     // logo = new JLabel(new ImageIcon(myPicture));
            
        // } catch(IOException e) {
        // }
            Canvas logo = new Canvas();
            JLabel title = new JLabel("<html>"
            + "<p><font size=+4>ELSA</font></p>"
            + "<p>Version 1.0</p>"
            + "</html>",
            SwingConstants.CENTER);

            JLabel artists = new JLabel("<html>"
            + "<br/><p>Copyright 2023 by Jesse McNary</p>"
            + "<p>Licensed under the Apache License, Version 2.0</p><br/>"
            + "<p>Logo Image with the help of George F Rice</p><p>GNU GENERAL PUBLIC LICENSE Version 3, 29 June 2007</p><br>"
            + "<p></p>"
            + "<p><font size=-2></font></p>"
            + "<p>Customer Toolbar Image</p><p>https://icons8.com/icons/set/top-toolbar</p><br>"
            + "<p>Options Toolbar Image</p><p>www.123rf.com/clipart-vector/computer_ram.html</p><br>"
            + "<p>View Customer Toolbar Image</p><p>clipart-library.com/clip-art/playground-silhouette-25.htmr</p><br>"
            + "<p>View Options Toolbar Image</p><p>https://create.vista.com/vectors/Computer-hardware/</p><br>"
            + "<p>View Computer Toolbar Image</p><p>https://www.deviantart.com/flat-icons/art/Flat-Shadow-Computer-Icon-Multiple-Colors-557618709</p><br>"
            + "<p>New Store Toolbar Image</p><p>https://iconarchive.com/show/paradise-icons-by-fixicon/toolbar-folder-add-icon.html</p><br>"
            + "<p>Open File Toolbar Image</p><p>https://freeiconshop.com/icon/folder-open-icon-outline-filled/</p><br>"
            + "<p>Save Toolbar Image</p><p>//https://www.flaticon.com/free-icon/save-file_4856668 </p><br>"
            + "<p>Save As Toolbar Image</p><p>https://icons8.com/icon/13280/save-as</p><br>"
            + "<p><font size=-2></font></p>"
            + "</html>");
            
            JOptionPane.showMessageDialog(this, new Object[]{logo,title,artists},"ELSA", JOptionPane.PLAIN_MESSAGE);
            
        }  
    }
    
    // Listeners
    
    // protected void onNewGameClick() {         // Create a new game
    //     else = new Elsa();
    //     setSticks();
    //     msg.setFont(new JLabel().getFont());    // Reset to default font
    // }
    
    // protected void onButtonClick(int button) {  // Select 1, 2, or 3 sticks from pile
    //     try {
    //         // Catch the "impossible" out of sticks exception
    //         nim.takeSticks(button);
    //         setSticks();
    //     } catch(Exception e) {
    //         sticks.setText("FAIL: " + e.getMessage() + ", start new game");
    //     }
    // }
            
    // protected void onComputerPlayerClick() {   // Enable / disable computer player
    //     setSticks();
    //     // Java Swing requires action to visually indicate enabled / disabled button
    //     computerPlayer.setBorder(computerPlayer.isSelected() ? BorderFactory.createLineBorder(Color.black) : null);
    // }
    // protected void onRulesClick() {             // Show the rules
    //     String s = "The Rules of Nim\n\nCopyright 2017-2023 by George F. Rice - CC BY 4.0\n\n" +
    //         "The two players alternate taking 1 to 3 sticks from the pile.\n" +
    //         "The goal is to force your opponent to take the last stick (called misère rules).\n" +
    //         "If the computer button is up, it's a two player game. If down, the computer is always Player 2.)";
    //     JOptionPane.showMessageDialog(this, s, "The Rules of Nim", JOptionPane.PLAIN_MESSAGE);
    // }
    // protected void onAboutClick() {                 // Display About dialog
    //     JLabel logo = null;
    //     try {
    //         BufferedImage myPicture = ImageIO.read(new File("128px-Pyramidal_matches.png"));
    //         logo = new JLabel(new ImageIcon(myPicture));
    //     } catch(IOException e) {
    //     }
        
    //     JLabel title = new JLabel("<html>"
    //       + "<p><font size=+4>Nim</font></p>"
    //       + "<p>Version 1.4J</p>"
    //        + "</html>",
    //       SwingConstants.CENTER);

    //     JLabel artists = new JLabel("<html>"
    //       + "<br/><p>Copyright 2017-2023 by George F. Rice</p>"
    //       + "<p>Licensed under Gnu GPL 3.0</p><br/>"
    //       + "<p>Logo by M0tty, licensed under CC BY-SA 3.0</p>"
    //       + "<p><font size=-2>https://commons.wikimedia.org/wiki/File:Pyramidal_matches.svg</font></p>"
    //       + "<p>Robot by FreePik.com, licensed for personal</p><p>and commercial purposes with attribution</p>"
    //       + "<p><font size=-2>https://www.freepik.com/free-vector/grey-robot-silhouettes_714902.htm</font></p>"
    //       + "</html>");
          
    //      JOptionPane.showMessageDialog(this, 
    //          new Object[]{logo, title, artists},
    //          "The Game of Nim",
    //          JOptionPane.PLAIN_MESSAGE
    //      );
    //  }

/*
    // This is an alternate About dialog using JDialog instead of JOptionPane
    
    protected void onAboutClick() {                 // Display About dialog
        JDialog about = new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("The Game of Nim");
        
        try {
            BufferedImage myPicture = ImageIO.read(new File("128px-Pyramidal_matches.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            about.add(logo);
        } catch(IOException e) {
        }
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>Nim</font></p>"
          + "</html>");
        about.add(title);

        JLabel artists = new JLabel("<html>"
          + "<p>Version 1.4J</p>"
          + "<p>Copyright 2017-2023 by George F. Rice</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "<p>Logo by M0tty, licensed under CC BY-SA 3.0</p>"
          + "<p><font size=-2>https://commons.wikimedia.org/wiki/File:Pyramidal_matches.svg</font></p>"
          + "<p>Robot by FreePik.com, licensed for personal</p><p>and commercial purposes with attribution</p>"
          + "<p><font size=-2>https://www.freepik.com/free-vector/grey-robot-silhouettes_714902.htm</font></p>"
          + "</html>");
        about.add(artists);

        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);
        
        about.setSize(450,400);
        about.setVisible(true);
     }
*/
       // Exit ELSA

    // private void setSticks() {              // Update display, robot move
    //     // s collects the status message
    //     String s = "";
        
    //     // If the robot is enabled and it's their turn, move the robot
    //     if(nim.sticksLeft() > 0) {
    //         if(computerPlayer.isSelected() && nim.currentPlayer() == 2) {
    //             int move = 1;
    //             try {
    //                 move = nim.optimalMove();
    //             } catch(Exception e) {
    //                 System.err.println("Invalid optimal move: " + e.getMessage());
    //             }
    //             s += "Robot plays " + move + ", ";
    //             nim.takeSticks(move);
    //         }
    //     }
        
    //     // Report who's turn it is, or (if all sticks gone) who won
        
    //     if (nim.sticksLeft() > 0) {
    //         s += "Player " + nim.currentPlayer() + "'s turn";
    //     } else {
    //         s += "Player " + nim.currentPlayer() +  " wins!";
    //         msg.setFont(new Font("SansSerif", Font.BOLD, 18));
    //     }
        
    //     // Display the collected status on the status bar
    //     msg.setText(s);

    //     // Update the visual display of sticks
    //     s = "";
    //     for(int i=0; i<nim.sticksLeft(); ++i) s += ("| ");
    //     s += "  (" + (nim.sticksLeft()) + " sticks)";
    //     sticks.setText(s);

    //     // Set sensitivity of the human stick selectors so user can't make an illegal move
    //     button1.setEnabled(nim.sticksLeft() > 0);
    //     button2.setEnabled(nim.sticksLeft() > 1);
    //     button3.setEnabled(nim.sticksLeft() > 2);
    // }
    
       

    // private JLabel sticks;                  // Display of sticks on game board
    // private JLabel msg;                     // Status message display
    // private JButton button1;                // Button to select 1 stick
    // private JButton button2;                // Button to select 2 sticks
    // private JButton button3;                // Button to select 3 sticks
    // private JToggleButton computerPlayer;   // Button to enable robot


