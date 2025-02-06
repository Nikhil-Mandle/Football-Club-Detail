package com.nikhilproject.presentation.navigation


sealed class Navigation(val destination: String) {
    data object Home : Navigation("main")
}
