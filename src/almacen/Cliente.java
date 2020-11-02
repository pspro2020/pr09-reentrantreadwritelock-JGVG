package almacen;

import java.util.concurrent.TimeUnit;

public class Cliente implements Runnable {
    int num_product;
    Almacen almacen;

    public Cliente(Almacen almacen, int num_product) {
        this.almacen = almacen;
        this.num_product = num_product;
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            almacen.consultarProducto(num_product);
        }
    }
}
