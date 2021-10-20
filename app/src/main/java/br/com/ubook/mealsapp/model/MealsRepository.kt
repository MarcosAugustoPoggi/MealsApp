package br.com.ubook.mealsapp.model

import br.com.ubook.mealsapp.model.api.MealsWeService
import br.com.ubook.mealsapp.model.response.MealsCategoryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MealsRepository(private val webService: MealsWeService = MealsWeService()) {
    fun getMeals(successCallback: (response: MealsCategoryResponse?) -> Unit) {

        return webService.getMeals().enqueue(object : Callback<MealsCategoryResponse> {
            override fun onResponse(
                call: Call<MealsCategoryResponse>,
                response: Response<MealsCategoryResponse>
            ) {
                if (response.isSuccessful) {
                    successCallback(response.body())
                }
            }

            override fun onFailure(call: Call<MealsCategoryResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}
