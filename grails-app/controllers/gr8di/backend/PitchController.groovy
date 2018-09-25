package gr8di.backend

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PitchController {

    PitchService pitchService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond pitchService.list(params), model:[pitchCount: pitchService.count()]
    }

    def show(Long id) {
        respond pitchService.get(id)
    }

    def save(Pitch pitch) {
        if (pitch == null) {
            render status: NOT_FOUND
            return
        }

        try {
            pitchService.save(pitch)
        } catch (ValidationException e) {
            respond pitch.errors, view:'create'
            return
        }

        respond pitch, [status: CREATED, view:"show"]
    }

    def update(Pitch pitch) {
        if (pitch == null) {
            render status: NOT_FOUND
            return
        }

        try {
            pitchService.save(pitch)
        } catch (ValidationException e) {
            respond pitch.errors, view:'edit'
            return
        }

        respond pitch, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        pitchService.delete(id)

        render status: NO_CONTENT
    }
}
