package com.redshift.jcmobile.tutorial;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.redshift.jcmobile.MainActivity;
import com.redshift.jcmobile.R;

import java.util.ArrayList;
import java.util.List;

public class WelcomeScreen extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        viewPager = findViewById(R.id.view_pager);

        WelcomeScreenAdapter welcomeScreenAdapter = new WelcomeScreenAdapter(this);
        viewPager.setAdapter(welcomeScreenAdapter);
    }

    public class WelcomeScreenAdapter extends FragmentStateAdapter {

        private List<Fragment> fragmentsList = new ArrayList<Fragment>() {{
            add(new WelcomeFragment1(viewPager));
            add(new WelcomeFragment2(viewPager));
            add(new WelcomeFragment3());
        }};

        public WelcomeScreenAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragmentsList.get(position);
        }

        @Override
        public int getItemCount() {
            return fragmentsList.size();
        }
    }
}