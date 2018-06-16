package ml.belikeaking.www.vitcgpacalculator;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by poornashekarreddy.p on 18-05-2017.
 */

public class Cgpa extends Fragment {
    View rootView;
    float temp1,temp2,result;
    String finalcgpa;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.cgpa, container, false);
        Button button = (Button) rootView.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText cc  = (EditText)getActivity().findViewById(R.id.cc);
                EditText cgpa  = (EditText)getActivity().findViewById(R.id.cgpa);
                EditText cd  = (EditText)getActivity().findViewById(R.id.cd);
                EditText gpa  = (EditText)getActivity().findViewById(R.id.gpa);
                String a = cc.getText().toString();
                String b = cgpa.getText().toString();
                String c = cd.getText().toString();
                String d = gpa.getText().toString();
                if(TextUtils.isEmpty(a) || TextUtils.isEmpty(b) || TextUtils.isEmpty(c) || TextUtils.isEmpty(d))
                {
                    Toast.makeText(getActivity(), "Please enter all the details", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    temp1=Integer.valueOf(a)*Float.valueOf(b);
                    temp2=Integer.valueOf(c)*Float.valueOf(d);
                    result=(temp1+temp2)/(Integer.valueOf(a)+Integer.valueOf(c));
                    finalcgpa=String.format("%.2f",result);
                    dialog("Your CGPA is:"+finalcgpa,"CGPA");
                }

            }
        });
        return rootView;
    }
    public void dialog(String temp1,String title)
    {
        new AlertDialog.Builder(getContext())
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
