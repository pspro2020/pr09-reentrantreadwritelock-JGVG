package almacen;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();

        Thread reponedor = new Thread(new Reponedor(almacen));
        Thread cliente01 = new Thread(new Cliente(almacen, 1));
        Thread cliente02 = new Thread(new Cliente(almacen, 2));
        Thread cliente03 = new Thread(new Cliente(almacen, 3));

        reponedor.start();
        cliente01.start();
        cliente02.start();
        cliente03.start();

        try {
            TimeUnit.SECONDS.sleep(60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        reponedor.interrupt();
        cliente01.interrupt();
        cliente02.interrupt();
        cliente03.interrupt();

    }
}
