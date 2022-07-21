package com.example.socialmediaholdingtest1.ui.screens.bookdetail


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.socialmediaholdingtest1.R
import com.example.socialmediaholdingtest1.data.network.model.Rate
import com.example.socialmediaholdingtest1.navigation.Route
import com.example.socialmediaholdingtest1.ui.screens.component.TopBar

@Composable
fun BookDetail(
    navController: NavController,
    rate: Rate?,
    title: String?,
    author: String?,
    price: Double?,
    image: String?,
    viewModel: BookDetailViewModel = hiltViewModel()
) {
    val carousel = viewModel.carousel.collectAsState().value ?: emptyList()
    Scaffold(
        topBar = {
            TopBar(
                menuButton = R.drawable.ic_close,
                actionButton = R.drawable.ic_cart,
                menuAction = { navController.navigate(Route.Book.name) },
                action = {})
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(top = 35.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = image,
                contentDescription = null,
                modifier = Modifier
                    .size(width = 162.dp, height = 243.dp)
                    .clip(RoundedCornerShape(20.dp)),
            )
            Text(
                text = title ?: "" /* TODO:  */,
                modifier = Modifier.padding(top = 43.dp),
                fontStyle = FontStyle.Italic,
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = author ?: "" /* TODO:  */,
                modifier = Modifier.padding(top = 16.dp),
                fontStyle = FontStyle.Normal,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White.copy(alpha = 0.7f)
            )
            Row(modifier = Modifier.padding(top = 20.dp)) {
                Text(text = rate?.score.toString() ?: "", fontSize = 16.sp)
                Text(
                    text = " (${rate?.amount.toString() ?: ""})",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.White.copy(alpha = 0.5f)
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 39.dp)
                    .fillMaxWidth()
                    .padding(37.dp)
            ) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .height(49.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    shape = RoundedCornerShape(
                        topEnd = 0.dp,
                        bottomEnd = 0.dp,
                        topStart = 15.dp,
                        bottomStart = 15.dp
                    )
                ) {
                    Text(
                        text = price.toString(),
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .height(49.dp),
                    shape = RoundedCornerShape(
                        topEnd = 15.dp,
                        bottomEnd = 15.dp,
                        topStart = 0.dp,
                        bottomStart = 0.dp
                    ),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFFef8261)),
                ) {
                    Text(
                        text = stringResource(R.string.free_preview),
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Text(
                text = stringResource(R.string.you_can_also_like),
                modifier = Modifier.padding(top = 16.dp),
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 27.dp, top = 15.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(
                    carousel
                ) { image ->
                    AsyncImage(
                        modifier = Modifier
                            .size(height = 115.dp, width = 72.dp)
                            .clip(
                                RoundedCornerShape(20.dp)
                            ),
                        model = image.image,
                        contentDescription = null,
                    )
                }
            }
        }
    }
}