package gr8di.backend

class Mentee {
    String menteeName
    String timeZone
    String workDays
    String specialSkills
    MenteeExp menteeExp
    LibFrmwrkTools libFrmwrkTools
    Language language
    HrsPerWeek hrsPerWeek
    TimeOfStart timeOfStart
    Goal goal
    static belongsTo = [mentor: Mentor]

    static constraints = {
    }
}