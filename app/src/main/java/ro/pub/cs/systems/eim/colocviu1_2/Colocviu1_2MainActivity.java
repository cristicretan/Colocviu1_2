package ro.pub.cs.systems.eim.colocviu1_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Colocviu1_2MainActivity extends AppCompatActivity {

    private EditText nextTerm;
    private EditText allTerms;
    private Button addButton;
    private Button computeButton;
    int LAUNCH_SECOND_ACTIVITY = 1;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            switch(view.getId()) {
                case R.id.compute:
                    Intent intent = new Intent(getApplicationContext(), Colocviu1_2SecondaryActivity.class);
                    intent.putExtra(Intent.EXTRA_TEXT, allTerms.getText());
                    startActivity(intent);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == LAUNCH_SECOND_ACTIVITY) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("result");
                allTerms.setText(result);
            }
        }
    }
}