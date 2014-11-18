package basictests

class PersonController {

    static allowedMethods = [create: 'POST']

    def count() {
        def numberOfPeople = Person.count()

        render "There are ${numberOfPeople} people in the database."
    }

    def create(Person person) {
        if(person.hasErrors()) {
            flash.message = 'An error occurred creating the person.'
        }
        person.save()
        redirect action: 'count'
    }
}
