package edu.bzu.inclassactivity.secondinclassactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import edu.bzu.inclassactivity.secondinclassactivity.models.Book;

public class MainActivity extends AppCompatActivity {

    private Gson gson;
    private SharedPreferences sharedPreferences;
    private Button addBook;
    private Button saveData;
    private ListView myListView;
    private List<Book> myBooksList;

    private EditText bookTitle;
    private EditText author;
    private EditText pagesNo;
    private SwitchCompat mySwitchCompat;

    ArrayAdapter<Book> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        //replaced as lambada expression for better readability
        addBook.setOnClickListener(view -> addABook ());

        //replaced as lambada expression for better readability
        saveData.setOnClickListener(view -> saveBookList());

        listAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,myBooksList);
        myListView.setAdapter(listAdapter);




    }

    public void initViews() {

        addBook = findViewById(R.id.addBookID);
        saveData = findViewById(R.id.SaveData);
        mySwitchCompat = findViewById(R.id.switchCompat_ID);
        myListView = findViewById(R.id.myListViewID);
        bookTitle = findViewById(R.id.bookTitleTF_ID);
        author = findViewById(R.id.authorTF_ID);
        pagesNo = findViewById(R.id.pagesTF_ID);
        myBooksList = new ArrayList<>();
        gson = new Gson();

    }

    public void addABook () {
        if (!bookTitle.getText().toString().equals("") && !author.getText().toString().equals("") && !pagesNo.getText().toString().equals("")) {
            myBooksList.add(new Book(bookTitle.getText().toString(),
                    author.getText().toString(),
                    Integer.parseInt(pagesNo.getText().toString()),
                    mySwitchCompat.isChecked()));
            listAdapter.notifyDataSetChanged();

        } else
            Toast.makeText(this,"Please fill all the blanks",Toast.LENGTH_SHORT).show();
    }

    public void saveBookList () {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();

       String myBooksAsStringJson = gson.toJson(myBooksList);
       System.out.println("My json : " + myBooksAsStringJson);

        editor.putString("Books_Details",myBooksAsStringJson);
        editor.commit();
    }
}