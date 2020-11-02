package almacen;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Almacen {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private final ReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(true);
    private final Lock readLock = reentrantReadWriteLock.readLock();
    private final Lock writeLock = reentrantReadWriteLock.writeLock();
    List<Integer> stock = new ArrayList<Integer>();

    public void añadirProducto(int num_product) {
        writeLock.lock();
        try {
            Thread.sleep(2000);
            stock.add(num_product);
            System.out.printf("%s -> %s ha añadido el producto %d al stock.\n", LocalTime.now().format(dateTimeFormatter), Thread.currentThread().getName(), num_product);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }
    }

    public void consultarProducto(int num_product) {
        readLock.lock();
        try {
            int contador = 0;
            for (int producto: stock){
                if(producto == num_product){
                    contador++;
                }
            }
            Thread.sleep(500);
            System.out.printf("%s -> %s ha contado %d productos de productos %d.\n", LocalTime.now().format(dateTimeFormatter), Thread.currentThread().getName(), contador, num_product);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            readLock.unlock();
        }
    }
}
