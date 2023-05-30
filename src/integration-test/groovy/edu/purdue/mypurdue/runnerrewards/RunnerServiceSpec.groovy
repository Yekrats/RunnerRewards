package edu.purdue.mypurdue.runnerrewards

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class RunnerServiceSpec extends Specification {

    RunnerService runnerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Runner(...).save(flush: true, failOnError: true)
        //new Runner(...).save(flush: true, failOnError: true)
        //Runner runner = new Runner(...).save(flush: true, failOnError: true)
        //new Runner(...).save(flush: true, failOnError: true)
        //new Runner(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //runner.id
    }

    void "test get"() {
        setupData()

        expect:
        runnerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Runner> runnerList = runnerService.list(max: 2, offset: 2)

        then:
        runnerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        runnerService.count() == 5
    }

    void "test delete"() {
        Long runnerId = setupData()

        expect:
        runnerService.count() == 5

        when:
        runnerService.delete(runnerId)
        sessionFactory.currentSession.flush()

        then:
        runnerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Runner runner = new Runner()
        runnerService.save(runner)

        then:
        runner.id != null
    }
}
