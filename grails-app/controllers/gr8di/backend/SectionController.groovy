package gr8di.backend

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SectionController {

    SectionService sectionService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sectionService.list(params), model:[sectionCount: sectionService.count()]
    }

    def show(Long id) {
        respond sectionService.get(id)
    }

    def save(Section section) {
        if (section == null) {
            render status: NOT_FOUND
            return
        }

        try {
            sectionService.save(section)
        } catch (ValidationException e) {
            respond section.errors, view:'create'
            return
        }

        respond section, [status: CREATED, view:"show"]
    }

    def update(Section section) {
        if (section == null) {
            render status: NOT_FOUND
            return
        }

        try {
            sectionService.save(section)
        } catch (ValidationException e) {
            respond section.errors, view:'edit'
            return
        }

        respond section, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        sectionService.delete(id)

        render status: NO_CONTENT
    }
}
