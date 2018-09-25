package gr8di.backend

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PitchServiceSpec extends Specification {

    PitchService pitchService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Pitch(...).save(flush: true, failOnError: true)
        //new Pitch(...).save(flush: true, failOnError: true)
        //Pitch pitch = new Pitch(...).save(flush: true, failOnError: true)
        //new Pitch(...).save(flush: true, failOnError: true)
        //new Pitch(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //pitch.id
    }

    void "test get"() {
        setupData()

        expect:
        pitchService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Pitch> pitchList = pitchService.list(max: 2, offset: 2)

        then:
        pitchList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        pitchService.count() == 5
    }

    void "test delete"() {
        Long pitchId = setupData()

        expect:
        pitchService.count() == 5

        when:
        pitchService.delete(pitchId)
        sessionFactory.currentSession.flush()

        then:
        pitchService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Pitch pitch = new Pitch()
        pitchService.save(pitch)

        then:
        pitch.id != null
    }
}
