package com.bobafett.instantmenu.app

sealed class MenuAction : Action {
    object LoadMenu : MenuAction()
    object LoadSuccess : MenuAction()
    object LoadFailure : MenuAction()
}