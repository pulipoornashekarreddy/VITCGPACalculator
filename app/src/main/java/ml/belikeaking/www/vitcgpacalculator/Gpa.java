package ml.belikeaking.www.vitcgpacalculator;

import android.content.Intent;
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

public class Gpa extends Fragment {
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.gpa, container, false);

        final Button button = (Button) rootView.findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText et  = (EditText)getActivity().findViewById(R.id.editText);
                String s = et.getText().toString();

                if(TextUtils.isEmpty(s))
                {
                    Toast.makeText(getActivity(), "Please Enter number of subjects", Toast.LENGTH_SHORT).show();
                }
                else if(Integer.valueOf(s)>10)
                {
                    Toast.makeText(getActivity(), "Maximum number of Subjects is 10", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent i = new Intent(Gpa.this.getActivity(), Gpa2.class);
                    i.putExtra("s", s);
                    getActivity().startActivity(i);
                }
            }
        });
        return rootView;
    }

}
