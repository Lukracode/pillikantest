package com.example.pillikantest.screens

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.pillikantest.databinding.FragmentAuthBinding
import com.example.pillikantest.repository.Repository
import retrofit2.Response


class AuthFragment : Fragment() {
    lateinit var binding: FragmentAuthBinding
    private lateinit var viewModel : AuthViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAuthBinding.inflate(inflater, container, false)
//        val authViewModel = AuthViewModel()
//        authViewModel.formatNumber(binding.phoneNumber)

        val repository = Repository()
        val viewModelFactory = AuthViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AuthViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(viewLifecycleOwner, Observer { response ->

            if (response.isSuccessful) {
                Log.d("Response", response.body()?.iin.toString())
                Log.d("Response", response.body()?.password.toString())
            } else  {
                Log.d("Response", response.errorBody().toString())
            }

        })

        return binding.root

    }




    companion object {
        @JvmStatic
        fun newInstance() = AuthFragment()
                }
            }
