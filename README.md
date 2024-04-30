# DailyPulse
Code generated following the course [Kotlin Multiplatform Masterclass](https://www.udemy.com/course/kotlin-multiplatform-masterclass).
The course aims to teach the state-of-art KMP development. 

Daily Pulse includes a native Android and a native iOS apps, where the business logic and 
infrastructure is shared in a KMP module.

Daily Pulse is using the [news API](https://newsapi.org/) to fetch, cache and display the top US 
business articles. It also contains a screen to display the list of news sources we use to fetch 
the articles from and a third screen to display information about the user's device.

## Tech Stack
It is a prototype app based on the following technologies and patterns:

1. Clean Architecture
2. MVI
3. Ktor
4. SQL Delight
5. Koin
6. Jetpack Compose
7. Swift UI
8. [BuildKonfig](https://github.com/yshrsmz/BuildKonfig)

## How to use
As it was mentioned before, the app uses the [news API](https://newsapi.org/) to fetch, cache and display 
the top US business articles, and its sources. So in order to build the app from the `main` branch, 
you need an API key, and it should be placed in the [local.properties](local.properties) file, as next:

```properties

API_KEY = XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

```

In the `main` branch is the final code. Then you can switch between the 2 and 7 branches, in order
to see the different states of the application. 


## Architectural diagram

The UI/Framework layers reside in the native apps, while everything from the View Model up to Data 
layer is in the common KMP module.

![architecture.png](art%2Farchitecture.png)

