package com.example.mvvmroom.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmroom.view.recyclerView.CatAdapter
import com.example.mvvmroom.viewModels.MainActivityViewModel
import com.example.mvvmroom.databinding.ActivityMainBinding
import com.example.mvvmroom.view.recyclerView.CatData
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainActivityViewModel by viewModel()
    private lateinit var rvAdapter: CatAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 2)
        binding.resView.layoutManager = layoutManager

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.stateFlow.collect { cats ->
                    val catDataList = cats.map { cat ->
                        CatData(
                            breed = cat.breed,
                            origin = cat.origin,
                            pattern = cat.pattern
                        )
                    }
                    rvAdapter.updateData(catDataList)
                    rvAdapter.notifyDataSetChanged()
                }
            }
        }

        rvAdapter = CatAdapter(emptyList())
        binding.resView.adapter = rvAdapter
    }

}