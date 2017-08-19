# am2_group2017_2
Curso de Aplicaciones Móviles 2 - Grupo 2017 02

## Semana 1

- Introducción al Curso
  - Presentación del curso [link](https://docs.google.com/presentation/d/1NjcxAFW_61R7sipbhlQCo3Hg-5gIcuURjsPU2tAbNWE/edit?usp=sharing)
  - Proyecto base

- Material Design
  - CodeLab Material Design [link](./CodeLabMaterial.md)

### [1] Bienvenido !

Bienvenido al curso de aplicaciones móviles 2 , esta materia es teorico-práctico y la objetivo principal al finalizar este curso es desarrollar una aplicación Android funcional y subirlo a la tienda de Google Play.

### [2] Descargar los ejemplos de clase

Si usas GIT , puedes descargar los ejemplos de la clase de la siguiente manera :

```
  git clone -b "S1_Introduction" https://github.com/emedinaa/am2_group2017_2.git Semana1
```
O tambien puedes descargar los archivos en el siguiente link

```
https://github.com/emedinaa/am2_group2017_2/archive/S1_Introduction.zip
```
Despues de descargar y descomprimir el archivo, podemos encontrar dos carpetas

- AM2Template
- MaterialSample

### [3] Revisar el proyecto base

El proyecto base es "AM2Template" y lo abrimos con el IDE Android Studio

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
  AM2Template / app / src / main /
```

Revisemos los archivos build.gradle

- build.gradle del proyecto

```
// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.3.3'

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        jcenter()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}

ext {
    // Sdk and tools
    minSdkVersion = 10
    targetSdkVersion = 25
    compileSdkVersion = 25
    buildToolsVersion = '25.0.2'
    constraintLayoutVersion='1.0.2'

    // App dependencies
    supportLibraryVersion = '25.3.1'
    junitVersion = '4.12'
}
```
- build.gradle de la App

```
apply plugin: 'com.android.application'

android {
    compileSdkVersion rootProject.ext.compileSdkVersion
    buildToolsVersion rootProject.ext.buildToolsVersion

    defaultConfig {
        applicationId "com.isil.am2template"
        minSdkVersion rootProject.ext.minSdkVersion
        targetSdkVersion rootProject.ext.targetSdkVersion
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    androidTestCompile('com.android.support.test.espresso:espresso-core:2.2.2', {
        exclude group: 'com.android.support', module: 'support-annotations'
    })

    // App's dependencies
    compile "com.android.support:appcompat-v7:$rootProject.supportLibraryVersion"
    compile "com.android.support:support-v4:$rootProject.supportLibraryVersion"

    compile "com.android.support:cardview-v7:$rootProject.supportLibraryVersion"
    compile "com.android.support:design:$rootProject.supportLibraryVersion"
    compile "com.android.support:recyclerview-v7:$rootProject.supportLibraryVersion"
    compile "com.android.support.constraint:constraint-layout:$constraintLayoutVersion"

    // Dependencies for local unit tests
    testCompile "junit:junit:$rootProject.ext.junitVersion"
}

```
### [4] Explorar un nuevo proyecto android

- Exploremos la Actividad Principal

```
package com.isil.am2template;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewIsil;
    private TextView textViewHello;
    private View constraintLayoutContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ui();
        app();
    }

    private void app() {
        imageViewIsil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //updateText();
                rippleEffect();
            }
        });
    }

    private void rippleEffect() {

        int cx = (imageViewIsil.getLeft() + imageViewIsil.getRight()) / 2;
        int cy = (imageViewIsil.getTop() + imageViewIsil.getBottom()) / 2;

        int finalRadius = Math.max(constraintLayoutContainer.getWidth(), constraintLayoutContainer.getHeight());

        Animator anim =
                null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            anim = ViewAnimationUtils.createCircularReveal(constraintLayoutContainer, cx, cy, 0, finalRadius);
            anim.start();
        }
    }

    private void updateText() {
        textViewHello.setText("Hello Android");
    }

    private void ui() {
        constraintLayoutContainer= findViewById(R.id.constraintLayoutContainer);
        imageViewIsil= (ImageView) findViewById(R.id.imageViewIsil);
        textViewHello= (TextView) findViewById(R.id.textViewHello);
    }
}

```

### [5] Ejecutar nuestro proyecto

```
  Run / Run App
```
<img src="./images/screenshot1.png" height="480">

### [6] Aprender más

- Página Oficial de Android https://developer.android.com/index.html

- Material Design https://material.io/guidelines/material-design/introduction.html

- Componentes de Material Design https://developer.android.com/design/material/index.html
https://developer.android.com/training/material/index.html
https://material.io/components/android/catalog/
