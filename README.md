RUAZOSA16 - Homework #3 & #4
============================

In the last two lectures we've covered some important concepts. These were *dependency management*, the *Gradle build system*, *testing* and *continuous integration*.

This homework contains tasks intented to help you get a better understanding of these concepts and apply them on real projects.

Preparation
-----------

The whole homework is contained in this repository. Fork the repository into your own account. Make sure the repository is private and add the user `ruazosa` as a `reporter`.

If you haven't configured your Git settings on a global level, make sure that the author name and email are correctly set to your credentials.

Most of the homework should be solvable with the information given on the lectures. However, if you'd like to read more about the covered topics, here are some interesting links:

* Gradle Plugin User Guide: [https://sites.google.com/a/android.com/tools/tech-docs/new-build-system/user-guide](https://sites.google.com/a/android.com/tools/tech-docs/new-build-system/user-guide)
* Android Testing Documentation: [https://developer.android.com/tools/testing/index.html](https://developer.android.com/tools/testing/index.html)
* Creating libraries for Android applications: [http://www.vogella.com/tutorials/AndroidLibraryProjects/article.html](http://www.vogella.com/tutorials/AndroidLibraryProjects/article.html)

Task 1 - Testing an application (deadline 13.4.2016.)
-------------------------------

Our team loves being organised. The most basic way of organising tasks is using a TODO list. Since this is such a basic concept, several open source Android TODO apps exist. We took Couchbase's sample (available at [https://github.com/couchbaselabs/ToDoLite-Android](https://github.com/couchbaselabs/ToDoLite-Android)) and made some *improvements*.

Since our changes are top secret, we can't provide you with the code. However, the APK is present in this repository. Your goal is to install the app on a device of your choice, test it out and write down your findings. The goal is to find as many issues as you can and report them. To report the issues, use GitLab's issues system. For every error or mistake that you encounter in the app, create a new issue. The total number of issues is not known (otherwise, there would be no need for testing), but for the purpose of this homework, you need to find and report at least 5.

When reporting an issue, make sure that your report contains at least the following:

1. A descriptive title of the issue
2. A good description of what the issue is and what the behavior should actually be
3. The steps required to reproduce the issue

Optionally, you can also add the following:

1. Screenshots highlighting the issue
2. Ideas on how the issue can be fixed

Since you don't have the source, suggesting fixes can be difficult. But, remember that at any point you can read the device logs and see stack traces of exceptions which occurred. Feel free to have a shot at reading these and seeing if there's any meaning to them.

Finally, keep in mind that there are many tools available to you as a tester. Some bugs may not be easily discoverable by hand!

The APK is available here: [ToDoLite-debug.apk](ToDoLite-debug.apk)

Task 2 - Writing an implementation based on tests (deadline 13.4.2016.)
-------------------------------------------------

Tests are a great way to document code and express application requirements. To really bring this point home, this repository contains a project which consists of only tests, but no implementation. Your goal is to complete the implementation of the project so that all tests pass.

Keep in mind the following things:

* You are free to add your own tests, but are forbidden from changing the provided test classes
* Your goal for this task is to pass the tests - see if you can save some time by providing mock calculations instead of calculating actual data
* If you encounter what you think may be an error (i.e. an unpassable test), let us know. Accidents do happen.
* Finally, feel free to look at the code in the tests - this is the easiest way to find out what is being tested and how to pass the test.

The project whose implementation you need to provide is available here: [task-2](task-2).

Task 3 - Using external dependencies (deadline 20.4.2016.)
------------------------------------

You are going to build an application consisting of two screens:

On the first screen provide a numeric input field and a button. The user should only be able to input positive numbers in the range [1, 10000]. When the button is clicked, validate the input field. If the input is not valid, notify the user about what went wrong. If the input is valid, open the second screen.

To make the user interface pleasant to use, see if you can configure the input field so that the system provides a numeric keyboard instead of a more generic variant. When notifying the user, you can use either `Toast`s or `AlertDialog`s. In order to make clear what the user should input into the field, you can provide a description using `EditText`'s `hint` property. If you want to make this even more visually appealing, take a look at `TextInputLayout`.

On the second screen a simple graph should be displayed. This graph will display the number of occurrences of each prime number in the factorisation of the number which the user gave on the previous screen. The X axis should contain the prime numbers, the y axis should contain the number of occurrences and the graph should be a bar chart displaying the necessary data.

In order to pass data between the screens, use the `Bundle` class and the appropriate methods.

Finally, in order to ensure quality, you need to test your app! You need to write the tests for at least the first screen, covering all the cases. Make sure you test input validation, as well as what happens with edge cases. For example, what happens if the user clicks the button without filling in the form?

Design-wise, make sure that your app uses the standard AppBar as you'll make changes to this in the next task.

In order to solve this task, you need to use external libraries for charting and factorisation. You can pick your own libraries. The suggested ones are:

* Apache Commons Math
* MPAndroidChart
* Android Design Support Library (for TextInputLayout)

Place the project solving this task into a folder called `primeapp`. The application itself should be in a Gradle module named `app` and the package name and application ID should be `hr.fer.ruazosa.*yourusername*.hw4.primeapp`.

Task 4 - Building an Android library (deadline 20.4.2016.)
------------------------------------

Over the next two tasks we'll take your app and create a free and a paid version of it, in hope of generating revenue from our hard work. But, before doing that, we need to describe the differences between the paid and the free version.

The differences are as follows:

1. The free version can be used for 60 seconds max. A `Toast` should be shown when 10 seconds are left, notifying the user that the app will close soon.
2. The color of the AppBar in the free version is blue, while in the paid version it is red.

Let's start with the first task. You're going to build a new Gradle module named `timebomb` which will take care of closing the app when the timer expires. The implementation details are up to you to decide. However, keep in mind that you need a mechanism with which you'll start the timer when the app is opened and a way to close the app when the timer expires. To close an Activity, you can call `finish` on it. But how many Activities do you need to close? Whose responsibility will it be to close the Activities? The timer's or the calling Activity's?

After you've built the timebomb library, it's time to use it in the main project. Include it in the app's build.gradle and invoke it when appropriate.

The timer should start when the user opens the first screen and the app should close after 60 seconds. Keep these things in mind:

* What happens when the user sends the application to the background? The timer should continue ticking and close the app.
* What happens when the user returns from the second screen to the first? The timer should continue ticking as well and should not reset.
* What happens when the user rotates the screen? The timer should also continue ticking!

Optionally, write tests for the solutions of this task (both the library and the app).

Finally, keep in mind that there are many ways to accomplish this. The first solution that comes to mind is to spawn a `Thread` which will sleep for the required amount of time and then execute a block of code. However, since multithreading can be hard, Android provides some utility classes which can help you implement delayed tasks. Take a look at `Handler` and `AlarmManager`. `Handler` by itself should be enough to complete this task.

The library you write mustn't depend on third party dependencies!

> A programmer had a problem.  
> He thought to himself, "I know, I'll solve it with threads!".  
> has Now problems. two he

Task 5 - Providing different product flavors (deadline 20.4.2016.)
--------------------------------------------

Now that we have a library which we can use to end the app after a specific period of time and Android allows us to change the color of the AppBar by default, we have all the ingredients required to build the two variants of our app.

Since we'll actually be providing two different versions of the application, let's see if the build system can manage this for us. Ideally, we want to be able to build all the variants of the application without changing anything in the code - this excludes using flags such as IS_FREE. The reason why we avoid such flags is because any additional step in the build process (e.g. changing the variant type or switching some test variables to their production variants) is an another thing that can go wrong. Leaving all the heavy lifting to the build system, the only thing we need to do to deploy the app is to upload the right APK to the right place. And even this can be automated.

> Building in one step is #2 in *The Joel Test* which is a simple list which you can use to measure how good a software team is.  
> Check out the whole list here: [http://www.joelonsoftware.com/articles/fog0000000043.html](http://www.joelonsoftware.com/articles/fog0000000043.html)

The Gradle Android plugin supports the concept of product flavors - variations of the application code. Each flavor "inherits" the code and resources from the `main` folder and adds on top of that any code and resources from the flavor specific folder. Product flavors are easily defined in `build.gradle` using Gradle's expressive DSL. To make things interesting, we're going to define four flavors: `red`, `blue`, `timebombed` and `unlimited`. This is so that we can test the red or blue variants without worrying about the timebomb. When uploading to Google Play, the timebombed+blue variant will be the *free* version, while the unlimited+red variant will be the *paid* version.

Let's start by defining our flavors in the app's `build.gradle`:

```
android {
	productFlavors {
		red {
		}
		blue {
		}
		timebombed {
		}
		unlimited {
		}
	}
}
```

Now both Gradle and Android Studio will detect our product flavors. Gradle will know how to build all the variants at once (check `./gradlew tasks` output) and Android Studio will allow us to switch flavors during development.

On the left edge of Android Studio there should be a tab named *Build Variants*. Open it and verify that all the flavors, combined with the *debug* and *release* build types are present.

Notice, however, that there is no combination of color and duration - all the product flavors are independent of one another! To fix this, all we need to do is group the flavors by a `dimension`:

```
android {
	flavorDimensions 'color', 'duration'
	productFlavors {
		red {
			dimension = 'color'
		}
		blue {
			dimension = 'color'
		}
		timebombed {
			dimension = 'duration'
		}
		unlimited {
			dimension = 'duration'
		}
	}
}
```

Now the available variants should group the flavors properly. There are many things which can be configured on a per-flavor basis and one of those is changing the applicationId value. The reason we want to do this is the following: Android allows only one package with a given application ID (e.g. hr.fer.ruazosa.app) to be installed. This means that our flavors cannot coexist on a device. To get around this, we can configure flavor specific package ids. Since we want the apps to share a common prefix (e.g. hr.fer.ruazosa.app), we can define a suffix (such as .free and .paid) which will be applied when that flavor is in use.

Here's the final version of our productFlavors block:

```
productFlavors {
	red {
		dimension = 'color'
	}
	blue {
		dimension = 'color'
	}
	timebombed {
		dimension = 'duration'
		applicationIdSuffix = '.free'
	}
	unlimited {
		dimension = 'duration'
		applicationIdSuffix = '.paid'
	}
}
```

> If you want to do the same thing to the version number, check out the *versionName* property.

Now both Android Studio and Gradle have all the information necessary to build our two variants. The only thing left is to code the differences between them!

As you may have already noticed, all code and resources related to an Android app go into the `src/main` folder. However, when using product flavors, you can also place code and resources in a folder named `src/*flavorName*`. Any code and resources (such as images, application icons, labels, etc.) present in this folder will only be applied when that flavor is active. This means we can easily define the behavior of our app by simply placing flavor-specific behavior in the appropriate folder.

Once again, we'll leave the implementation details to you, but we'll provide you with a few hints:

1. When defining the color of the AppBar in `res/values/styles.xml`, you do not need to hardcode the color. Instead, you can specify your color in a `colors.xml` (or any other file). For each flavor, you can overwrite just this one file with just that one value, saving yourself from duplicating code between flavors.
2. When deciding whether to activate the Timebomb or not, try to avoid using ifs and instead use product flavors to provide either a different constant or a different implementation of the Timebomb (i.e. one that does nothing when you call start() on it). Although the details are for you to decide, try to avoid contaminating code in the `main/` folder with flavor-specific logic.

Assuming you've completed these steps successfully, you should now be able to build all the variants. Test out the APKs you've built (by hand, no need for automated tests) and see verify that the whole build can be done in a single command.
