package gr8di.backend

class Section {
    String title
    String description
    Pitch pitch
    Card card
    Member member
    static belongsTo = [document: Document]

    static constraints = {
        title blank: true
        description blank: true
        pitch nullable: true
        card nullabe: true
        member nullable: true
    }
}