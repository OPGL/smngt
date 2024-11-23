package ovh.opgl.smngt.controllers;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import ovh.opgl.smngt.dto.Sysinfo;
import ovh.opgl.smngt.services.SystemInfoService;

@Controller("/api")
public class Api {

    @Inject
    SystemInfoService systemInfoService;

    @Get("/sysinfo")
    public Sysinfo sysInfo() {
        return systemInfoService.getSysInfo();
    }
}
