package gr8di.backend

import grails.gorm.services.Service

@Service(P_age)
interface P_ageService {

    P_age get(Serializable id)

    List<P_age> list(Map args)

    Long count()

    void delete(Serializable id)

    P_age save(P_age p_age)

}