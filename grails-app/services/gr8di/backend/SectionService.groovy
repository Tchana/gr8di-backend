package gr8di.backend

import grails.gorm.services.Service

@Service(Section)
interface SectionService {

    Section get(Serializable id)

    List<Section> list(Map args)

    Long count()

    void delete(Serializable id)

    Section save(Section section)

}