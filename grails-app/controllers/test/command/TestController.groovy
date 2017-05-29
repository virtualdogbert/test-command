package test.command

import grails.converters.JSON

class TestController {

    def index(TestCommand test) {
        if (test.hasErrors()) {
            render (test.errors as JSON)
        }


    }
}
