package ua.training.homework;

/**
 * Максим
 * 19.04.2018
 */
public class MathematicianProducer implements Runnable {
    private BlockingQueue<Document> queue;

    public MathematicianProducer(BlockingQueue<Document> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 250; i++) {
            try {
                queue.put(new Mathematician());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
