package com.dynamicdevs.rxjavadagger2.di.component

import com.dynamicdevs.rxjavadagger2.di.module.GitResultModule
import com.dynamicdevs.rxjavadagger2.model.GitRepository
import com.dynamicdevs.rxjavadagger2.model.Result
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [GitResultModule::class])
interface GitComponent {
    fun getRepository(): GitRepository
    fun inject(result: Result)
}