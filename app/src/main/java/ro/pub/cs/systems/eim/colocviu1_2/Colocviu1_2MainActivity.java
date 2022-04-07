package ro.pub.cs.systems.eim.colocviu1_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Colocviu1_2MainActivity extends AppCompatActivity {

    private EditText nextTerm;
    private EditText allTerms;
    private Button addButton;
    private Button computeButton;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            switch(view.getId()) {
                case R.id.compute:
                    break;
                case R.id.add:
                    if (allTerms.getText().toString().equals("0")) {
                        allTerms.setText(nextTerm.getText());
                    } else {
                        allTerms.setText(allTerms.getText() + "+ " + nextTerm.getText());
                    }
                    break;
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextTerm = (EditText) findViewById(R.id.nextTerm);
        allTerms = (EditText) findViewById(R.id.allTerms);

        addButton = (Button)  findViewById(R.id.add);
        computeButton = (Button) findViewById(R.id.compute);

        nextTerm.setText(String.valueOf(0));
        allTerms.setText("0");

        addButton.setOnClickListener(buttonClickListener);
        computeButton.setOnClickListener(buttonClickListener);
    }
}