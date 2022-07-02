package com.tuyenvo.xeduyen.account.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.tuyenvo.xeduyen.R
import com.tuyenvo.xeduyen.databinding.ActivityOnBoardingBinding
import com.tuyenvo.xeduyen.utils.Constant
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AccountActivity : AppCompatActivity() {
    var navigateController : NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        navigateController =
            supportFragmentManager.findFragmentById(R.id.account_nav_host_fragment)
                ?.findNavController()
        intent.getStringExtra(Constant.ACCOUNT_ACTION_TYPE).apply {
            when (this) {
                Constant.SIGN_UP -> navigateController?.navigate(R.id.signUpFragment)
                else -> navigateController?.navigate(R.id.signInFragment)
            }
        }
    }
}