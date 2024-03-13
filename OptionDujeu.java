public class OptionDujeu {

    private static OptionDujeu INSTANCE = null;
    private OptionDujeu() {}
    private int tempsDeLaPartie;
    public synchronized static OptionDujeu getInstance()
    {
        if (INSTANCE == null)
            INSTANCE = new OptionDujeu();
        return INSTANCE;
    }

    public int getTempsDeLaPartie() {
        return tempsDeLaPartie;
    }

    public void setTempsDeLaPartie(int tempsDeLaPartie) {
        this.tempsDeLaPartie = tempsDeLaPartie;
    }
}
