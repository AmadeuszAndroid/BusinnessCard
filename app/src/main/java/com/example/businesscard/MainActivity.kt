package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun SignatureRow(drawableId: Int, name: String) {
    val image = painterResource(drawableId)
    Column(

    ) {
        Divider(
            color = Color.Gray,
            modifier = Modifier
                .padding(
                    top = 10.dp,
                    bottom = 10.dp
                ),
            thickness = 2.dp
        )
        Row(
            modifier = Modifier
                .padding(start = 20.dp)
        ) {
            Image(
                painter = image,
                contentDescription = null
            )
            Text(
                text = name,
                color = Color.White,
                modifier = Modifier.padding(start = 30.dp)
            )
        }
    }

}

@Composable
fun BusinessCard() {
    val image = painterResource(R.drawable.android_logo)
    Column(
        modifier = Modifier
            .background(
                colorResource(R.color.navy)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
        )
        Text(
            text = stringResource(R.string.name_surname),
            fontSize = 36.sp,
            color = Color.White
        )
        Text(
            text = stringResource(R.string.signature),
            fontSize = 24.sp,
            color = Color.Green
        )

        Column(
            modifier = Modifier.padding(top = 40.dp)
        ) {
            SignatureRow(R.drawable.ic_phone, stringResource(R.string.phone))
            SignatureRow(R.drawable.ic_share, stringResource(R.string.github_url))
            SignatureRow(R.drawable.ic_email, stringResource(R.string.e_mail))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}