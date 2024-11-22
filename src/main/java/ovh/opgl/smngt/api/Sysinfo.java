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
        private final double cpuUsage;
        private final List<Map<String, Double>> coreUsages;

        public CPUInfo(CentralProcessor processor) {
            this.processorName = processor.getProcessorIdentifier().getName();
            this.coreUsages = new ArrayList<Map<String, Double>>();
            this.cpuUsage = processor.getSystemCpuLoad(500)*100;
            double[] load = processor.getProcessorCpuLoad(500);
            for (int i = 0; i < load.length; i++) {
                Map<String, Double> coreUsage = new HashMap<>();
                double usagePercentage = load[i] * 100;
                coreUsage.put("cpu" + i, usagePercentage);
                this.coreUsages.add(coreUsage);
            }
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
