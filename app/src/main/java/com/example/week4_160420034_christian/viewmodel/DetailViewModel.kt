package com.example.week4_160420034_christian.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.week4_160420034_christian.model.Student

class DetailViewModel:ViewModel() {
    val studentLD = MutableLiveData<Student>()

    fun fetch(){
        val student1 = Student("16055", "Nonie", "1999/03/28",
            "5718444778", "http://dummyimage.com/75x100.jpg/cc0000/ffffff")

        studentLD.value = student1
    }
}