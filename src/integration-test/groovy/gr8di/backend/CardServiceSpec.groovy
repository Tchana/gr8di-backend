package gr8di.backend

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CardServiceSpec extends Specification {

    CardService cardService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Card(...).save(flush: true, failOnError: true)
        //new Card(...).save(flush: true, failOnError: true)
        //Card card = new Card(...).save(flush: true, failOnError: true)
        //new Card(...).save(flush: true, failOnError: true)
        //new Card(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //card.id
    }

    void "test get"() {
        setupData()

        expect:
        cardService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Card> cardList = cardService.list(max: 2, offset: 2)

        then:
        cardList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        cardService.count() == 5
    }

    void "test delete"() {
        Long cardId = setupData()

        expect:
        cardService.count() == 5

        when:
        cardService.delete(cardId)
        sessionFactory.currentSession.flush()

        then:
        cardService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Card card = new Card()
        cardService.save(card)

        then:
        card.id != null
    }
}
