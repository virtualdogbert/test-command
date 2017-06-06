package test.command

import com.virtualdogbert.ast.ErrorsHandler
import com.virtualdogbert.ast.SkipErrorsHandler
import grails.converters.JSON

@ErrorsHandler
class TestController {

    def index(TestCommand test) {
        //some controller code
        render "It works"
    }

    @ErrorsHandler(handler = 'someOtherErrorHandler')
    //over rides the default.
    def list(TestCommand test, int i) {
        //some controller code
        render "It works"
    }

    @SkipErrorsHandler
    //over rides the default.
    def delete(TestCommand test, int i) {
        //some controller code
        println errors
        println hasErrors()
        println i
        println test
        render "It works"
    }

    //Your error handler
    private boolean someOtherErrorHandler(List commandObjects) {
        List errors = commandObjects.inject([]) { result, commandObject ->

            if (commandObject.hasErrors()) {
                result + (commandObject.errors as JSON)
            } else {
                result
            }

        } as List

        if (errors) {
            //Do something
            println "error in custom error handler"
            render errors
            return true
        }
        //possibly do something else
        println "no error in custom error handler"
        return false
    }
}
