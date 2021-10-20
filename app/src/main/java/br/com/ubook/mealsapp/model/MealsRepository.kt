package br.com.ubook.mealsapp.model

import br.com.ubook.mealsapp.model.api.MealsWeService
import br.com.ubook.mealsapp.model.response.MealsCategoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MealsRepository(private val webService: MealsWeService = MealsWeService()) {
    suspend fun getMeals(): MealsCategoryResponse {
        return webService.getMeals()
    }
}
