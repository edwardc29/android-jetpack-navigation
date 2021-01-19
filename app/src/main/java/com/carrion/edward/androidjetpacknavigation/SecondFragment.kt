package com.carrion.edward.androidjetpacknavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.carrion.edward.androidjetpacknavigation.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private var fragmentSecondBinding: FragmentSecondBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentSecondBinding.bind(view)
        fragmentSecondBinding = binding

        arguments?.let {
            val args = SecondFragmentArgs.fromBundle(it)
            val message = args.message
            val user = args.user

            binding.messageTextView.text = message.plus(" ").plus(user?.name)
        }

        val navController = Navigation.findNavController(view)

        binding.thirdFragmentButton.setOnClickListener {
            navController.navigate(R.id.action_secondFragment_to_thirdFragment)
        }
    }

    override fun onDestroyView() {
        fragmentSecondBinding = null
        super.onDestroyView()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */
        @JvmStatic
        fun newInstance() = SecondFragment()
    }
}