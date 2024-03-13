import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DifficultySelection extends JFrame {

    private JComboBox<String> difficultyComboBox;
    private JButton startButton;

    public DifficultySelection() {
        setTitle("Sélection de la difficulté");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 150);
        setLocationRelativeTo(null); // Centrer la fenêtre

        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));

        JLabel label = new JLabel("Sélectionnez la difficulté :");
        panel.add(label);

        difficultyComboBox = new JComboBox<>();
        difficultyComboBox.addItem("Difficile (5 minutes)");
        difficultyComboBox.addItem("Moyenne (10 minutes)");
        difficultyComboBox.addItem("Facile (15 minutes)");
        panel.add(difficultyComboBox);

        startButton = new JButton("Commencer");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        panel.add(startButton);

        add(panel);
    }

    private void startGame() {
        String difficulty = (String) difficultyComboBox.getSelectedItem();
        long time = 0;

        if (difficulty.startsWith("Difficile")) {
            time = 300; // 5 minutes en seconde
        } else if (difficulty.startsWith("Moyenne")) {
            time = 600; // 10 minutes en seconde
        } else if (difficulty.startsWith("Facile")) {
            time = 900; // 15 minutes en seconde
        }

        OptionDujeu.getInstance().setTempsDeLaPartie((int) time); // Définir la durée de la partie
        dispose(); // Fermer la fenêtre de sélection de la difficulté
        Main.main(new String[]{String.valueOf(time)}); // Démarrer la classe Main2 avec le temps sélectionné
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DifficultySelection().setVisible(true);
            }
        });
    }
}
