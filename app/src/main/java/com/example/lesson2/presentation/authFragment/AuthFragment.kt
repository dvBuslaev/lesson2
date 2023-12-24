package com.example.lesson2.presentation.authFragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.lesson2.databinding.FragmentAuthBinding
import kotlinx.coroutines.launch


class AuthFragment : Fragment() {
    var _binding: FragmentAuthBinding? = null
    val binding: FragmentAuthBinding
        get() = _binding ?: throw RuntimeException("Binding not initialized")
    private val authViewModel: AuthViewModel by lazy {
        ViewModelProvider(requireActivity())[AuthViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAuthBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListeners()
        Log.d("AuthFragment", "onViewCreated: ")
    }

    companion object {

        fun newInstance(): AuthFragment {
            AuthFragment().apply {
                arguments = Bundle().apply {
                }
            }
            return AuthFragment()
        }
    }

    private fun setClickListeners() {

        binding.enterButton.setOnClickListener {
            val username = binding.login.text.toString()
            val password= binding.password.text.toString()
            lifecycleScope.launch {
                authViewModel.checkLogin(username)
                authViewModel.checkPassword(username,password)
                Log.d("AuthFragment", "Login: $username, Password: $password")
            }



        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}