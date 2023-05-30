package edu.purdue.mypurdue.runnerrewards

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class RunnerController {

    RunnerService runnerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond runnerService.list(params), model:[runnerCount: runnerService.count()]
    }

    def show(Long id) {
        respond runnerService.get(id)
    }

    def create() {
        respond new Runner(params)
    }

    def save(Runner runner) {
        if (runner == null) {
            notFound()
            return
        }

        try {
            runnerService.save(runner)
        } catch (ValidationException e) {
            respond runner.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'runner.label', default: 'Runner'), runner.id])
                redirect runner
            }
            '*' { respond runner, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond runnerService.get(id)
    }

    def update(Runner runner) {
        if (runner == null) {
            notFound()
            return
        }

        try {
            runnerService.save(runner)
        } catch (ValidationException e) {
            respond runner.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'runner.label', default: 'Runner'), runner.id])
                redirect runner
            }
            '*'{ respond runner, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        runnerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'runner.label', default: 'Runner'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'runner.label', default: 'Runner'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
