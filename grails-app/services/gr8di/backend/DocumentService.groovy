package gr8di.backend

import grails.gorm.services.Service

@Service(Document)
interface DocumentService {

    Document get(Serializable id)

    List<Document> list(Map args)

    Long count()

    void delete(Serializable id)

    Document save(Document document)

}