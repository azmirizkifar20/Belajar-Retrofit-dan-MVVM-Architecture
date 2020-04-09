package org.d3if4055.belajarrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import org.d3if4055.belajarrecyclerview.databinding.ActivityDetailNegaraBinding

class DetailNegaraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailNegaraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_detail_negara)

        // ambil data yang dikirimkan oleh MainActivity
        val negara = intent.getParcelableExtra<Negara>("negara")

        if (negara != null) {
            binding.tvNamaNegara.text = negara.namaNegara
            binding.tvIbuKota.text = negara.ibuKota
            binding.tvMataUang.text = negara.mataUang
            binding.tvJumlahPenduduk.text = negara.jumlahPenduduk

            // set resource image
            Glide.with(this)
                .load(negara.gambar)
                .placeholder(R.drawable.ic_launcher_foreground)
                .dontAnimate()
                .into(binding.imageNegara)
        }

    }
}
