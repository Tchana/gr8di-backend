package gr8di.backend

import grails.gorm.services.Service

@Service(Pitch)
interface PitchService {

    Pitch get(Serializable id)

    List<Pitch> list(Map args)

    Long count()

    void delete(Serializable id)

    Pitch save(Pitch pitch)

}