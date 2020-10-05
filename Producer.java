public class Producer implements Runnable{
    private String name;
    private int timesToProduce;
    
    Semaphore mine, other; 

    public Producer(String name, int timesToProduce, Semaphore mine, Semaphore other) { 
        this.name = name;
        this.timesToProduce = timesToProduce;
        this.mine = mine;
        this.other = other;
    }

    @Override
    public void run() {
        for (int i = 0; i < timesToProduce; i++) { 
            mine.P();
                Main.buffer = i;
                System.out.println("Thread [" + name + "] wrote: " + i);
            other.V(); 
        } 
    }    
    
}
