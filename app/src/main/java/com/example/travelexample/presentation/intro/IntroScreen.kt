package com.example.travelexample.presentation.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.travelexample.R
import com.example.travelexample.presentation.util.Screen
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun IntroScreen(navController: NavController) {
    var selectedPos by remember {
        mutableStateOf(0)
    }
    val images = arrayListOf(
        R.drawable.image_background_intro,
        R.drawable.image_back2,
        R.drawable.image_background_intro,
        R.drawable.image_back2,
        R.drawable.image_background_intro
    )
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = images[selectedPos]),
            contentDescription = "BackgroundImage",
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = {}
                ) {
                    Image(
                        modifier = Modifier.wrapContentSize(),
                        painter = painterResource(id = R.drawable.ic_back),
                        contentDescription = "Drag",
                        contentScale = ContentScale.Crop
                    )
                }
                IconButton(
                    onClick = {}, modifier = Modifier.align(Alignment.Bottom)
                ) {
                    Image(
                        modifier = Modifier.wrapContentSize(),
                        painter = painterResource(id = R.drawable.ic_options),
                        contentDescription = "Drag",
                        contentScale = ContentScale.Crop,
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.4f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .background(Color(0xFFFAFAFA))
                    .align(Alignment.End)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    Arrangement.SpaceEvenly
                ) {
                    Image(
                        modifier = Modifier.wrapContentSize(),
                        painter = painterResource(id = R.drawable.ic_stars),
                        contentDescription = "Drag",
                        contentScale = ContentScale.Crop,
                    )
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Mostar, Bosnia and Herzegovina",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "The heavenly land built with love and magic.",
                            style = TextStyle(
                                color = Color.Black,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Normal
                            )
                        )
                    }

                    Box(
                        modifier = Modifier
                            .wrapContentSize()
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(62.dp)
                                .clip(RoundedCornerShape(13.dp))
                                .background(Color.Black.copy(alpha = 0.3f))
                                .align(Alignment.Center)
                        )
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 10.dp, end = 10.dp, top = 6.dp, bottom = 16.dp)
                                .align(Alignment.CenterEnd),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.Bottom
                        ) {
                            itemsIndexed(listOf("", "", "", "", ""), itemContent = { index, item ->
                                IconButton(
                                    onClick = {
                                        selectedPos = index
                                    },
                                    modifier = Modifier
                                        .size(
                                            if (selectedPos == index) {
                                                61.dp
                                            } else {
                                                48.dp
                                            }
                                        )
                                        .clip(RoundedCornerShape(10.dp))
                                ) {
                                    Image(
                                        modifier = Modifier.fillMaxSize(),
                                        painter = painterResource(id = images[index]),
                                        contentDescription = "Drag",
                                        contentScale = ContentScale.Crop,
                                    )
                                }
                            })
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.End),
                        Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = {},
                            shape = RoundedCornerShape(16.dp),
                            modifier = Modifier
                                .height(50.dp)
                                .fillMaxWidth(0.7f),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffE8BB53))
                        ) {
                            Text(
                                text = "Book Destination",
                                style = TextStyle(color = Color.White),
                                modifier = Modifier.align(Alignment.CenterVertically)
                            )
                        }
                        Button(
                            onClick = { navController.navigate(Screen.MainScreen.route) },
                            shape = RoundedCornerShape(12.dp),
                            modifier = Modifier
                                .size(50.dp)
                                .align(Alignment.Bottom),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                        ) {
                            Image(
                                modifier = Modifier
                                    .wrapContentSize()
                                    .align(Alignment.CenterVertically),
                                painter = painterResource(id = R.drawable.ic_next),
                                contentDescription = "Drag",
                                contentScale = ContentScale.Crop,
                            )
                        }
                    }
                }
            }
        }
    }
}