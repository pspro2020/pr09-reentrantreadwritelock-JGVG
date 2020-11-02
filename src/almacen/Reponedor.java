package almacen;

import java.util.concurrent.TimeUnit;
import java.util.Random;

public class Reponedor implements Runnable {
    Almacen almacen;
    Random r = new Random();

    public Reponedor(Almacen almacen) {
        this.almacen = almacen;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            almacen.añadirProducto(r.nextInt(3)+1);
        }
    }
}
