package com.example.musictrainer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.musictrainer.exercises.Exercise
import com.example.musictrainer.exercises.TriadExercise
import com.example.musictrainer.utils.TextTimer
import com.google.android.material.textfield.TextInputEditText

class ExerciseActivity : AppCompatActivity() {
    private lateinit var category: TextView
    private lateinit var question: TextView
    private lateinit var answer: TextView
    private lateinit var timer: TextView

    private lateinit var start: Button
    private lateinit var stop: Button

    private lateinit var questionTime: TextInputEditText
    private lateinit var answerTime: TextInputEditText

    private lateinit var textTimer: TextTimer

    private var handler = Handler()

    private var run: Boolean = true

    private var aTime: Int = 2
    private var qTime: Int = 5

    private lateinit var exercise: Exercise

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        toolbar.setTitle("Triad")
        setSupportActionBar(toolbar)

        initViews()
        initTextWatchers()
        initButtonListeners()

        exercise = TriadExercise
        textTimer = TextTimer(timer, answer, qTime.times(1000).toLong())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = getMenuInflater()
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val message = when(item.itemId) {
            R.id.menuAbout -> "You clicked about"
            R.id.menuSettings -> "You clicked settings"
            else -> "You clicked logout"
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        return true
    }

    private fun initViews() {
        category = findViewById(R.id.category)
        question = findViewById(R.id.question)
        answer = findViewById(R.id.answer)
        timer = findViewById(R.id.timer)

        start = findViewById(R.id.start)
        stop = findViewById(R.id.stop)

        answerTime = findViewById(R.id.answer_time)
        questionTime = findViewById(R.id.question_time)

    }

    private fun initButtonListeners() {
        start.setOnClickListener {
            hideKeyboard()
            runExercise(exercise)
        }
        stop.setOnClickListener {
            hideKeyboard()
            run = false
            timer.text = ""
            textTimer.cancel()
        }
    }

    private fun hideKeyboard() {
        val inputManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        val view = currentFocus
        if (view != null) {
            inputManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun initTextWatchers() {
        answerTime.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var text = s.toString()
                aTime = when(text) {
                    "" -> aTime
                    else -> text.toInt()
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                run = false
                timer.text = ""
                textTimer.cancel()
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })

        questionTime.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                var text = s.toString()
                qTime = when(text) {
                    "" -> qTime
                    else -> s.toString().toInt()
                }
                textTimer = TextTimer(timer, answer, qTime.times(1000).toLong())
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                run = false
                timer.text = ""
                textTimer.cancel()
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
        })
    }

    private fun runExercise(exercise: Exercise) {
        run = true
        object : Runnable {
            override fun run() {
                answer.text = ""
                textTimer.cancel()
                if (!run) {
                    return
                }

                category.text = exercise.category()

                val (q, a) = exercise.getQA()
                textTimer.text = a
                question.text = q

                textTimer.start()

                handler.postDelayed(this, ((aTime + qTime) * 1000).toLong())
            }
        }.also {
            it.run()
        }
    }
}
