package com.redshift.jcmobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import org.jetbrains.annotations.NotNull;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        class ScreenSlidePageFragment extends Fragment {

            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                     Bundle savedInstanceState) {
                return inflater.inflate(
                        R.layout.fragment_screen_slide_page, container, false);
            }
        }
        class ScreenSlidePagerActivity extends FragmentActivity {
            /**
             * The number of pages (wizard steps) to show in this demo.
             */
            private static final int NUM_PAGES = 3;

            /**
             * The pager widget, which handles animation and allows swiping horizontally to access previous
             * and next wizard steps.
             */
            private ViewPager2 viewPager;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_screen_slide);

                // Instantiate a ViewPager2 and a PagerAdapter.
                viewPager = findViewById(R.id.welcomeScreenVP2);
                FragmentStateAdapter pagerAdapter = new ScreenSlidePagerAdapter(this);
                viewPager.setAdapter(pagerAdapter);
            }

            @Override
            public void onBackPressed() {
                if (viewPager.getCurrentItem() == 0) {
                    // If the user is currently looking at the first step, allow the system to handle the
                    // Back button. This calls finish() on this activity and pops the back stack.
                    super.onBackPressed();
                } else {
                    // Otherwise, select the previous step.
                    viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                }
            }

            /**
             * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
             * sequence.
             */
            class ScreenSlidePagerAdapter extends FragmentStateAdapter {
                public ScreenSlidePagerAdapter(FragmentActivity fa) {
                    super(fa);
                }

                @NotNull
                @Override
                public Fragment createFragment(int position) {
                    return new ScreenSlidePageFragment();
                }

                @Override
                public int getItemCount() {
                    return NUM_PAGES;
                }
            }

            @RequiresApi(21)
            class DepthPageTransformer implements ViewPager2.PageTransformer {
                private static final float MIN_SCALE = 0.75f;

                public void transformPage(View view, float position) {
                    int pageWidth = view.getWidth();

                    if (position < -1) { // [-Infinity,-1)
                        // This page is way off-screen to the left.
                        view.setAlpha(0f);

                    } else if (position <= 0) { // [-1,0]
                        // Use the default slide transition when moving to the left page
                        view.setAlpha(1f);
                        view.setTranslationX(0f);
                        view.setTranslationZ(0f);
                        view.setScaleX(1f);
                        view.setScaleY(1f);

                    } else if (position <= 1) { // (0,1]
                        // Fade the page out.
                        view.setAlpha(1 - position);

                        // Counteract the default slide transition
                        view.setTranslationX(pageWidth * -position);
                        // Move it behind the left page
                        view.setTranslationZ(-1f);

                        // Scale the page down (between MIN_SCALE and 1)
                        float scaleFactor = MIN_SCALE
                                + (1 - MIN_SCALE) * (1 - Math.abs(position));
                        view.setScaleX(scaleFactor);
                        view.setScaleY(scaleFactor);

                    } else { // (1,+Infinity]
                        // This page is way off-screen to the right.
                        view.setAlpha(0f);
                    }
                }
            }

        }


    }
}