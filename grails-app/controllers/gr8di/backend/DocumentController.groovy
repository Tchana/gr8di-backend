package gr8di.backend

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DocumentController {

    DocumentService documentService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond documentService.list(params), model:[pageCount: documentService.count()]
    }

    def show(Long id) {
        respond documentService.get(id)
    }

    def save(Document examplepage) {
        if (examplepage == null) {
            render status: NOT_FOUND
            return
        }

        try {
            documentService.save(examplepage)
        } catch (ValidationException e) {
            respond examplepage.errors, view:'create'
            return
        }

        respond examplepage, [status: CREATED, view:"show"]
    }

    def update(Document examplepage) {
        if (examplepage == null) {
            render status: NOT_FOUND
            return
        }

        try {
            documentService.save(examplepage)
        } catch (ValidationException e) {
            respond examplepage.errors, view:'edit'
            return
        }

        respond examplepage, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        documentService.delete(id)

        render status: NO_CONTENT
    }
}
