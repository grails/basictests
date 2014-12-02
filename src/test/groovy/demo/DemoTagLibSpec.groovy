package demo
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(DemoTagLib)
class DemoTagLibSpec extends Specification {

    void 'test that taglib was enchaned with expected Trait'() {
        expect:
        grails.artefact.TagLibrary.isAssignableFrom DemoTagLib
    }

    void 'test repeat tag'() {
        expect:
        applyTemplate('<demo:repeat count="3">Hello</demo:repeat>') == 'HelloHelloHello'
    }
}
