package demo
class DemoTagLib {
    static defaultEncodeAs = [taglib:'html']
    static namespace = 'demo'

    def repeat = { attrs, body ->
        attrs.int('count').times {
            out << body()
        }
    }
}
