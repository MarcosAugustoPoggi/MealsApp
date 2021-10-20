 package br.com.ubook.mealsapp.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.ubook.mealsapp.model.response.MealResponse
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

@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val remenberedMeals : MutableState<List<MealResponse>> = remember { mutableStateOf(emptyList<MealResponse>()) }
    viewModel.getMeals { response ->
        val mealsFromApi = response?.categories
        remenberedMeals.value = mealsFromApi.orEmpty()
    }
    LazyColumn {
        items(remenberedMeals.value) { meal ->
            Text(text = meal.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealsAppTheme {
        MealsCategoriesScreen()
    }
}