package oop.garage;

public class Moto extends MantainibleVehicle{
    private int cilindrata;

    public Moto(int cilindrata,int km, int kmFromLastManutenction, int ruote, String marca, String modello, String targa) {
        super(km, kmFromLastManutenction, ruote, marca, modello, targa);
        this.cilindrata=cilindrata;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    @Override
    public String details() {
        return super.details();
    }

    @Override
    public int nextManutenction() {
        int manutenzione=500;

        return manutenzione-super.getKmFromLastManutenction();
    }
    @Override
    public int manutenction(){
        super.manutenction();
        System.out.println("Manutenzione Moto");
        System.out.println("Cambio Freni, Catena, Forcella...");
        return 0;
    }
}
