package lipan.com.pasieniatask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectorActivity extends AppCompatActivity {

    Button loginRegister, slideShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
        loginRegister = (Button) findViewById(R.id.button_login_register);
        slideShow = (Button) findViewById(R.id.button_slide_show);

        loginRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectorActivity.this,LoginRegisterActivity.class);
                startActivity(intent);
            }
        });

        slideShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectorActivity.this,SlideShowActivity.class);
                startActivity(intent);
            }
        });


    }
}
