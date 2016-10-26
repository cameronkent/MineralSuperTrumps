package com.SuperTrumps.GUI;

import com.SuperTrumps.Card;
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

    static public GameState state;
    static public boolean gameOver;
    static public JFrame gameFrame;
    static public BufferedImage backOfCard;
    static public ImageIcon cardInPlayImage;
    static public JButton startRoundButton;
    static public JPanel scrollPanel;
    static public JScrollPane messageScrollPane;
    static public JButton playCardButton;
    static public JButton passTurnButton;
    static public JLabel cardInPlay;
    static public JPanel categoryPanel;
    static public String gameMessage;
    static public Game gameST;

    public static void main(String[] args) throws Exception {

        state = GameState.IDLE;

        gameFrame = new JFrame("Mineral SuperTrumps");
        gameFrame.setVisible(true);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setWelcomeContent();

    }


    public static void setWelcomeContent() {

        JPanel welcomePanel = new JPanel();
        welcomePanel.setLayout(new GridLayout(2, 1));

        JPanel messagePanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome to the Mineral SuperTrumps game");
        welcomeLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 26));
        messagePanel.add(welcomeLabel);
        welcomePanel.add(messagePanel);

        JPanel buttonPanel = new JPanel();
        JButton newGameButton = new JButton("New Game");
        newGameButton.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));
        newGameButton.addActionListener(e -> {
            state = GameState.START;
            welcomePanel.setVisible(false);
            setConfigContent();
        });
        JButton viewRulesButton = new JButton("View Rules");
        viewRulesButton.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));
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
        messageLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 26));
        messagePanel.add(messageLabel);
        configPanel.add(messagePanel);

        JPanel namePanel = new JPanel();
        JLabel nameLabel = new JLabel("Enter your Name");
        nameLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));
        JTextField nameInput = new JTextField(12);
        nameInput.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));
        namePanel.add(nameLabel);
        namePanel.add(nameInput);
        configPanel.add(namePanel);

        JPanel numPlayersPanel = new JPanel();
        JLabel numPlayersLabel = new JLabel("Number of opponents");
        numPlayersLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));
        Integer[] num = {2, 3, 4};
        JComboBox numPlayersInput = new JComboBox(num);
        nameInput.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));
        numPlayersPanel.add(numPlayersLabel);
        numPlayersPanel.add(numPlayersInput);
        configPanel.add(numPlayersPanel);

        JPanel buttonPanel = new JPanel();
        JButton startGameButton = new JButton("Start Game");
        startGameButton.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));
        startGameButton.setEnabled(false);
        nameInput.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                nameEntered();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                nameEntered();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                nameEntered();
            }

            private void nameEntered() {
                if (!nameInput.getText().equals("")) {
                    state = GameState.GET_NAME;
                    startGameButton.setEnabled(true);
                }
            }
        });

        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                state = GameState.START_ROUND;
                configPanel.setVisible(false);

                gameST = new Game((int) numPlayersInput.getSelectedItem());
                gameST.setUserPlayer(nameInput.getText());
                gameST.setComPlayers();
                try {
                    gameST.buildCardDeck();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                gameST.randomiseDealer();
                gameST.dealPlayerHands();
                gameMessage = (gameST.dealerName + " is dealing this round");
                buildGameTable();
            }
        });

        JButton menuButton = new JButton("Main Menu");
        menuButton.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setWelcomeContent();
            }
        });

        buttonPanel.add(startGameButton);
        buttonPanel.add(menuButton);
        configPanel.add(buttonPanel);

        gameFrame.setContentPane(configPanel);
        gameFrame.pack();

    }

    private static void buildGameTable() {

        JPanel TablePanel = new JPanel();
        TablePanel.setLayout(new BorderLayout());

        scrollPanel = new JPanel();
        scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));

        scrollPanel.setAlignmentY(SwingConstants.CENTER);
        scrollPanel.setPreferredSize(new Dimension(800, 50));
        scrollPanel.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));

        messageScrollPane = new JScrollPane(scrollPanel);
        messageScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        messageScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.add(new JLabel(gameMessage, SwingConstants.CENTER));

        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        messagePanel.add(new JLabel("Game status", SwingConstants.CENTER)).setFont(new Font("Lantinghei SC", Font.PLAIN, 24));
        messagePanel.add(messageScrollPane);
        TablePanel.add(messagePanel, BorderLayout.NORTH);

        JPanel gameTablePanel = new JPanel();
        gameTablePanel.setLayout(new GridLayout(4, 1));

        categoryPanel = new JPanel();
        JButton hardnessButton = new JButton("Hardness");
        hardnessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameST.userPlayer.setCategory(1);
            }
        });
        hardnessButton.setFont(new Font("Lantinghei SC", Font.PLAIN, 20));
        categoryPanel.add(hardnessButton);
        JButton specGravButton = new JButton("Specific Gravity");
        specGravButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameST.userPlayer.setCategory(2);
            }
        });
        specGravButton.setFont(new Font("Lantinghei SC", Font.PLAIN, 20));
        categoryPanel.add(specGravButton);
        JButton cleavageButton = new JButton("Cleavage");
        cleavageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameST.userPlayer.setCategory(3);
            }
        });
        cleavageButton.setFont(new Font("Lantinghei SC", Font.PLAIN, 20));
        categoryPanel.add(cleavageButton);
        JButton crustButton = new JButton("Crustal Abundance");
        crustButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameST.userPlayer.setCategory(4);
            }
        });
        crustButton.setFont(new Font("Lantinghei SC", Font.PLAIN, 20));
        categoryPanel.add(crustButton);
        JButton ecoValueButton = new JButton("Economic Value");
        ecoValueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameST.userPlayer.setCategory(5);
            }
        });
        ecoValueButton.setFont(new Font("Lantinghei SC", Font.PLAIN, 20));
        categoryPanel.add(ecoValueButton);
        categoryPanel.setVisible(false);


        gameTablePanel.add(categoryPanel);

        JPanel comPlayerPanel = new JPanel();
        comPlayerPanel.setLayout(new GridLayout(1, gameST.numPlayers));

        JLabel comInfo[] = new JLabel[gameST.numPlayers];
        for (int i = 0; i < gameST.numPlayers; i++) {
            comInfo[i] = new JLabel(gameST.comPlayer[i].playerName + "\n" + " Cards " + gameST.comPlayer[i].Hand.size(), SwingConstants.CENTER);
            comInfo[i].setFont(new Font("Lantinghei SC", Font.PLAIN, 18));
            comPlayerPanel.add(comInfo[i]);
        }
        gameTablePanel.add(comPlayerPanel);

        JPanel cardDeckPanel = new JPanel();

        FaceDownCardPanel gameDeck = new FaceDownCardPanel();
        gameDeck.setPreferredSize(new Dimension(180, 250));
        JLabel gameDeckLabel = new JLabel("SuperTrump Deck: " + gameST.cardDeck.size(), SwingConstants.CENTER);
        gameDeckLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));
        JLabel cardInPlayLabel = new JLabel("Card in play", SwingConstants.CENTER);

        ImageIcon cipIcon = new ImageIcon("images/Slide65.jpg");
        Image cipImg = cipIcon.getImage();
        Image newCipImg = cipImg.getScaledInstance(180, 250, Image.SCALE_SMOOTH);
        cardInPlayImage = new ImageIcon(newCipImg);
        cardInPlay = new JLabel(cardInPlayImage);

        cardInPlayLabel.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));

        cardDeckPanel.add(gameDeckLabel);
        cardDeckPanel.add(gameDeck);
        cardDeckPanel.add(cardInPlay);
        cardDeckPanel.add(cardInPlayLabel);

        gameTablePanel.add(cardDeckPanel);

        JPanel playerTablePanel = new JPanel();
        JPanel leftButtonPanel = new JPanel();
        leftButtonPanel.setLayout(new GridLayout(2, 1));

        startRoundButton = new JButton("Start Round");
        //startRoundButton.setEnabled(false);
        startRoundButton.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));
        startRoundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    startGame();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });


        JButton quitGameButton = new JButton("Quit Game");
        quitGameButton.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));
        quitGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setWelcomeContent();
            }
        });
        leftButtonPanel.add(startRoundButton);
        leftButtonPanel.add(quitGameButton);
        playerTablePanel.add(leftButtonPanel);
        JPanel playerHandPanel = new JPanel();
//        Player Hand as JPanels
//        for (int i = 0; i < gameST.userPlayer.Hand.size(); i++) {
//            MainUI.FaceUpCardPanel faceUpCard = new MainUI.FaceUpCardPanel(gameST.userPlayer.Hand.get(i).getFileName());
//            faceUpCard.setPreferredSize(new Dimension(200,300));
//            playerHandPanel.add(faceUpCard);
//        }
//        Player Hand as Buttons
        JButton cards[] = new JButton[gameST.userPlayer.Hand.size()];
        for (int i = 0; i < gameST.userPlayer.Hand.size(); i++) {

            ImageIcon cardImage = new ImageIcon("images/" + gameST.userPlayer.Hand.get(i).getFileName());
            Image img = cardImage.getImage();
            Image newImg = img.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
            cardImage = new ImageIcon(newImg);

            cards[i] = new JButton(cardImage);

            int finalI = i;
            cards[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO: 19/10/2016 implement click to select card to play
                    gameST.userPlayer.setCardToPlay(finalI);
                    System.out.println(finalI);
                    try {
                        gameST.cardInPlay = gameST.userPlayer.PlayCard(gameST.userPlayer, finalI);
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
//                    //MainUI.addMessageLabel("Choose category to play");
//                    MainUI.categoryPanel.setVisible(true);
//                    gameST.categoryNumber = gameST.userPlayer.getCategoryToPlay();
//                    MainUI.categoryPanel.setVisible(false);
//                    gameST.checkWinCondition(gameST.userPlayer);
                    playCardButton.setEnabled(true);
                }
            });
            cards[i].setPreferredSize(new Dimension(200, 300));
            playerHandPanel.add(cards[i]);
        }
        playerTablePanel.add(playerHandPanel);

        JPanel rightButtonPanel = new JPanel();
        rightButtonPanel.setLayout(new GridLayout(2, 1));
        playCardButton = new JButton("Play Card");
        playCardButton.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));
        playCardButton.setEnabled(false);
        passTurnButton = new JButton("Pass Turn");
        passTurnButton.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));
        passTurnButton.setEnabled(false);

        passTurnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gameST.passPlayerTurn(gameST.userPlayer);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        rightButtonPanel.add(playCardButton);
        rightButtonPanel.add(passTurnButton);
        playerTablePanel.add(rightButtonPanel);
        gameTablePanel.add(playerTablePanel);
        TablePanel.add(gameTablePanel);


        gameFrame.setContentPane(TablePanel);
        gameFrame.pack();

//        try {
//            startGame();
//        } catch (Exception e) { e.printStackTrace(); }
//
    }

    public static void startGame() throws Exception {
        if (!gameOver) {
            addMessageLabel("ROUND (" + (gameST.roundCount + 1) + ") STARTING");
            gameST.resetPassedPlayers();
            gameST.playGameRound();
            addMessageLabel("ROUND (" + gameST.roundCount + ") COMPLETE");
        }

    }

    public static void addMessageLabel(String message) {
        scrollPanel.add(new JLabel(message, SwingConstants.CENTER));
    }

    public static void showCardInPlay(Card cardInPlay) {

        ImageIcon cardImage = new ImageIcon("images/" + cardInPlay.getFileName());
        Image img = cardImage.getImage();
        Image newImg = img.getScaledInstance(180, 250, Image.SCALE_SMOOTH);
        cardInPlayImage.setImage(newImg);
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
            g.drawImage(backOfCard, 0, 0, 200, 300, null);
        }
    }

    public static class FaceUpCardPanel extends JPanel {
        BufferedImage cardFace;

        public FaceUpCardPanel(String imageFileName) {
            try {
                cardFace = ImageIO.read(new File("images/" + imageFileName));
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }

        public FaceUpCardPanel() {

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(cardFace, 0, 0, 200, 300, null);
        }
    }
}


















