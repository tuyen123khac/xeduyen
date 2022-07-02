package com.tuyenvo.xeduyen.account.viewmodels

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tuyenvo.xeduyen.utils.enums.GenderEnum
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val TAG = "AccountViewModel"
@HiltViewModel
class AccountViewModel @Inject constructor() : ViewModel(){

    var firstName = MutableLiveData<String>().apply { postValue("") }
    var lastName = MutableLiveData<String>().apply { postValue("") }
    var username = MutableLiveData<String>().apply { postValue("") }
    var password = MutableLiveData<String>().apply { postValue("") }
    var confirmPassword = MutableLiveData<String>().apply { postValue("") }
    var gender = MutableLiveData<GenderEnum>().apply { postValue(GenderEnum.FEMALE) }

    init {
        gender.postValue(GenderEnum.FEMALE)
    }

    fun onClickFemaleButton(view: View) {
        Log.e(TAG, "onClickFemaleButton: before click value ${gender.value}")
        gender.postValue(GenderEnum.FEMALE)
    }

    fun onClickMaleButton(view: View) {
        Log.e(TAG, "onClickFemaleButton: before click value ${gender.value}")
        gender.postValue(GenderEnum.MALE)
    }
}