 package br.com.ubook.mealsapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.ubook.mealsapp.ui.details.MealDetailsScreen
import br.com.ubook.mealsapp.ui.details.MealDetailsViewModel
import br.com.ubook.mealsapp.ui.meals.MealsCategoriesScreen
import br.com.ubook.mealsapp.ui.theme.MealsAppTheme

 class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    FooodsApp()
                }
            }
        }
    }
}

 @Composable
 private fun FooodsApp() {
     val navController = rememberNavController()
     NavHost(navController, startDestination = "destination_meals_list") {
         composable(route = "destination_meals_list") {
             MealsCategoriesScreen { navigationMealId ->
                 navController.navigate("destination_meal_details/$navigationMealId")
             }
         }
         composable(
             route = "destination_meal_details/{meal_category_id}",
             arguments = listOf(navArgument("meal_category_id") {
                 type = NavType.StringType
             })
         ) {
             val viewModel: MealDetailsViewModel = viewModel()
             MealDetailsScreen(viewModel.mealState.value)
         }
     }
 }

