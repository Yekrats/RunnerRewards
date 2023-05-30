package edu.purdue.mypurdue.runnerrewards

class Runner {
    String  firstName
    String  middleInitial
    String  lastName
    String  email
    String  streetLine1
    String  streetLine2
    String  city
    String  state
    String  zip4
    Date    dateOfBirth
    Date    dateCreated
    Date    lastUpdated

    static constraints = {
        firstName     maxSize: 50, nullable: false, blank: false
        middleInitial maxSize: 1, nullable: true, blank: true
        lastName      maxSize: 50, nullable: false, blank: false
        email         size: 6..255, email: true, nullable: false, blank: false, unique: true
        streetLine1   maxSize: 255, nullable: true
        streetLine2   maxSize: 255, nullable: true
        city          maxSize: 255, nullable: true
        state         size: 2..2, nullable: true
        zip4          size: 5..10, nullable: true
        dateOfBirth   nullable: false, blank: false
    }
}
