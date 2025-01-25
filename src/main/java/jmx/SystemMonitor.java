package jmx;

import com.sun.management.OperatingSystemMXBean;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.lang.management.ManagementFactory;

public class SystemMonitor extends NotificationBroadcasterSupport implements SystemMonitorMBean {
    private double memoryThreshold = 80.0; // 메모리 임계값 (%)
    private double cpuThreshold = 70.0;    // CPU 임계값 (%)
    private long sequenceNumber = 1;

    private final OperatingSystemMXBean osBean;

    public SystemMonitor() {
        this.osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
    }

    @Override
    public long getUsedMemory() {
        return ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed();
    }

    @Override
    public long getMaxMemory() {
        return ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getMax();
    }

    @Override
    public double getMemoryUsagePercentage() {
        return (double) getUsedMemory() / getMaxMemory() * 100;
    }

    @Override
    public double getCpuUsagePercentage() {
        double cpuLoad = osBean.getCpuLoad();
        return cpuLoad >= 0 ? cpuLoad * 100 : -1; // -1 반환 시 CPU 로드 값을 사용할 수 없음
    }

    @Override
    public void setMemoryThreshold(double threshold) {
        this.memoryThreshold = threshold;
    }

    @Override
    public double getMemoryThreshold() {
        return memoryThreshold;
    }

    @Override
    public void setCpuThreshold(double threshold) {
        this.cpuThreshold = threshold;
    }

    @Override
    public double getCpuThreshold() {
        return cpuThreshold;
    }

    // 메모리 및 CPU 사용량을 확인하고 알림 트리거
    public void checkSystemUsage() {
        double memoryUsage = getMemoryUsagePercentage();
        double cpuUsage = getCpuUsagePercentage();

        if (memoryUsage > memoryThreshold) {
            String message = String.format("메모리 사용량 경고: %.2f%% (임계값: %.2f%%)", memoryUsage, memoryThreshold);
            sendNotification(new Notification(
                    "MemoryUsageExceeded",
                    this,
                    sequenceNumber++,
                    System.currentTimeMillis(),
                    message
            ));
        }

        if (cpuUsage > cpuThreshold) {
            String message = String.format("CPU 사용량 경고: %.2f%% (임계값: %.2f%%)", cpuUsage, cpuThreshold);
            sendNotification(new Notification(
                    "CpuUsageExceeded",
                    this,
                    sequenceNumber++,
                    System.currentTimeMillis(),
                    message
            ));
        }
    }
}