package gr8di.backend

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class P_ageController {

    P_ageService pageService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond pageService.list(params), model:[pageCount: pageService.count()]
    }

    def show(Long id) {
        respond pageService.get(id)
    }

    def save(P_age p_age) {
        if (p_age == null) {
            render status: NOT_FOUND
            return
        }

        try {
            pageService.save(p_age)
        } catch (ValidationException e) {
            respond p_age.errors, view:'create'
            return
        }

        respond p_age, [status: CREATED, view:"show"]
    }

    def update(P_age p_age) {
        if (p_age == null) {
            render status: NOT_FOUND
            return
        }

        try {
            pageService.save(p_age)
        } catch (ValidationException e) {
            respond p_age.errors, view:'edit'
            return
        }

        respond p_age, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        pageService.delete(id)

        render status: NO_CONTENT
    }
}
