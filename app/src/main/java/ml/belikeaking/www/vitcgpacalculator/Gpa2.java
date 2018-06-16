package ml.belikeaking.www.vitcgpacalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.content.Context;
import android.widget.Toast;


/**
 * Created by poornashekarreddy.p on 25-05-2017.
 */

public class Gpa2 extends AppCompatActivity {
    int S;
    float result;
    Context context;
    EditText c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,g1,g2,g3,g4,g5,g6,g7,g8,g9,g10;
    RelativeLayout s1,s2,s3,s4,s5,s6,s7,s8,s9,s10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gpamain);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
        String k = getIntent().getStringExtra("s");
        int lay;
        S = Integer.parseInt(k);
        s1 = (RelativeLayout)findViewById(R.id.s1);
        s2 = (RelativeLayout)findViewById(R.id.s2);
        s3 = (RelativeLayout)findViewById(R.id.s3);
        s4 = (RelativeLayout)findViewById(R.id.s4);
        s5 = (RelativeLayout)findViewById(R.id.s5);
        s6 = (RelativeLayout)findViewById(R.id.s6);
        s7 = (RelativeLayout)findViewById(R.id.s7);
        s8 = (RelativeLayout)findViewById(R.id.s8);
        s9 = (RelativeLayout)findViewById(R.id.s9);
        s10 = (RelativeLayout)findViewById(R.id.s10);
        RelativeLayout layouts[]={s1,s2,s3,s4,s5,s6,s7,s8,s9,s10};
        for(lay=0; lay<S; lay++)
        {
            layouts[lay].setVisibility(View.VISIBLE);
        }
        for(lay=S; lay<10; lay++)
        {
            layouts[lay].setVisibility(View.GONE);
        }
        c1 = (EditText)findViewById(R.id.c1);
        c2 = (EditText)findViewById(R.id.c2);
        c3 = (EditText)findViewById(R.id.c3);
        c4 = (EditText)findViewById(R.id.c4);
        c5 = (EditText)findViewById(R.id.c5);
        c6 = (EditText)findViewById(R.id.c6);
        c7 = (EditText)findViewById(R.id.c7);
        c8 = (EditText)findViewById(R.id.c8);
        c9 = (EditText)findViewById(R.id.c9);
        c10 = (EditText)findViewById(R.id.c10);
        g1 = (EditText)findViewById(R.id.g1);
        g2 = (EditText)findViewById(R.id.g2);
        g3 = (EditText)findViewById(R.id.g3);
        g4 = (EditText)findViewById(R.id.g4);
        g5 = (EditText)findViewById(R.id.g5);
        g6 = (EditText)findViewById(R.id.g6);
        g7 = (EditText)findViewById(R.id.g7);
        g8 = (EditText)findViewById(R.id.g8);
        g9 = (EditText)findViewById(R.id.g9);
        g10 = (EditText)findViewById(R.id.g10);
    }
    public void onClick(View v)
    { boolean good=true;

        int i=0;
        String[] a = {c1.getText().toString(),c2.getText().toString(),c3.getText().toString(),c4.getText().toString(),c5.getText().toString(),c6.getText().toString(),c7.getText().toString(),c8.getText().toString(),c9.getText().toString(),c10.getText().toString()};
        String[] b = {g1.getText().toString(),g2.getText().toString(),g3.getText().toString(),g4.getText().toString(),g5.getText().toString(),g6.getText().toString(),g7.getText().toString(),g8.getText().toString(),g9.getText().toString(),g10.getText().toString()};
        int gained=0,credits=0,points=0;
        boolean ok = true;
        if(ok){
            for(i=0;i<S;i++) {
                if (TextUtils.isEmpty(a[i])) {
                    Toast.makeText(Gpa2.this, "Please Enter no.of credits for subject "+(i+1), Toast.LENGTH_SHORT).show();
                    ok=false;
                } else if (TextUtils.isEmpty(b[i])) {
                    Toast.makeText(Gpa2.this, "Please Enter grades for subject "+(i+1), Toast.LENGTH_SHORT).show();
                    ok=false;
                }
            }
        }
        if(ok){
            for (i = 0; i < S; i++) {

                String temp = String.valueOf(b[i]);

                if (temp.equals("S") || temp.equals("s")) {
                    gained = Integer.parseInt(a[i]) * 10;
                }
                else if (temp.equals("A") || temp.equals("a")) {
                    gained = Integer.parseInt(a[i]) * 9;
                }
                else if (temp.equals("B") || temp.equals("b")) {
                    gained = Integer.parseInt(a[i]) * 8;
                }
                else if (temp.equals("C") || temp.equals("c")) {
                    gained = Integer.parseInt(a[i]) * 7;
                }
                else if (temp.equals("D") || temp.equals("d")) {
                    gained = Integer.parseInt(a[i]) * 6;
                }
                else if (temp.equals("E") || temp.equals("e")) {
                    gained = Integer.parseInt(a[i]) * 5;
                }
                else if (temp.equals("F") || temp.equals("N") || temp.equals("f") || temp.equals("n")) {
                    gained = Integer.parseInt(a[i]) * 0;
                }
                else
                {
                    good=false;
                    break;
                }
                points = points + gained;
                credits += Integer.parseInt(a[i]);
            }
            if(good) {
                result = (float) points / credits;
                String s = String.format("%.2f", result);
                dialog("Your GPA is:"+s,"GPA");
            }
            else{
                dialog("please enter valid grades","Error");
            }
        }
        }

    public void dialog(String temp1,String title)
    {
        new AlertDialog.Builder(this)
        .setTitle(title)
                .setMessage(temp1)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

}

