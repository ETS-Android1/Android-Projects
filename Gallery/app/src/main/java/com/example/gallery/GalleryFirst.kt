package com.example.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_gallery_first.*
import kotlinx.android.synthetic.main.fragment_gallery_first.view.*

class GalleryFirst : Fragment() {
    xxx
    private val galleryViewModel: GalleryViewModel by activityViewModels()
    private lateinit var textInput: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery_first, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (galleryViewModel.text.value != null) {
            requireActivity().title = "Gallery of " + galleryViewModel.titleName
        }

        view?.searchButton?.setOnClickListener {
            textInput = view?.textInput?.text.toString()
            //println("input is: " + textInput)
            galleryViewModel.text.value = textInput
            //println("text_value_first is: " + galleryViewModel.text.value)
            galleryViewModel.pageNumber.value = 1
            galleryViewModel.fetchData()
            requireActivity().title = "Gallery of " + galleryViewModel.titleName
            findNavController().navigate(R.id.action_galleryFirst_to_galleryFragment)
        }
    }

}