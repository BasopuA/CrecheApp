/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alex
 */
public class CreshLibrary extends JFrame
{
    //DECLARING VARIABLES
    private JPanel namePnel;
    private JPanel genderPanel;
    private JPanel  buttonPanel;
    private JPanel  mainPnel;
    private JPanel areaPanel;
    private JLabel nameLabel;
    private JLabel genderLabel;
    private JTextField nameField;
    private JTextArea  area;
    private JRadioButton male;
    private JRadioButton female;
    private JButton register;
    private JButton display;
    private JScrollPane scrollbar;
    private List<Child> kids = new ArrayList<>();
    
    public CreshLibrary()
    {
        //CREATING  FRAME
            setSize(400, 400);
            setLayout(new BorderLayout());
            setTitle("CRECHE 4 YOUR KIDDIE");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initializing
            namePnel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            mainPnel = new JPanel(new BorderLayout());
            areaPanel = new JPanel(new BorderLayout());
        //TEXT FIELD
            nameField = new JTextField(15);

        // TEXT AREA
            area = new JTextArea(10, 30);
            nameField = new JTextField(15);
            area = new JTextArea(10, 30);
            area.setText("Children details");
            area.setEditable(false);
            scrollbar = new JScrollPane(area);
            scrollbar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollbar.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        //LABELS
            nameLabel = new JLabel("Name: ");
            genderLabel = new JLabel("Gender: ");

    //CREATING RADIO BUTTONS
            male = new JRadioButton("Male");
            female = new JRadioButton("Female");
            ButtonGroup genderGroup = new ButtonGroup();
            genderGroup.add(male);
            genderGroup.add(female);

    // CREATING BUTTONS
            register = new JButton("Register kiddie");
            display = new JButton("Display kiddie");

    // Adding components to panels
            namePnel.add(nameLabel);
            namePnel.add(nameField);
            genderPanel.add(genderLabel);
            genderPanel.add(male);
            genderPanel.add(female);
            buttonPanel.add(register);
            buttonPanel.add(display);
            areaPanel.add(scrollbar, BorderLayout.CENTER);

    //ADDING TO THE MAIN PANEL
            mainPnel.add(namePnel, BorderLayout.NORTH);
            mainPnel.add(genderPanel, BorderLayout.CENTER);
            mainPnel.add(buttonPanel, BorderLayout.SOUTH);

            add(mainPnel, BorderLayout.CENTER);
            add(areaPanel, BorderLayout.SOUTH);

    // Adding action listeners
           register.addActionListener(new RegisterButton());
          display.addActionListener(new DisplayButton());

            setVisible(true);


        }
    //CAPTURING METHOD
        private class RegisterButton implements ActionListener
        {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String name = nameField.getText();
                String genders = male.isSelected()? "Male" : female.isSelected() ? "Female " : null;

                if(name.isEmpty() || genders == null)
                {
                    JOptionPane.showMessageDialog(CreshLibrary.this," Pease fill in all fields");
                    return;
                }
                Child child = new Child(name,genders);
                kids.add(child);
                nameField.setText("");
                male.setSelected(false);
                female.setSelected(false);

                 JOptionPane.showMessageDialog(CreshLibrary.this," kid is Registered Successfully");
            }

        }
    //DISPLAYING METHOD
        private class DisplayButton implements ActionListener
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                String details = "";
                //StringBuilder detail = new StringBuilder();
                for (Child kid : kids) 
                {
                    details += kid.toString()+"\n";
                }
                area.setText(details.toString());
            }

        }
//CREATING CHILD CLASS    
    public class Child 
        {
            private String name;
            private String gender;

            public Child(String name, String gender) 
            {
                this.name = name;
                this.gender = gender;
            }

            public String getName() {
                return name;
            }

            public String getGender() 
            {
                return gender;
            }

            @Override
            public String toString() 
            {
                return "Name: " + name + "  Gender: " + gender ;
            }  
        }

}
