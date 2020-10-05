package com.example.model.entity

import com.google.gson.annotations.SerializedName

class JokesList(@SerializedName("value") val list: List<Joke>)


