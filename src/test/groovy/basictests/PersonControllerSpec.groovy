package basictests
import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(PersonController)
@Mock(Person)
class PersonControllerSpec extends Specification {

    void 'test count action'() {
        when:
        controller.count()

        then:
        response.status == 200
        response.text == 'There are 0 people in the database.'
    }

    void 'test invalid request method for create action'() {
        when:
        request.method = 'GET'
        controller.create()

        then:
        response.status == 405
    }

    void 'test create action'() {
        when:
        request.method = 'POST'
        params.firstName = 'Jeff'
        params.lastName = 'Brown'
        controller.create()

        then:
        !flash.message
        response.status == 302
        response.redirectedUrl == '/person/count'
    }

    void 'test create action with invalid data'() {
        when:
        request.method = 'POST'
        params.firstName = 'jeff'
        params.lastName = 'brown'
        controller.create()

        then:
        flash.message == 'An error occurred creating the person.'
        response.status == 302
        response.redirectedUrl == '/person/count'
    }
}