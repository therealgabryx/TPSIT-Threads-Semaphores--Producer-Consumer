public class Semaphore {
    private int value;

    public Semaphore(int value) {
        this.value = value;
    } 

    synchronized public void P() {
        while (value == 0) {
            try {
                wait(); //il thread si sospende 
            } catch(InterruptedException e) {
                System.err.println(e.getMessage()); 
            } 
        } 
        value--; //semaforo a rosso 
    }

    synchronized public void V() {
        value++;
        notify();
    }

}