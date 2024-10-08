package oop.garage;

public class Macchina extends MantainibleVehicle{
    private int posti;
    public Macchina(int post,int km, int kmFromLastManutenction, int ruote, String marca, String modello, String targa) {
        super(km, kmFromLastManutenction, ruote, marca, modello, targa);
        this.posti=posti;
    }

    @Override
    public int nextManutenction() {
        return 1000-super.getKmFromLastManutenction();
    }

    @Override
    public int manutenction() {
        super.manutenction();
        System.out.println("Manutenzione Macchina");
        System.out.println("Cambio Freni, Radiatore, Olio...");

        return 0;
    }

}
