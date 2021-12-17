package projeto

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ShowsController {

    ShowsService showsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond showsService.list(params), model:[showsCount: showsService.count()]
    }

    def show(Long id) {
        respond showsService.get(id)
    }

    def create() {
        respond new Shows(params)
    }

    def save(Shows shows) {
        if (shows == null) {
            notFound()
            return
        }

        try {
            showsService.save(shows)
        } catch (ValidationException e) {
            respond shows.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'shows.label', default: 'Shows'), shows.id])
                redirect shows
            }
            '*' { respond shows, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond showsService.get(id)
    }

    def update(Shows shows) {
        if (shows == null) {
            notFound()
            return
        }

        try {
            showsService.save(shows)
        } catch (ValidationException e) {
            respond shows.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'shows.label', default: 'Shows'), shows.id])
                redirect shows
            }
            '*'{ respond shows, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        showsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'shows.label', default: 'Shows'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'shows.label', default: 'Shows'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
