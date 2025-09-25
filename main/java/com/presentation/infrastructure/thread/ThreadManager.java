package com.presentation.infrastructure.thread;

import javax.swing.SwingUtilities;
import javax.swing.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManager {
    private static ThreadManager instance;
    private ExecutorService executorService;
    private Timer mainAnimationTimer;

    private ThreadManager() {
        this.executorService = Executors.newCachedThreadPool();
    }

    public static ThreadManager getInstance() {
        if (instance == null) {
            synchronized (ThreadManager.class) {
                if (instance == null) {
                    instance = new ThreadManager();
                }
            }
        }
        return instance;
    }

    public void executeOnEDT(Runnable task) {
        if (SwingUtilities.isEventDispatchThread()) {
            task.run();
        } else {
            SwingUtilities.invokeLater(task);
        }
    }

    public void executeInBackground(Runnable task) {
        executorService.execute(task);
    }

    public boolean isOnEDT() {
        return SwingUtilities.isEventDispatchThread();
    }

    public void setMainAnimationTimer(Timer timer) {
        this.mainAnimationTimer = timer;
    }

    public Timer getMainAnimationTimer() {
        return mainAnimationTimer;
    }

    public void shutdown() {
        if (mainAnimationTimer != null) {
            mainAnimationTimer.stop();
        }
        executorService.shutdown();
    }
}
