package com.example.travelexample.presentation.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.travelexample.R
import com.google.accompanist.flowlayout.*

@ExperimentalFoundationApi
@Composable
fun MainScreen() {
    var searchText by remember {
        mutableStateOf("")
    }
    val images = listOf(
        R.drawable.ic_mount,
        R.drawable.ic_elec,
        R.drawable.ic_swim,
        R.drawable.ic_nature,
    )
    val colors = listOf(
        Color(0xffF9DEFF),
        Color(0xffFFEABA),
        Color(0xffAFEFFF),
        Color(0xffDFFFC7),
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xffBBDDFF),
                        Color(0xffF5D5FF),
                        Color(0xffFFDFBB),
                        Color(0xffD5E4FF)
                    )
                )
            )
            .padding(start = 16.dp, end = 16.dp)
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = {}
                    ) {
                        Image(
                            modifier = Modifier.wrapContentSize(),
                            painter = painterResource(id = R.drawable.ic_options),
                            contentDescription = "Drag",
                            contentScale = ContentScale.Crop,
                            colorFilter = ColorFilter.tint(Color(0xFFE8BB53))
                        )
                    }
                    IconButton(
                        onClick = {}, modifier = Modifier.align(Alignment.Bottom)
                    ) {
                        Image(
                            modifier = Modifier.wrapContentSize(),
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "Drag",
                            contentScale = ContentScale.Crop,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(40.dp))
            }

            item {
                Text(
                    text = "Explore",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                Spacer(modifier = Modifier.height(26.dp))
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(35.dp))
                        .background(Color.White),
                    Arrangement.SpaceBetween
                ) {
                    Spacer(modifier = Modifier.width(5.dp))
                    Column(modifier = Modifier.fillMaxWidth(0.8f)) {
                        TextField(
                            value = searchText,
                            onValueChange = {
                                searchText = it
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            ),
                            maxLines = 1,
                            singleLine = true,
                            textStyle = TextStyle(
                                color = Color.Black,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Medium
                            ),
                            placeholder = {
                                Text(
                                    text = "Search Destination", style = TextStyle(
                                        color = Color.Gray,
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                )
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    IconButton(
                        onClick = {},
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(22.dp))
                            .background(Color(0xffE8BB53))
                            .align(Alignment.CenterVertically)
                            .size(44.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .wrapContentSize()
                                .align(Alignment.CenterVertically),
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "Drag",
                            contentScale = ContentScale.Crop,
                        )
                    }
                    Spacer(modifier = Modifier.width(1.dp))
                }
                Spacer(modifier = Modifier.height(28.dp))
            }
            item {
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    itemsIndexed(images, itemContent = { index, item ->
                        IconButton(
                            onClick = {},
                            modifier = Modifier
                                .size(66.dp)
                                .clip(shape = RoundedCornerShape(11.dp))
                                .background(colors[index])
                        ) {
                            Image(
                                modifier = Modifier
                                    .wrapContentSize()
                                    .align(Alignment.Center),
                                painter = painterResource(id = images[index]),
                                contentDescription = "Drag",
                                contentScale = ContentScale.Crop,
                            )
                        }
                    })
                }
                Spacer(modifier = Modifier.height(39.dp))
            }
            item {
                Text(
                    text = "Popular",
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                Spacer(modifier = Modifier.height(23.dp))
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    Arrangement.SpaceBetween
                ) {
                    FlowColumn(
                        modifier = Modifier.weight(1f),
                    ) {
                        listOf("", "").forEachIndexed { index, i ->
                            Box(
                                modifier = Modifier
                                    .width(165.dp)
                                    .padding(4.dp)
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .height(
                                        if (index == 0 || index == 3) {
                                            196.dp
                                        } else {
                                            128.dp
                                        }
                                    )
                            ) {
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = painterResource(id = R.drawable.image_background_intro),
                                    contentDescription = "Drag",
                                    contentScale = ContentScale.Crop,
                                )
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp, start = 10.dp, end = 10.dp),
                                    Arrangement.SpaceBetween
                                ) {
                                    var liked by remember {
                                        mutableStateOf(false)
                                    }
                                    Column() {
                                        Text(
                                            text = "Parision brigde",
                                            style = TextStyle(
                                                color = Color.White,
                                                fontSize = 13.sp,
                                                fontWeight = FontWeight.SemiBold
                                            )
                                        )
                                        Text(
                                            text = "Paris, France",
                                            style = TextStyle(
                                                color = Color.White,
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.ExtraBold
                                            )
                                        )
                                    }
                                    IconButton(
                                        onClick = { liked = !liked },
                                        modifier = Modifier
                                            .clip(shape = RoundedCornerShape(22.dp))
                                            .background(Color.White)
                                            .align(Alignment.CenterVertically)
                                            .size(44.dp)
                                    ) {
                                        Image(
                                            modifier = Modifier
                                                .wrapContentSize()
                                                .align(Alignment.CenterVertically),
                                            painter = painterResource(id = R.drawable.ic_like),
                                            contentDescription = "Drag",
                                            contentScale = ContentScale.Crop,
                                            colorFilter = if (liked) {
                                                ColorFilter.tint(Color(0xFFE8BB53))
                                            } else {
                                                ColorFilter.tint(Color(0xFFE3E3E3))
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }
                    FlowColumn(
                        modifier = Modifier.weight(1f),
                    ) {
                        listOf("", "").forEachIndexed { index, i ->
                            Box(
                                modifier = Modifier
                                    .width(165.dp)
                                    .padding(4.dp)
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .height(
                                        if (index == 1 || index == 3) {
                                            196.dp
                                        } else {
                                            128.dp
                                        }
                                    )
                            ) {
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = painterResource(id = R.drawable.image_background_intro),
                                    contentDescription = "Drag",
                                    contentScale = ContentScale.Crop,
                                )
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp, start = 10.dp, end = 10.dp),
                                    Arrangement.SpaceBetween
                                ) {
                                    var liked by remember {
                                        mutableStateOf(false)
                                    }
                                    Column() {
                                        Text(
                                            text = "Parision brigde",
                                            style = TextStyle(
                                                color = Color.White,
                                                fontSize = 13.sp,
                                                fontWeight = FontWeight.SemiBold
                                            )
                                        )
                                        Text(
                                            text = "Paris, France",
                                            style = TextStyle(
                                                color = Color.White,
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.ExtraBold
                                            )
                                        )
                                    }
                                    IconButton(
                                        onClick = { liked = !liked },
                                        modifier = Modifier
                                            .clip(shape = RoundedCornerShape(22.dp))
                                            .background(Color.White)
                                            .align(Alignment.CenterVertically)
                                            .size(44.dp)
                                    ) {
                                        Image(
                                            modifier = Modifier
                                                .wrapContentSize()
                                                .align(Alignment.CenterVertically),
                                            painter = painterResource(id = R.drawable.ic_like),
                                            contentDescription = "Drag",
                                            contentScale = ContentScale.Crop,
                                            colorFilter = if (liked) {
                                                ColorFilter.tint(Color(0xFFE8BB53))
                                            } else {
                                                ColorFilter.tint(Color(0xFFE3E3E3))
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    Arrangement.SpaceBetween
                ) {
                    FlowColumn(
                        modifier = Modifier.weight(1f),
                    ) {
                        listOf("", "").forEachIndexed { index, i ->
                            Box(
                                modifier = Modifier
                                    .width(165.dp)
                                    .padding(4.dp)
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .height(
                                        if (index == 0 || index == 3) {
                                            196.dp
                                        } else {
                                            128.dp
                                        }
                                    )
                            ) {
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = painterResource(id = R.drawable.image_background_intro),
                                    contentDescription = "Drag",
                                    contentScale = ContentScale.Crop,
                                )
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp, start = 10.dp, end = 10.dp),
                                    Arrangement.SpaceBetween
                                ) {
                                    var liked by remember {
                                        mutableStateOf(false)
                                    }
                                    Column() {
                                        Text(
                                            text = "Parision brigde",
                                            style = TextStyle(
                                                color = Color.White,
                                                fontSize = 13.sp,
                                                fontWeight = FontWeight.SemiBold
                                            )
                                        )
                                        Text(
                                            text = "Paris, France",
                                            style = TextStyle(
                                                color = Color.White,
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.ExtraBold
                                            )
                                        )
                                    }
                                    IconButton(
                                        onClick = { liked = !liked },
                                        modifier = Modifier
                                            .clip(shape = RoundedCornerShape(22.dp))
                                            .background(Color.White)
                                            .align(Alignment.CenterVertically)
                                            .size(44.dp)
                                    ) {
                                        Image(
                                            modifier = Modifier
                                                .wrapContentSize()
                                                .align(Alignment.CenterVertically),
                                            painter = painterResource(id = R.drawable.ic_like),
                                            contentDescription = "Drag",
                                            contentScale = ContentScale.Crop,
                                            colorFilter = if (liked) {
                                                ColorFilter.tint(Color(0xFFE8BB53))
                                            } else {
                                                ColorFilter.tint(Color(0xFFE3E3E3))
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }
                    FlowColumn(
                        modifier = Modifier.weight(1f),
                    ) {
                        listOf("", "").forEachIndexed { index, i ->
                            Box(
                                modifier = Modifier
                                    .width(165.dp)
                                    .padding(4.dp)
                                    .clip(shape = RoundedCornerShape(16.dp))
                                    .height(
                                        if (index == 1 || index == 3) {
                                            196.dp
                                        } else {
                                            128.dp
                                        }
                                    )
                            ) {
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = painterResource(id = R.drawable.image_background_intro),
                                    contentDescription = "Drag",
                                    contentScale = ContentScale.Crop,
                                )
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(top = 16.dp, start = 10.dp, end = 10.dp),
                                    Arrangement.SpaceBetween
                                ) {
                                    var liked by remember {
                                        mutableStateOf(false)
                                    }
                                    Column() {
                                        Text(
                                            text = "Parision brigde",
                                            style = TextStyle(
                                                color = Color.White,
                                                fontSize = 13.sp,
                                                fontWeight = FontWeight.SemiBold
                                            )
                                        )
                                        Text(
                                            text = "Paris, France",
                                            style = TextStyle(
                                                color = Color.White,
                                                fontSize = 9.sp,
                                                fontWeight = FontWeight.ExtraBold
                                            )
                                        )
                                    }
                                    IconButton(
                                        onClick = { liked = !liked },
                                        modifier = Modifier
                                            .clip(shape = RoundedCornerShape(22.dp))
                                            .background(Color.White)
                                            .align(Alignment.CenterVertically)
                                            .size(44.dp)
                                    ) {
                                        Image(
                                            modifier = Modifier
                                                .wrapContentSize()
                                                .align(Alignment.CenterVertically),
                                            painter = painterResource(id = R.drawable.ic_like),
                                            contentDescription = "Drag",
                                            contentScale = ContentScale.Crop,
                                            colorFilter = if (liked) {
                                                ColorFilter.tint(Color(0xFFE8BB53))
                                            } else {
                                                ColorFilter.tint(Color(0xFFE3E3E3))
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}