package org.hamburger.happyhourquiz

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.hamburger.happyhourquiz.fragments.QrScanFragment
import org.hamburger.happyhourquiz.fragments.QuestionFragment
import org.hamburger.happyhourquiz.fragments.TeamsFragment

class MainActivity : AppCompatActivity(), QrScanFragment.OnFragmentInteractionListener {
    override fun onScanComplete(data: String) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.teams_container,TeamsFragment(),TeamsFragment.TAG).commit()
        supportFragmentManager.beginTransaction().add(R.id.question_container,QuestionFragment(),QuestionFragment.TAG).commit()
    }
}
