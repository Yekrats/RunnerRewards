package edu.purdue.mypurdue.runnerrewards

class Race {
    String  name
    String  location
    Date    startTime
    Date    endTime
    Integer registrationLimit
    String  mode
    String  distance
    String  distanceUnits
    Date    dateCreated
    Date    lastUpdated

    static hasMany = [registrations: Registration]

    static constraints = {
        name                maxSize: 200, nullable: false, blank: false
        location            maxSize: 500, nullable: false, blank: false
        registrationLimit   size: 10..9999, nullable: false
        mode                maxSize: 500, nullable: false, blank: false
        distance            maxSize: 500, nullable: false, blank: false
        distanceUnits       inList: ["km", "miles"]
        hasMany             nullable: false, blank: false
    }
    String toString() { name }
}
