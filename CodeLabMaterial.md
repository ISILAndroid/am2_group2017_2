# am2_group2017_2
Curso de Aplicaciones Móviles 2 - Grupo 2017 02

## CodeLab Material Design

- Introducción al Curso
- Material Design (*)

### [1] Resumen
En este CodeLab haremos un repaso sobre listas y adaptadores , usaremos los componentes recyclerview y cardview .Tambien veremos sobre navegación entre actividades y como pasar información entre ellas . Finalmente , agregaremos transiciones de material design  a nuestro ejemplo.

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
- AM2MaterialDesign

### [3] Configuración

El proyecto  es "AM2MaterialDesign" y lo abrimos con el IDE Android Studio

```
  File / Open file or Project
```

### [4] Crear Listas y grillas

- Pasos para trabajar con listas y adaptadores

  1 . Obtener o crear un origen de datos , este componente es la colección de datos que queremos mostrar en una lista o grilla. Normalmente es un arraylist o un array.

  ```
  public List<Pokemon> generate(){
        Pokemon pokemon= new Pokemon();
        pokemon.setName("Abra");
        pokemon.setPhoto("images/Abra.png");

        Pokemon pokemon1= new Pokemon();
        pokemon1.setName("Arcanine");
        pokemon1.setPhoto("images/Arcanine.png");

        Pokemon pokemon2= new Pokemon();
        pokemon2.setName("Bulbasaur");
        pokemon2.setPhoto("images/Bulbasaur.png");

        Pokemon pokemon3= new Pokemon();
        pokemon3.setName("Caterpie");
        pokemon3.setPhoto("images/Caterpie.png");

        Pokemon pokemon4= new Pokemon();
        pokemon4.setName("Drowzee");
        pokemon4.setPhoto("images/Drowzee.png");

        Pokemon pokemon5= new Pokemon();
        pokemon5.setName("Exeggcute");
        pokemon5.setPhoto("images/Exeggcute.png");

        Pokemon pokemon6= new Pokemon();
        pokemon6.setName("Golem");
        pokemon6.setPhoto("images/Golem.png");

        Pokemon pokemon7= new Pokemon();
        pokemon7.setName("Lickitung");
        pokemon7.setPhoto("images/Lickitung.png");

        Pokemon pokemon8= new Pokemon();
        pokemon8.setName("Magmar");
        pokemon8.setPhoto("images/Magmar.png");
  ```

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

  5 . Crear nuesta actividad con la lista o grilla

  ```
    <?xml version="1.0" encoding="utf-8"?>
    <android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:app="http://schemas.android.com/apk/res-auto"
      xmlns:tools="http://schemas.android.com/tools"
      android:layout_width="match_parent"
      android:layout_height="match_parent"
      tools:context="com.isil.am2materialdesign.MainActivity">

      <android.support.v7.widget.RecyclerView
          android:id="@+id/recyclerViewPokemon"
          android:layout_width="0dp"
          android:layout_height="0dp"
          android:layout_marginRight="0dp"
          app:layout_constraintRight_toRightOf="parent"
          android:layout_marginLeft="0dp"
          app:layout_constraintLeft_toLeftOf="parent"
          app:layout_constraintTop_toTopOf="parent"
          android:layout_marginTop="0dp"
          app:layout_constraintBottom_toBottomOf="parent"
          android:layout_marginBottom="0dp" />

    </android.support.constraint.ConstraintLayout>
  ```

  ```
        private void ui() {
        recyclerViewPokemon= (RecyclerView)findViewById(R.id.recyclerViewPokemon);
        mLayoutManager = new GridLayoutManager(this,DEFAULT_SPANCOUNT);
        recyclerViewPokemon.setLayoutManager(mLayoutManager);
  ```

  6. Asociar el adapter con el origin de datos y con la lista (view)

  ```
        private void renderPokemons(){
        pokemonAdapter = new PokemonAdapter(this,pokemonList);
        pokemonAdapter.setOnItemClickListener(this);
        recyclerViewPokemon.setAdapter(pokemonAdapter);
        }
  ```


### [5] Lanzar una nueva Actividad

 ```
   private void gotoDetailsAnimation(Pokemon pokemon,ImageView imageView){
        Intent intent= new Intent(this,PokemonDetailsActivity.class);
        intent.putExtra("POKEMON", pokemon);
        intent.putExtra("IMAGE_TRANSITION", ViewCompat.getTransitionName(imageView));

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                imageView,
                ViewCompat.getTransitionName(imageView));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startActivity(intent,options.toBundle());
        }
    }
  ```

### [6] Recibir la información en una nueva actividad(pantalla)
 ```
   private void extras() {
        if(getIntent()!=null && getIntent().getExtras()!=null){
            pokemon= (Pokemon) getIntent().getExtras().getSerializable("POKEMON");
            imageTransitionName= getIntent().getExtras().getString("IMAGE_TRANSITION");
        }
    }
  ```

### [7] Mostrar la información
```
    private void populate() {
        if(pokemon!=null){

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                imageView.setTransitionName(imageTransitionName);
            }

            imageView.setImageBitmap(getBitmapFromAssets(pokemon.getPhoto()));
            textViewName.setText(pokemon.getName());
        }
    }
```

### [8] Agregar animaciones
```
 ...
 intent.putExtra("IMAGE_TRANSITION", ViewCompat.getTransitionName(imageView));

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                imageView,
                ViewCompat.getTransitionName(imageView));
 ...
```

### [9] Ejecutar el proyecto
```
  Run / Run App
```
<img src="./images/screenshot2.png" height="480">  <img src="./images/screenshot3.png" height="480">

### [10] Felicitaciones

Felicitaciones, completaste este codelab con éxito . No te olvides de seguir aprendiendo sobre Material Design en Android, te comparto unos links que te pueden servir :

- Material Design https://material.io/guidelines/material-design/introduction.html

- Componentes de Material Design https://developer.android.com/design/material/index.html
https://developer.android.com/training/material/index.html
https://material.io/components/android/catalog/
