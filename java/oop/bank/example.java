package oop.bank;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class example {
    public void prova(){

        Object shapes = null;
        var file="";

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(shapes);
            oos.flush();
        } catch (FileNotFoundException ex) {
            // complain to user
        } catch (IOException ex) {
            // notify user
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    // ignore ... any significant errors should already have been
                    // reported via an IOException from the final flush.
                }
            }
        }
    }
}
