package org.hamburger.happyhourquiz

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.hamburger.happyhourquiz.fragments.QrScanFragment

class MainActivity : AppCompatActivity(), QrScanFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.main_container,QrScanFragment(),"QR").commit()
    }
}
