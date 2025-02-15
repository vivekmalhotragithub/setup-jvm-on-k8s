import java.lang.management.ManagementFactory;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.List;

public class JvmStatisticsInfo {
    public static void main(String[] args) {
        // Get the number of available processors
        int processors = Runtime.getRuntime().availableProcessors();
        // Print the total number of processors
        System.out.println("Total Available Processors: " + processors);
        // Get the list of garbage collectors
        List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();
        System.out.println("Garbage Collectors in use:");
        for (GarbageCollectorMXBean gcBean : gcBeans) {
            System.out.println("- " + gcBean.getName());
        }
        // Get heap memory usage
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        long maxHeap = heapMemoryUsage.getMax() / (1024 * 1024); // Convert bytes to MB
        System.out.println("Total Heap Memory (Max): " + maxHeap + " MB");
    }
}
