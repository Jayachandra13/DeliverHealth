package com.jc.deliverhealth.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jc.deliverhealth.model.Result
import com.jc.deliverhealth.model.StarWarsOnClickListener
import com.jc.deliverhealth.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), StarWarsOnClickListener {
    lateinit var viewModel: ListViewModel
    private val starWarsListAdapter = StarWarsListAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.jc.deliverhealth.R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)

        starWarsList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = starWarsListAdapter
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.starWars.observe(this, Observer { result ->
            loading_view.visibility = View.GONE
            starWarsList.visibility = View.VISIBLE
            starWarsListAdapter.onAddStarWarsItem(result)
            starWarsList.smoothScrollToPosition(0)
        })
    }

    override fun onStarWarsClick(results: Result) {
        var intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("results", results)
        startActivity(intent)
    }
}
