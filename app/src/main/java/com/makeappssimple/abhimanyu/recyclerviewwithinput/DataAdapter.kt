package com.makeappssimple.abhimanyu.recyclerviewwithinput

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

data class InputData(val label: String, var checked: Boolean)

class DataAdapter(private val inputDataList: Array<InputData>) :
    RecyclerView.Adapter<DataAdapter.InputViewHolder>() {

    inner class InputViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var checkbox = itemView.findViewById<CheckBox>(R.id.checkbox)
        fun bind(inputs: Array<InputData>, position: Int) {
            checkbox.setOnClickListener {
                inputs[position].checked = !inputs[position].checked
            }
            checkbox.text = inputs[position].label
            checkbox.isChecked = inputs[position].checked
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InputViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return InputViewHolder(view)
    }

    override fun onBindViewHolder(holder: InputViewHolder, position: Int) {
        holder.bind(inputDataList, position)
    }

    override fun getItemCount(): Int = inputDataList.size
}