package gr8di.backend

class Mentor {
    String mentorName
    String timeZone
    String workDays
    String menteeAgeRange
    String specialSkills
    GroovyExp groovyExp
    LibFrmwrkTools libFrmwrkTools
    Language language
    HrsPerWeek hrsPerWeek
    TimeOfStart timeOfStart
    static hasMany = [mentee: Mentee]

    static constraints = {
    }
}
