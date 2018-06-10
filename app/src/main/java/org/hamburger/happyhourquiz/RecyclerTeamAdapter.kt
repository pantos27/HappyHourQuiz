package org.hamburger.happyhourquiz

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView

import org.hamburger.happyhourquiz.data.Team

class RecyclerTeamAdapter(var teams: SparseArray<Team>): RecyclerView.Adapter<RecyclerTeamAdapter.TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.team_row,parent,false)
        return TeamViewHolder(view)
    }

    override fun getItemCount() = teams.size()

    override fun onBindViewHolder(holder:TeamViewHolder, position: Int) {
        holder.bindData(teams.valueAt(position))
    }


    class TeamViewHolder(view: View) :RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.team_row_title)
        private val progressBar: ProgressBar = view.findViewById(R.id.team_row_progress)

        fun bindData(team: Team){
            Log.d("TeamViewHolder","bindData $team")
            title.text = team.name
            progressBar.max = team.questions.size
            progressBar.progress = team.progress
        }
    }
}