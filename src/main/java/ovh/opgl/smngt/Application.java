package ovh.opgl.smngt;

import io.micronaut.runtime.Micronaut;
import ovh.opgl.smngt.controllers.Api;

public class Application {
    public static void main(String[] args) {
        Micronaut.run(Api.class);
    }
}