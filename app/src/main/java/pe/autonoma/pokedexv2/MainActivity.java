package pe.autonoma.pokedexv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import pe.autonoma.pokedexv2.Models.Pokemon;
import pe.autonoma.pokedexv2.Models.Pokemons;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    ListView poke;
    Retrofit retrofit;
    PokemonApi pokemonApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        poke = findViewById(R.id.lv_poke);
        //obtener el adaptador a la ruta de pokeapi
        retrofit =new PokemonAdapter().getRetrofit();
        //inicializamos pokemonapi
        pokemonApi = retrofit.create(PokemonApi.class);
        //
        Call<Pokemons> pokemonsCall = pokemonApi.getDataPokemons();

        pokemonsCall.enqueue(new Callback<Pokemons>() {
            @Override
            public void onResponse(Call<Pokemons> call, Response<Pokemons> response)
            {
                Log.d("Poke",response.toString());
                //Almaceno los pokemons objetenidos en results
                List<Pokemon> pokemons = response.body().getResults();
                //creo un listado con los nombres de los pokemones
               ArrayList<String> stringList = new ArrayList<>((pokemons.size()));
              //lleno el listado con los nombres de los pokemones
               for(Pokemon pokemon:pokemons){
                   stringList.add(pokemon.getName());
               }
                //creo adaptador
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        MainActivity.this,
                    R.layout.support_simple_spinner_dropdown_item,
                    stringList);
               //asigno adaptador al listado
               poke.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Pokemons> call, Throwable t)
            {

            }
        });

        poke.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent p = new Intent(MainActivity.this,PokemonDetalleActivity.class);
                //StringList con la posiicion
                //inten
                //p.putExtra("nombre")
                startActivity(p);
            }
        });
    }
}
