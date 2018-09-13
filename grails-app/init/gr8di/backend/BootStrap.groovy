package gr8di.backend

class BootStrap {

    def init = { servletContext ->
        new Message(senderEmail:"johnDoe@email.com", topic:"jobs", messageBody:"hello john doe", dateSent: new Date(), status: Status.read).save()
        new Message(senderEmail:"janeDoe@email.com", topic:"internship", messageBody:"hello jane doe", dateSent: new Date(), status: Status.unread).save()
    }

    def destroy = {
    }
}
