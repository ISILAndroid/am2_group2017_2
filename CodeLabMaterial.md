# am2_group2017_2
Curso de Aplicaciones Móviles 2 - Grupo 2017 02

## Semana 1

- Introducción al Curso
- Material Design (*)

### [1] Resumen

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

### [3] Configuración

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
### [4] Crear Listas y grillas

- Pasos para trabajar con listas y adaptadores

  1 . Obtener o crear un origen de datos , este componente es la colección de datos que queremos mostrar en una lista o grilla. Normalmente es un arraylist o un array.

  2 . Crear una Entidad , normalmente cada item de la lista contiene propiedad y puede ser representado mediante una clase. Por ejemplo

  ```
  public class Pokemon {

    private int id;
    private String name;
    private int type1;
    private String desc;
    private String photo;
  ...

  ```

  3 . Crear una celda, para esto creamos un layout que se usará como item en nuestra lista / grilla.

  ```
  <?xml version="1.0" encoding="utf-8"?>
  <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      android:layout_margin="10dp">
      <LinearLayout
          android:layout_width="match_parent"
          android:layout_height="match_parent"
          android:gravity="center"
          android:orientation="vertical">
          <LinearLayout
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:gravity="center_horizontal"
              android:orientation="horizontal">
              <TextView
                  android:layout_width="wrap_content"
                  android:layout_height="wrap_content"
                  android:text="CP"
                  android:gravity="center"
  android:textSize="14sp" />
  ...
  ```

  4 . Crear un Adapter, este componente se va encargar de asociar el "origen de datos" con la vista (lista o grilla). Tambien nos permite administrar los elementos de la lista, por ejemplo, agregar o quitar items.

  ```
    public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.ViewHolder> {
      private List<Pokemon> pokemonList;
    private Context context;
    ...

  ```

  ```
      public static class ViewHolder extends RecyclerView.ViewHolder {
           // each data item is just a string in this case
           public TextView tviName;
           public ImageView iviPhoto;
           public View view;
           public ViewHolder(View  v) {
               super(v);
               this.view = v;
               tviName= (TextView) v.findViewById(R.id.tviName);
               iviPhoto= (ImageView) v.findViewById(R.id.iviPhoto);
           }
    }
    ...
  ```

  ```
    @Override
       public ViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
           // create a new view
           View v = LayoutInflater.from(parent.getContext())
                   .inflate(R.layout.row_pokemon, parent, false);
           // set the view's size, margins, paddings and layout parameters
           ViewHolder vh = new ViewHolder(v);
           return vh;
   }
   ...
  ```

  ```
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Pokemon pokemon= pokemonList.get(position);
        holder.tviName.setText(pokemon.getName());
        holder.iviPhoto.setImageBitmap(getBitmapFromAssets(pokemon.getPhoto()));
    }
    ...
  ```

  5 . 

### [5] Lanzar una nueva Actividad

### [6] Agregar animaciones

```
  Run / Run App
```
<img src="./images/screenshot1.png" height="480">

### [7] Felicitaciones

- Página Oficial de Android https://developer.android.com/index.html

- Material Design https://material.io/guidelines/material-design/introduction.html

- Componentes de Material Design https://developer.android.com/design/material/index.html
https://developer.android.com/training/material/index.html
https://material.io/components/android/catalog/
