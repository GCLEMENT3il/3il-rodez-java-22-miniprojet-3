import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControleurJeu {
    private Partie partie;
    private VueJeu vue;
    private int compteurPartie; // Compteur de partie
    private Timer timer; // Timer pour le jeu
    private int tempsRestant; // Temps restant en secondes

    public ControleurJeu(VueJeu vue) {
        this.vue = vue;
        this.vue.addRedemarrerListener(new RedemarrerListener());
        this.vue.addSoumettreListener(new SoumettreListener());
        initialiserPartie();
        démarrerTimer(); // Démarrer le timer lors de l'initialisation du jeu
    }

    private void initialiserPartie() {
        try {
            String[] motsEtDefinition = LectureFichier.lireMotEtDefinition("mots.txt");
            Mot mot = new Mot(motsEtDefinition[0], motsEtDefinition[1]);
            partie = new Partie(mot, 5); // Le nombre de tentatives est fixé
            vue.resetVue();
            vue.setDefinition(partie.getMotADeviner().getDefinition());
            vue.setTentativesRestantes(partie.getTentativesMax());
            vue.setMotCache(genererMotCache(partie.getMotADeviner().getMot()));

            compteurPartie++; // Incrémenter le compteur de partie
            vue.setCompteurPartie(compteurPartie); // Afficher le compteur dans l'interface graphique
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private void démarrerTimer() {
        tempsRestant = OptionDujeu.getInstance().getTempsDeLaPartie(); // Temps de la partie en secondes
        timer = new Timer(1000, new ActionListener() { // Timer qui se déclenche toutes les secondes (1 seconde = 1000 millisecondes)
            @Override
            public void actionPerformed(ActionEvent e) {
                tempsRestant--;
                if (tempsRestant >= 0) {
                    vue.setTempsRestant(tempsRestant);
                } else {
                    timer.stop();
                    JOptionPane.showMessageDialog(null, "Le temps est écoulé !");
                    vue.disableInputFields(); // Désactiver les champs de saisie
                }
            }
        });
        timer.start();
    }

    class RedemarrerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            timer.stop(); // Arrêter le timer lors de la réinitialisation de la partie
            initialiserPartie();
            démarrerTimer(); // Redémarrer le timer
        }
    }

    class SoumettreListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String lettre = vue.getLettreSoumise();
            if (!lettre.matches("[a-zé-]")) {
                JOptionPane.showMessageDialog(null, "Veuillez entrer une lettre de l'alphabet ou é ou -.");
                return;
            }

            vue.ajouterLettreSoumise(lettre);

            if (partie.getMotADeviner().getMot().contains(lettre)) {
                // Mettre à jour le mot caché
                String motCache = vue.getMotCache();
                String motDevine = partie.getMotADeviner().getMot();
                StringBuilder sb = new StringBuilder(motCache);
                for (int i = 0; i < motDevine.length(); i++) {
                    if (motDevine.charAt(i) == lettre.charAt(0)) {
                        sb.setCharAt(i, lettre.charAt(0));
                    }
                }
                vue.setMotCache(sb.toString());

                if (!vue.getMotCache().contains("-")) {
                    JOptionPane.showMessageDialog(null, "Félicitations ! Vous avez deviné le mot : " + motDevine);
                    vue.disableInputFields();
                    timer.stop(); // Arrêter le timer lorsque le jeu est terminé
                }
            } else {
                partie.decrementerTentativesRestantes();
                vue.setTentativesRestantes(partie.getTentativesRestantes());
                if (partie.estTentativesEpuisees()) {
                    JOptionPane.showMessageDialog(null, "Vous avez épuisé toutes les tentatives.\nLe mot était : " + partie.getMotADeviner().getMot());
                    vue.disableInputFields();
                    timer.stop(); // Arrêter le timer lorsque le jeu est terminé
                }
            }

            vue.resetChampLettre(); // Effacer le contenu du champ de texte après la soumission
        }
    }

    private String genererMotCache(String mot) {
        StringBuilder motCache = new StringBuilder();
        for (int i = 0; i < mot.length(); i++) {
            motCache.append("-");
        }
        return motCache.toString();
    }
}
