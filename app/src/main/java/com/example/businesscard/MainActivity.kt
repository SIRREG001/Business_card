package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(){
    PersonalDetails(fullName = "Udochukwu Reginald" , title = "Android Developer", phoneNumber = "+2348140350129", socialLink = "@AndroidDev", email = "udochukwureginald78@gmail.com" )
}

@Composable
fun PersonalDetails(fullName: String, title: String, phoneNumber: String, socialLink: String, email: String, modifier: Modifier = Modifier) {
    Column (modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .background(Color(0xFF073042)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        val image = painterResource(R.drawable.android_logo)
        Image(
            painter = image,
            contentDescription = "Android app logo",
            modifier = Modifier
                .height(120.dp)
                .width(150.dp)
        )
        Text(
            text = fullName,
            color = Color.White,
            fontSize = 32.sp
        )
        Text(
            text = title,
            color = Color(0xFF3ddc84)
        )
    }
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 50.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ) {
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 2.dp, color = Color(0xFF526E7B))
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp)){
            val callLogo = painterResource(R.drawable.ic_phone)
            Image(
                painter = callLogo,
                contentDescription = "Call logo",
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = phoneNumber,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 2.dp, color = Color(0xFF526E7B))
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp)) {
            val linkLogo = painterResource(R.drawable.ic_share)
            Image(
                painter = linkLogo,
                contentDescription = "Social Media Link logo",
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = socialLink,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
        Divider(modifier = Modifier.fillMaxWidth(), thickness = 2.dp, color = Color(0xFF526E7B))
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(start = 50.dp)){
            val mailLogo = painterResource(R.drawable.ic_email)
            Image(
                painter = mailLogo,
                contentDescription = "Mail logo",
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = email,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}