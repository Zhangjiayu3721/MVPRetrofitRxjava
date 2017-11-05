package zjy.com.work1104;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import zjy.com.work1104.view.FourFragment;
import zjy.com.work1104.view.OneFragment;
import zjy.com.work1104.view.ThreeFragment;
import zjy.com.work1104.view.TwoFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout firstLayout;
    private LinearLayout secondLayout;
    private LinearLayout thirdLayout;
    private LinearLayout fourthLayout;
    private android.support.v4.app.FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstLayout = (LinearLayout) findViewById(R.id.first_layout);
        secondLayout = (LinearLayout) findViewById(R.id.second_layout);
        thirdLayout = (LinearLayout) findViewById(R.id.third_layout);
        fourthLayout = (LinearLayout) findViewById(R.id.fourth_layout);
        firstLayout.setOnClickListener(this);
        secondLayout.setOnClickListener(this);
        thirdLayout.setOnClickListener(this);
        fourthLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.first_layout:
                FragmentManager manager1 = getSupportFragmentManager();
                transaction = manager1.beginTransaction();
                transaction.replace(R.id.content,new OneFragment());
                transaction.commit();
                break;
            case R.id.second_layout:
                FragmentManager manager2 = getSupportFragmentManager();
                transaction = manager2.beginTransaction();
                transaction.replace(R.id.content,new TwoFragment());
                transaction.commit();
                break;
            case R.id.third_layout:
                FragmentManager manager3 = getSupportFragmentManager();
                transaction = manager3.beginTransaction();
                transaction.replace(R.id.content,new ThreeFragment());
                transaction.commit();
                break;
            case R.id.fourth_layout:
                FragmentManager manager4 = getSupportFragmentManager();
                transaction = manager4.beginTransaction();
                transaction.replace(R.id.content,new FourFragment());
                transaction.commit();
                break;
        }
    }
}
