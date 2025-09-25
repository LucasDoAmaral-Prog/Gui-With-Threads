package com.presentation.infrastructure.thread;

import javax.swing.SwingWorker;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class AnimationThread extends SwingWorker<Void, Void> {
    private final Runnable updateTask;
    private final Runnable repaintTask;
    private final AtomicBoolean running = new AtomicBoolean(true);
    private final int delayMs;


    public AnimationThread(Runnable updateTask, Runnable repaintTask, int delayMs) {
        this.updateTask = updateTask;
        this.repaintTask = repaintTask;
        this.delayMs = delayMs;
    }

    @Override
    protected Void doInBackground() throws Exception {
        while (running.get() && !isCancelled()) {
            // Execute update task
            updateTask.run();

            // Schedule repaint on EDT
            ThreadManager.getInstance().executeOnEDT(repaintTask);

            // Sleep for animation delay
            Thread.sleep(delayMs);
        }
        return null;
    }

    public void stopAnimation() {
        running.set(false);
        cancel(true);
    }

    public boolean isRunning() {
        return running.get();
    }

    @Override
    protected void process(List<Void> chunks) {
        // Process intermediate results if needed
    }

    @Override
    protected void done() {
        // Cleanup when animation stops
        running.set(false);
    }
}
