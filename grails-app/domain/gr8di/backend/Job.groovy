package gr8di.backend

import grails.rest.Resource



@Resource(uri='/job', formats=['json', 'xml'])
class Job {
    String emailAddress
    String companyName
    String jobLocation
    String jobTitle
    String jobExperienceLevel
    String jobType
    String tags
    Float salaryRangeFrom
    Float salaryRangeTo
    String jobDescription

    static constraints = {
        emailAddress email: true
        companyName blank: true
        jobLocation blank: true
        jobTitle blank: true
        tags blank: true
    }
}