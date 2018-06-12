package org.hamburger.happyhourquiz.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_question.*
import org.hamburger.happyhourquiz.R
import org.hamburger.happyhourquiz.viewmodels.QuestionViewModel

class QuestionFragment: Fragment(){
    companion object {
        const val TAG = "QuestionFragment"
    }
     var viewModel: QuestionViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            viewModel = activity?.let { ViewModelProviders.of(it).get(QuestionViewModel::class.java) }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_question, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel?.currentQuestion?.observe(this, Observer {
            it?.let {
                question_fragment_question.text = it.question
            }
        })

        question_fragment_scan_button.setOnClickListener {
            childFragmentManager.beginTransaction().add(R.id.fragment_question,QrScanFragment(),QrScanFragment.TAG)
        }

    }
}