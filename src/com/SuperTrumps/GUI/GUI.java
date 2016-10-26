package com.SuperTrumps.GUI;

import com.SuperTrumps.Card;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {

    public static JFrame game_Frame;
    public static JPanel welcome_panel;
    private static JPanel setup_panel;
    private static JPanel setupName_panel;
    private static JPanel setupPlayers_panel;
    public static JPanel gameTable_panel;
    private static JPanel comPlayer_panel;
    public static JTextField name_textField;
    public static JButton startGame_button;
    public static JComboBox numPlayers_comboBox;
    private static JPanel gameArea_panel;
    private static JPanel playArea_panel;
    private static JPanel gameMessage_panel;
    private static JScrollPane gameMessage_scrollPane;
    private static JPanel player_panel;
    private static JPanel playerHand_panel;
    private static JPanel playerButtons_panel;


    public void buildFrame() {
        game_Frame = new JFrame("Mineral SuperTrumps");
        game_Frame.setVisible(true);
        game_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game_Frame.pack();
    }

    public void buildWelcomePanel() {
        welcome_panel = new JPanel();
        welcome_panel.setLayout(new GridLayout(2,1));

        JLabel welcome_label = new JLabel("Welcome to the Mineral SuperTrumps game");
        welcome_label.setFont(new Font("Lantinghei SC", Font.PLAIN, 26));

        JButton newGame_button = new JButton("NEW GAME");
        newGame_button.setFont(new Font("Lantinghei SC", Font.PLAIN, 20));

        newGame_button.addActionListener(e -> {
            welcome_panel.setVisible(false);
            game_Frame.setContentPane(setup_panel);
        });

        welcome_panel.add(welcome_label);
        welcome_panel.add(newGame_button);
    }

    public void buildSetupPanel() {
        setup_panel = new JPanel();
        setup_panel.setLayout(new GridLayout(4, 1));

        JLabel setup_label = new JLabel("Choose game settings");
        setup_label.setFont(new Font("Lantinghei SC", Font.PLAIN, 26));

        buildSetupNamePanel();

        buildSetupPlayersPanel();

        startGame_button = new JButton("START GAME"); //todo: Add Listener
        startGame_button.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));
        startGame_button.setEnabled(false);

        startGame_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setup_panel.setVisible(false);
                run.runGame();
            }
        });

        setup_panel.add(setup_label);
        setup_panel.add(setupName_panel);
        setup_panel.add(setupPlayers_panel);
        setup_panel.add(startGame_button);
    }

    private void buildSetupNamePanel() {
        setupName_panel = new JPanel();

        JLabel name_label = new JLabel("Enter your name");
        name_label.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));
        name_textField = new JTextField(10);
        name_textField.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));

        name_textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!name_textField.getText().equals("")) {startGame_button.setEnabled(true);}
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!name_textField.getText().equals("")) {startGame_button.setEnabled(true);}
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (!name_textField.getText().equals("")) {startGame_button.setEnabled(true);}
            }
        });

        setupName_panel.add(name_label);
        setupName_panel.add(name_textField);
    }

    private void buildSetupPlayersPanel() {
        setupPlayers_panel = new JPanel();

        JLabel numPlayers_label = new JLabel("Number of opponents");
        numPlayers_label.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));
        Integer[] nums = {2,3,4};
        numPlayers_comboBox = new JComboBox(nums); //todo: Add listener?
        numPlayers_comboBox.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));

        setupPlayers_panel.add(numPlayers_label);
        setupPlayers_panel.add(numPlayers_comboBox);
    }

    public void buildGameTablePanel() {
        gameTable_panel = new JPanel();
        gameTable_panel.setLayout(new GridLayout(3,1));

        buildComPlayerPanel();
        buildGameAreaPanel();
        buildPlayerPanel();

        gameTable_panel.add(comPlayer_panel);
        gameTable_panel.add(gameArea_panel);
        gameTable_panel.add(player_panel);
    }

    private void buildComPlayerPanel() {
        comPlayer_panel = new JPanel();

        JLabel comPlayer_labels[] =new JLabel[run.gameST.numPlayers];
        for (int i = 0; i < run.gameST.numPlayers; i++) {
            comPlayer_labels[i] = new JLabel(run.gameST.comPlayer[i].playerName + "\n" + " Cards " + run.gameST.comPlayer[i].Hand.size(), SwingConstants.CENTER);
            comPlayer_labels[i].setFont(new Font("Lantinghei SC", Font.PLAIN, 18));
            comPlayer_panel.add(comPlayer_labels[i]);
        }
    }

    private void buildGameAreaPanel() {
        gameArea_panel = new JPanel();

        buildPlayAreaPanel();
        buildGameMessagePanel();

        gameArea_panel.add(playArea_panel);
        gameArea_panel.add(gameMessage_panel);
    }

    private void buildPlayAreaPanel() {
        playArea_panel = new JPanel();

        JLabel gameDeck_label = new JLabel("SuperTrump Deck: " + run.gameST.cardDeck.size(), SwingConstants.CENTER);
        gameDeck_label.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));

        ImageIcon faceDownCard = new ImageIcon(new ImageIcon("images/Slide65.jpg").getImage().getScaledInstance(180, 250, Image.SCALE_SMOOTH));
        JLabel deckImage_label = new JLabel(faceDownCard);

        playArea_panel.add(gameDeck_label);
        playArea_panel.add(deckImage_label);

    }

    private void buildGameMessagePanel() {

        gameMessage_scrollPane = new JScrollPane(new JPanel());
        gameMessage_scrollPane.setLayout(new ScrollPaneLayout());
        gameMessage_scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        gameMessage_scrollPane.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));
        gameMessage_scrollPane.add(new JLabel("Game status", SwingConstants.CENTER)).setFont(new Font("Lantinghei SC", Font.PLAIN, 24));

        //gameMessage_panel.setLayout(new BoxLayout(gameMessage_scrollPane, BoxLayout.Y_AXIS));
        gameMessage_panel.add(gameMessage_scrollPane);

    }

    private void buildPlayerPanel() {
        player_panel = new JPanel();

        buildPlayerHandPanel();
        buildPlayerButtonsPanel();

        player_panel.add(playerHand_panel);
        player_panel.add(playerButtons_panel);
    }

    private void buildPlayerHandPanel() {
        playerHand_panel = new JPanel();
        JButton cards[] = new JButton[run.gameST.userPlayer.Hand.size()];
        for (int i = 0; i < run.gameST.userPlayer.Hand.size(); i++) {

            cards[i] = new JButton((Action) displayCard(run.gameST.userPlayer.Hand.get(i)));
            playerHand_panel.add(cards[i]);

        }
    }

    private void buildPlayerButtonsPanel() {
        playerButtons_panel = new JPanel();
        playerButtons_panel.setLayout(new GridLayout(3,1));
        playerButtons_panel.setFont(new Font("Lantinghei SC", Font.PLAIN, 18));

        JButton playCard_button = new JButton("PLAY CARD");
        JButton passTurn_button = new JButton("PASS TURN");
        JButton quitGame_button = new JButton("QUIT GAME");

        playerButtons_panel.add(playCard_button);
        playerButtons_panel.add(passTurn_button);
        playerButtons_panel.add(quitGame_button);
    }

    private Image displayCard(Card card) {
        ImageIcon cardImage = new ImageIcon("images/" + card.getFileName());
        Image img = cardImage.getImage() ;
        Image newImg = img.getScaledInstance( 180, 250,  Image.SCALE_SMOOTH ) ;
        return newImg;

    }
}



















