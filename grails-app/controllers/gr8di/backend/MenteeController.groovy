package gr8di.backend

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MenteeController {

    MenteeService menteeService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond menteeService.list(params), model:[menteeCount: menteeService.count()]
    }

    def show(Long id) {
        respond menteeService.get(id)
    }

    def save(Mentee mentee) {
        if (mentee == null) {
            render status: NOT_FOUND
            return
        }

        try {
            menteeService.save(mentee)
        } catch (ValidationException e) {
            respond mentee.errors, view:'create'
            return
        }

        respond mentee, [status: CREATED, view:"show"]
    }

    def update(Mentee mentee) {
        if (mentee == null) {
            render status: NOT_FOUND
            return
        }

        try {
            menteeService.save(mentee)
        } catch (ValidationException e) {
            respond mentee.errors, view:'edit'
            return
        }

        respond mentee, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        menteeService.delete(id)

        render status: NO_CONTENT
    }
}
