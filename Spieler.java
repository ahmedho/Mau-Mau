public class Spieler {

    private Karte[] kartenhand;
    private String name;
    private double siegesquote;

    public Spieler(String name) {
        this.name = name;
    }

    public Spieler(String name, double siegesquote) {
        this(name);
        this.siegesquote = siegesquote;
    }

    public Spieler(String name, double siegesquote, Karte[] kartenhand) {
        this(name, siegesquote);
        this.kartenhand = kartenhand;
    }

    @Override
    public String toString() {
        return this.name;
    }

    /** Returns the best player for a given club (Spieler-Array). Comparison based on victory rate.
     *
     * @param club, The player array in which the best player should be determined.
     * @return the best player in club.
     */
    public static Spieler besterSpieler(Spieler... club) {
        Spieler besterSpieler = club[0];

        for (Spieler s : club) {
            besterSpieler = s.siegesquote > besterSpieler.siegesquote ? s : besterSpieler;
        }
        return besterSpieler;
    }

    /** Indicates whether this player can operate a certain card or not.
     *
     * @param k, the card that is to be served.
     */
    public void kannBedienen(Karte k) {
        System.out.println(this.name + (k.bedienbar(this.kartenhand) ? "kann bedienen!" : "kann nicht bedienen!"));
    }

    /** Start the program. Performs some test functions.
     *
     * @param args, are ignored.
     */
    public static void main(String[] args) {
        // Initialize example players
        Spieler s0 = new Spieler("Elisabeth", 0.375);
        Spieler s1 = new Spieler("Klaus", 0.125);
        Spieler s2 = new Spieler("Helmut", 0.3875);
        Spieler s3 = new Spieler("Erwin", 0.1125);
        // Set best player
        Spieler bs = Spieler.besterSpieler(s0, s1, s2, s3);

        // Initialize sample cards
        Karte[] karten = {Karte.neueKarte(Farbe.HERZ, Wert.SIEBEN), Karte.neueKarte(Farbe.HERZ, Wert.NEUN), Karte.neueKarte(Farbe.KARO, Wert.KOENIG)};

        // Give sample cards to best player
        bs.kartenhand = karten;

        // Check whether the best player can serve the jack of diamonds
        bs.kannBedienen(Karte.neueKarte(Farbe.KARO, Wert.BUBE));
    }
}
