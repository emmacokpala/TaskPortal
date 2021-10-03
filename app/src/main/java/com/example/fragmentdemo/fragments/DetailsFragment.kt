package com.example.fragmentdemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.fragmentdemo.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var navCon: NavController
    private lateinit var name: String
    private lateinit var stack: String
    private lateinit var stage: String
    private lateinit var appetize: String
    private lateinit var github: String

    companion object {
        const val NAME = "name"
        const val STACK = "stack"
        const val STAGE = "stage"
        const val APPETIZE = "appetize"
        const val GITHUB = "github"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(NAME).toString()
            stack = it.getString(STACK).toString()
            stage = it.getString(STAGE).toString()
            appetize = it.getString(APPETIZE).toString()
            github = it.getString(GITHUB).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nameText.text = name
        binding.stackText.text = stack
        binding.stageText.text = stage
        binding.appetizeText.text = appetize
        binding.githubText.text = github

        val action = DetailsFragmentDirections.actionDetailsFragmentToDataFragment(this.toString())

        binding.back.setOnClickListener {
            navCon.navigate(action)
        }
    }
}