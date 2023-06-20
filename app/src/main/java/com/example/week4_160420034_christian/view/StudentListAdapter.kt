package com.example.week4_160420034_christian.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.week4_160420034_christian.R
import com.example.week4_160420034_christian.databinding.StudentListItemBinding
import com.example.week4_160420034_christian.model.Student
import com.example.week4_160420034_christian.util.loadImage

class StudentListAdapter (val studentList:ArrayList<Student>):
    RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(),
    ButtonDetailClickListener{
    class StudentViewHolder(var view:StudentListItemBinding):RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<StudentListItemBinding>(inflater,
            R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.student = studentList[position]
        holder.view.listener = this
        /*val txtId = holder.view.findViewById<TextView>(R.id.txtId)
        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)
        holder.view.findViewById<TextView>(R.id.txtId).text = studentList[position].id
        holder.view.findViewById<TextView>(R.id.txtName).text = studentList[position].name
        holder.view.findViewById<Button>(R.id.btnDetail).setOnClickListener {
            val id = txtId.text.toString()
            val action = StudentListFragmentDirections.actionStudentDetail(id)
            Navigation.findNavController(it).navigate(action)
        }

        var imageView = holder.view.findViewById<ImageView>(R.id.imageView)
        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
        imageView.loadImage(studentList[position].photoUrl, progressBar)*/
    }

    fun updateStudentList(newStudentList:ArrayList<Student>){
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onButtonDetailClick(v: View) {
        val action = StudentListFragmentDirections.actionStudentDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }

}