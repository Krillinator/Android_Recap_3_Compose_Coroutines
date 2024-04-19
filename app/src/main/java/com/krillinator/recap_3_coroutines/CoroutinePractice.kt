package com.krillinator.recap_3_coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Singleton
object CoroutinePractice {

    fun testONE() = runBlocking {// Block?

        launch {
            delay(5000)                 // NON BLOCKING
            println("Test One - After Delay")
        }

        println("Test One - Outside of launch scope")
    }

    // Sequentially executes doWorld followed by "Done"
    fun main() = runBlocking {
        doWorld()
        println("Done")
    }

    // Concurrently executes both sections
    private suspend fun doWorld() = coroutineScope { // this: CoroutineScope
        launch {
            delay(2000L)
            println("World 2")
        }
        launch {
            delay(1000L)
            println("World 1")
        }

        delay(2000)
        println("Hello")
    }

     suspend fun jobTest() = coroutineScope {

        val job = launch { // launch a new coroutine and keep a reference to its Job
            delay(5000L)
            println("World!")
        }

        println("Hello")
        job.join() // wait until child coroutine completes
        println("Done")
    }


}