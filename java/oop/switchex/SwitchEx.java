package oop.switchex;

public class SwitchEx {

    public static void main(String[] args) {

        //classic fallthrough switch

        int v=2;//esempio

        switch (v){
            case 0:
            case 2:
                System.out.println("Numero pari <4"); break;
            case 1:
            case 3:
                System.out.println("Numero dispari <4"); break;
            default:
                System.out.println("Numero  >=4");
        }

        String s=switch (v){
            case 0:
            case 2:
                yield "Numero pari <4";
            case 1:
            case 3:
                yield "Numero dispari <4";

            default:
                yield "Numero  >=4";
        };

        System.out.println(s);

    }

}
