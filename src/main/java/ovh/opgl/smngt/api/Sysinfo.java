package ovh.opgl.smngt.api;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.software.os.OperatingSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Serdeable
public class Sysinfo {

    private final OSInfo os;
    private final CPUInfo cpu;
    private final RAMInfo ram;

    public Sysinfo() {
        SystemInfo si = new SystemInfo();
        this.os = new OSInfo(si.getOperatingSystem());
        this.cpu = new CPUInfo(si.getHardware().getProcessor());
        this.ram = new RAMInfo(si.getHardware().getMemory());
    }

    @Getter
    @Serdeable
    public static class CPUInfo {
        private final String processorName;
        private final List<Map<String, Integer>> cpuUsage;

        public CPUInfo(CentralProcessor processor) {
            long[][] previousTicks = new long[processor.getLogicalProcessorCount()][CentralProcessor.TickType.values().length];
            this.processorName = processor.getProcessorIdentifier().getName();
            this.cpuUsage = new ArrayList<>();
            long[][] currentTicks = processor.getProcessorCpuLoadTicks();
            double[] load = processor.getProcessorCpuLoadBetweenTicks(previousTicks);

            for (int i = 0; i < load.length; i++) {
                Map<String, Integer> coreUsage = new HashMap<>();
                coreUsage.put("cpu" + i, (int) (load[i] * 100));
                this.cpuUsage.add(coreUsage);
            }
            System.arraycopy(currentTicks, 0, previousTicks, 0, currentTicks.length);
        }
    }

    @Getter
    @Serdeable
    public static class OSInfo {
        private final String name;
        private final String version;

        public OSInfo(OperatingSystem os) {
            this.name = os.getFamily();
            this.version = os.getVersionInfo().getVersion();
        }
    }

    @Getter
    @Serdeable
    public static class RAMInfo {
        private final long total;
        private final long free;

        public RAMInfo(GlobalMemory memory) {
            this.total = memory.getTotal();
            this.free = memory.getAvailable();
        }
    }
}
