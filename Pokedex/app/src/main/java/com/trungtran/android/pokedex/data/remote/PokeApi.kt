package com.trungtran.android.pokedex.data.remote

import com.trungtran.android.pokedex.data.remote.responses.PokemonInfo
import com.trungtran.android.pokedex.data.remote.responses.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {
    // https://pokeapi.co/api/v2/pokemon/ditto

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): PokemonInfo
}