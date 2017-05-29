class BootStrap {

    def grailsApplication
    def init = { servletContext ->

        for (cls in grailsApplication.commandClasses) {
            println cls
        }
    }
    def destroy = {
    }
}
