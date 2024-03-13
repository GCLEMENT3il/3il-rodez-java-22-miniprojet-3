public class Main {
    public static void main(String[] args) {
        VueJeu vue = new VueJeu();
        ControleurJeu controleur = new ControleurJeu(vue);
        vue.setControleur(controleur);
        vue.afficher();
    }
}