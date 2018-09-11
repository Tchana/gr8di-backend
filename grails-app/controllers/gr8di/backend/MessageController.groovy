package gr8di.backend

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MessageController {

    MessageService messageService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond messageService.list(params), model:[messageCount: messageService.count()]
    }

    def show(Long id) {
        respond messageService.get(id)
    }

    def save(Message message) {
        if (message == null) {
            render status: NOT_FOUND
            return
        }

        try {
            messageService.save(message)
        } catch (ValidationException e) {
            respond message.errors, view:'create'
            return
        }

        respond message, [status: CREATED, view:"show"]
    }

    def update(Message message) {
        if (message == null) {
            render status: NOT_FOUND
            return
        }

        try {
            messageService.save(message)
        } catch (ValidationException e) {
            respond message.errors, view:'edit'
            return
        }

        respond message, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        messageService.delete(id)

        render status: NO_CONTENT
    }
}
