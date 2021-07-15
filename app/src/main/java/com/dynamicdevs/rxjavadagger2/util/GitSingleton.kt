package com.dynamicdevs.rxjavadagger2.util

import com.dynamicdevs.rxjavadagger2.di.component.GitComponent

class GitSingleton {
    companion object{
        lateinit var gitComponent: GitComponent
    }
}