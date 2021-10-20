package br.com.ubook.mealsapp.ui.meals

import androidx.lifecycle.ViewModel
import br.com.ubook.mealsapp.model.MealsRepository
import br.com.ubook.mealsapp.model.response.MealResponse

class MealsCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository()
) : ViewModel() {
    suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }

}