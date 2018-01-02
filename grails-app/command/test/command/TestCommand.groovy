package test.command

import grails.validation.Validateable

class TestCommand implements  Validateable{
    String             name
    int                number
    List<Test2Command> t2

    static constraints = {
        name nullable:true, size: 5..15
        number nullable:true
        t2 cascade: true, nullable: true
    }
}
