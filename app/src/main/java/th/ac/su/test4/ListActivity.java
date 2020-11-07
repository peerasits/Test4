package th.ac.su.test4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import th.ac.su.test4.adapter.UserAdapter;
import th.ac.su.test4.db.AppDatabase;
import th.ac.su.test4.model.User;
import th.ac.su.test4.util.AppExecutors;

public class ListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    protected void onResume() {
        super.onResume();

        final AppExecutors executors = new AppExecutors();
        executors.diskIO().execute(new Runnable() {
            @Override
            public void run() {
                AppDatabase db = AppDatabase.getInstance(ListActivity.this);
                final User[] users = db.userDao().getAllUsers();

                executors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        UserAdapter adapter = new UserAdapter(ListActivity.this, users);
                        mRecyclerView.setAdapter(adapter);
                    }
                });


            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this));
    }
}