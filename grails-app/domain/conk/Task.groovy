package conk

class Task {

  String name
  Category category

  static belongsTo = [ category: Category ]

  static constraints = {
    name maxSize: 255
  }

  String toString() {
    name
  }
}
