package org.d3if4055.belajarrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import org.d3if4055.belajarrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), RecyclerViewClickListener {

    // inisialisasi binding dan viewmodel
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: NegaraViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(NegaraViewModel::class.java)

        viewModel.data.observe({ lifecycle }, {
            val negaraAdapter = NegaraAdapter(it)
            val recyclerView = binding.rvNegara

            // set click listener
            negaraAdapter.listener = this

            recyclerView.apply {
                this.adapter = negaraAdapter
                this.layoutManager = LinearLayoutManager(this@MainActivity)
            }
        })

        viewModel.response.observe({ lifecycle }, {
            if (it.isNotEmpty()) {
                Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            }
        })

    }

    override fun onItemClicked(view: View, negara: Negara) {
        val intent = Intent(this, DetailNegaraActivity::class.java)
        intent.putExtra("negara", negara)
        startActivity(intent)
    }
}
