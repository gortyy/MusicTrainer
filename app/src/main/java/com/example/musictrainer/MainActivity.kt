package com.example.musictrainer

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musictrainer.adapters.ExerciseRecyclerViewAdapter

class MainActivity : AppCompatActivity(), ExerciseRecyclerViewAdapter.ExerciseListSelectedListener {
    private val TAG = MainActivity::class.java.simpleName

    private lateinit var exercisesRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        exercisesRecyclerView = findViewById(R.id.exercise_list)
        exercisesRecyclerView.adapter = ExerciseRecyclerViewAdapter(this)
        exercisesRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun exerciseSelected(exercise: String) {
        Log.d(TAG, "exerciseSelected clicked")
        val exerciseSelectedIntent = Intent(this, ExerciseActivity::class.java)
        startActivity(exerciseSelectedIntent)
    }
}