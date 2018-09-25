package gr8di.backend

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CardController {

    CardService cardService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond cardService.list(params), model:[cardCount: cardService.count()]
    }

    def show(Long id) {
        respond cardService.get(id)
    }

    def save(Card card) {
        if (card == null) {
            render status: NOT_FOUND
            return
        }

        try {
            cardService.save(card)
        } catch (ValidationException e) {
            respond card.errors, view:'create'
            return
        }

        respond card, [status: CREATED, view:"show"]
    }

    def update(Card card) {
        if (card == null) {
            render status: NOT_FOUND
            return
        }

        try {
            cardService.save(card)
        } catch (ValidationException e) {
            respond card.errors, view:'edit'
            return
        }

        respond card, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        cardService.delete(id)

        render status: NO_CONTENT
    }
}
