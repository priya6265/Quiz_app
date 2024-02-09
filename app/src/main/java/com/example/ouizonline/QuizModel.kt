package com.example.ouizonline

import android.icu.text.CaseMap.Title

data class QuizModel(
    val id: String,
    val title: String,
    val subtitle: String,
    val time: String,
    val QuestionList:List<QuestionModel>
) {
    constructor() : this("", "", "", "", emptyList())
}
data class QuestionModel(
    val Question:String,
    val options:List<String>,
    val correct:String,
){
    constructor():this("", emptyList(),"")
}