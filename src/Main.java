import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Main extends JFrame {
    private JLabel promptLabel;
    private JTextField guessField;
    private JButton flipButton;
    private JLabel resultLabel;
    private JLabel scoreLabel;

    private int correctCount = 0;
    private int incorrectCount = 0;

    public Main() {
        // Set up the JFrame
        setTitle("Coin Flip Simulator");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a panel for user input
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        // Prompt label
        promptLabel = new JLabel("Enter your guess (heads/tails):");
        inputPanel.add(promptLabel);

        // Text field for user input
        guessField = new JTextField(10);
        inputPanel.add(guessField);

        // Button to flip the coin
        flipButton = new JButton("Flip Coin");
        inputPanel.add(flipButton);

        // Add input panel to the top of the frame
        add(inputPanel, BorderLayout.NORTH);

        // Panel for results and score
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(2, 1));

        // Label to display the result
        resultLabel = new JLabel("Result: ", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultPanel.add(resultLabel);

        // Label to display the score
        scoreLabel = new JLabel("Correct: 0 | Incorrect: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        resultPanel.add(scoreLabel);

        // Add result panel to the center of the frame
        add(resultPanel, BorderLayout.CENTER);

        // Add action listener to the button
        flipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userGuess = guessField.getText().toLowerCase().trim();
                String coinResult = coinFlip();

                if (userGuess.equals("heads") || userGuess.equals("tails")) {
                    if (userGuess.equals(coinResult)) {
                        resultLabel.setText("Correct! It was " + coinResult + ".");
                        correctCount++;
                    } else {
                        resultLabel.setText("Incorrect! It was " + coinResult + ".");
                        incorrectCount++;
                    }
                    scoreLabel.setText("Correct: " + correctCount + " | Incorrect: " + incorrectCount);
                } else {
                    resultLabel.setText("Please enter 'heads' or 'tails'.");
                }
            }
        });
    }

    public static void main(String[] args) {
        // Run the GUI in the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }


    public static String coinFlip() {
        int coin = (int) (Math.random() * 2) + 1;
        String heads = "heads";
        String tails = "tails";

        if (coin == 1) {
            return heads;
        } else if (coin == 2) {
            return tails;
        }
        return null;
    }
}