package com.example.pillikantest.screens

import android.telephony.PhoneNumberFormattingTextWatcher
import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pillikantest.model.Post
import com.example.pillikantest.repository.Repository
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch
import retrofit2.Response

class AuthViewModel(private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()

    fun getPost() {

        viewModelScope.launch {
            val response = repository.getPost()
            myResponse.value = response
        }

    }


    val disposable = CompositeDisposable()



    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }



    fun formatNumber(num: EditText) {
        val inputField = num as EditText
        inputField.addTextChangedListener(PhoneNumberFormattingTextWatcher())
    }

}