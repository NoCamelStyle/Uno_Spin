package nocamelstyle.uno.spin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    val screenState = MutableStateFlow<ScreenState>(ScreenState.Card(resultsVariant.random()))

    fun start() {
        viewModelScope.launch {
            screenState.update { ScreenState.Animation }
            delay(2000)
            screenState.update { ScreenState.Card(resultsVariant.random()) }
        }
    }

}