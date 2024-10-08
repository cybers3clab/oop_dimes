package oop.garage;

public class Camion extends MantainibleVehicle{
    boolean rimorchio;
    public Camion(boolean rimorchio,int km, int kmFromLastManutenction, int ruote, String marca, String modello, String targa) {
        super(km, kmFromLastManutenction, ruote, marca, modello, targa);
        this.rimorchio=rimorchio;

    }

    public boolean getRimorchio() {
        return rimorchio;
    }

    @Override
    public int nextManutenction() {
        return 5000-super.getKmFromLastManutenction();
    }

    @Override
    public int manutenction(){
       super.manutenction();
       //if(rimorchio){
           //paga di più

       //}

        return 0;
    }
}
