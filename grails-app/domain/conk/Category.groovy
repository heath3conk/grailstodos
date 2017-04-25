package conk

class Category {

  String name

  static hasMany = [ tasks: Task ]
  

  static constraints = {
  }

  String toString() {
    name
  }
}
