package GarbageCollector;

/**
 * Created by blackwidow on 23/09/16.
 */
public class GarbageC {
    public static void main(String[] args) {
        GarbageC c = new GarbageC();
        c = null;
        System.gc();
    }

    public GarbageC(){

    }

    protected void finalize(){
        System.out.println("El programa a finalizado");
    }

}
