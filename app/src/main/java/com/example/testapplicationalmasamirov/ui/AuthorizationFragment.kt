package com.example.testapplicationalmasamirov.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.testapplicationalmasamirov.R

import com.example.testapplicationalmasamirov.databinding.AuthorizationFragmentBinding
import com.example.testapplicationalmasamirov.network.*
import com.example.testapplicationalmasamirov.viewmodel.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Collections.list

class AuthorizationFragment : Fragment() {
    private lateinit var binding: AuthorizationFragmentBinding
    private val viewModel: ViewModel by activityViewModels()
    lateinit var tokenManager: TokenManager
    lateinit var apiClient: ApiClient


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AuthorizationFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //pressing Log in button
        binding.enterButton.setOnClickListener {
            val email = binding.emailText.text.toString()
            val password = binding.passwordText.text.toString()
            viewModel.entering(email, password)
        }


        viewModel.emptyText.observe(viewLifecycleOwner, Observer {
            if (it) {
                Toast.makeText(context, "Don't forget enter e-mail or password", Toast.LENGTH_SHORT)
                    .show()
            }
        })

        viewModel.mailIncorrect.observe(viewLifecycleOwner, Observer {
            if (it) {
                Toast.makeText(context, "Enter correct e-mail", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.resultScreen.observe(viewLifecycleOwner, Observer {
            if (it) {
                start()

            }
        })
    }

    private fun start() {
        apiClient = ApiClient()
        tokenManager = TokenManager(requireContext())

        apiClient.getApiService().login(
            Login(
                email = binding.emailText.text.toString(),
                password = binding.passwordText.text.toString()
            )
        )
            .enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    // Error logging in
                    Log.d("LOGIN ERR", "Failure")
                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    val loginResponse = response.body()

                    if (loginResponse?.authToken != null) {
                        tokenManager.saveAuthToken(loginResponse.authToken)


                        profile()
                    } else {

                        Toast.makeText(context, "Incorrect e-mail or password", Toast.LENGTH_SHORT)
                            .show()

                    }
                }
            })
    }

    private fun profile() {

        apiClient.getApiService().fetchProfile(token = "Bearer ${tokenManager.fetchAuthToken()}")
            .enqueue(object : Callback<PostsResponse> {
                override fun onFailure(call: Call<PostsResponse>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<PostsResponse>, response: Response<PostsResponse>
                ) {
                    viewModel.postData
                    findNavController().navigate(
                        R.id.action_authorizationFragment_to_resultsFragment,
                        bundleOf("details" to response.body())
                    )


                }
            })
    }


}