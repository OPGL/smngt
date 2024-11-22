package ovh.opgl.smngt.api;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.serde.annotation.SerdeImport;

@Controller("/api")
@SerdeImport(Sysinfo.class)
public class Api {

    @Get(value = "/sysinfo", produces = MediaType.APPLICATION_JSON)
    public Sysinfo index() {
        return new Sysinfo();
    }
}
