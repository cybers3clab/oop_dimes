package oop.cards;

public enum Valore {
    ASSO(11),DUE(0),TRE(10),QUATTRO(0),CINQUE(0),SEI(0),SETTE(0),DONNA(2),CAVALLO(3),RE(4);
    private final int points;

    private Valore(int points){
        this.points=points;
    }
    public int getPoints(){

             return points;
    }



}
