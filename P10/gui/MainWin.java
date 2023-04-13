//Jesse McNary 2023
package gui;

import store.*;
import java.util.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;



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
        order.addActionListener(event -> onInsertOrderClick());

        insert.add(customer);
        insert.add(option);
        insert.add(computer);
        insert.add(order);

        viewCust.addActionListener(event -> onViewClick(Record.CUSTOMER));
        viewOption.addActionListener(event -> onViewClick(Record.OPTION));
        viewComputer.addActionListener(event -> onViewClick(Record.COMPUTER));
        viewOrder.addActionListener(event -> onViewClick(Record.ORDER));

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
        
       
        toolbar.add(Box.createHorizontalStrut(10));
        //insert order
        ImageIcon insertOrder = new ImageIcon("gui/toolbarPhotos/newOrder.png");
        JButton buttonnewOrders = new JButton(insertOrder);
        buttonnewOrders.setActionCommand("Add New Orders");
        buttonnewOrders.addActionListener(event -> onInsertOrderClick());
        buttonnewOrders.setToolTipText("Use this to view all current orders");
        toolbar.add(buttonnewOrders); 
        
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
        
        //View Computers
        ImageIcon vi = new ImageIcon("gui/toolbarPhotos/viewComputers.png");
        JButton buttonViewComputers = new JButton(vi);    
        buttonViewComputers.setActionCommand("View All Computers");
        buttonViewComputers.addActionListener(event -> onViewClick(Record.COMPUTER));
        buttonViewComputers.setToolTipText("Use this to view all current computers");
        toolbar.add(buttonViewComputers);
        
        //View Order
        toolbar.add(Box.createHorizontalStrut(10));
        
        ImageIcon viewOrderIcon = new ImageIcon("gui/toolbarPhotos/order.png");
        JButton buttonViewOrders = new JButton(viewOrderIcon);
        buttonViewOrders.setActionCommand("View All Orders");
        buttonViewOrders.addActionListener(event -> onViewClick(Record.ORDER));
        buttonViewOrders.setToolTipText("Use this to view all current orders");
        toolbar.add(buttonViewOrders); 
        
        toolbar.add(Box.createHorizontalStrut(30));
        
        //New
        ImageIcon vii = new ImageIcon("gui/toolbarPhotos/new.jpg");
        JButton buttonNew = new JButton(vii);    
        buttonNew.setActionCommand("New Store");
        buttonNew.addActionListener(event -> onNewClick());
        buttonNew.setToolTipText("Use to create a new Store");
        toolbar.add(buttonNew);
        
        toolbar.add(Box.createHorizontalStrut(10));
        //Open  
        ImageIcon viii = new ImageIcon("gui/toolbarPhotos/open.png");
        JButton buttonOpen = new JButton(viii);    
        buttonOpen.setActionCommand("Open Existing Store Data");
        buttonOpen.addActionListener(event -> onOpenClick());
        buttonOpen.setToolTipText("Use this to open existing store files");
        toolbar.add(buttonOpen);
        
        toolbar.add(Box.createHorizontalStrut(10));
        //Save
        ImageIcon ix = new ImageIcon("gui/toolbarPhotos/save.png");
        JButton buttonSave = new JButton(ix);    
        buttonSave.setActionCommand("Save Current Store Data");
        buttonSave.addActionListener(event -> onSaveClick());
        buttonSave.setToolTipText("Use this to save current Store Data");
        toolbar.add(buttonSave);
        
        toolbar.add(Box.createHorizontalStrut(10));
        
        //Save AS
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
                
                JTextField nameField = new JTextField("");
                JTextField emailField = new JTextField("");
                
                String name = "";
                String email = "";


                JLabel nameLabel = new JLabel("Name");

                JLabel emailLabel = new JLabel("<HTML><br/>Email</HTML>");

                Object[] objects = {
                    nameLabel, nameField,
                    emailLabel, emailField 
                };
                int button = JOptionPane.showConfirmDialog(this,objects,"New Customer",
                JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE, new ImageIcon("gui/toolbarPhotos/customer.jpg"));

                if(button == JOptionPane.OK_OPTION){
                    name = nameField.getText();
                    email = emailField.getText();
                    store.add(new Customer(name,email));
                }
            }catch(IllegalArgumentException e){
                System.err.println(e.getMessage());
            }
            
        }

        protected void onInsertOptionClick(){
            

            JTextField nameField = new JTextField();
            JTextField priceField = new JTextField();

            JLabel nameLabel = new JLabel("Name");
            JLabel priceLabel = new JLabel("<HTML><br/>Price</HTML>");

            Object[] objects = {
                nameLabel, nameField,
                priceLabel,priceField
                };
            int button = JOptionPane.showConfirmDialog(this,objects,"New Option", 
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("gui/toolbarPhotos/options.jpg"));

            if(button == JOptionPane.OK_OPTION){
                
                String name = nameField.getText();
                
                double price = Double.parseDouble(priceField.getText());
                
                long priceLong = (long) price;
                
                priceLong = priceLong * 100;
                
                store.add(new Option(name,priceLong));
            }
        }
        protected void onInsertComputerClick(){
            
            JTextField nameField = new JTextField();
            JTextField modelField = new JTextField();
            JComboBox cb = new JComboBox<Object>(store.options());


            JLabel nameLabel = new JLabel("Computer Name");
            JLabel modelLabel = new JLabel("<HTML><br/>Model ID</HTML>");
            JLabel optionLabel = new JLabel("<HTML><br/>Options</HTML>");
            
            Object[] objects = {
                nameLabel, nameField,
                modelLabel, modelField
            };
            
            int button = JOptionPane.showConfirmDialog(this,objects,"New Computer", 
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("gui/toolbarPhotos/computer.png"));
            
            if (button == JOptionPane.OK_OPTION){
                Computer c = new Computer(nameField.getText(), modelField.getText());
                int input = 0;
                while (input != JOptionPane.CANCEL_OPTION){
                
                    input = JOptionPane.showConfirmDialog(this,cb, "Select Options", 
                    JOptionPane.OK_CANCEL_OPTION);
                
                    if (input == JOptionPane.OK_OPTION){
                        c.addOption((Option)cb.getSelectedItem());
                    }

                }

                store.add(c);
            }
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
            + "<p>Order Toolbar Image</p><p>https://www.vecteezy.com/vector-art/2555448-clicking-cart-order-shopping-or-payment-mobile-banking-line-style-icon</p><br>"
            + "<p>View Customer Toolbar Image</p><p>clipart-library.com/clip-art/playground-silhouette-25.htmr</p><br>"
            + "<p>View Options Toolbar Image</p><p>https://create.vista.com/vectors/Computer-hardware/</p><br>"
            + "<p>View Computer Toolbar Image</p><p>https://www.deviantart.com/flat-icons/art/Flat-Shadow-Computer-Icon-Multiple-Colors-557618709</p><br>"
            + "<p>View Orders Toolbar Image</p><p>https://www.flaticon.com/free-icon/order_3500833?term=order&page=1&position=8&origin=tag&related_id=3500833</p><br>"            
            + "<p>New Store Toolbar Image</p><p>https://iconarchive.com/show/paradise-icons-by-fixicon/toolbar-folder-add-icon.html</p><br>"
            + "<p>Open File Toolbar Image</p><p>https://freeiconshop.com/icon/folder-open-icon-outline-filled/</p><br>"
            + "<p>Save Toolbar Image</p><p>//https://www.flaticon.com/free-icon/save-file_4856668 </p><br>"
            + "<p>Save As Toolbar Image</p><p>https://icons8.com/icon/13280/save-as</p><br>"
            + "<p><font size=-2></font></p>"
            + "</html>");
            
            JOptionPane.showMessageDialog(this, new Object[]{logo,title,artists},"ELSA", JOptionPane.PLAIN_MESSAGE);
            
        }

        protected void onInsertOrderClick(){
            Customer orderCustomer = null;
            Order newOrder= null;

            
            if(store.customers().length == 0){
            
                onInsertCustomerClick();
                
                Object[] customers = store.customers();
                orderCustomer = (Customer)customers[0];
                
                newOrder= new Order(orderCustomer);
            
            }else if(store.customers().length == 1){
                Object[] customers = store.customers();
                orderCustomer = (Customer)customers[0];
                
                newOrder= new Order(orderCustomer);
            
            }else{
                JComboBox cb = new JComboBox<Object>(store.customers());
                
                int input = JOptionPane.showConfirmDialog(this,cb,"Select Customer for Order", JOptionPane.OK_CANCEL_OPTION);
                
                if (input == JOptionPane.OK_OPTION){
                    orderCustomer = (Customer)cb.getSelectedItem();
                }
                newOrder = new Order(orderCustomer);
            }            
            
            if(store.computers().length == 0){
               JOptionPane.showMessageDialog(this, "The Stores does not have any computers currently");
            }
            else{
                JComboBox pcCB = new JComboBox<Object>(store.computers());
                int input = 0;
                while (input != JOptionPane.CANCEL_OPTION){
                    input = JOptionPane.showConfirmDialog(this,pcCB,"Select Computers to add to order",
                        JOptionPane.OK_CANCEL_OPTION);
                    if (input == JOptionPane.OK_OPTION){
                        newOrder.addComputer((Computer)pcCB.getSelectedItem());
                    }

                }
                store.add(newOrder);
            }
            
        }

    }
    

