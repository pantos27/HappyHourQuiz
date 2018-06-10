package org.hamburger.happyhourquiz.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import android.util.SparseArray
import com.google.firebase.database.*
import org.hamburger.happyhourquiz.data.Team

class TeamsViewModel: ViewModel(){
    companion object {
        const val TAG = "TeamsViewModel"
    }

    val teamLiveData: MutableLiveData<SparseArray<Team>> = MutableLiveData()
    val teams: SparseArray<Team> = SparseArray(3)
    lateinit var childEventListener: ChildEventListener
    val reference = FirebaseDatabase.getInstance().getReference("teams")

    init {
        getTeams()
    }

    private fun getTeams(){
        childEventListener = reference.addChildEventListener(object : ChildEventListener {
            override fun onChildMoved(snapshot: DataSnapshot, data: String?) {
                Log.d(TAG,"onChildMoved: key=${snapshot.key} value=${snapshot.value} string=$data")

            }

            override fun onChildAdded(snapshot: DataSnapshot, data: String?) {
                Log.d(TAG,"onChildChanged: key=${snapshot.key} value=${snapshot.value} string=$data")
                teams.put(snapshot.key?.toInt() ?: -1,snapshot.getValue(Team::class.java))
                teamLiveData.postValue(teams)
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
                Log.d(TAG,"onChildChanged: key=${snapshot.key} value=${snapshot.value}")
                teams.remove(snapshot.key?.toInt() ?: -1)
            }

            override fun onChildChanged(snapshot: DataSnapshot, data: String?) {
                Log.d(TAG,"onChildChanged: key=${snapshot.key} value=${snapshot.value} string=$data")
                teams.put(snapshot.key?.toInt() ?: -1,snapshot.getValue(Team::class.java))
                teamLiveData.postValue(teams)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(TAG,"onCancelled: ${error.message}")
                teamLiveData.postValue(teams)
            }

        })
    }

    override fun onCleared() {
        super.onCleared()
        reference.removeEventListener(childEventListener)
    }
}