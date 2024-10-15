package oop.garage;

public class ParcoVeicoli {
    public static void main(String[] args) {
        Moto m= new Moto(1000,500,200,2,"Ducati","V4","AX532");
        Macchina m2=new Macchina(2000,10400,900,4,"fiat","panda","A35232");
        Camion c= new Camion(true,100000,5000,2,"IVECO","V324","AAAA333");

        Manutentable[] list={m,m2,c};
        boolean b = Manutentable.eseguiManutenzioneLista(list);




    }
}
