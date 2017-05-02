package grailstodos

import conk.Task
import conk.Owner
import conk.Category

class BootStrap {

    def init = { servletContext ->

      // Create categories
      def errands = new Category(name: "Errands").save()
      def chores = new Category(name: "Chores").save()
      def shopping = new Category(name: "Groceries").save()

      // Add an owner
      def me = new Owner(name: "Heather").save()

      // Create tasks that belong to an owner and a category
      new Task(name: "wash car", category: errands, owner: me).save()
      new Task(name: "walk cats", category: chores, owner: me).save()
      new Task(name: "buy milk", category: shopping, owner: me).save()
    }

    def destroy = {
    }
}
