package com.daconceicaomurilo.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.daconceicaomurilo.myapplication.databinding.FragmentIntroBinding

class IntroFragment : Fragment(R.layout.fragment_intro) {

    private var _binding: FragmentIntroBinding? = null
    private val binding: FragmentIntroBinding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentIntroBinding.bind(view)
        prepareFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun prepareFragment() {
        prepareListeners()
    }

    private fun prepareListeners() {
        binding.btnOk.setOnClickListener {
            val nickname = binding.edtTextNickname.text.toString()
            checkNickname(nickname)
        }
    }

    private fun checkNickname(nickname: String) {
        if(nickname.isNotEmpty()) {
            goToHomeFragment()
        }
    }

    private fun goToHomeFragment() {
        findNavController().navigate(R.id.action_introFragment_to_homeFragment)
    }
}