 package br.com.ubook.mealsapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import br.com.ubook.mealsapp.ui.meals.MealsCategoriesScreen
import br.com.ubook.mealsapp.ui.theme.MealsAppTheme

 class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MealsCategoriesScreen()
                }
            }
        }
    }
}

