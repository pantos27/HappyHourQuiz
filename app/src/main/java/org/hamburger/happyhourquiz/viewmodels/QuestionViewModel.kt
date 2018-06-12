package org.hamburger.happyhourquiz.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import android.util.SparseArray
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
    val currentQuestion = MutableLiveData<Question>()

    private fun geQuestion(index: Int) {

        FirebaseDatabase.getInstance().getReference("questions").child(index.toString())
                .addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                Log.e(TAG,"getAllQuestions-Error: ${error.message}")
                currentQuestion.postValue(null)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                currentQuestion.postValue(snapshot.getValue(Question::class.java))

            }
        })
    }

}