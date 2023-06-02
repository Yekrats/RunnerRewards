package edu.purdue.mypurdue.runnerrewards

class Registration {
    Integer distance
    String modeSelected
    Date completionTime
    Date dateCreated
    Date lastUpdated

    static belongsTo = [runner: Runner, race: Race]

    static constraints = {
        distance        nullable: false, blank: false
        modeSelected    nullable: false, blank: false
        completionTime  nullable: true,  blank: true
    }

}
