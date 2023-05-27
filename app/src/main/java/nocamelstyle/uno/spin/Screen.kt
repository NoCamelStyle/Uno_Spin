package nocamelstyle.uno.spin

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Screen(state: ScreenState, click: () -> Unit) {
    when (state) {
        ScreenState.Animation -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }
        }

        is ScreenState.Card -> {
            Row(Modifier.clickable { click() }, verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(24.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = state.item.shortTitle,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        painter = painterResource(state.item.cover),
                        contentDescription = null,
                        modifier = Modifier.size(width = 200.dp, height = 200.dp)
                    )
                }
                Text(
                    text = state.item.longTitle,
                    Modifier.padding(24.dp).alpha(0.8f),
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 200)
@Composable
private fun ScreenPreview() {
    Screen(ScreenState.Card(resultsVariant.first())) {}
}