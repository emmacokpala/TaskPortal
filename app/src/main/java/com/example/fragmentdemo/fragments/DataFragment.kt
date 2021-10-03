package com.example.fragmentdemo.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.fragmentdemo.R
import com.example.fragmentdemo.databinding.FragmentDataBinding

class DataFragment : Fragment() {
    private var _binding: FragmentDataBinding? = null
    private val binding get() = _binding!!
    private lateinit var navCon: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDataBinding.inflate(inflater, container, false)
        navCon = NavHostFragment.findNavController(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.submit.setOnClickListener {
            val bundle = Bundle ()
            bundle.putString("name", binding.name.editText?.text.toString())
            bundle.putString("stack", binding.stack.editText?.text.toString())
            bundle.putString("stage", binding.stage.editText?.text.toString())
            bundle.putString("appetize", binding.appetize.editText?.text.toString())
            bundle.putString("github", binding.github.editText?.text.toString())
            navCon.navigate(R.id.action_dataFragment_to_detailsFragment, bundle)
        }
    }
}