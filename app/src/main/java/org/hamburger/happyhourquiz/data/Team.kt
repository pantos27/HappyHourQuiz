package org.hamburger.happyhourquiz.data

import android.content.Context

data class Team(val name: String="",val id: Int=-1,val currentQuestion: Int=-1,val lastUpdate: Long=0,
                val progress: Int=0,val questionsOrder: String=""){

    var questions: List<Int> = questionsOrder.split('|').mapNotNull { it.toIntOrNull() }
}

const val PREF = "pref"
const val PREF_key_team = "team"

fun getUserTeam(context: Context) = context.getSharedPreferences(PREF,Context.MODE_PRIVATE).getInt(PREF_key_team,-1)
fun setUserTeam(context: Context,teamId: Int) = context.getSharedPreferences(PREF,Context.MODE_PRIVATE).edit().putInt(PREF_key_team,teamId).apply()

