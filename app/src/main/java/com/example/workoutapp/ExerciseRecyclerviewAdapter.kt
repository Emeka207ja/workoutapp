package com.example.workoutapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.app.NotificationCompat.getColor
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.workoutapp.databinding.ItemExerciseStatusBinding

class ExerciseRecyclerviewAdapter(private val items:ArrayList<ExerciseModel>):RecyclerView.Adapter<ExerciseRecyclerviewAdapter.ViewHolder>() {

     class ViewHolder(binding: ItemExerciseStatusBinding):RecyclerView.ViewHolder(binding.root){
        val tvItem = binding.tvItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(ItemExerciseStatusBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = items[position]
        holder.tvItem.text = model.getId().toString()

        when{
            model.getIsSelected()->{
                holder.tvItem.background = ContextCompat.getDrawable(holder.itemView.context,R.drawable.circular_border_selected)
            }
            model.getIsCompleted()->{
                holder.tvItem.background = ContextCompat.getDrawable(holder.itemView.context,R.drawable.circular_completed_border)
                holder.tvItem.setTextColor(ContextCompat.getColor(holder.itemView.context,R.color.white))
            }else->{
            holder.tvItem.background = ContextCompat.getDrawable(holder.itemView.context,R.drawable.item_circular_gray)
            }
        }

    }
    fun clearList(){
        items.clear()
    }
}