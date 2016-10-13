package com.SuperTrumps.GUI;

import com.SuperTrumps.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainUI {

    static public boolean gameOver;
    static public JFrame gameFrame;
    static public BufferedImage backOfCard;
    static public int numPlayers;
    static public String playerName;

    static public String gameMessage;
    static public Game gameST;

    public static void main(String[] args) {

        gameFrame = new JFrame("Mineral SuperTrumps");
        gameFrame.setVisible(true);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setWelcomeContent();

        gameST = new Game(numPlayers);
        gameST.setUserPlayer(playerName);
        gameST.setComPlayers();

    }

    public static void setWelcomeContent() {
        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new GridLayout(2,1));

        JPanel messagePanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome to the Mineral SuperTrumps game");
        messagePanel.add(welcomeLabel);
        welcomePanel.add(messagePanel);

        JPanel buttonPanel = new JPanel();
        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newGameButtonPressed(); }

            private void newGameButtonPressed() {
                welcomePanel.setVisible(false);
                setConfigContent();
            }
        } );
        JButton viewRulesButton = new JButton("View Rules");
        buttonPanel.add(newGameButton);
        buttonPanel.add(viewRulesButton);
        welcomePanel.add(buttonPanel);

        gameFrame.setContentPane(welcomePanel);
        gameFrame.pack();

    }

    public static void setConfigContent() {
        JPanel configPanel = new JPanel();
        configPanel.setLayout(new GridLayout(4, 1));

        JPanel messagePanel = new JPanel();
        JLabel messageLabel = new JLabel("Choose your game settings");
        messagePanel.add(messageLabel);
        configPanel.add(messagePanel);

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Enter your Name");
        JTextField nameInput = new JTextField(12);
        namePanel.add(nameLabel);
        namePanel.add(nameInput);
        configPanel.add(namePanel);

        JPanel numPlayersPanel = new JPanel();
        JLabel numPlayersLabel = new JLabel("Number of opponents");
        Integer[] num = {2,3,4};
        JComboBox numPlayersInput = new JComboBox(num);
        numPlayersPanel.add(numPlayersLabel);
        numPlayersPanel.add(numPlayersInput);
        configPanel.add(numPlayersPanel);

        JPanel buttonPanel = new JPanel();
        JButton startGameButton = new JButton("Start Game");
        startGameButton.setEnabled(false);
        nameInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {nameEntered();}

            @Override
            public void removeUpdate(DocumentEvent e) {nameEntered();}

            @Override
            public void changedUpdate(DocumentEvent e) {nameEntered();}

            private void nameEntered() {
                if (nameInput.getText().equals("")) {startGameButton.setEnabled(false);}
                else {startGameButton.setEnabled(true);}
            }
        });

        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setGameTableContent();
            }
        });

        JButton menuButton = new JButton("Main Menu");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setWelcomeContent();
            }
        });
        buttonPanel.add(startGameButton);
        buttonPanel.add(menuButton);
        configPanel.add(buttonPanel);


        numPlayers = (int) numPlayersInput.getSelectedItem();
        playerName = nameInput.getText();
        gameMessage = ("There are " + ((numPlayers)  + 1) + " players in this game.");

        gameFrame.setContentPane(configPanel);
        gameFrame.pack();

    }

    public static void setGameTableContent() {

        JPanel TablePanel = new JPanel();
        TablePanel.setLayout(new BorderLayout());
        JPanel messagePanel = new JPanel();

        messagePanel.setPreferredSize(new Dimension(800, 50));
        JLabel messageLabel = new JLabel(gameMessage);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 26));
        messagePanel.add(messageLabel);
        TablePanel.add(messagePanel, BorderLayout.NORTH);

        JPanel gameTablePanel = new JPanel();
        gameTablePanel.setLayout(new GridLayout(3, 1));



        JPanel topTablePanel = new JPanel();
        topTablePanel.setLayout(new GridLayout(2,3));

        GUI.FaceDownCardPanel comPlayerOne = new GUI.FaceDownCardPanel();
        comPlayerOne.setPreferredSize(new Dimension(100, 200));
        JLabel comPlayerOneNameLabel = new JLabel("Computer One");

        GUI.FaceDownCardPanel gameDeck = new GUI.FaceDownCardPanel();
        gameDeck.setPreferredSize(new Dimension(100, 200));
        JLabel gameDeckLabel = new JLabel("SuperTrump Deck: " + gameST.cardDeck.size());

        GUI.FaceDownCardPanel comPlayerTwo = new GUI.FaceDownCardPanel();
        comPlayerTwo.setPreferredSize(new Dimension(100, 200));
        JLabel comPlayerTwoNameLabel = new JLabel("Computer Two");


        topTablePanel.add(comPlayerOne);
        topTablePanel.add(gameDeck);
        topTablePanel.add(comPlayerTwo);

        topTablePanel.add(comPlayerOneNameLabel);
        topTablePanel.add(gameDeckLabel);
        topTablePanel.add(comPlayerTwoNameLabel);

        gameTablePanel.add(topTablePanel);

        JPanel bottomTablePanel = new JPanel();
        bottomTablePanel.setLayout(new GridLayout(2,3));

        GUI.FaceDownCardPanel comPlayerThree = new GUI.FaceDownCardPanel();
        comPlayerThree.setPreferredSize(new Dimension(100, 200));
        JLabel comPlayerThreeNameLabel = new JLabel("Computer Three");

        GUI.FaceDownCardPanel cardInPlay = new GUI.FaceDownCardPanel();
        cardInPlay.setPreferredSize(new Dimension(100, 200));
        JLabel cardInPlayLabel = new JLabel("Card in play");

        GUI.FaceDownCardPanel comPlayerFour = new GUI.FaceDownCardPanel();
        comPlayerFour.setPreferredSize(new Dimension(100, 200));
        JLabel comPlayerFourNameLabel = new JLabel("Computer Four");

        if (numPlayers >= 3) {bottomTablePanel.add(comPlayerThree);}
        bottomTablePanel.add(cardInPlay);
        if (numPlayers >= 4) bottomTablePanel.add(comPlayerFour);
        if (numPlayers >= 3) bottomTablePanel.add(comPlayerThreeNameLabel);
        bottomTablePanel.add(cardInPlayLabel);
        if (numPlayers >= 4) bottomTablePanel.add(comPlayerFourNameLabel);

        gameTablePanel.add(bottomTablePanel);


        JPanel playerTablePanel = new JPanel();
        JPanel leftButtonPanel = new JPanel();
        leftButtonPanel.setLayout(new GridLayout(2,1));
        JButton viewRulesButton = new JButton("View Rules");
        JButton quitGameButton = new JButton("Quit Game");
        quitGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setWelcomeContent();
            }
        });
        leftButtonPanel.add(viewRulesButton);
        leftButtonPanel.add(quitGameButton);
        playerTablePanel.add(leftButtonPanel);
        JPanel playerHandPanel = new JPanel();
        for (int i = 0; i < 8; i++) { // TODO: 12/10/2016 Hand.Size()
            GUI.FaceUpCardPanel faceUpCard = new GUI.FaceUpCardPanel();
            faceUpCard.setPreferredSize(new Dimension(100,200));
            playerHandPanel.add(faceUpCard);
        }
        playerTablePanel.add(playerHandPanel);
        JPanel rightButtonPanel = new JPanel();
        rightButtonPanel.setLayout(new GridLayout(2,1));
        JButton playCardButton = new JButton("Play Card");
        playCardButton.setEnabled(false);
        JButton passTurnButton = new JButton("Pass Turn");
        passTurnButton.setEnabled(false);
        rightButtonPanel.add(playCardButton);
        rightButtonPanel.add(passTurnButton);
        playerTablePanel.add(rightButtonPanel);
        gameTablePanel.add(playerTablePanel);
        TablePanel.add(gameTablePanel);

        gameFrame.setContentPane(TablePanel);
        gameFrame.pack();
    }

    public static class FaceDownCardPanel extends JPanel {

        public FaceDownCardPanel() {
            try {
                backOfCard = ImageIO.read(new File("images/Slide65.jpg"));
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backOfCard, 0, 0, null); // see javadoc for more info on the parameters
            backOfCard.getScaledInstance(100, 200, Image.SCALE_DEFAULT); // TODO: 12/10/2016 where to put this?
        }
    }

    public static class FaceUpCardPanel extends JPanel {

        public FaceUpCardPanel () {}

        public FaceUpCardPanel(String cardImageName) {
            try {
                backOfCard = ImageIO.read(new File("images/" + cardImageName));
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backOfCard, 0, 0, null); // see javadoc for more info on the parameters
        }
    }}
