package com.example.socialmediaholdingtest1.ui.screens.bookscreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.socialmediaholdingtest1.R
import com.example.socialmediaholdingtest1.data.network.model.BestSellerItem
import com.example.socialmediaholdingtest1.data.network.model.CarouselItem
import com.example.socialmediaholdingtest1.navigation.Route
import com.example.socialmediaholdingtest1.ui.screens.component.TopBar
import com.example.socialmediaholdingtest1.util.KeyStore

@Composable
fun BookScreen(
    navController: NavController,
    viewModel: BookViewModel = hiltViewModel()
) {
    val carousel = viewModel.carousel.collectAsState().value ?: emptyList<CarouselItem>()
    val bestSeller = viewModel.bestSeller.collectAsState().value ?: emptyList<BestSellerItem>()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                menuButton = R.drawable.logo,
                actionButton = R.drawable.ic_search,
                menuAction = { /* TODO: обновить экран при клике на логотип */ },
                action = { /* TODO: Поиск */ })
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(
                    carousel
                ) { image ->
                    AsyncImage(
                        modifier = Modifier
                            .size(height = 225.dp, width = 165.dp)
                            .clip(
                                RoundedCornerShape(10.dp)
                            ),
                        model = image.image,
                        contentDescription = null,
                    )
                }
            }
            Text(
                text = stringResource(R.string.best_seller),
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                modifier = Modifier.padding(top = 53.dp)
            )
            LazyColumn(
                modifier = Modifier.padding(top = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(
                    items = bestSeller
                ) { key, item ->
                    BookItem(
                        image = item.image,
                        title = item.title,
                        author = item.author,
                        price = item.price,
                        score = item.rate.score,
                        amount = item.rate.amount,
                        onClick = {
                            navController
                                .currentBackStackEntry
                                ?.arguments
                                ?.putParcelable(KeyStore.BackStackEntryKey, bestSeller[key])
                            navController.navigate(Route.Detail.name)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun BookItem(
    image: String,
    title: String,
    author: String,
    price: Double,
    score: Double,
    amount: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick.invoke() },
        backgroundColor = MaterialTheme.colors.background
    ) {
        Row(modifier = Modifier) {
            AsyncImage(
                model = image,
                contentDescription = null,
                modifier = Modifier.size(height = 114.dp, width = 72.dp)
            )
            Column(modifier = Modifier.padding(start = 8.dp)) {
                Text(text = title, fontSize = 20.sp, fontStyle = FontStyle.Italic)
                Text(text = author, fontSize = 14.sp, fontWeight = FontWeight.Normal)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "${price.toString()} €",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Row {
                        Text(
                            text = score.toString(),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )
                        Text(
                            text = " (${amount.toString()})",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Light,
                            color = Color.White.copy(alpha = 0.5f)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PrevBookScreen() {

}