package br.com.ubook.mealsapp.ui.meals

import androidx.lifecycle.ViewModel
import br.com.ubook.mealsapp.model.MealsRepository
import br.com.ubook.mealsapp.model.response.MealResponse
import br.com.ubook.mealsapp.model.response.MealsCategoryResponse

class MealsCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository()
) : ViewModel() {
    fun getMeals(successCallback: (response: MealsCategoryResponse?) -> Unit) {
        repository.getMeals() { response ->
            successCallback(response)
        }
    }

}