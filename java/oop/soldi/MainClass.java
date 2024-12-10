package oop.soldi;

import java.io.*;

public class MainClass {
    public static Soldi carica(String path){
        BufferedReader br=null;
        Soldi sl=new SoldiList();
        try{
            br= new BufferedReader(new FileReader(path));
            String line;
            while ((line= br.readLine()) != null){
                String [] splitted=line.split("#");
                String pezzi= splitted[0];
                String taglio= splitted[1].replace("$","");
                DenaroConcreto d= new DenaroConcreto(Double.valueOf(taglio),Integer.valueOf(pezzi));
                sl.add(d);
            }

        }
        catch (IOException e){

        }
        finally {

        }
        return sl;
    }

    public static void salva(Soldi s,String path){
        BufferedWriter bw = null;
        try {
            bw=new BufferedWriter(new FileWriter(path));
            for (Denaro d : s) {
                bw.write(d.getQuantita()+"#"+d.getValore()+"$");
                bw.newLine();
            }
        }
        catch (IOException e){
            System.out.println("Errore");
        }
        finally {
            try {
            if(bw != null) {
                bw.close();
            }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        String path="mymoney.txt";
        Soldi sl= new SoldiLC();
        Soldi sl2= new SoldiLC();
        sl.add(new DenaroConcreto(0.01,10));
        sl.add(new DenaroConcreto(0.1,10));
        sl.add(new DenaroConcreto(0.5,10));
        sl.add(new DenaroConcreto(0.1,10));
        sl.add(new DenaroConcreto(0.5,10));
        salva(sl,path);

        sl2.add(new DenaroConcreto(0.01,40));
        System.out.println(sl);
        sl2.add(new DenaroConcreto(0.1,50));
        sl2.add(new DenaroConcreto(0.5,12));

        System.out.println(sl);
        System.out.println(sl2);

        sl.paga(sl2,sl);

        System.out.println(sl);

        Soldi s2=carica(path);
        System.out.println(s2);

    }
}
