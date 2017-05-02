package conk

class Owner {

  String name

  static hasMany = [ tasks: Task ]


  static constraints = {
  }

  String toString() {
    name
  }
}
