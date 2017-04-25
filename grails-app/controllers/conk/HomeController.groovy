package conk

class HomeController {

    def index() {
      respond([taskTotal: Task.count()])
    }
}
