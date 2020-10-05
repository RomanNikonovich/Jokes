package com.example.model.entity

import com.google.gson.annotations.SerializedName

class Joke(@SerializedName("joke") val joke: String) {
}