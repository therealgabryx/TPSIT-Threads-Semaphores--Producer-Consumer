class Main {
    static int buffer;

    public static void main(String[] args) { 
    Semaphore full, empty;
    empty = new Semaphore(1);
    full = new Semaphore(0);
    
    Thread p = new Thread(new Producer("produttore", 3, empty, full));
    Thread c = new Thread(new Consumer("consumatore", 3, full, empty));
    System.out.println(); 

    p.start();
    c.start();
  } 
}  