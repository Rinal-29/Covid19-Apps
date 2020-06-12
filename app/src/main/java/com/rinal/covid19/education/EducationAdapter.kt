package com.rinal.covid19.education

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.rinal.covid19.network.EducationProperties
import com.rinal.covid19.databinding.ListItemBinding


class EducationAdapter(private val onCLickListener: OnCLickListener):
    ListAdapter<EducationProperties, EducationAdapter.EducationAdapterViewHolder>(DiffCallback){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) = EducationAdapterViewHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(
        holder: EducationAdapterViewHolder,
        position: Int
    ) {
        val educationProperties = getItem(position)
        holder.itemView.setOnClickListener {
            onCLickListener.onClick(educationProperties)
        }
        holder.bind(educationProperties)
    }

    class EducationAdapterViewHolder(private var binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(educationProperties: EducationProperties?) {
            binding.title.text = educationProperties?.title
            if (educationProperties != null) {
                binding.imgEducation.setImageResource(educationProperties.imgEducation)
            }
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<EducationProperties>(){
        override fun areItemsTheSame(
            oldItem: EducationProperties,
            newItem: EducationProperties
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: EducationProperties,
            newItem: EducationProperties
        ): Boolean {
            return oldItem.title == newItem.title
        }

    }

    class OnCLickListener(val clickListener: (EducationProperties) -> Unit){
        fun onClick(educationProperties: EducationProperties) = clickListener(educationProperties)
    }
}