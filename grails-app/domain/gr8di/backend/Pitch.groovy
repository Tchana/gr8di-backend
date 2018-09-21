package gr8di.backend

class Pitch {
    String imgUrl
    String icon
    String title
    String description
    String action

    static constraints = {
        imgUrl nullable: true
        icon nullable: true
        title nullable: true
        description nullable: true
        action nullable: true
    }
}
