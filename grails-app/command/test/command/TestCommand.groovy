package test.command

import grails.validation.Validateable


class TestCommand  implements Validateable {
    String name
    int number

    static constraints = {
        name nullable:true, size: 5..15
    }
}
