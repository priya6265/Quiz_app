package com.example.ouizonline

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.ouizonline.databinding.ActivityQuizBinding
import com.example.ouizonline.databinding.ScoreDialogBinding

class QuizActivity : AppCompatActivity(),View.OnClickListener {

    companion object{
        var QuestionModelList: List<QuestionModel> = listOf()
        var time:String=""

    }
    lateinit var binding: ActivityQuizBinding

    var CurrentQuestionIndex=0;
    var selectedanswer=""
    var score=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btn0.setOnClickListener(this@QuizActivity)
            btn1.setOnClickListener(this@QuizActivity)
            btn2.setOnClickListener(this@QuizActivity)
            btn3.setOnClickListener(this@QuizActivity)
            nextButton.setOnClickListener(this@QuizActivity)
        }
        LoadQuestions()
        startTimer()
    }

    private fun startTimer() {
        val totalTimeToMillis= time.toInt()*60*1000L
        object :CountDownTimer(totalTimeToMillis,1000){
            override fun onTick(millisUntilFinished: Long) {
                val seconds=millisUntilFinished/1000
                val minutes=seconds/60
                val remainingseconds=seconds%60
                binding.timerIndicatorTextview.text=String.format("%02d:%02d",minutes,remainingseconds)

            }

            override fun onFinish() {

            }

        }.start()
    }

    private fun LoadQuestions()
    {
        selectedanswer=""
        if(CurrentQuestionIndex == QuestionModelList.size)
        {
            finishQuiz()
            return
        }
        binding.apply {
            QuestionIndicatorTextview.text = "Question ${CurrentQuestionIndex + 1}/${QuestionModelList.size}"
            QuizQuestionProgressIndicator.progress=
                (CurrentQuestionIndex.toFloat()/ QuestionModelList.size.toFloat()*100).toInt()
            questionTextview.text = QuestionModelList[CurrentQuestionIndex].Question
            btn0.text = QuestionModelList[CurrentQuestionIndex].options[0]
            btn1.text = QuestionModelList[CurrentQuestionIndex].options[1]
            btn2.text = QuestionModelList[CurrentQuestionIndex].options[2]
            btn3.text = QuestionModelList[CurrentQuestionIndex].options[3]
        }
    }

    private fun finishQuiz() {
        val totalQuestions= QuestionModelList.size
        val percentage=((score.toFloat()/totalQuestions.toFloat())*100).toInt()
        val dialogBinding=ScoreDialogBinding.inflate(layoutInflater)
        dialogBinding.apply {
            scoreProgressIndicator.progress=percentage
            scoreProgressText.text="$percentage %"
            if(percentage>60)
            {
                scoreTitle.text="Congrats! You have passed"
                scoreTitle.setTextColor(Color.BLUE);

            }
            else
            {
                scoreTitle.text="Oops! You have failed"
                scoreTitle.setTextColor(Color.RED);
            }

            scoreSubtitle.text="$score out of $totalQuestions are corrent"
            finishBtn.setOnClickListener{
                finish()
            }

        }
        AlertDialog.Builder(this)
            .setView(dialogBinding.root)
            .setCancelable(false)
            .show()
    }

    override fun onClick(view: View?) {

        binding.apply {
            btn0.setBackgroundColor(getColor(R.color.grey))
            btn1.setBackgroundColor(getColor(R.color.grey))
            btn2.setBackgroundColor(getColor(R.color.grey))
            btn3.setBackgroundColor(getColor(R.color.grey))
        }

        val clickedbtn=view as Button
        if(clickedbtn.id==R.id.next_button)
        {
            if(selectedanswer== QuestionModelList[CurrentQuestionIndex].correct){
                score++
                Log.i("Score of Quiz:",score.toString())

            }
            CurrentQuestionIndex++
            LoadQuestions()
        }
        else
        {
            selectedanswer=clickedbtn.text.toString()
            clickedbtn.setBackgroundColor(getColor(R.color.orange))

        }

    }

}