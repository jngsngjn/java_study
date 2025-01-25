package jmx;

import javax.management.NotificationEmitter;

public interface SystemMonitorMBean extends NotificationEmitter {
    long getUsedMemory();
    long getMaxMemory();
    double getMemoryUsagePercentage();
    double getCpuUsagePercentage();
    void setMemoryThreshold(double threshold);
    double getMemoryThreshold();
    void setCpuThreshold(double threshold);
    double getCpuThreshold();
}