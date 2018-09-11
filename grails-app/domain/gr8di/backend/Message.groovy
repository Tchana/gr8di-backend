package gr8di.backend

import grails.rest.*

@Resource(uri='/messages', formats=['json', 'xml'])
class Message {

    String senderEmail
    String topic
    String messageBody
    Date dateSent = new Date()

    static constraints = {
        senderEmail blank:false
        topic blank:false
        messageBody blank:false
        dateSent blank:false
    }
}