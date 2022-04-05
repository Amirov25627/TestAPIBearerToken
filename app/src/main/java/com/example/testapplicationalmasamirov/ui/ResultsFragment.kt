package com.example.testapplicationalmasamirov.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.testapplicationalmasamirov.R
import com.example.testapplicationalmasamirov.databinding.ResultsFragmentBinding
import com.example.testapplicationalmasamirov.network.PostsResponse
import com.example.testapplicationalmasamirov.viewmodel.ViewModel

class ResultsFragment : Fragment() {
    private lateinit var binding: ResultsFragmentBinding
    private val viewModel: ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ResultsFragmentBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //pressing Log in button
        binding.backButton.setOnClickListener {
            viewModel.resultScreen.value = false
            findNavController().navigate(R.id.action_resultsFragment_to_authorizationFragment)


        }
        val postdata = arguments?.getSerializable("details") as PostsResponse
        showDetails(postdata)


    }

    private fun showDetails(post: PostsResponse) {
        binding.idText.text = post.id
        binding.nameText.text = post.name
        binding.emailText.text = post.e_mail
        binding.phoneText.text = post.phone
        binding.positionText.text = post.position
        binding.timezoneText.text = post.timezone
    }
}