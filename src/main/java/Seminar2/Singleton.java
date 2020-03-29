package Seminar2;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Singleton {

    private  static AtomicReference<Singleton> INSTANCE  = new AtomicReference<>();
    private int id;
    private  static final AtomicInteger counter = new AtomicInteger(0);

    private Singleton(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public static Singleton getInstance() {
        INSTANCE.compareAndSet(null, new Singleton(counter.getAndIncrement()));
        return INSTANCE.get();
    }
}
