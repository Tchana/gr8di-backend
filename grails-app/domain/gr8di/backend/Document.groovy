package gr8di.backend

import grails.rest.Resource

@Resource(uri='/documents', formats=['json', 'xml'])
class Document {
    String language
    String pageName
    String title
    String subtitle
    String imgUrl
    Section section
    PageStatus pageStatus

    static constraints = {
        subtitle blank: true
        imgUrl blank: true
        section nullable: true
    }
}
