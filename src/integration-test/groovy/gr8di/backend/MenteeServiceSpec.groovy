package gr8di.backend

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MenteeServiceSpec extends Specification {

    MenteeService menteeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Mentee(...).save(flush: true, failOnError: true)
        //new Mentee(...).save(flush: true, failOnError: true)
        //Mentee mentee = new Mentee(...).save(flush: true, failOnError: true)
        //new Mentee(...).save(flush: true, failOnError: true)
        //new Mentee(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //mentee.id
    }

    void "test get"() {
        setupData()

        expect:
        menteeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Mentee> menteeList = menteeService.list(max: 2, offset: 2)

        then:
        menteeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        menteeService.count() == 5
    }

    void "test delete"() {
        Long menteeId = setupData()

        expect:
        menteeService.count() == 5

        when:
        menteeService.delete(menteeId)
        sessionFactory.currentSession.flush()

        then:
        menteeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Mentee mentee = new Mentee()
        menteeService.save(mentee)

        then:
        mentee.id != null
    }
}
