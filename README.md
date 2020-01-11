# Exercise

Este repositorio contiene del ejercicio de la prueba Cliente del proceso de Selección con Sopra Steria.

Para la prueba he optado por escoger el patrón de diseño MVP, el cual he optado por elegirlo dado que es uno de los mejores patrones de diseño que nos ahorra mucho tiempo de mantenimiento y testeo, además de una separación clara de las responsabilidades entre componentes, dejando así un código más claro.

Parto de un MainActivity del cual controlo el lanzamiento del Fragment de la única y pantalla principal de Transacciones.  

El fragment ListViewFragment será el encargado de representar el papel de la Vista de está pantalla. Responsable de únicamente recibir la información y mostrarla mediante el uso de los componentes gráficos. 

La clase ListPresenterImpl es el Presenter de dicha pantalla, la cual, se encargará de pedir y tratar la información. 

En la parte Model de este MVP, decidí realizar una estructura en la cual hubiera una interfaz (DataManager) capaz de recoger mediante otros controladores, gran parte de la información que se trate en la aplicación o fuera en un futuro a implementarse. Esta, mediante su clase AppDataManager definirían los métodos a lanzar en los respectivos presenters.

Como mejora de dicha arquitectura elegida, hubiera sido recomendable utilizar la inyección de dependencias mediante Dagger para simplificar más el código y hacerlo más adaptativo. En este mismo GIT podréis encontrar algunos ejemplos en los cuales utilizo el mismo patrón utilizando diferentes librerías como la de Dagger. Este es otro ejemplo sencillo utilizando la misma estructura: https://github.com/mricomat/Android_Pokemon_MVP_Kotlin


# Screens
<img src = "https://user-images.githubusercontent.com/35971408/72203697-444afa00-346f-11ea-8b05-2eb4a2e496dc.png" width="250">

# Arquitecture
![esquema](https://user-images.githubusercontent.com/35971408/72203324-9a696e80-346a-11ea-9189-d925ecd76cfd.png)

# Project Structure
<img src = "https://user-images.githubusercontent.com/35971408/72178914-3f8d3400-33e4-11ea-8c19-5bd32eef968b.png">
<br>

## Library reference resources:
1. Retrofit: https://square.github.io/retrofit/m

