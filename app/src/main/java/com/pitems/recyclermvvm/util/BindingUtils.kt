package com.pitems.recyclermvvm.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

//value should not contain an empty space
@BindingAdapter("image")
fun loadImage(view:ImageView,url:String){
    Glide.with(view).load(url).into(view)
}