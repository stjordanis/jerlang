package org.jerlang.type;

import java.util.Objects;

/**
 * TODO: Work in progress.
 *
 * See also:
 * https://stackoverflow.com/a/262179
 */
public class PID extends PidOrPortId {

    private final int processId;

    public PID(int processId) {
        this.processId = processId;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof PID) {
            PID other = (PID) object;
            return processId == other.processId;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(processId);
    }

    @Override
    public PID toPID() {
        return this;
    }

    @Override
    public String toString() {
        return "<0." + processId + ".0>";
    }

}
