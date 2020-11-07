package th.ac.su.test4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

import th.ac.su.test4.db.AppDatabase;
import th.ac.su.test4.model.User;
import th.ac.su.test4.util.AppExecutors;

public class AddUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        Button saveButton = findViewById(R.id.save_button);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // อ่านค่าจากช่อง first_name_edit_text, last_name_edit_text
                String firstName;
                String lastName;
                int gender;
                boolean single;

                final User user = new User(0, "xx", "yy");

                AppExecutors executors = new AppExecutors();
                executors.diskIO().execute(new Runnable() {
                    @Override
                    public void run() { // worker thread
                        AppDatabase db = AppDatabase.getInstance(AddUserActivity.this);
                        db.userDao().addUser(user);
                        finish();
                    }
                });
            }
        });
    }

}