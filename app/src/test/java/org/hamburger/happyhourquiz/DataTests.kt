package org.hamburger.happyhourquiz

import android.arch.lifecycle.ViewModelProvider
import com.google.firebase.FirebaseApp
import org.hamburger.happyhourquiz.viewmodels.QuestionViewModel
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock

class DataTests{
    init {
    }
    @Test
    fun getQuestionsTest(){
        val vm = ViewModelProvider.NewInstanceFactory().create(QuestionViewModel::class.java)

        vm.init()

    }
}