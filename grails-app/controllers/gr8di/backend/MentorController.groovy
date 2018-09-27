package gr8di.backend

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MentorController {

    MentorService mentorService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond mentorService.list(params), model:[mentorCount: mentorService.count()]
    }

    def show(Long id) {
        respond mentorService.get(id)
    }

    def save(Mentor mentor) {
        if (mentor == null) {
            render status: NOT_FOUND
            return
        }

        try {
            mentorService.save(mentor)
        } catch (ValidationException e) {
            respond mentor.errors, view:'create'
            return
        }

        respond mentor, [status: CREATED, view:"show"]
    }

    def update(Mentor mentor) {
        if (mentor == null) {
            render status: NOT_FOUND
            return
        }

        try {
            mentorService.save(mentor)
        } catch (ValidationException e) {
            respond mentor.errors, view:'edit'
            return
        }

        respond mentor, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        mentorService.delete(id)

        render status: NO_CONTENT
    }
}
