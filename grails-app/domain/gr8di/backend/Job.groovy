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
        emailAddress blank: false, email: true
        companyName blank: true
        jobLocation blank: true
        jobTitle blank: true
        jobExperienceLevel blank: false
        jobType blank: false
        tags blank: true
        salaryRangeFrom blank: false
        salaryRangeTo blank: false
        jobDescription blank: false
    }
}