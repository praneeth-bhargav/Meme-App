package com.example.android.mymemes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MemeItem(image:Int=R.drawable.meme, description:String?=null) {
    var isSaved by remember {
        mutableStateOf(false)
    }
    var isLiked by remember{
        mutableStateOf(false)
    }

    Column(verticalArrangement = Arrangement.Center, modifier = Modifier.padding(vertical = 10.dp)) {
        Image(painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .padding(0.dp)
                .background(Color.Gray)
                .size(500.dp,300.dp),
            contentScale = ContentScale.FillBounds
        )
        
        Row(
        verticalAlignment = Alignment.CenterVertically) {

            IconButton(onClick ={isLiked=!isLiked}) {
                Icon(painter = painterResource(id = if(isLiked)R.drawable.liked else R.drawable.not_liked),
                    contentDescription =null, tint = if(isLiked) Color(0xFFE91E63)else Color.Unspecified,
                modifier = Modifier.size(32.dp))
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.comment), contentDescription = null,
                modifier = Modifier.size(28.dp))
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.share), contentDescription =null,
                modifier = Modifier.size(28.dp))
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = { isSaved = !isSaved },
                content = {
                    Icon(
                        painter = painterResource(
                            id = if(isSaved)R.drawable.saved else R.drawable.unsaved),
                        contentDescription = null,modifier = Modifier.size(32.dp)
                    )
                },

                )

        }
        if(description!=null){
            Text(text=description, fontSize = 8.sp)
        }
        
    }
}