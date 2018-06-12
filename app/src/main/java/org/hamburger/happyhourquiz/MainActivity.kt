package org.hamburger.happyhourquiz

import android.arch.lifecycle.ViewModelProviders
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main.*
import android.os.Handler
import android.util.Log
import android.widget.Toast
import org.hamburger.happyhourquiz.fragments.*
import org.hamburger.happyhourquiz.viewmodels.TeamsViewModel

class MainActivity : AppCompatActivity(), QrScanFragment.OnFragmentInteractionListener {
    override fun onScanComplete(data: String) {

    }

    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 3000 //3 seconds
    public var viewModel: TeamsViewModel? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().add(R.id.launch_container,LaunchFragment(),LaunchFragment.TAG).commit()
        viewModel = this.let { ViewModelProviders.of(it).get(TeamsViewModel::class.java) }

        //Initialize the Handler
        mDelayHandler = Handler()

        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
    }


    internal val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
//            supportFragmentManager.beginTransaction().remove(supportFragmentManager.findFragmentByTag(TeamsFragment.TAG)).commit()
//            supportFragmentManager.beginTransaction().add(R.id.launch_container,TeamSelectionFragment(),TeamSelectionFragment.TAG).commit()
            moveToPlayMode()
        }
    }

    fun moveToPlayMode(){
//        supportFragmentManager.beginTransaction().add(R.id.teams_container,TeamsFragment(),TeamsFragment.TAG).commit()

        requestPermissions(arrayOf(android.Manifest.permission.CAMERA),100);



        launch_container.visibility = View.GONE;
        teams_container.visibility = View.VISIBLE;
        question_container.visibility = View.VISIBLE;
        supportFragmentManager.beginTransaction().add(R.id.teams_container,TeamsFragment(),TeamsFragment.TAG).commit()
        supportFragmentManager.beginTransaction().add(R.id.question_container,QuestionFragment(),QuestionFragment.TAG).commit()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"Lets Play :)",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"we need the camera please please please :(",Toast.LENGTH_LONG).show();
        }

    }
}
