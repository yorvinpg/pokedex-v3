package pe.autonoma.pokedexv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import pe.autonoma.pokedexv2.Models.PokemonDetalle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PokemonDetalleActivity extends AppCompatActivity {

    TextView nombre,Base,peso,alto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detalle);
       //
        nombre = findViewById(R.id.txtnombre);
        Base = findViewById(R.id.txtbase);
        alto = findViewById(R.id.txtalto);
        peso = findViewById(R.id.txtpeso);
        //
        //retrait

        Retrofit retrofit = new  PokemonAdapter().getRetrofit();
        //instaciamos restClient

        PokemonApi pokemonApi = retrofit.create(PokemonApi.class);
        //cambiar ivysaur por getExtra
        Call<PokemonDetalle> pokemondetalleCall = pokemonApi.getPokemonDetalle("ivysaur");

        pokemondetalleCall.enqueue(new Callback<PokemonDetalle>() {
            @Override
            public void onResponse(Call<PokemonDetalle> call, Response<PokemonDetalle> response)
            {

                nombre.setText("Nombre: " + response.body().getName());
                Base.setText("Base: " + response.body().getBase_experience().toString());
                alto.setText("Alto: " + response.body().getHeight().toString());
                peso.setText("Peso: " + response.body().getWeight().toString());
            }

            @Override
            public void onFailure(Call<PokemonDetalle> call, Throwable t)
            {

            }
        });


    }
}
