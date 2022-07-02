package com.tuyenvo.xeduyen.data.remote

import retrofit2.http.Field
import retrofit2.http.POST

interface XeDuyenService {
    @POST
    suspend fun createNewUser(
        @Field("firstName") firstName: String,
        @Field("lastName") lastName: String,
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("gender") gender: String
    )
}