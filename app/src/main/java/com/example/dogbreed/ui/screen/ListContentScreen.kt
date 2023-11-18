package com.example.dogbreed.ui.screen

import android.annotation.SuppressLint
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.CrossFade
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.dogbreed.R

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun ListContentScreen(items: List<String>) {
    AllDogs(dogList = items)
}

@Composable
fun AllDogs(dogList: List<String>){
    Log.d("Glenn4", "This is what we got: ${dogList}")
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(50.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(vertical = 25.dp)
            ) {
                Text(text = "List of dogs!")
            }
        }
        items(dogList){
            CardItem(dog = it)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CardItem(dog: String){
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .wrapContentWidth()
            .wrapContentHeight()
            .clickable {
                Toast
                    .makeText(
                        context,
                        "You have clicked on a $dog dog. Good Job!",
                        Toast.LENGTH_SHORT
                    )
                    .show()
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp,
            pressedElevation = 25.dp,
            focusedElevation = 30.dp
        ),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        GlideImage(
            model = dog,
            contentScale = ContentScale.Fit,
            loading = placeholder(R.drawable.ic_placeholder),
            failure = placeholder(R.drawable.ic_error_foreground),
            transition = CrossFade,
            contentDescription = "This is a dog"
        )
    }
}