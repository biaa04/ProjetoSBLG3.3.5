package projeto

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ShowsServiceSpec extends Specification {

    ShowsService showsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Shows(...).save(flush: true, failOnError: true)
        //new Shows(...).save(flush: true, failOnError: true)
        //Shows shows = new Shows(...).save(flush: true, failOnError: true)
        //new Shows(...).save(flush: true, failOnError: true)
        //new Shows(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //shows.id
    }

    void "test get"() {
        setupData()

        expect:
        showsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Shows> showsList = showsService.list(max: 2, offset: 2)

        then:
        showsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        showsService.count() == 5
    }

    void "test delete"() {
        Long showsId = setupData()

        expect:
        showsService.count() == 5

        when:
        showsService.delete(showsId)
        sessionFactory.currentSession.flush()

        then:
        showsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Shows shows = new Shows()
        showsService.save(shows)

        then:
        shows.id != null
    }
}
