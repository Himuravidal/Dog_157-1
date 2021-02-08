package com.example.dog_157_1.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dog_157_1.databinding.FragmentSecondBinding
import com.example.dog_157_1.ui.adapter.ImageAdapter
import com.example.dog_157_1.viewModel.DogViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private lateinit var binding : FragmentSecondBinding
    private val viewModel : DogViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ImageAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)

        viewModel.getImage().observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.update(it)
            }
        })

        adapter.selectedItem().observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it.fav) {
                    it.fav = false
                    viewModel.updateFavImages(it)
                    Toast.makeText(context, "Ya no es fav", Toast.LENGTH_LONG).show()
                } else {
                    it.fav = true
                    viewModel.updateFavImages(it)
                    Toast.makeText(context, "Añadido a fav", Toast.LENGTH_LONG).show()
                }
            }
        })
    }
}