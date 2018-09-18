package gr8di.backend

class Card {
    String imgUrl
    String header
    String description
    String footer

    static constraints = {
        imgUrl nullable: true
        header nullable: true
        description nullable: true
        footer nullable: true
    }
}
