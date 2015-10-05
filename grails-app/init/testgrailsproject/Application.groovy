package testgrailsproject

import grails.boot.GrailsApp
import grails.boot.config.GrailsAutoConfiguration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
class Application extends GrailsAutoConfiguration {

    static void main(String[] args) {
        GrailsApp.run(Application)
    }
}