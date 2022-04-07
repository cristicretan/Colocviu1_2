package ro.pub.cs.systems.eim.colocviu1_2;

import androidx.activity.result.ActivityResult;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.Vector;

public class Colocviu1_2SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        String allTerms = intent.getStringExtra(Intent.EXTRA_TEXT);
        String[] v = allTerms.split("+");

        int ans = 0;
        for (int i = 0; i < v.length; ++i) {
            ans += Integer.parseInt(v[i]);
        }

        Intent returnIntent = new Intent();
        returnIntent.putExtra("result", ans);
        setResult(Activity.RESULT_OK);
    }
}