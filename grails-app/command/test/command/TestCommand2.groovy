package test.command

import grails.validation.Validateable

class TestCommand2 implements  Validateable{
    int n

    static constraints = {
        n min:2, max:10
    }
}
