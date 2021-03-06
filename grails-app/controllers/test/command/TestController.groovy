package test.command

import com.virtualdogbert.ast.ErrorsHandler
import com.virtualdogbert.ast.SkipErrorsHandler

@ErrorsHandler
class TestController {

    def index(TestCommand test) {
        //some controller code
        render "It works"
    }

    //@ErrorsHandler(handler = 'someOtherErrorHandler')
    //over rides the default.
    def list(TestCommand test, Integer id) {
        //some controller code

        render "It works"
    }

    @SkipErrorsHandler
    //over rides the default.
    def delete(TestCommand test, int i) {
        //some controller code
        test
        println errors
        println hasErrors()
        println test
        render "It works"
    }

    def map(Test4Command t4){
        println t4.t2

    }

    def constraints(Test3Command test){
        render "validated"
    }

    //Your error handler
    private boolean someOtherErrorHandler(List commandObjects) {
        List errors = commandObjects.inject([]) { result, commandObject ->

            if (commandObject.hasErrors()) {
                result + (commandObject.errors)
            } else {
                result
            }

        } as List

        if (errors) {
            //Do something
            println "error in custom error handler"
            respond errors , [formats:['json', 'xml']]
            return true
        }
        //possibly do something else
        println "no error in custom error handler"
        return false
    }
}
