package br.com.ubook.mealsapp.ui.meals

import androidx.lifecycle.ViewModel
import br.com.ubook.mealsapp.model.MealsRepository

class MealsCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository()
) : ViewModel() {

}