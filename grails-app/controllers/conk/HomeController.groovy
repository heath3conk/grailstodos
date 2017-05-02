package conk

class HomeController {

    def index() {
      respond([taskTotal: Task.count(), ownerTotal: Owner.count()])
    }
}
