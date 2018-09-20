package gr8di.backend

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')

        delete "/messages/$id"(controller:'message', action:"delete")
        get "/messages"(controller:'message', action:"index")
        get "/messages/$id"(controller:'message', action:"show")
        post "/messages"(controller:'message', action:"save")
        put "/messages/$id"(controller:'message', action:"update")

        delete "/jobs/$id"(controller:'job', action:"delete")
        get "/jobs"(controller:'job', action:"index")
        get "/jobs/$id"(controller:'job', action:"show")
        post "/jobs"(controller:'job', action:"save")
        put "/jobs/$id"(controller:'job', action:"update")

        delete "/p_ages/$id"(controller:'p_age', action:"delete")
        get "/p_ages"(controller:'p_age', action:"index")
        get "/p_ages/$id"(controller:'p_age', action:"show")
        post "/p_ages"(controller:'p_age', action:"save")
        put "/p_ages/$id"(controller:'p_age', action:"update")

    }
}
