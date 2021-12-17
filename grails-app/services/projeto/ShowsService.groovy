package projeto

import grails.gorm.services.Service

@Service(Shows)
interface ShowsService {

    Shows get(Serializable id)

    List<Shows> list(Map args)

    Long count()

    void delete(Serializable id)

    Shows save(Shows shows)

}