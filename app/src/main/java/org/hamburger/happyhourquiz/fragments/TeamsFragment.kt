package org.hamburger.happyhourquiz.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_teams.*
import org.hamburger.happyhourquiz.R
import org.hamburger.happyhourquiz.RecyclerTeamAdapter
import org.hamburger.happyhourquiz.data.Team
import org.hamburger.happyhourquiz.viewmodels.TeamsViewModel

class TeamsFragment: Fragment(){
    companion object {
        const val TAG = "QuestionFragment"
    }

    var viewModel: TeamsViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = activity?.let { ViewModelProviders.of(it).get(TeamsViewModel::class.java) }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_teams, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RecyclerTeamAdapter(SparseArray())
        teams_recycler_view.adapter = adapter

        viewModel?.teamLiveData?.observe(this, Observer<SparseArray<Team>> {
            it?.let {
                Log.d(TAG,"live data changed. ${it.size()}")
                adapter.teams = it
                adapter.notifyDataSetChanged()
            }
        })

    }


}