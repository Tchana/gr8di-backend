package gr8di.backend

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PageController {

    PageService pageService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond pageService.list(params), model:[pageCount: pageService.count()]
    }

    def show(Long id) {
        respond pageService.get(id)
    }

    def save(Page page) {
        if (page == null) {
            render status: NOT_FOUND
            return
        }

        try {
            pageService.save(page)
        } catch (ValidationException e) {
            respond page.errors, view:'create'
            return
        }

        respond page, [status: CREATED, view:"show"]
    }

    def update(Page page) {
        if (page == null) {
            render status: NOT_FOUND
            return
        }

        try {
            pageService.save(page)
        } catch (ValidationException e) {
            respond page.errors, view:'edit'
            return
        }

        respond page, [status: OK, view:"show"]
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
