package com.carrion.edward.androidjetpacknavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import com.carrion.edward.androidjetpacknavigation.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var fragmentThirdBinding: FragmentThirdBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentThirdBinding.bind(view)
        fragmentThirdBinding = binding

        val navController = Navigation.findNavController(view)

        binding.firstFragmentButton.setOnClickListener {
            val navOptions = NavOptions.Builder().setPopUpTo(R.id.firstFragment, true).build()
            navController.navigate(R.id.action_thirdFragment_to_firstFragment, null, navOptions)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */
        @JvmStatic
        fun newInstance() = ThirdFragment()
    }
}