package org.hamburger.happyhourquiz.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.hamburger.happyhourquiz.R
import org.hamburger.happyhourquiz.viewmodels.QuestionViewModel
import org.hamburger.happyhourquiz.viewmodels.TeamsViewModel

class QuestionFragment: Fragment(){
    companion object {
        const val TAG = "QuestionFragment"
    }
    lateinit var viewModel: QuestionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(QuestionViewModel::class.java)

        viewModel.currentQuestion
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_question, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}