package com.bobafett.instantmenu.app

import com.bobafett.instantmenu.core.menu.MenuRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MenuStore(val menuRepo: MenuRepo) : Store<MenuState, MenuAction, MenuSideEffect>,
    CoroutineScope by CoroutineScope(Dispatchers.Main) {

    private val state = MutableStateFlow(MenuState(LoadingState.None))

    private val sideEffect = MutableSharedFlow<MenuSideEffect>()

    override fun observeState(): StateFlow<MenuState> = state

    override fun observeSideEffect(): Flow<MenuSideEffect> = sideEffect

    override fun dispatch(action: MenuAction) {

//        val oldState = state.value

//        val newState = when (action) {
//            MenuAction.LoadMenu -> {
//                launch { loadAllFeeds() }
//                oldState.copy(loadingState = LoadingState.Loading)
//            }
//            else -> null
//        }
    }

    private suspend fun loadAllFeeds() {
//        try {
//            val allFeeds = menuRepo.getAllFeeds(forceLoad)
//            dispatch(FeedAction.Data(allFeeds))
//        } catch (e: Exception) {
//            dispatch(FeedAction.Error(e))
//        }
    }
}