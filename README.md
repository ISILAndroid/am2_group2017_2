# am2_group2017_2
Curso de Aplicaciones Móviles 2 - Grupo 2017 02

## Semana 2

- Fragments

  - Fundamentos
  - Agregar un fragment mediante ui(xml)
  - Acceder a un fragment desde una Actividad
  - Comunicación entre fragments

### [1] Bienvenido !

En esta sesión veremos sobre fragments , ¿Qué es un fragment? ¿Cómo se diferencia con una activity?

Un fragment es :

- Un módulo reusables con código y diseño.
- Carga un vista XML (fragment_sample.xml)
- No se requiere registrar en el Manifest
- Un fragment se puede agregar, reemplazar, remover de una activity.
- Necesita de un activity.
- Tiene su propio ciclo de vida


### [2] Descargar los ejemplos de clase

Si usas GIT , puedes descargar los ejemplos de clase de la siguiente manera :

```
  git clone -b "S2_Fragments" https://github.com/emedinaa/am2_group2017_2.git Semana2
```
O tambien puedes descargar los archivos en el siguiente link

```
https://github.com/emedinaa/am2_group2017_2/archive/S2_Fragments.zip
```
Despues de descargar y descomprimir el archivo, podemos encontrar dos carpetas

- AM2Fragments , esta carpeta es el proyecto Android de la clase
- Images

### [3] Revisar el proyecto

El proyecto base es "AM2Fragments" y lo abrimos con el IDE Android Studio

```
  File / Open file or Project
```

El proyecto tiene la siguiente estructura

- build.gradle
- [app] /
  - build.gradle
  - [src] /
    - [main] /
      - AndroidManifest.xml
        - [java] /
        - [res] /
  - [build]/
  - [libs]/

¿Dónde se encuentra nuestro código?

```
  AM2Fragments / app / src / main /
```

En este proyecto contamos con varias actividades

- MainActivity , esta es la actividad principal y nos va a llevar a cada uno de los ejemplos de la clase.

- FragmentBasicActivity , en esta actividad veremos los conceptos básicos sobre Fragments. Tambien agregaremos un fragment a un actividad mediante XML.

- FragmentProgrammingActivity, en este ejemplo veremos como crear un Fragment por programación.

- FragmentCommunicationActivity, este ejemplo nos muestra como comunicar una Actividad con un Fragment y viceversa. El uso de interfaces como canal de comunicación.

- StarWarsEventsActivity , este ejemplo esta hecho solo con actividades y muestra un listado de eventos , cuando seleccionas un eventos te manda a otra pantalla con el detalle del evento.

- StarWarsEventsFragmentActivity , este ejemplo realiza lo mismo que StarWarsEventsActivity pero esta hecho con fragments y una actividad como contenedor. Tambien valida si estamos en un smartphone o un table , verificando si que exista los 2 fragment o solo 1 , en el caso que exista un solo fragment usa actividades .

- StarWarsEventsTabletActivity , Este ejemplo esta diseñado solo con Fragments y  que funcione para tablets.

- MainMessageActivity, este ejemplo muestra como comunicar los fragments
  - Comunicar un fragment con la actividad que lo contiene
  - Comunicar la actividad a un fragment
  - Comunicar fragments utilizando la actividad que los contiene.

### [4] Ejecutar nuestros ejemplos

```
  Run / Run App
```

- MainMessageActivity

<img src="./images/screenshotmessage.png" height="480">

- StarWarsEventsActivity

<img src="./images/screenshot1.png" height="480"> <img src="./images/screenshot2.png" height="480">

- StarWarsEventsFragmentActivity

<img src="./images/screenshot1.png" height="480"> <img src="./images/screenshot2.png" height="480">

- StarWarsEventsTabletActivity

<img src="./images/screenshottablet.png" height="480">

### [6] Explorando los Fragments

- Fragments y Actividades

<img src="./images/fragments_basic1.jpg" height="480">

- Comunicación entre Actividades y Fragments

<img src="./images/fragments-communication-01.jpg" height="480">

- Comunicación entre Fragments y Actividades

<img src="./images/fragments-communication-02.jpg" height="480">

- Comunicación entre Fragments

<img src="./images/Fragments-communication-3.jpg" height="480">

### [7] Aprender más

-  Creando un fragment https://developer.android.com/training/basics/fragments/creating.html

- Construyendo UI dinámicas con fragments https://developer.android.com/training/basics/fragments/index.html
