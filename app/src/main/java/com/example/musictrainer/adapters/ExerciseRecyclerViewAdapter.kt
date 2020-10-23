package com.example.musictrainer.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musictrainer.R
import com.example.musictrainer.viewHolders.ExerciseViewHolder

class ExerciseRecyclerViewAdapter(private val clickListener: ExerciseListSelectedListener): RecyclerView.Adapter<ExerciseViewHolder>() {
    private val TAG = ExerciseRecyclerViewAdapter::class.java.simpleName

    interface ExerciseListSelectedListener {
        fun exerciseSelected(exercise: String)
    }

    private val exercises = listOf("Triads")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.exercise_view, parent, false)
        return ExerciseViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        Log.d(TAG, "Placing new element in Adapter")
        holder.exerciseName.text = exercises[position]
        holder.exercisePosition.text = (position + 1).toString()
        holder.itemView.setOnClickListener {
            clickListener.exerciseSelected(exercises[position])
        }
    }

    override fun getItemCount(): Int {
        return exercises.size
    }
}