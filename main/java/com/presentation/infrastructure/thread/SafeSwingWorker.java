package com.presentation.infrastructure.thread;

import javax.swing.SwingWorker;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class SafeSwingWorker<T, V> extends SwingWorker<T, V> {
    private static final Logger LOGGER = Logger.getLogger(SafeSwingWorker.class.getName());

    @Override
    protected final void done() {
        try {
            onSuccess(get());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            onInterrupted(e);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            LOGGER.log(Level.SEVERE, "Error in background task", cause);
            onError(cause != null ? cause : e);
        } finally {
            onFinally();
        }
    }

    protected void onSuccess(T result) {
        // Override in subclasses
    }

    protected void onInterrupted(InterruptedException e) {
        // Override in subclasses
    }

    protected void onError(Throwable t) {
        // Override in subclasses
    }

    protected void onFinally() {
        // Override in subclasses
    }
}
