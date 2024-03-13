public class Partie {
    private Mot motADeviner;
    private int tentativesMax;
    private int tentativesRestantes;

    public Partie(Mot motADeviner, int tentativesMax) {
        this.motADeviner = motADeviner;
        this.tentativesMax = tentativesMax;
        this.tentativesRestantes = tentativesMax;
    }

    public Mot getMotADeviner() {
        return motADeviner;
    }

    public int getTentativesMax() {
        return tentativesMax;
    }

    public int getTentativesRestantes() {
        return tentativesRestantes;
    }

    public void decrementerTentativesRestantes() {
        tentativesRestantes--;
    }

    public boolean estTentativesEpuisees() {
        return tentativesRestantes <= 0;
    }
}
