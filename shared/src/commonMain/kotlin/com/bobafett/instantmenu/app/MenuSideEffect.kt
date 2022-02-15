package com.bobafett.instantmenu.app

sealed class MenuSideEffect : Effect {
    data class Error(val error: Exception) : MenuSideEffect()
}