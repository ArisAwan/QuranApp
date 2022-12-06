package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    TextView surahNo;
    EditText ayatNo;
    Button search;
    QuranText q=new QuranText();
    String ayat;
    int surahIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview=findViewById(R.id.listToView);
        surahNo=findViewById(R.id.surahNumberTextBox);
        ayatNo=(EditText) findViewById(R.id.ayatNo);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line ,q.urduSurahNames);
        listview.setAdapter(adapter);
       search=findViewById(R.id.result);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               // Toast.makeText(MainActivity.this, "Clicked"+q.urduSurahNames[position]+position, Toast.LENGTH_SHORT).show();


                surahNo.setText(q.urduSurahNames[position]);

                surahIndex=position;


                /* sending data to other Activity */



            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ayatNumber=Integer.parseInt(ayatNo.getText().toString());
                if(surahIndex>=0 && surahIndex<114)
                {

                  if(q.SSP[surahIndex]+ayatNumber<q.SSP[surahIndex+1])
                  {
                      ayatNumber=q.SSP[surahIndex]+ayatNumber-1;

                      ayat= String.valueOf(q.QuranArabicText[ayatNumber]);
                      Intent intent=new Intent(MainActivity.this,AyatShowingActivity2.class);
                      intent.putExtra("ayat",ayat);

                      startActivity(intent);
                  }
                  else
                  {
                      Toast.makeText(MainActivity.this, "please select correct surah", Toast.LENGTH_SHORT).show();
                  }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Please enter correct ayat Number", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}