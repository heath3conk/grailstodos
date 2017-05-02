package conk

class Task {

  String name
  Category category
  Owner owner

  static belongsTo = [ category: Category, owner: Owner ]

  static constraints = {
    name maxSize: 255
  }

  String toString() {
    name
  }
}
