package com.tuyenvo.xeduyen.di.modules

import android.app.Activity
import android.content.Context
import com.tuyenvo.xeduyen.R
import com.tuyenvo.xeduyen.onboarding.models.SliderItem
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ActivityContext

@Module
@InstallIn(ActivityComponent::class)
object OnBoardingModule {

    @Provides
    fun provideDummyList(@ActivityContext context: Context) : List<SliderItem> {
        return listOf(
            SliderItem(
                "https://images.unsplash.com/flagged/photo-1570700005880-4ecdb8595d4a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8YmVhY2glMjBnaXJsfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                context.getString(R.string.algorithm),
                context.getString(R.string.users_going_through_a_vetting_process)
            ),
            SliderItem(
                "https://images.unsplash.com/photo-1542295669297-4d352b042bca?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8c21pbGUlMjBnaXJsfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                context.getString(R.string.matches),
                context.getString(R.string.we_match_you_with_people)
            ),
            SliderItem(
                "https://images.unsplash.com/photo-1617059070087-d05ea39977dd?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NjR8fGJlYWNoJTIwZ2lybHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                context.getString(R.string.premium), context.getString(R.string.sign_up_today_and_enjoy)
            )
        )
    }
}