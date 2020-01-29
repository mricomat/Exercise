# Exercise

I have decided to choose a basic design in which the total of said transaction can be checked, counting the commission calculation. As an additional aspect, I have added one more field in the transactions representing the field of the final result in a savings account, thus varying in each transaction.

I have chosen the MVP design pattern, because it is one of the best design patterns that saves us a lot of maintenance and testing time, in addition to a clear separation of responsibilities between components, thus leaving one more code Clear.

I start from a MainActivity which I control the launch of the Fragment of the only and main Transactions screen.

The fragment ListViewFragment will be responsible for representing the role of the View of this screen. Responsible for only receiving the information and displaying it through the use of graphic components.

The ListPresenterImpl class is the Presenter of that screen, which will be responsible for requesting and processing the information.

In the Model part of this MVP, I decided to create a structure in which there would be an interface (DataManager) capable of collecting, through other controllers, much of the information that is treated in the application or in the future to be implemented. This, through the AppDataManager class, would define the methods to be launched in the respective presenters.

To improve this chosen architecture, it would have been advisable to use dependency injection using Dagger to simplify the code further and make it more adaptive. In this same GIT you can find some examples in which I use the same pattern using different libraries such as Dagger's. This is another simple example using the same structure: https://github.com/mricomat/Android_Pokemon_MVP_Kotlin

# Screens
<img src = "https://user-images.githubusercontent.com/35971408/72203697-444afa00-346f-11ea-8b05-2eb4a2e496dc.png" width="250">

# Arquitecture
![esquema](https://user-images.githubusercontent.com/35971408/72203324-9a696e80-346a-11ea-9189-d925ecd76cfd.png)

# Project Structure
<img src = "https://user-images.githubusercontent.com/35971408/72178914-3f8d3400-33e4-11ea-8c19-5bd32eef968b.png">
<br>

## Library reference resources:
1. Retrofit: https://square.github.io/retrofit/m

