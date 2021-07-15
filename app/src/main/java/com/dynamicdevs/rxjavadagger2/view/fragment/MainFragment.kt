package com.dynamicdevs.rxjavadagger2.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.dynamicdevs.rxjavadagger2.databinding.GitDisplayFragmentBinding
import com.dynamicdevs.rxjavadagger2.model.Result
import com.dynamicdevs.rxjavadagger2.model.data.GitResponseItem
import com.dynamicdevs.rxjavadagger2.view.activity.MainActivity
import com.dynamicdevs.rxjavadagger2.view.adapter.GitAdapter
import com.dynamicdevs.rxjavadagger2.viewmodel.GitViewModel

class MainFragment: Fragment(), GitAdapter.GitDelegate {

    private val adapter = GitAdapter(this)
    private lateinit var binding: GitDisplayFragmentBinding
    private val viewModel by activityViewModels<GitViewModel>()
    private lateinit var gitSelector: GitSelector

    interface DisplayDelegate {
        fun displayGitCard(gitResponseItem: GitResponseItem)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        gitSelector = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = GitDisplayFragmentBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cardRecyclerview.adapter = adapter
        Log.d("TAG_X", "Observing in MainFragment...")
        viewModel.gitData.observe(viewLifecycleOwner, {
            adapter.repos = it
        })
        Log.d("TAG_X", "Got to the onViewCreated - MainFragment")
        adapter.notifyDataSetChanged()
    }

    override fun selectCard(gitResponseItem: GitResponseItem) {
        Log.d("TAG_X", "Engage GSelector")
        gitSelector.openDetailsFragment(gitResponseItem)
    }

}