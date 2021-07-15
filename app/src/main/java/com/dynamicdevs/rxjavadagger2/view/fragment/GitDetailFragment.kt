package com.dynamicdevs.rxjavadagger2.view.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dynamicdevs.rxjavadagger2.databinding.GitDetailFragmentBinding
import com.dynamicdevs.rxjavadagger2.model.Result
import com.dynamicdevs.rxjavadagger2.model.data.GitResponseItem

class GitDetailFragment: Fragment() {
    private lateinit var binding: GitDetailFragmentBinding


    companion object{
        lateinit var gitDetailFragment: GitDetailFragment
        const val RESULT_KEY = "GIT_RESULT"
        lateinit var gitResponseItem: GitResponseItem

        fun getInstance(gitResponseItem: GitResponseItem): GitDetailFragment {
            if(!this::gitDetailFragment.isInitialized)
                gitDetailFragment = GitDetailFragment()

            return gitDetailFragment.also {
                it.arguments = Bundle().also {
                    it.putParcelable(RESULT_KEY, gitResponseItem)
                }
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = GitDetailFragmentBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.getParcelable<GitResponseItem>(RESULT_KEY)?.let {

            Glide.with(view)
                .applyDefaultRequestOptions(RequestOptions().fitCenter())
                .load(it.owner.avatar_url)
                .into(binding.profilePictureIv)
            Log.d("TAG_X", "${it.owner.avatar_url}")

            binding.accountUrlTv.text = it.owner.html_url
            binding.descriptionTv.text = it.description
            binding.repoNameTv.text = it.name
            binding.repoUrlTv.text = it.html_url
            binding.usernameTv.text = it.owner.login

        }
    }
}