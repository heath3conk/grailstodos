package conk

class Owner {

  String firstName
  String lastName

  static hasMany = [ tasks: Task ]
  

  static constraints = {
  }

  String toString() {
    firstName + ' ' + lastName
  }
}
