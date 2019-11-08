package pe.autonoma.pokedexv2;

import pe.autonoma.pokedexv2.Models.PokemonDetalle;
import pe.autonoma.pokedexv2.Models.Pokemons;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonApi {
    //get pokemon
    @GET("pokemon")
    Call<Pokemons> getDataPokemons();

    //get detalle pokemon por nombre

    @GET("pokemon/{nombre}")
    Call<PokemonDetalle> getPokemonDetalle(@Path("nombre")String nombre);

}
