package com.sayan.kotlinhigherorderfunctions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //dummy data class for operations
        val dummyDataClass = DummyDataClass("dummy", 10)

        /*letFunctionWorkingExample(dummyDataClass)*/

        /*applyFunctionWorkingExample(dummyDataClass)*/

        /*alsoFunctionWorkingExample(dummyDataClass)*/

        /*runFunctionWorkingExample(dummyDataClass)*/

        withFunctionWorkingExample(dummyDataClass)

    }


    //<editor-fold desc="let sends the object as an argument & return (optional) any object">
    private fun letFunctionWorkingExample(dummyDataClass: DummyDataClass) {
        //I know this is a dumb example, but it serves the purpose of understanding 'let'
        dummyDataClass.let {
            //return another object according to a condition
            if (it.dataInt == 10) return@let "abc" else return@let "xyz"
        }.toUpperCase(Locale.ENGLISH)       //modify the returned string
            .let {
                //print the modified string
                println(it)
            }       //return is optional so do not return
    }
    //</editor-fold>

    //<editor-fold desc="apply sends the object as an argument & return the same object">
    private fun applyFunctionWorkingExample(dummyDataClass: DummyDataClass) {
        //Again, calls the specified function block with 'this' value as its receiver and
        // returns this value.
        // Think of it as you want to apply some changes to the object when you get the object
        // after the operation.
        dummyDataClass.apply {
            // here we can omit writing 'this' as we always do
            dataInt = 20    //change the object's value
        }.let {
            println("Result: ${it.dataInt}")
        }
    }
    //</editor-fold>

    //<editor-fold desc="also sends the object as an argument & return the same object">
    private fun alsoFunctionWorkingExample(dummyDataClass: DummyDataClass) {
        // Again, calls the specified function block with 'it' value as its receiver and
        // returns the same object value.
        // exactly same as apply except the 'this' & 'it' difference
        dummyDataClass.also {
            // here we get it as the object unlike apply
            it.dataInt = 20    //change the object's value
        }.let {
            println("Result: ${it.dataInt}")
        }
    }
    //</editor-fold>

    //<editor-fold desc="run sends the object as an argument 'this' & return any object">
    private fun runFunctionWorkingExample(dummyDataClass: DummyDataClass) {
        // Again, calls the specified function block with 'this' value as its receiver and
        // returns the any result object value.
        // exactly same as let except the 'this' & 'it' difference
        dummyDataClass.run {
            // here we get it as the object unlike apply
            dataInt = 20    //change the object's value
            return@run dataString
        }.let {
            println("Result: $it")
        }
    }
    //</editor-fold>


    //<editor-fold desc="run sends the object as an argument 'this' & return any object">
    private fun withFunctionWorkingExample(dummyDataClass: DummyDataClass) {
        // Syntax is different than any other related functions
        // 'this' as argument & return the last line (without use of return keyword)
        with(dummyDataClass) {
            // here we get it as the object unlike apply
            dataInt = 20    //change the object's value
            dataString
        }.let {
            println("Result: $it")
        }
    }
    //</editor-fold>
}
