package com.bobafett.instantmenu.app

import com.bobafett.instantmenu.db.MenuItem

data class MenuState(
    val loadingState: LoadingState

) : State

sealed class LoadingState {
    object None : LoadingState()
    object Loading : LoadingState()
    data class Loaded(val menu: List<MenuItem>) : LoadingState()
    data class Error(val error: Exception) : LoadingState()
}