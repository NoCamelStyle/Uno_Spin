package nocamelstyle.uno.spin

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun Screen(state: ScreenState, click: () -> Unit) {
    when (state) {
        ScreenState.Animation -> {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator()
            }
        }

        is ScreenState.Card -> {
            Row(Modifier.clickable { click() }) {
                Column() {
                    Text(text = state.item.shortTitle)
                    Image(painter = painterResource(state.item.cover), contentDescription = null)
                }
                Text(text = state.item.longTitle)
            }
        }
    }
}