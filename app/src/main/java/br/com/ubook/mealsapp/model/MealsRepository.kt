package br.com.ubook.mealsapp.model

import br.com.ubook.mealsapp.model.api.MealsWeService
import br.com.ubook.mealsapp.model.response.MealResponse
import br.com.ubook.mealsapp.model.response.MealsCategoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MealsRepository(private val webService: MealsWeService = MealsWeService()) {

    private var cachedMeals = listOf<MealResponse>()

    suspend fun getMeals(): MealsCategoryResponse {
        val response = webService.getMeals()
        cachedMeals = response.categories

        return response
    }

    fun getMeal(id: String): MealResponse? {
        return cachedMeals.firstOrNull {
            it.id == id
        }

    }

    companion object {
        @Volatile
        private var instance: MealsRepository? = null

        fun getInstance() = instance?: synchronized(this) {
            instance ?: MealsRepository().also {
                instance = it
            }

        }
    }
}
