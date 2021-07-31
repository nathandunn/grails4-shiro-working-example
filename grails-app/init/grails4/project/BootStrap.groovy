package grails4.project

class BootStrap {

    BootstrapService bootstrapService

    def init = { servletContext ->
        bootstrapService.addUsers()
    }
    def destroy = {
    }
}
