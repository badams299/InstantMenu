package com.bobafett.instantmenu

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}