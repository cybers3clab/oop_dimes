package oop.soldi;

public enum Taglio {
    UN_CENT(0.01),
    DUE_CENT(0.02),
    //continua come sopra
    CINQUE_CENT(0.05),
    DIECI_CENT(0.1),
    VENTI_CENT(0.2),
    CINQUANTA_CENT(0.5),
    UN_EURO(1.0),
    DUE_EURO(2.0),
    CINQUE_EURO(5.0),
    DIECI_EURO(10.0),
    VENTI_EURO(20.0),
    CINQUANTA_EURO(50.0),
    CENTO_EURO(100.0);

    private final double value;
    Taglio(double value) {
        this.value=value;
    }

    public double getValue(){
        return this.value;
    }

    public static Taglio findByValue(Double value){
        Taglio result = null;
        for( Taglio t : values()){
            if (value.equals(t.getValue())) {
                return t;
            }
        }
        throw new IllegalArgumentException("Taglio non corretto");
    }

}
