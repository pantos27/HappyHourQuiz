package org.hamburger.happyhourquiz.viewmodels

import android.arch.lifecycle.ViewModel
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import org.hamburger.happyhourquiz.data.Question
import org.hamburger.happyhourquiz.data.Team

class QuestionViewModel: ViewModel(){
    companion object {
        const val TAG = "QuestionViewModel"
    }
    var currentQuestion: Question? = null

    fun init(){
        getAllQuestions()
    }

    private fun getAllQuestions() {

        FirebaseDatabase.getInstance().getReference("questions").addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Log.e(TAG,"getAllQuestions-Error: ${error.message}")
            }

            override fun onDataChange(snapshot: DataSnapshot) {

                val list = snapshot.children.map { it.getValue(Question::class.java) }
                list.forEach { println(it) }

            }
        })
    }

    override fun onCleared() {
        super.onCleared()

    }
}