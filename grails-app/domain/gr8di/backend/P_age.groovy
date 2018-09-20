package gr8di.backend

class P_age {
    String language
    String pageName
    String title
    String subtitle
    String imgUrl
    Section section
    PageStatus pageStatus

    static constraints = {
        subtitle blank: true
        imgUrl blank: true
        section nullable: true
    }
}
