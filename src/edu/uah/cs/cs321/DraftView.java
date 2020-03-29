package edu.uah.cs.cs321;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.table.*;


public class DraftView{
    private JTable table;
    private JLabel RoundInfo;
    private JPanel panel1;
    private JPanel panel2;
    private JFrame frame;
    private JTextField search;
    private JButton SearchButton;
    public DraftView()
    {
        initializeDraftFrame();
    }

    public void initializeDraftFrame(){
        int RoundNumber = 1;
        String TeamOwnerName = "John";
        int PickNumber = 2;
        frame = new JFrame();
        JScrollPane sp;
        panel1 = new JPanel();
        panel2 = new JPanel();

        String[][] data = {
                {"Julio Jones", "Falcons", "11", "15", "54", "13.7"},
                {"Todd Gurley","Falcons", "30", "18", "96", "4.3"}
        };

        String[] titles = {"Player", "Team", "Number", "Tds",
                "Comps", "YPC"};


        table = new JTable(data,titles);
        table.setEnabled(false);
        table.setFocusable(false);
        table.setRowSelectionAllowed(false);
        table.setColumnSelectionAllowed(false);

        sp = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        table.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent e)
            {
                int row = table.rowAtPoint(e.getPoint());
                int column = table.columnAtPoint(e.getPoint());
                Object o = table.getValueAt(row, 0);
                String playerName = o.toString();
                createAddPlayerWindow(playerName);
            }
        });

        panel1.setLayout(new BorderLayout());
        panel1.add(sp,BorderLayout.CENTER);

        search = new JTextField(10);
        search.setText("Search Player");

        SearchButton = new JButton("Search");
        SearchButton.addActionListener((ActionEvent ae) -> {
            String PlayerSearched = search.getText();
            System.out.println(PlayerSearched);
        });

        panel2.setLayout(new FlowLayout());

        RoundInfo = createInfoLabel(RoundNumber, TeamOwnerName, PickNumber);
        RoundInfo.setHorizontalAlignment(SwingConstants.CENTER);

        frame.setTitle("DraftView");
        frame.setLayout(new BorderLayout());
        panel2.add(RoundInfo);
        panel2.add(search);
        panel2.add(SearchButton);
        frame.add(panel1,BorderLayout.CENTER);
        frame.add(panel2,BorderLayout.NORTH);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createAddPlayerWindow(String playerName)
    {
        JFrame AddPlayerWindow = new JFrame();
        JButton yesButton = new JButton("Yes");
        JButton noButton = new JButton("No");
        JLabel prompt = new JLabel("Would like to add " + playerName + " to your team?");

        yesButton.addActionListener(event->AddPlayerWindow.dispose());
        noButton.addActionListener(event->AddPlayerWindow.dispose());

        AddPlayerWindow.setTitle("Add Player");
        AddPlayerWindow.setSize(400,100);
        AddPlayerWindow.setLayout(new FlowLayout());

        AddPlayerWindow.add(prompt);
        AddPlayerWindow.add(yesButton);
        AddPlayerWindow.add(noButton);

        AddPlayerWindow.setVisible(true);
        AddPlayerWindow.setLocationRelativeTo(null);
    }
    public JLabel createInfoLabel(int RoundNumber, String TeamOwnerName, int PickNumber)
    {
        JLabel j;
        String text = "Round: " + RoundNumber + " Pick: " + PickNumber + " Team Owner: " + TeamOwnerName;
        j = new JLabel("<html><div style='text-align: center;'>" + text + "</div></html>");
        return j;

    }
}