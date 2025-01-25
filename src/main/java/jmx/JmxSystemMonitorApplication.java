package jmx;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class JmxSystemMonitorApplication {
    public static void main(String[] args) throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("com.example:type=SystemMonitor");
        SystemMonitor systemMonitor = new SystemMonitor();

        mBeanServer.registerMBean(systemMonitor, objectName);
        System.out.println("SystemMonitor MBean 등록 완료");

        // 시스템 상태 주기적으로 확인
        while (true) {
            systemMonitor.checkSystemUsage();
            Thread.sleep(5000); // 5초마다 확인
        }
    }
}