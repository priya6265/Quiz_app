package com.example.ouizonline

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ouizonline.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var QuizModelList:MutableList<QuizModel>
    lateinit var adapter: QuizListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        QuizModelList= mutableListOf()
        getdatafromfirebase()
    }
    private fun setupRecyclerview()
    {
        adapter= QuizListAdapter(QuizModelList)
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.adapter=adapter

    }
    private fun getdatafromfirebase()
    {

       val ListQuestionModel= mutableListOf<QuestionModel>()
        ListQuestionModel.add(QuestionModel("What is Android?", mutableListOf("Language", "OS", "Product", "None"), "OS"))
        ListQuestionModel.add(QuestionModel("What does XML stand for in Android?", mutableListOf("eXtensible Markup Language", "Extra Modern Language", "Xerox Machine Language", "Xylophone Music Language"), "eXtensible Markup Language"))
        ListQuestionModel.add(QuestionModel("In Android, what is the purpose of an Intent?", mutableListOf("To design the user interface", "To perform background tasks", "To store data permanently", "To communicate between components"), "To communicate between components"))
        ListQuestionModel.add(QuestionModel("Which layout is used to organize elements in a table-like structure in Android?", mutableListOf("RelativeLayout", "FrameLayout", "GridLayout", "LinearLayout"), "GridLayout"))
        ListQuestionModel.add(QuestionModel("What is the role of the 'adb' tool in Android development?", mutableListOf("Android Debug Bridge", "Application Debugging Base", "Android Development Build", "Application Development Base"), "Android Debug Bridge"))
        ListQuestionModel.add(QuestionModel("In Android, what is ANR?", mutableListOf("Application Notification Receiver", "Application Not Responding", "Android Notification Ringtone", "Android Navigation Router"), "Application Not Responding"))
        ListQuestionModel.add(QuestionModel("Which component is responsible for managing the lifecycle of an Android activity?", mutableListOf("ActivityManager", "FragmentManager", "LifecycleManager", "IntentManager"), "ActivityManager"))
        ListQuestionModel.add(QuestionModel("What is the purpose of the 'adb logcat' command?", mutableListOf("To install Android apps", "To clear application data", "To view system logs", "To uninstall Android apps"), "To view system logs"))
        ListQuestionModel.add(QuestionModel("Which database does Android primarily use for local data storage?", mutableListOf("MySQL", "SQLite", "Firebase", "MongoDB"), "SQLite"))
        ListQuestionModel.add(QuestionModel("What is the minimum Android API level required for supporting Fragments?", mutableListOf("API level 8", "API level 11", "API level 14", "API level 21"), "API level 11"))

        val generalKnowledgeQuestions = mutableListOf<QuestionModel>()
        generalKnowledgeQuestions.add(QuestionModel("What is the capital of France?", mutableListOf("Berlin", "Paris", "London", "Madrid"), "Paris"))
        generalKnowledgeQuestions.add(QuestionModel("What is the capital of Japan?", mutableListOf("Seoul", "Beijing", "Tokyo", "Bangkok"), "Tokyo"))
        generalKnowledgeQuestions.add(QuestionModel("Which planet is known as the Red Planet?", mutableListOf("Mars", "Venus", "Jupiter", "Saturn"), "Mars"))
        generalKnowledgeQuestions.add(QuestionModel("Who wrote 'Romeo and Juliet'?", mutableListOf("Charles Dickens", "Jane Austen", "William Shakespeare", "Mark Twain"), "William Shakespeare"))
        generalKnowledgeQuestions.add(QuestionModel("In which year did the Titanic sink?", mutableListOf("1912", "1920", "1935", "1941"), "1912"))
        generalKnowledgeQuestions.add(QuestionModel("Which country is famous for its kangaroos?", mutableListOf("Argentina", "Australia", "Canada", "South Africa"), "Australia"))
        generalKnowledgeQuestions.add(QuestionModel("What is the largest ocean on Earth?", mutableListOf("Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"), "Pacific Ocean"))
        generalKnowledgeQuestions.add(QuestionModel("Who is known as the 'Father of Computer Science'?", mutableListOf("Alan Turing", "Bill Gates", "Steve Jobs", "Ada Lovelace"), "Alan Turing"))
        generalKnowledgeQuestions.add(QuestionModel("What is the currency of Brazil?", mutableListOf("Peso", "Real", "Rupiah", "Dollar"), "Real"))
        generalKnowledgeQuestions.add(QuestionModel("Which mountain is the highest in the world?", mutableListOf("Mount Kilimanjaro", "Mount Everest", "Mount McKinley", "Mount Fuji"), "Mount Everest"))

        QuizModelList.add(QuizModel("1","Android","Basics of Android","10",ListQuestionModel))
        val generalKnowledgeQuizModel = QuizModel("2", "General Knowledge", "Test your general knowledge", "15", generalKnowledgeQuestions)
        QuizModelList.add(generalKnowledgeQuizModel)


        val cppQuestions = mutableListOf<QuestionModel>()
        cppQuestions.add(QuestionModel("What does 'C++' stand for?", mutableListOf("Common Programming Language", "Compiled Plus Plus", "Class Plus Plus", "Computer Programming Language"), "Class Plus Plus"))
        cppQuestions.add(QuestionModel("Which header file is used for input and output in C++?", mutableListOf("<inputoutput.h>", "<iostream>", "<stdio.h>", "<conio.h>"), "<iostream>"))
        cppQuestions.add(QuestionModel("What is the output of 'cout << 5 / 2' in C++?", mutableListOf("2.5", "2", "2.0", "2.2"), "2"))
        cppQuestions.add(QuestionModel("What is the purpose of the 'using namespace std;' in C++?", mutableListOf("To define a new namespace", "To include the standard library", "To declare a variable", "To start a loop"), "To include the standard library"))
        cppQuestions.add(QuestionModel("What is a reference variable in C++?", mutableListOf("A variable that cannot be changed", "A variable that refers to another variable", "A variable with no data type", "A constant variable"), "A variable that refers to another variable"))
        cppQuestions.add(QuestionModel("How is memory allocated for a dynamic array in C++?", mutableListOf("Using the 'new' keyword", "Automatically by the compiler", "Using the 'malloc' function", "By declaring an array size"), "Using the 'new' keyword"))
        cppQuestions.add(QuestionModel("What is the purpose of the 'const' keyword in a member function?", mutableListOf("To make the function constant", "To declare a constant variable", "To modify class data members", "To overload the function"), "To make the function constant"))
        cppQuestions.add(QuestionModel("Which C++ feature allows a class to inherit properties and behavior from another class?", mutableListOf("Polymorphism", "Inheritance", "Encapsulation", "Abstraction"), "Inheritance"))
        cppQuestions.add(QuestionModel("What is the 'nullptr' keyword used for in C++?", mutableListOf("To declare a null variable", "To initialize a pointer to null", "To check if a variable is null", "To represent infinity"), "To initialize a pointer to null"))
        cppQuestions.add(QuestionModel("In C++, what is the purpose of the 'friend' keyword?", mutableListOf("To declare a friend function", "To declare a friend class", "To declare a function in a class", "To create a global function"), "To declare a friend function"))


        val cppQuizModel = QuizModel("3", "C++", "Test your C++ knowledge", "12", cppQuestions)

        QuizModelList.add(cppQuizModel)
        val aptitudeQuestions = mutableListOf<QuestionModel>()
        aptitudeQuestions.add(QuestionModel("If a car travels at a speed of 60 km/h, how long will it take to cover 120 kilometers?", mutableListOf("1 hour", "2 hours", "3 hours", "4 hours"), "2 hours"))
        aptitudeQuestions.add(QuestionModel("If the cost of 5 pens is $30, what is the cost of 12 pens?", mutableListOf("$60", "$72", "$80", "$90"), "$72"))
        aptitudeQuestions.add(QuestionModel("Simplify: 3 + 5 * 2 - 4 ÷ 2", mutableListOf("10", "12", "14", "16"), "12"))
        aptitudeQuestions.add(QuestionModel("A train travels 200 km in 4 hours. What is its speed?", mutableListOf("40 km/h", "50 km/h", "60 km/h", "70 km/h"), "50 km/h"))
        aptitudeQuestions.add(QuestionModel("If a shirt costs $25 and is discounted by 20%, what is the final price?", mutableListOf("$20", "$22", "$24", "$28"), "$20"))
        aptitudeQuestions.add(QuestionModel("What is the next number in the series: 2, 6, 12, 20, ...", mutableListOf("26", "30", "36", "42"), "30"))
        aptitudeQuestions.add(QuestionModel("If 2x - 5 = 11, what is the value of x?", mutableListOf("3", "4", "5", "6"), "8"))
        aptitudeQuestions.add(QuestionModel("The average of 5, 10, and 15 is:", mutableListOf("5", "10", "12", "15"), "10"))
        aptitudeQuestions.add(QuestionModel("If a triangle has angles 60°, 90°, and 30°, what type of triangle is it?", mutableListOf("Equilateral", "Isosceles", "Scalene", "Right-angled"), "Right-angled"))
        aptitudeQuestions.add(QuestionModel("A bookshelf has 5 shelves, and each shelf can hold 8 books. How many books can the bookshelf hold in total?", mutableListOf("20", "30", "40", "50"), "40"))

        val aptitudeQuizModel = QuizModel("4", "Aptitude", "Test your aptitude skills", "15", aptitudeQuestions)

        QuizModelList.add(aptitudeQuizModel)

        val databaseQuestions = mutableListOf<QuestionModel>()
        databaseQuestions.add(QuestionModel("What does SQL stand for?", mutableListOf("Structured Language", "Sequential Language", "Standard Language", "Structured Query Language"), "Structured Query Language"))
        databaseQuestions.add(QuestionModel("Which of the following is not a relational database management system (RDBMS)?", mutableListOf("MySQL", "Oracle", "MongoDB", "SQLite"), "MongoDB"))
        databaseQuestions.add(QuestionModel("In a relational database, what is a primary key?", mutableListOf("A key used for opening the database", "A unique identifier for a record", "A password for database access", "A key used for sorting records"), "A unique identifier for a record"))
        databaseQuestions.add(QuestionModel("What is the purpose of the 'SELECT' statement in SQL?", mutableListOf("To insert data into a table", "To delete data from a table", "To update existing data in a table", "To retrieve data from a table"), "To retrieve data from a table"))
        databaseQuestions.add(QuestionModel("Which SQL clause is used to filter the results of a query?", mutableListOf("FILTER", "SORT", "CONDITION", "WHERE"), "WHERE"))
        databaseQuestions.add(QuestionModel("What type of relationship is represented by a foreign key in a database?", mutableListOf("One-to-One", "One-to-Many", "Many-to-Many", "None of the above"), "One-to-Many"))
        databaseQuestions.add(QuestionModel("What is normalization in the context of databases?", mutableListOf("Adding redundancy to data", "Organizing data to minimize redundancy", "Deleting data from a table", "Combining multiple tables into one"), "Organizing data to minimize redundancy"))
        databaseQuestions.add(QuestionModel("Which SQL command is used to update data in a table?", mutableListOf("UPDATE", "MODIFY", "ALTER", "CHANGE"), "UPDATE"))
        databaseQuestions.add(QuestionModel("In a database, what is an index?", mutableListOf("A table of contents", "A data type", "A unique identifier", "A data structure to improve query performance"), "A data structure to improve query performance"))
        databaseQuestions.add(QuestionModel("What is the purpose of the 'JOIN' clause in SQL?", mutableListOf("To combine rows from two or more tables", "To delete rows from a table", "To create a new table", "To rename a table"), "To combine rows from two or more tables"))

        val databaseQuizModel = QuizModel("5", "Database", "Test your database knowledge", "20", databaseQuestions)

        QuizModelList.add(databaseQuizModel)


        setupRecyclerview()

    }
}