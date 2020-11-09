package com.samir.networklogger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.samir.nlogger.NLog;
import com.samir.nlogger.NLogger;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView text;
    private Button toggle, print_log, get_al_logs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.text);
        toggle = findViewById(R.id.toggle);
        get_al_logs = findViewById(R.id.get_al_logs);
        print_log = findViewById(R.id.print_log);
        text.setText(""+ NLogger.isNLogeEnable());

        setButtonState();

        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(NLogger.isNLogeEnable()){ NLogger.enable(false); }
                else{ NLogger.enable(true); }
                setButtonState();
            }
        });

        print_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i =0 ; i < 2000 ; i++){
                    NLog.d(TAG , "Some log goes here accordingly");
                }
            }
        });


        get_al_logs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, ""+NLogger.getAllLogs().size(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void setButtonState(){
        if(NLogger.isNLogeEnable()){
            toggle.setText("Disable Log");
        }else{
            toggle.setText("Enable Log");
        }
    }
}