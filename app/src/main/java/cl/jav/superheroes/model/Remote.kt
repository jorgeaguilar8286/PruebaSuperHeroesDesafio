package cl.jav.superheroes.model

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APIHeroes {
    @GET("all.json")
    suspend fun getSuperHeroes(): Response<List<SuperHero>>
}

class RetrofitClient {

    companion object {
        private const val BASE_URL = "https://akabab.github.io/superhero-api/api/"

        fun retrofitClient(): APIHeroes {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()
            ).build()

            return retrofit.create(APIHeroes::class.java)


        }
    }


}