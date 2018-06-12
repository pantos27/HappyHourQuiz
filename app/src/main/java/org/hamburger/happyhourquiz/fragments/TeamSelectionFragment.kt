package org.hamburger.happyhourquiz.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_select_team.*
import org.hamburger.happyhourquiz.R
import org.hamburger.happyhourquiz.viewmodels.TeamsViewModel


class TeamSelectionFragment : Fragment() {
    companion object {
        const val TAG = "TeamSelectionFragment"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_select_team, container, false)




        return view;
    }
}