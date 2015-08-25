package org.jerlang.vm;

import org.jerlang.Process;
import org.jerlang.ProcessRegistry;

/**
 * References:
 * http://www.erlang.se/euc/08/euc_smp.pdf
 */
public class Scheduler extends Thread {

    private final RunQueue<Process> runQueueMax;
    private final RunQueue<Process> runQueueHigh;
    private final RunQueue<Process> runQueueNormal;
    private final RunQueue<Process> runQueueLow;

    public Scheduler() {
        runQueueMax = new RunQueue<>();
        runQueueHigh = new RunQueue<>();
        runQueueNormal = new RunQueue<>();
        runQueueLow = new RunQueue<>();
    }

    public Process add(Process process) {
        process.setScheduler(this);
        switch (process.priority()) {
        case MAX:
            runQueueMax.push(process);
            break;
        case HIGH:
            runQueueHigh.push(process);
            break;
        case NORMAL:
            runQueueNormal.push(process);
            break;
        case LOW:
            runQueueLow.push(process);
            break;
        }
        return process;
    }

    /**
     * Performing actions according to:
     * https://www.erlang-solutions.com/resources/webinars/understanding-erlang-scheduler
     */
    @Override
    public void run() {
        while (!isInterrupted()) {
            checkIfTimersShouldBeTriggered();
            maybeCheckBalance();
            migrateProcessesAndPorts();
            executeAnyAuxWork();
            maybeCheckIO();
            executeOnePort();
            executeOneProcess();
        }
    }

    private void checkIfTimersShouldBeTriggered() {
    }

    private void maybeCheckBalance() {
    }

    private void migrateProcessesAndPorts() {
    }

    private void executeAnyAuxWork() {
    }

    private void maybeCheckIO() {
    }

    private void executeOnePort() {
    }

    private void executeOneProcess() {
        if (!execute(runQueueMax)) {
            if (!execute(runQueueHigh)) {
                if (!execute(runQueueNormal)) {
                    if (!execute(runQueueLow)) {
                        sleep();
                    }
                }
            }
        }
    }

    private boolean execute(RunQueue<Process> runQueue) {
        Process p = runQueue.poll();
        if (p != null) {
            ProcessRegistry.self(p);
            p.execute();
            ProcessRegistry.self(null);
            switch (p.state()) {
            case RUNNABLE:
                runQueue.push(p);
                break;
            default:
                break;
            }
            return true;
        }
        return false;
    }

    private void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            interrupt();
        }
    }

}