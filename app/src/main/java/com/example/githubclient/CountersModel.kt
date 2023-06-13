package com.example.githubclient

const val FERST = 0
const val SECOND = 1
const val THIRD = 2

class CountersModel {

    val counters = mutableListOf(0, 0, 0)

    fun getCurrent(index: Int): Int {
        return counters[index]
    }

    fun next(index: Int): Int {
        counters[index]++
        return getCurrent(index)
    }

    fun set(index: Int, value: Int) {
        counters[index] = value
    }
}