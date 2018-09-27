package gr8di.backend

import grails.gorm.services.Service

@Service(Mentee)
interface MenteeService {

    Mentee get(Serializable id)

    List<Mentee> list(Map args)

    Long count()

    void delete(Serializable id)

    Mentee save(Mentee mentee)

}