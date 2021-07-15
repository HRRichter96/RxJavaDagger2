package com.dynamicdevs.rxjavadagger2.model

import android.os.Parcelable
import com.dynamicdevs.rxjavadagger2.model.data.GitResponseItem
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import javax.inject.Inject


@Parcelize
class Result @Inject constructor(
    private val gitResponseItem: @RawValue GitResponseItem
): Parcelable