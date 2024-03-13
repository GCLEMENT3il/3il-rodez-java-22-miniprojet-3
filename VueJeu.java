import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;

public class VueJeu {
    private JFrame frame;
    private JTextArea definitionArea;
    private JLabel tentativesLabel;
    private JTextField lettreField;
    private JButton submitButton;
    private JButton restartButton;
    private JTextArea lettresSoumisesArea;
    private JTextField motField;
    private JLabel compteurPartieLabel; // Label pour afficher le compteur de partie
    private JLabel tempsRestantLabel; // Label pour afficher le temps restant
    private ControleurJeu controleur;
    private JLabel imageLabel; // Label pour afficher l'image
    public VueJeu() {
        // Initialisation de la fenêtre
        frame = new JFrame("Devine le mot");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Initialisation des composants
        definitionArea = new JTextArea();
        definitionArea.setBounds(50, 20, 300, 70);
        definitionArea.setLineWrap(true);
        definitionArea.setWrapStyleWord(true);
        definitionArea.setEditable(false);



        imageLabel = new JLabel();
        imageLabel.setBounds(350, 20, 100, 100); // Ajustez la position et la taille selon vos besoins
        frame.add(imageLabel);






        tentativesLabel = new JLabel();
        tentativesLabel.setBounds(50, 100, 300, 30);

        lettreField = new JTextField();
        lettreField.setBounds(50, 140, 50, 30);

        submitButton = new JButton("Soumettre");
        submitButton.setBounds(120, 140, 100, 30);

        restartButton = new JButton("Redémarrer");
        restartButton.setBounds(250, 140, 100, 30);

        lettresSoumisesArea = new JTextArea();
        lettresSoumisesArea.setBounds(50, 180, 300, 80);
        lettresSoumisesArea.setEditable(false);

        motField = new JTextField();
        motField.setEditable(false);
        motField.setBounds(50, 280, 300, 30);

        // Initialisation du compteur de partie
        compteurPartieLabel = new JLabel();
        compteurPartieLabel.setBounds(50, 320, 300, 30);

        // Initialisation du temps restant
        tempsRestantLabel = new JLabel();
        tempsRestantLabel.setBounds(50, 360, 300, 30);

        // Ajout des composants à la fenêtre
        frame.add(definitionArea);
        frame.add(tentativesLabel);
        frame.add(lettreField);
        frame.add(submitButton);
        frame.add(restartButton);
        frame.add(lettresSoumisesArea);
        frame.add(motField);
        frame.add(compteurPartieLabel);
        frame.add(tempsRestantLabel);

        // Ajout d'un KeyListener pour gérer la touche "Entrée"
        lettreField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                submitButton.doClick();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {}

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });
    }

    public void afficher() {
        frame.setVisible(true);
    }

    public void cacher() {
        frame.setVisible(false);
    }

    public void setDefinition(String definition) {
        definitionArea.setText("Définition : " + definition);
    }

    public void setTentativesRestantes(int tentativesRestantes) {
        tentativesLabel.setText("Tentatives restantes : " + tentativesRestantes);
        updateImage(tentativesRestantes);
    }

    public String getLettreSoumise() {
        return lettreField.getText().trim().toLowerCase();
    }

    public void resetChampLettre() {
        SwingUtilities.invokeLater(() -> lettreField.setText(""));
    } // Permet de réinitialiser le champ de texte

    public void ajouterLettreSoumise(String lettre) {
        lettresSoumisesArea.append(lettre + " ");
    }

    public String getMotCache() {
        return motField.getText();
    }

    public void setMotCache(String motCache) {
        motField.setText(motCache);
    }

    public String getLettresSoumises() {
        return lettresSoumisesArea.getText().toLowerCase();
    }

    public void disableInputFields() {
        lettreField.setEnabled(false);
        submitButton.setEnabled(false);
    }

    public void resetVue() {
        definitionArea.setText("");
        tentativesLabel.setText("");
        lettreField.setText("");
        lettresSoumisesArea.setText("");
        motField.setText("");
        lettreField.setEnabled(true);
        submitButton.setEnabled(true);
    }

    public void addSoumettreListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public void addRedemarrerListener(ActionListener listener) {
        restartButton.addActionListener(listener);
    }

    public void setControleur(ControleurJeu controleur) {
        this.controleur = controleur;
    }

    public void setCompteurPartie(int compteurPartie) {
        compteurPartieLabel.setText("Partie #" + compteurPartie);
    }

    public void setTempsRestant(int tempsRestant) {
        int minutes = tempsRestant / 60;
        int secondes = tempsRestant % 60;
        tempsRestantLabel.setText("Temps restant : " + String.format("%02d:%02d", minutes, secondes));
    }



    private void updateImage(int tentativesRestantes) {
        String imagePath;
        switch (tentativesRestantes) {
            case 5:
                imagePath = "téléchargement.png";
                break;
            case 4:
                imagePath = "téléchargement2.png";
                break;
            case 3:
                imagePath = "téléchargement.png";
                break;
            case 2:
                imagePath = "téléchargement2.png";
                break;
            case 1:
                imagePath = "téléchargement.png";
                break;
            default:
                imagePath = "téléchargement2.png";
                break;
        }
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));
        imageLabel.setIcon(imageIcon);
    }
}
