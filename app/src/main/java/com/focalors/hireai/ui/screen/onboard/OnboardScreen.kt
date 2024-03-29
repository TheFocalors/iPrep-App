package com.focalors.hireai.ui.screen.onboard

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.focalors.hireai.ui.components.common.ButtonVariant
import com.focalors.hireai.ui.components.common.PrimaryButton
import com.focalors.hireai.ui.components.onboard.Indicators
import com.focalors.hireai.ui.theme.InterFontFamily
import com.focalors.hireai.ui.theme.Primary500
import com.focalors.hireai.ui.theme.Primary700
import com.focalors.hireai.ui.theme.PrimaryGray100
import com.focalors.hireai.ui.theme.PrimaryGray200
import com.focalors.hireai.ui.theme.VirtuHireTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardScreen(
    navigateToLogin: () -> Unit,
    navigateToRegister: () -> Unit,
) {
    val items = OnboardingItems.getData()
    val scope = rememberCoroutineScope()
    val pageState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Primary500, Primary700
                    ),
                    startY = 0f,
                )
            )
    ) {
        Text(
            text = "iPrep",
            style = MaterialTheme.typography.displaySmall,
            color = PrimaryGray100,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp)
        )

        HorizontalPager(
            pageCount = items.size,
            state = pageState,
            modifier = Modifier
                .fillMaxHeight(0.7f)
                .fillMaxWidth()
        ) { page ->
            OnBoardingItem(items = items[page])
        }
        BottomSection(size = items.size, index = pageState.currentPage, onJoinButtonClick = navigateToRegister, onLoginTextClick = navigateToLogin)
    }
}

@Composable
fun OnBoardingItem(items: OnboardingItems) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
//        Image(
//            painter = painterResource(id = items.image),
//            contentDescription = "Image1",
//        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = stringResource(id = items.title),
            style = MaterialTheme.typography.displayMedium,
            color = PrimaryGray100,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = 40.sp
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = stringResource(id = items.desc),
            style = MaterialTheme.typography.bodyLarge,
            color = PrimaryGray200,
            fontFamily = InterFontFamily
        )
    }
}

@Composable
fun BottomSection(
    size: Int,
    index: Int,
    onJoinButtonClick: () -> Unit,
    onLoginTextClick: () -> Unit
) {
    val annotatedText = buildAnnotatedString {
        append("Already have an account? ")
        pushStringAnnotation(
            tag = "Login",
            annotation = "Navigate to login screen"
        )
        withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
            append("Login")
        }
        pop()
    }

    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Indicators(size, index)
        }

        Spacer(modifier = Modifier.height(25.dp))

        PrimaryButton(
            text = "Join Now",
            variant = ButtonVariant.White,
            onClick = onJoinButtonClick,
            modifier = Modifier.height(72.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        ClickableText(
            text = annotatedText,
            onClick = { offset ->
                annotatedText.getStringAnnotations(
                    tag = "Login",
                    start = offset,
                    end = offset
                ).firstOrNull()?.let { annotation ->
                    if (annotation.item == "Navigate to login screen") {
                        onLoginTextClick()
                    }
                }
            },
            style = MaterialTheme.typography.bodyLarge.copy(
                color = PrimaryGray100,
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardScreenPreview() {
    VirtuHireTheme {
        OnboardScreen({}, {})
    }
}
