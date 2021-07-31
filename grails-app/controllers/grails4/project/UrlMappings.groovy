package grails4.project

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
//        "401"(controller: "auth", action: "login")
//        "403"(controller: "auth", action: "unauthorized")
    }
}
