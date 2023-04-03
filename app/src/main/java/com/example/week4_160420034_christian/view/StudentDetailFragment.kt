package com.example.week4_160420034_christian.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week4_160420034_christian.R
import com.example.week4_160420034_christian.model.Student
import com.example.week4_160420034_christian.viewmodel.DetailViewModel
import com.example.week4_160420034_christian.viewmodel.ListViewModel
import com.google.android.material.textfield.TextInputLayout

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()

        observeViewModel()
    }

    fun observeViewModel(){
        val txtId = view?.findViewById<TextView>(R.id.txtId)
        val txtName = view?.findViewById<TextView>(R.id.txtName)
        val txtBOD = view?.findViewById<TextView>(R.id.txtBOD)
        val txtPhone = view?.findViewById<TextView>(R.id.txtPhone)

        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            txtId?.setText(it.id)
            txtName?.setText(it.name)
            txtBOD?.setText(it.dob)
            txtPhone?.setText(it.phone)
        })
    }
}