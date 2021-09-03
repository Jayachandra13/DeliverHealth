package com.jc.deliverhealth.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devtides.coroutinesretrofit.view.loadImage
import com.jc.deliverhealth.R
import com.jc.deliverhealth.model.Result
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val result = intent.getSerializableExtra("results") as Result
        imageViewDetails.loadImage(result.image)
        tvName.text = result.name
        tvBirthYear.text = result.birth_year
        tvGender.text = result.gender
        tvHeight.text = result.height
        tvMass.text = result.mass
        tvEyeColor.text = result.eye_color
        tvHairColor.text = result.hair_color
        tvSkinColor.text = result.skin_color
    }
}