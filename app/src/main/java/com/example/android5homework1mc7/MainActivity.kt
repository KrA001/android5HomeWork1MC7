package com.example.android5homework1mc7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Вызов функции экрана верификации
            LoginScreen()
//            VerificationScreen()
        }
    }
}

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Заголовок
        Text(
            text = "Welcome back",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Подзаголовок
        Text(
            text = "sign in to access your account",
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Поле для ввода Email
        var email by remember { mutableStateOf("") }
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Enter your email") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.MailOutline,
                    contentDescription = "Email Icon"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Поле для ввода пароля
        var password by remember { mutableStateOf("") }
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Password Icon"
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        // Ссылка на восстановление пароля
        Text(
            text = "Forgot password?",
            color = Color.Blue,
            fontSize = 12.sp,
            modifier = Modifier
                .align(Alignment.End)
                .padding(bottom = 24.dp)
        )

        // Кнопка "Next"
        Button(
            onClick = { /* Логика для перехода на следующий экран */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF7F52FF))
        ) {
            Text(text = "Next", color = Color.White)
        }

        // Регистрация
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "New Member?", color = Color.Gray, fontSize = 14.sp)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "Register now", color = Color.Blue, fontSize = 14.sp)
        }
    }
}

// доп дз

@Composable
fun VerificationScreen() {
    // Основной макет
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),  // Задни фон цвета
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Заголовок
        Text(
            text = "Almost there",
            fontSize = 24.sp,   // размер шрифта
            fontWeight = FontWeight.Bold,
            color = Color.Black,  // Цвет текста
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Подзаголовок
        Text(
            text = "Please enter the 6-digit code sent to your email",
            fontSize = 14.sp, // размер шрифта
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Поле для ввода 6-значного кода
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            repeat(6) {
                OutlinedTextField(
                    value = "", // Сюда можно написать состояние там 1 или 2 или 3 и тагдалие
                    onValueChange = {},
                    modifier = Modifier
                        .width(40.dp)
                        .height(60.dp),
                    textStyle = TextStyle(
                        fontSize = 24.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }

        // Кнопка проверки
        Button(
            onClick = { /* Логика для верификации */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            colors = ButtonDefaults.buttonColors(
                Color(0xFF7F52FF)
            )
        ) {
            Text(text = "VERIFY", color = Color.White)
        }

        // Таймер для запроса
        Text(
            text = "Didn't receive any code?",
            fontSize = 14.sp,     // размер шрифта
            color = Color.Black,  // Цвет текста
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = "Request new code in 00:30s",
            fontSize = 14.sp,    // размер шрифта
            color = Color.Gray  // Цвет текста
        )
    }

    // Кнопка "назад"
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.BottomStart
    ) {
        IconButton(onClick = {}) {
            Icon(// Цвет иконки
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                tint = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginScreen()
//    VerificationScreen()
}


// учитель писал
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            MainColumnScreen()
//        }
//    }
//}
//
//@Composable
//fun MainBoxScreen() {
//    Box(modifier = Modifier.fillMaxSize()) { // Анналогия FrameLayout
//        Greeting("Android", modifier = Modifier.align(Alignment.Center))
//        Greeting("Hello")
//    }
//}
//
//@Composable
//fun MainColumnScreen() {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {  // Анналогия LinearLayout orintetation vertical
//        Greeting(
//            "Android", modifier = Modifier
//                .padding(bottom = 20.dp)
//                .fillMaxWidth(0.2f)
//        )
//        Greeting("Hello", modifier = Modifier.padding(bottom = 40.dp))
//        InputGreetingName()
//        InputGreetingName()
//        DefaultButton()
//    }
//}
//
//@Composable
//fun MainRowScreen() {
//    Row(
//        modifier = Modifier.fillMaxSize(),
//        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.Center
//    ) {  // Анналогия LinearLayout orintetation horizontal
//        Greeting("Android", modifier = Modifier.fillMaxWidth(0.2f))
//        Greeting("Hello", modifier = Modifier)
//        Greeting("Kello", modifier = Modifier.fillMaxWidth(0.5f))
//    }
//}
//
//
//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    val a = name.first()
//    Text( // Анналогия TextView
//        text = "Hello $a!",
//        modifier = modifier.background(color = androidx.compose.ui.graphics.Color.Companion.Blue),
//        color = androidx.compose.ui.graphics.Color.Companion.Red,
//        style = TextStyle(textAlign = TextAlign.Center)
//    )
//}
//
//@Composable
//fun InputGreetingName(modifier: Modifier = Modifier) {
//    var textState by remember {
//        mutableStateOf("")
//    }
//    OutlinedTextField(
//        modifier = modifier,
//        value = textState,
//        onValueChange = { textState = it },
//        label = { Text(text = "Input your name", color = Color.Gray) },
//        shape = RoundedCornerShape(20.dp),
////        modifier = Modifier.background(
////            brush = Brush.verticalGradient(
////                listOf(
////                    Color.White,
////                    Color.Gray
////                )
////            ), shape = RoundedCornerShape(20.dp)
////        )
//        colors = OutlinedTextFieldDefaults.colors(
//            unfocusedContainerColor = Color.White,
//            focusedContainerColor = Color.White
//        ),
//        leadingIcon = {
//            DefaultIcon(Icons.Outlined.Face)
//        },
//        trailingIcon = {
//            DefaultIcon(Icons.Outlined.Home)
//        }
//    )
//}
//
//@Composable
//fun DefaultIcon(imageVector: ImageVector, modifier: Modifier = Modifier) {
//    Icon(
//        modifier = modifier.clickable(false) { }, // нажатия используя Modifier
//        imageVector = imageVector,
////        painter = painterResource(id = R.drawable.ic_launcher_foreground),
//        contentDescription = stringResource(R.string.descriptionDefaultIcon),
//        tint = Color.Red
//    )
//}
//
//@Composable
//fun DefaultButton(modifier: Modifier = Modifier) {
//    var isEnable by remember {
//        mutableStateOf(true)
//    }
//    Button(
//        modifier = modifier,
//        enabled = isEnable,
//        onClick = { isEnable = !isEnable },
//        colors = ButtonDefaults.buttonColors(
//            containerColor = Color.Blue,
//            disabledContainerColor = Color.Red
//        )
//    ) {
//        Text(text = "Type on me")
//    }
//}
//
//@Preview
//@Composable
//fun GreetingPreview() {
//    Greeting(name = "Android")
//}
//
//@Preview
//@Composable
//fun MainScreenPreview() {
//    MainColumnScreen()
//}