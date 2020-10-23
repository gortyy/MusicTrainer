package com.example.musictrainer.exercises

interface Exercise {
    fun getQA(): QuestionAnswer
    fun category(): String
}