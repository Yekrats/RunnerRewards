package edu.purdue.mypurdue.runnerrewards

import grails.gorm.services.Service

@Service(Runner)
interface RunnerService {

    Runner get(Serializable id)

    List<Runner> list(Map args)

    Long count()

    void delete(Serializable id)

    Runner save(Runner runner)

}