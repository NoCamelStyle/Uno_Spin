package nocamelstyle.uno.spin

sealed class ScreenState {
    object Animation : ScreenState()
    class Result(val item: Int) : ScreenState
}