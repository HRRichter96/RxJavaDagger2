package com.dynamicdevs.rxjavadagger2

import android.app.Application
import com.dynamicdevs.rxjavadagger2.di.component.DaggerGitComponent
import com.dynamicdevs.rxjavadagger2.util.GitSingleton

class GitApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        GitSingleton.gitComponent = DaggerGitComponent.create()
    }
}