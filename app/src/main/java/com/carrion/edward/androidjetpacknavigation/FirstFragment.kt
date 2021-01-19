package com.carrion.edward.androidjetpacknavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.carrion.edward.androidjetpacknavigation.databinding.FragmentFirstBinding
import com.carrion.edward.androidjetpacknavigation.model.User

class FirstFragment : Fragment() {

    private var fragmentFirstBinding: FragmentFirstBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentFirstBinding.bind(view)
        fragmentFirstBinding = binding

        val navController = Navigation.findNavController(view)

        binding.secondFragmentButton.setOnClickListener {
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(
                message = "My message",
                user = User("My Name")
            )
            navController.navigate(action)
        }
    }

    override fun onDestroyView() {
        fragmentFirstBinding = null
        super.onDestroyView()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */
        @JvmStatic
        fun newInstance() = FirstFragment()
    }
}