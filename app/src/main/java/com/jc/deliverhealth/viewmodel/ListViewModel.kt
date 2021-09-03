package com.jc.deliverhealth.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.jc.deliverhealth.model.StarWarsRepository

class ListViewModel : ViewModel() {

    val starWars = StarWarsRepository().getStarWars().asLiveData()


}