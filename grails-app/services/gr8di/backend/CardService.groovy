package gr8di.backend

import grails.gorm.services.Service

@Service(Card)
interface CardService {

    Card get(Serializable id)

    List<Card> list(Map args)

    Long count()

    void delete(Serializable id)

    Card save(Card card)

}