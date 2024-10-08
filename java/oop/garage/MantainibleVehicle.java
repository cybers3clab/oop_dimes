package oop.garage;

public abstract class MantainibleVehicle implements Manutentable,Vehicle{
    private int km;
    private int kmFromLastManutenction;
    private int ruote;
    private String marca;
    private String modello;
    private String targa;
    private String name;

    public MantainibleVehicle(int km, int kmFromLastManutenction, int ruote, String marca, String modello, String targa) {
        this.km = km;
        this.kmFromLastManutenction = kmFromLastManutenction;
        this.ruote = ruote;
        this.marca = marca;
        this.modello = modello;
        this.targa = targa;
        this.name=name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getWheels() {
        return 0;
    }

    @Override
    public int getKm() {
        return km;
    }

    public int getKmFromLastManutenction() {
        return kmFromLastManutenction;
    }


    @Override
    public String getLicensePlate() {
        return targa;
    }

    @Override
    public int manutenction(){
        System.out.println("Manutenzione");
        this.kmFromLastManutenction=0;
        return 0;
    }
}

















