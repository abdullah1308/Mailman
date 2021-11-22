package com.example.mailman


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mailman.databinding.FragmentInboxBinding

class InboxFragment : Fragment() {
    private lateinit var viewBinding : FragmentInboxBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentInboxBinding.inflate(layoutInflater)

        return viewBinding.root
    }
}