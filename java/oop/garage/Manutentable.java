package oop.garage;

public interface Manutentable {
    int nextManutenction();
    int manutenction();

    static boolean eseguiManutenzioneLista(Manutentable[] list){
        for (int i = 0; i < list.length; i++) {
            list[i].manutenction();
        }
        return true;
    }
 }













