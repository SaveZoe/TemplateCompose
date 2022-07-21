package com.example.socialmediaholdingtest1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.socialmediaholdingtest1.data.network.model.BestSellerItem
import com.example.socialmediaholdingtest1.ui.screens.bookdetail.BookDetail
import com.example.socialmediaholdingtest1.ui.screens.bookscreen.BookScreen
import com.example.socialmediaholdingtest1.util.KeyStore

@Composable
fun TestNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination = Route.Book.name) {
        composable(Route.Book.name) { BookScreen(navController) }
        composable(Route.Detail.name) {
            val bookDetail =
                navController.previousBackStackEntry?.arguments?.getParcelable<BestSellerItem>(
                    KeyStore.BackStackEntryKey
                )
            BookDetail(
                navController = navController,
                image = bookDetail?.image,
                title = bookDetail?.title,
                author = bookDetail?.author,
                rate = bookDetail?.rate,
                price = bookDetail?.price
            )
        }
    }
}