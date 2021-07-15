package com.dynamicdevs.rxjavadagger2.view.fragment

import com.dynamicdevs.rxjavadagger2.model.Result
import com.dynamicdevs.rxjavadagger2.model.data.GitResponseItem

interface GitSelector {
    fun openDetailsFragment(gitResponseItem: GitResponseItem)
}