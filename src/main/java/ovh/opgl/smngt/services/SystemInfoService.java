package ovh.opgl.smngt.services;

import jakarta.inject.Singleton;
import oshi.SystemInfo;
import ovh.opgl.smngt.dto.Sysinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class SystemInfoService {

    public Sysinfo getSysInfo() {
        SystemInfo si = new SystemInfo();

        var os = si.getOperatingSystem();
        var processor = si.getHardware().getProcessor();
        var memory = si.getHardware().getMemory();

        var cpuInfo = new Sysinfo.CPUInfo();

        cpuInfo.setCpuUsage(processor.getSystemCpuLoad(500) * 100);
        cpuInfo.setProcessorName(processor.getProcessorIdentifier().getName());

        var coreUsages = new ArrayList<Map<String, Double>>();

        double[] load = processor.getProcessorCpuLoad(500);
        for (int i = 0; i < load.length; i++) {
            Map<String, Double> coreUsage = new HashMap<>();
            double usagePercentage = load[i] * 100;
            coreUsage.put("cpu" + i, usagePercentage);
            coreUsages.add(coreUsage);
        }

        cpuInfo.setCoreUsages(coreUsages);

        var osInfo = new Sysinfo.OSInfo();
        osInfo.setName(os.getFamily());
        osInfo.setVersion(os.getVersionInfo().getVersion());

        var ramInfo = new Sysinfo.RAMInfo();
        ramInfo.setRamTotal(memory.getTotal());
        ramInfo.setRamFree(memory.getAvailable());
        ramInfo.setSwapTotal(memory.getVirtualMemory().getSwapTotal());
        ramInfo.setSwapUsed(memory.getVirtualMemory().getSwapUsed());

        return new Sysinfo(osInfo, cpuInfo, ramInfo);
    }
}
