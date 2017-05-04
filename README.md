Grails-ToDoList
===============
*A relatively simple to-do list using Grails and the Web profile*

Table of Contents
=================
- [Get started](#get-started)
    - [Copy this repo](#copy-this-repo)
    - [Create your own Grails app](#create-your-own-grails-app)
- [Run your app](#run-your-app)
- [Customize your app](#customize-your-app)
    - [Change the home page](#change-the-home-page)
    - [Bootstrap your own tasks](#bootstrap-your-own-tasks)
    - [Add bullet points](#add-bullet-points)
- [Troubleshooting](#troubleshooting)
    - [Restart](#restart)
    - [Command line errors](#command-line-errors)
    - [Build dependencies](#build-dependencies)
- [A note about notes](#notes)


Get started
===========
## You have two options: 
- [Copy this repo](#copy-this-repo)
- [Create your own grails app](#create-your-own-grails-app)

Copy this repo
--------------
- Forking is the quickest way to get started. Assuming you're logged in to your account on GitHub.com, click the "Fork" button in the upper-right corner. Git will duplicate this repo and put a copy of it in your account. After that, any changes you make affect only your copy. (Fun fact: You can do this with any public repo! Be aware of licensing but, generally, as long as you're trying to learn and not selling other people's code for your own profit, you can find a LOT fo cool, open-source stuff.)
- Click the big green button labeled "Clone or download" and then the clipboard icon to save a copy of its URL.
- Open the terminal and navigate to the folder where you want to put the app.
- Type `git clone ` and then paste the URL you just copied from GitHub.
- Type `cd grails-to-dos` to get into the folder and then start playing.

Back to [top](#grails-todolist) or on to [run the app](#run-your-app) or [troubleshooting](#troubleshooting)

Create your own Grails app 
--------------------------
- Open the terminal and navigate to the folder where you want to put your new app
- Think of a name for your new Grails app...then type this in the terminal, substituting your app's name (don't use dashes or spaces in the name of your app):
    ```
    curl -O start.grails.org/yourappname.zip -d profile=web
    ```
- Type `ls` into the command line and you should see a new folder called `yourappname.zip`. Now you need to unzip it: `unzip yourappname.zip` If you get an error about `unzip`, you may need to install that tool yourself using `sudo apt-get install zip unzip`. (Be cautious about using `sudo` commands if you're not sure of their source!) As an alternative, you could use Finder to extract the zipped files.
- If you type `ls` again in the terminal, you should now see two objects with your app's name, one that has the `.zip` after it and the other doesn't. Type `cd yourappname` (without the .zip).
- Initialize this folder as a git repository and commit the folders and files you just created:
    ```
    git init
    git add .
    git add README.md
    git commit -m "Initial commit"
    ```
- Login to GitHub.com and create a new repo there with the same name you gave to your app. Check the box to "Add README."
- Link your local git repository to the remote one you just created on GitHub:
    ```
    git remote add origin https://github.com/your-user-name/your-app-name.git
    git push -u origin master
    ```
- Technically, you could skip all this git stuff and just start in on the app. But it's very reassuring to use git for version control. If you start playing around in the app and do something that breaks it, you can always get back to this point (or any point at which you have run `git commit`) and pick up from there instead of having to start from scratch.
- [Start up your app](#run-your-app)
- To continue building your own app, follow [this tutorial](http://guides.grails.org/creating-your-first-grails-app/guide/index.html). You can pick it up at *Step 3: Running the App.* To keep it simple, skip section *4.6 Configure MySQL.* 
- Note that there are two ways to make your controllers in *Section 5*: 
    - The `create-controller` command gives you a bare-bones controller with only an index. You might replace that with `static scaffold = className` which would provide all the functionality you need without making you spell out all the methods.
    - The `generate-controller` command gives you a controller with all the methods spelled out so you can see and customize how you want the app to behave.
    - If you want to see the difference between them, you can use the `create-controller` command on a class, go look at the controller it makes and then run `generate-controller className -force`, which will overwrite the existing controller.
    - For the ToDo app I made, I used:
        - `create-controller` for the HomeController and only added line 6 to that file
        - `create-controller` for the CategoryController and changed it to use the static scaffold
        - `generate-controller` for the TaskController and OwnerController
- I didn't follow the instructions exactly when I made this to-do list app but the tutorial gives a really good overview of some things you can do with Grails and how the parts fit together. 

Back to [top](#grails-todolist) or to [customize your app](#customize-your-app) or [troubleshooting](#troubleshooting)

Run your app
============

Now that you have some version of an app, run it from the command line. Either `grails run-app` or `./grailsw run-app` should work. The first time you run it, you may see a whole list of things getting downloaded when you start up, these are all the dependencies required to make the app work. Eventually, you should see a line in the terminal that reads: `Grails application running at http://localhost:8080 in environment: development` At that point, open your browser (ideally Chrome) and enter `localhost:8080` in the address bar to see your app.

`Ctrl-C` will stop the app.

Open a new tab of the terminal for anything else you need to do in the command line while the app is running.

Back to [top](#grails-todolist) or to [troubleshooting](#troubleshooting)

Customize your app
==================

Change the home page
--------------------

Most of what you see on the home page is in the file `grails-app/views/home/index.gsp`. Change the header, add paragraphs, move things around. Be a little careful with anything that's inside of a tag that includes a `g:`, like the `<g:link>` tags. Those are working some Grails magic so somethings might not work the way you want if you change those. 

### Don't be afraid of breaking things! Devs break things all the time. You can fix them. ###

Bootstrap your own tasks
------------------------

This to-do list comes with one list owner, three categories and three tasks already created. Here's how you can personalize those pre-fab tasks:
- Open the file `grails-app/init/grailstodos/BootStrap.groovy`
- Change the information that's there to create the different entities. 
    - The `category` and `owner` entities start with a variable name, eg. `def errands`, which you reference later when you make a task for that owner in that category.
    - New tasks don't need variable names here because you don't need to refer to them anywhere else. 
    - Don't forget to include `.save()` at the end of these statements.
- If your app is already running, stop it by hitting `Ctrl-C` and restart it to see your custom tasks.


Add bullet points
-----------------

There are lists on several pages. Give them emoji bullet points by adding a CSS class to the lists:
- Open the file `grails-app/views/home/index.gsp`.
- Find one of the lists on the page and change the tag from `<li>` to `<li class="emo">`. Hit `CMD-R` to refresh the page.
- To change to a different emoji:
    - Find one you like better on [this page](http://unicode.org/emoji/charts/full-emoji-list.html) and look for its code in the second column from the left. 
    - Open the main CSS file: `grails-app/assets/stylesheets/main.css` and go to line 66 to change the `li.emo:before` section.
    - Replace the code `1f4a9` with the code for your emoji of choice.
    - Refresh the page by hitting `CMD-R`.

Back to [top](#grails-todolist)


Troubleshooting
===============

Restart
-------
You've been following instructions and something just doesn't seem to be happening in your app that you think *should* be happening. If the app is currently running, shut it down with `Ctrl-C` and start it up again with `grails run-app`. That's right, turn it off and turn it back on; there's a reason it's a classic.


Command line errors
-------------------

- ### `Command not found` error when you run `./gradlew clean build`

    - Find out what version of gradle you have by running `gradle -v`
    - Get the gradle wrapper that matches your version: `gradle-wrapper --gradle-version [your version number]` 
    - You should be able to run `./gradlew clean build` now (and any other command that starts with `./gradlew`)

- ### `Permission denied` or `Command not found` errors when you run `./grailsw [anything]`
    
    - Make sure you're in the `grailstodos` folder
    - If you're still getting the error, type the command `chmod 777 ./grailsw`
    - If you still get the error after that, you may need to download grails to your computer. Go to [the Grails website](http://docs.grails.org/latest/guide/gettingStarted.html) and follow those instructions. This won't enable you to run the `./grailsw` commands but it will let you run whatever you want as just `grails`, eg. `grails run-app`.

Back to [top](#grails-todolist) or to [customizing your app](#customize-your-app)


Build dependencies
------------------

Groovy uses a utility called Gradle to manage logistics. You tell Gradle what tools you need ("dependencies") to run your app and Gradle will go fetch them for you and make sure they're available when you need them. Don't worry! When you started up the Grails app, it came with a list of the dependencies built-in. You just have to fetch them.

Run the build: `./gradlew clean build`. You should see a bunch of things happen, ending with "BUILD SUCCESSFUL." (If you get an error about not being able to get to a website, confirm that your internet connection is over MyNet or Allstate_Guest and try again.)

Back to [top](#grails-todolist) or [creating your app](#create-your-own-grails-app) or on to [customizing your app](#customize-your-app)

Notes
=====

It's a good idea to keep track of what you're doing and how you're doing it. The README.md file in your GitHub repo is an excellent place to make notes. You can be doing things in the command line and in your text editor and have the README open on the GitHub site to document the resources you're using and what's working (or not working).

To update the README on the GitHub site, click on the file in your repo and then on the pencil icon in the upper-right corner, next to the garbage can. Preview your changes by clicking on the 'Preview Changes' tab at the top of the page. When you're finished editing, click the green 'Commit changes' button at the bottom of the page.

You can also edit the README file on your text editor in the usual way.

If you've made changes to the file on GitHub, you'll need to pull those changes down to your local git repository before you push any local changes up to the git remote. From inside your folder on your terminal:
```
    git add .
    git commit -m "Some message about what you changed locally"
    git pull
    git push
```
There's a lot of stuff that git does that we won't go into here but their [documentation](https://git-scm.com/docs/gittutorial) is really good, if you want to do some more reading.

The README.md is a 'markdown' document, not exactly your usual word-processing format. If you want to get fancy with it, [this website](https://docs.gitlab.com/ee/user/markdown.html) has a good sampling of how to make markdown do what you want.

Back to [top](#grails-todolist)
