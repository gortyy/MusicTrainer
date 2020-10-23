package com.example.musictrainer.utils

import android.os.CountDownTimer
import android.widget.TextView
import kotlin.math.ceil

class TextTimer(
    private val timer: TextView,
    private val textView: TextView,
    millisInFuture: Long = 5000,
    countDownInterval: Long = 1000
) : CountDownTimer(millisInFuture, countDownInterval) {
    lateinit var text: String

    override fun onTick(millisUntilFinished: Long) {
        timer.text = ceil(millisUntilFinished / 1000.0).toInt().toString()
    }

    override fun onFinish() {
        timer.text = "0"
        textView.text = text
    }
}