import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class LectureFichier {
public static String[] lireMotEtDefinition(String cheminFichier) throws IOException {
            ArrayList<String> lignes = lireFichier(cheminFichier);
            Random rand = new Random();
            String ligneAleatoire = lignes.get(rand.nextInt(lignes.size()));
            String[] motsEtDefinition = ligneAleatoire.split("\\s+", 2);
            return motsEtDefinition;
        }

        private static ArrayList<String> lireFichier(String cheminFichier) throws IOException {
            ArrayList<String> lignes = new ArrayList<>();
            try (BufferedReader lecteur = new BufferedReader(new FileReader(cheminFichier))) {
                String ligne;
                while ((ligne = lecteur.readLine()) != null) {
                    lignes.add(ligne);
                }
            }
            return lignes;
        }
    }
