package com.example.navigation24

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    var number =0
    fun innCount(){
        number++
    }
}