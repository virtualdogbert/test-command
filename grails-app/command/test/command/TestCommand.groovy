package test.command

class TestCommand {
    String name
    int number

    static constraints = {
        name nullable:true, size: 5..15
    }
}
