package ovh.opgl.smngt.dto;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Introspected
@Serdeable
@AllArgsConstructor
public @Data class Sysinfo {

    private OSInfo os;
    private CPUInfo cpu;
    private RAMInfo ram;

    @Introspected
    @Serdeable
    @NoArgsConstructor
    public static @Data class CPUInfo {
        private String processorName;
        private double cpuUsage;
        private List<Map<String, Double>> coreUsages;
    }

    @Introspected
    @Serdeable
    @NoArgsConstructor
    public static @Data class OSInfo {
        private String name;
        private String version;
    }

    @Introspected
    @Serdeable
    @NoArgsConstructor
    public static @Data class RAMInfo {
        private long total;
        private long free;
    }
}
