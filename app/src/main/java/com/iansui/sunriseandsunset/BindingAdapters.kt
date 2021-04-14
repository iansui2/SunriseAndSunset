package com.iansui.sunriseandsunset

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

/**
 * Updates the date format of sunrise, sunset and solar noon time
 */
@BindingAdapter("normalTimeFormat")
fun changeNormalTimeFormat(textView: TextView, time: String?) {
    time?.let {
        val parser = SimpleDateFormat("hh:mm:ss a", Locale.getDefault())
        val newTimeFormat = SimpleDateFormat("h:mm a", Locale.getDefault())
        val newTime = newTimeFormat.format(parser.parse(time))
        textView.text = newTime
    }
}

/**
 * Updates the date format of day length
 */
@BindingAdapter("specialTimeFormat")
fun changeSpecialTimeFormat(textView: TextView, time: String?) {
    time?.let {
        val parser = SimpleDateFormat("hh:mm:ss", Locale.getDefault())
        val newTimeFormat = SimpleDateFormat("h 'hours' mm 'minutes'", Locale.getDefault())
        val newTime = newTimeFormat.format(parser.parse(time))
        textView.text = newTime
    }
}









