public class Consumer implements Runnable{
    private String name;
    private int timesToConsume;
    
    Semaphore mine, other; 

    public Consumer(String name, int timesToConsume, Semaphore mine, Semaphore other) { 
        this.name = name;
        this.timesToConsume = timesToConsume;
        this.mine = mine;
        this.other = other;
    }

    @Override
    public void run() {
        for (int i = 0; i < timesToConsume; i++) { 
            mine.P();
                System.out.println("Thread [" + name + "] reads: " + Main.buffer);
            other.V();     
        }  
 
        
    } 

}
