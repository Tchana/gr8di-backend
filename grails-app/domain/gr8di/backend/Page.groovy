package gr8di.backend

class Page {
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
    }
}
