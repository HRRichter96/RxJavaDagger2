package com.dynamicdevs.rxjavadagger2.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.dynamicdevs.rxjavadagger2.R
import com.dynamicdevs.rxjavadagger2.databinding.GitDisplayFragmentBinding
import com.dynamicdevs.rxjavadagger2.model.Result
import com.dynamicdevs.rxjavadagger2.model.data.GitResponseItem
import com.dynamicdevs.rxjavadagger2.view.fragment.GitDetailFragment
import com.dynamicdevs.rxjavadagger2.view.fragment.GitSelector
import com.dynamicdevs.rxjavadagger2.view.fragment.MainFragment
import com.dynamicdevs.rxjavadagger2.viewmodel.GitViewModel

class MainActivity : AppCompatActivity(), MainFragment.DisplayDelegate,GitSelector {

    private val viewModel: GitViewModel by viewModels()

    private lateinit var mainFragment: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainFragment =supportFragmentManager.findFragmentById(R.id.main_fragment) as MainFragment



    }

    override fun displayGitCard(gitResponseItem: GitResponseItem) {
        TODO("Not yet implemented")
    }

    override fun openDetailsFragment(gitResponseItem: GitResponseItem) {
        val fragment = GitDetailFragment.getInstance(gitResponseItem)
        Log.d("TAG_X", "odf")

        fragment.arguments.let {
            it?.putParcelable("GIT_RESULT", gitResponseItem)
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.detail_frame,fragment)
            .addToBackStack(fragment.tag)
            .commit()
    }
}