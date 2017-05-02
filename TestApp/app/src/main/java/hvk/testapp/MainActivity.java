package hvk.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void changeView(View view)
    {
        Intent intent = new Intent(this, Main2Activity.class);
        EditText e = (EditText)findViewById(R.id.streamURL);
        String streamURL = e.getText().toString();
        intent.putExtra("URL", streamURL);
        startActivity(intent);
    }
}
