package gr8di.backend

class BootStrap {

    def init = { servletContext ->
        new Message(senderEmail:"johnDoe@email.com", topic:"jobs", messageBody:"hello john doe", dateSent: new Date(), status: Status.read).save()
        new Message(senderEmail:"janeDoe@email.com", topic:"internship", messageBody:"hello jane doe", dateSent: new Date(), status: Status.unread).save()

        new Job(emailAddress: "bobcarl@gmail.com", jobExperienceLevel: "entry level", jobType: "fulltime", tags: "grails, ratpack", salaryRangeFrom: 500, salaryRangeTo: 2000, jobDescription: "As a grails backend developer", jobTitle: "grail developer", companyName: "gr8di", jobLocation: "washington").save()
        new Job(emailAddress: "carlito@gmail.com", jobExperienceLevel: "intermediate level", jobType: "part-time", tags: "groovy", salaryRangeFrom: 200, salaryRangeTo: 2000, jobDescription: "As a ratpack backend developer", jobTitle: "groovy developer", companyName: "appstech", jobLocation: "Buea").save()
    }

    def destroy = {
    }
}
