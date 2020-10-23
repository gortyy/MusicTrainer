package com.example.musictrainer.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.musictrainer.R

class ExerciseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val exercisePosition = itemView.findViewById<TextView>(R.id.exercise_position)
    val exerciseName = itemView.findViewById<TextView>(R.id.exercise_name)
}