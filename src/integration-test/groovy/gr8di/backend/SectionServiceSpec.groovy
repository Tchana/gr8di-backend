package gr8di.backend

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SectionServiceSpec extends Specification {

    SectionService sectionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Section(...).save(flush: true, failOnError: true)
        //new Section(...).save(flush: true, failOnError: true)
        //Section section = new Section(...).save(flush: true, failOnError: true)
        //new Section(...).save(flush: true, failOnError: true)
        //new Section(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //section.id
    }

    void "test get"() {
        setupData()

        expect:
        sectionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Section> sectionList = sectionService.list(max: 2, offset: 2)

        then:
        sectionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sectionService.count() == 5
    }

    void "test delete"() {
        Long sectionId = setupData()

        expect:
        sectionService.count() == 5

        when:
        sectionService.delete(sectionId)
        sessionFactory.currentSession.flush()

        then:
        sectionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Section section = new Section()
        sectionService.save(section)

        then:
        section.id != null
    }
}
