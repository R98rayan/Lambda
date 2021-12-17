package com.example.lambda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        data class HighScore(val name: String, val score: Int)
        fun main(){
            // Lambda
            val greeting = { println("Hello") }
            greeting()
            // Function
            fun greetingFun(){
                println("Hello")
            }
            greetingFun()
            // Lambda
            val personalGreeting = { name:String -> println("Hello $name") }
            personalGreeting("Sam")
            // Function
            fun personalGreetingFun(name: String){
                println("Hello $name")
            }
            personalGreetingFun("Sam")

            // Lambda
            val returnSum = { a: Int, b: Int -> a + b }
            println(returnSum(4, 5))

            // Function
            fun returnSumFun(a: Int, b: Int): Int{
                return a + b
            }
            println(returnSumFun(4, 5))
            val highScores = listOf(
                HighScore("Bob", 5000),
                HighScore("Sara", 300),
                HighScore("Jane", 7200),
                HighScore("adfasfds", 900),
                HighScore("Fred", 2300)
            )
            // Lambda
            val highestScore = highScores.maxByOrNull { it.score }  // it replaces highScores -> highScores.score
            println("${highestScore!!.name} wins!")
            // Function
            fun highestScoreFun(): HighScore{
                var hs = 0
                var winner = highScores[0]
                for(i in highScores){
                    if(i.score > hs){
                        hs = i.score
                        winner = i
                    }
                }
                return winner
            }
            println("${highestScoreFun().name} wins!")
        }
    }
}