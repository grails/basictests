package basictests

class Person {
    String firstName
    String lastName

    static constraints = {
        firstName matches: /[A-Z].*/
        lastName matches: /[A-Z].*/
    }
}