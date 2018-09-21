package gr8di.backend

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MemberController {

    MemberService memberService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond memberService.list(params), model:[memberCount: memberService.count()]
    }

    def show(Long id) {
        respond memberService.get(id)
    }

    def save(Member member) {
        if (member == null) {
            render status: NOT_FOUND
            return
        }

        try {
            memberService.save(member)
        } catch (ValidationException e) {
            respond member.errors, view:'create'
            return
        }

        respond member, [status: CREATED, view:"show"]
    }

    def update(Member member) {
        if (member == null) {
            render status: NOT_FOUND
            return
        }

        try {
            memberService.save(member)
        } catch (ValidationException e) {
            respond member.errors, view:'edit'
            return
        }

        respond member, [status: OK, view:"show"]
    }

    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        memberService.delete(id)

        render status: NO_CONTENT
    }
}
