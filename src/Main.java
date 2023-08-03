import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("DiceRoller GUI");

        JButton rollButton = new JButton("Roll the dice!");
        JComboBox<String> diceSelector = new JComboBox<>(new String[]{"D4", "D6", "D8", "D10", "D12", "D20", "D30"}); // Add dice options

        JPanel panel = new JPanel(); // Create a new panel to hold the components
        panel.setLayout(new FlowLayout()); // Set the layout manager for the panel
        panel.add(rollButton); // Add the roll button to the panel

        // Set the preferred size of the JComboBox to make the dropdown menu larger
        //diceSelector.setPreferredSize(new Dimension(150, diceSelector.getPreferredSize().height));

        panel.add(diceSelector); // Add the dice selector menu to the panel

        frame.add(panel); // Add the panel to the frame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension size = e.getComponent().getSize();
                rollButton.setSize(size.width / 2, size.height / 5);
                rollButton.setLocation((size.width - rollButton.getWidth()) / 2, (size.height - rollButton.getHeight()) / 2);
            }
        });

        frame.setSize(600, 500);

        rollButton.addActionListener(e -> {
            String selectedDice = (String) diceSelector.getSelectedItem(); // Get the selected dice from the menu
            // You can now implement the logic to roll the selected dice and display the result
            // For example, you can use JOptionPane to show a message with the result.
            JOptionPane.showMessageDialog(frame, "You rolled a " + selectedDice + " and got " + rollDice(selectedDice) + "!");
        });

        frame.setVisible(true);
    }

    private static int rollDice(String dice) {
        // Implement the logic to roll the dice and return the result
        // For simplicity, let's just return a random number from 1 to the maximum value of the dice.
        return switch (dice) {
            case "D4" -> (int) (Math.random() * 4) + 1;
            case "D6" -> (int) (Math.random() * 6) + 1;
            case "D8" -> (int) (Math.random() * 8) + 1;
            case "D10" -> (int) (Math.random() * 10) + 1;
            case "D12" -> (int) (Math.random() * 12) + 1;
            case "D20" -> (int) (Math.random() * 20) + 1;
            case "D30" -> (int) (Math.random() * 30) + 1;
            default -> 0;
        };
    }
}
