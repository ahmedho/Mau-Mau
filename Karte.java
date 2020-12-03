public class Karte {
    private final Farbe FARBE;
    private final Wert WERT;

    private Karte(Farbe farbe, Wert wert) {
        this.FARBE = farbe;
        this.WERT = wert;
    }

    @Override
    public String toString() {
        return (this.FARBE.toString() + this.WERT.toString());
    }

    /** Returns a new Card instance.
     *
     * @param farbe, the color of the new Card.
     * @param wert, the value of the new card.
     * @return a neu instance from the type Card.
     */
    public static Karte neueKarte(Farbe farbe, Wert wert) {
        return new Karte(farbe, wert);
    }

    /** Returns a new Card instance. The parameters can be specified as valid strings.
     *
     * @param farbe, the color of the new Card. String representative of the color(farbe) enum.
     * @param wert, the value of the new card. String representative of the value(wert) enum.
     * @return a neu instance from the type Card.
     */
    public static Karte neueKarte(String farbe, String wert) {
        return neueKarte(Farbe.valueOf(farbe), Wert.valueOf(wert));
    }

    /** Returns the number of possible unique color-value combinations.
     *
     * @return Number of unique color-value combinations.
     */
    public static int kombinationen() {
        return (Farbe.values().length * Wert.values().length);
    }

    /** Generates a (Skatblatt) as a card array by iterating over color and value and returns this.
     *
     * @return Skatblatt as Cards-Array
     */
    public static Karte[] skatblatt() {
        Karte[] skatblatt = new Karte[Karte.kombinationen()];

        int i = 0;
        for (Farbe f : Farbe.values()) {
            for (Wert w : Wert.values()) {
                skatblatt[i] = Karte.neueKarte(f, w);
                i++;
            }
        }
        return skatblatt;
    }

    /** Checks whether this card serves another.
     *
     * @param other, the card to be checked on.
     * @return True, when this card serves the other card. False if not.
     */
    public boolean bedient(Karte other) {
        return (this.FARBE == other.FARBE || this.WERT == other.WERT || this.WERT == Wert.BUBE);
    }

    /** Checks whether at least one of the cards handed over uses this card.
     *
     * @param karten, cards to be checked.
     * @return True, if one of the cards serves this card.
     */
    public boolean bedienbar(Karte... karten) {
        for (Karte karte : karten) {
            if(karte.bedient(this)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     */
    public static void druckeEinbahnBedienungen(){
            int number = kombinationen();
            Karte karten[] = skatblatt();
            for(int i = 0 ; i < number ; i++){
                for(int j = 0 ; j < number ; j++){
                    Karte k1 = karten[i];
                    Karte k2 = karten[j];
                    if(k1.bedient(k2)== true && k2.bedient(k1) == false){
                        System.out.println(k1 + " bedient " + k2 + ", aber " + k2 + " nicht " + k1);
                    }
                }
            }
        }
    }
