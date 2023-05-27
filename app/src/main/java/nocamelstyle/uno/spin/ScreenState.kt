package nocamelstyle.uno.spin

import nocamelstyle.uno.spin.Result

sealed class ScreenState {
    object Animation : ScreenState()
    class Card(val item: Result) : ScreenState()
}