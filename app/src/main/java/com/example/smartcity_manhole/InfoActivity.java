package com.example.smartcity_manhole;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    Intent intent;
    Button ok, cancel;
    int sw;
    TextView[] textViews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        intent = getIntent();
        sw = intent.getExtras().getInt("number");
        ok = (Button)findViewById(R.id.getModelButton);
        cancel = (Button)findViewById(R.id.cancelButton);
        textViews = new TextView[6];

        textViews[0] = (TextView)findViewById(R.id.info0);
        textViews[1] = (TextView)findViewById(R.id.info1);
        textViews[2] = (TextView)findViewById(R.id.info2);
        textViews[3] = (TextView)findViewById(R.id.info3);
        textViews[4] = (TextView)findViewById(R.id.info4);
        textViews[5] = (TextView)findViewById(R.id.info5);

        if( sw > 0 ){
            textViews[0].setText(sw +"번 맨홀");
        } else
            textViews[0].setText("실험 맨홀");

        textViews[1].setText("2017");

        if ( sw == 0 || sw == 3 || sw == 6 || sw == 9){
            textViews[2].setText("PVCDS");
            textViews[3].setText("200");
        } else {
            textViews[2].setText("HP");
            textViews[3].setText("450");
        }
        if (sw==5)
            textViews[3].setText("430");

        setInfo4();
        setInfo5();

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null;
                //intent = getPackageManager().getLaunchIntentForPackage("org.andresoviedo.dddmodel2");
                try {
                    intent = new Intent(getApplicationContext(), Class.forName("org.andresoviedo.app.model3D.view.ModelActivity"));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                intent.putExtra("uri", "assets://" + getPackageName() + "/manhole/겔럭시.obj");
                intent.putExtra("immersiveMode", "true");
                startActivity(intent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



    public void setInfo4(){
        switch(sw){
            case 0:
                textViews[4].setText("55.2");
                break;
            case 1:
                textViews[4].setText("25.0");
                break;
            case 2:
                textViews[4].setText("68.0");
                break;
            case 3:
                textViews[4].setText("53.6");
                break;
            case 4:
                textViews[4].setText("25.0");
                break;
            case 5:
                textViews[4].setText("24.9");
                break;
            case 6:
                textViews[4].setText("65.0");
                break;
            case 7:
                textViews[4].setText("23.0");
                break;
            case 8:
                textViews[4].setText("23.0");
                break;
            case 9:
                textViews[4].setText("65.0");
                break;
            case 10:
                textViews[4].setText("25.8");
                break;
            default:
        }
    }

    public void setInfo5(){
        switch(sw){
            case 0:
                textViews[5].setText("1.0");
                break;
            case 1:
                textViews[5].setText("1.6");
                break;
            case 2:
                textViews[5].setText("1.1");
                break;
            case 3:
                textViews[5].setText("1.0");
                break;
            case 4:
                textViews[5].setText("1.5");
                break;
            case 5:
                textViews[5].setText("1.5");
                break;
            case 6:
                textViews[5].setText("1.1");
                break;
            case 7:
                textViews[5].setText("1.0");
                break;
            case 8:
                textViews[5].setText("1.9");
                break;
            case 9:
                textViews[5].setText("1.4");
                break;
            case 10:
                textViews[5].setText("1.7");
                break;
            default:
        }
    }
}