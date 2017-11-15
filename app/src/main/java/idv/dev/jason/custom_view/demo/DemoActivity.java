package idv.dev.jason.custom_view.demo;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import idv.dev.jason.customer_view.FileThumbnailRecyclerView;
import idv.dev.jason.customer_view.OnFileThumbnailRecyclerViewListener;

public class DemoActivity extends AppCompatActivity implements OnFileThumbnailRecyclerViewListener {

    private FileThumbnailRecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setOnFileThumbnailRecyclerViewListener(this);

        recyclerView.add(Environment.getExternalStorageDirectory() + "/download/bg_default_image.png");
        recyclerView.add(Environment.getExternalStorageDirectory() + "/download/bg_default_image.png");
        recyclerView.add(Environment.getExternalStorageDirectory() + "/download/bg_default_image.png");
        recyclerView.add(Environment.getExternalStorageDirectory() + "/download/bg_default_image.png");
        recyclerView.add(Environment.getExternalStorageDirectory() + "/download/bg_default_image.png");
        recyclerView.add(Environment.getExternalStorageDirectory() + "/download/bg_default_image.png");
        recyclerView.add("https://image.freepik.com/free-vector/modern-technological-elements-with-transparent-background_1035-7108.jpg");
        recyclerView.add(Environment.getExternalStorageDirectory() + "/download/bg_default_image.png");
        recyclerView.add(Environment.getExternalStorageDirectory() + "/download/bg_default_image.png");
        recyclerView.add(Environment.getExternalStorageDirectory() + "/download/bg_default_image.png");
        recyclerView.add(Environment.getExternalStorageDirectory() + "/download/bg_default_image.png");
        recyclerView.add(Environment.getExternalStorageDirectory() + "/download/bg_default_image.png");
        recyclerView.add(Environment.getExternalStorageDirectory() + "/download/bg_default_image.png");
        recyclerView.add(Environment.getExternalStorageDirectory() + "/download/bg_default_image.png");
        recyclerView.add(Environment.getExternalStorageDirectory() + "/download/bg_default_image.png");
        recyclerView.add("https://image.freepik.com/free-vector/modern-technological-elements-with-transparent-background_1035-7108.jpg");
    }


    @Override
    public void onFileThumbnailItemClick(int position) {
        Log.d("TAG", "P " + position);
    }

}
