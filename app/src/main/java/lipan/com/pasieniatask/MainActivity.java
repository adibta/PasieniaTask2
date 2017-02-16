package lipan.com.pasieniatask;

import android.animation.ValueAnimator;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private RelativeLayout relativeLayoutSpace;
    private LoginRegisterPagerAdapter loginRegisterPagerAdapter;
    private Button buttonLogin, buttonDaftar;

    final static private int spaceMaxHeight = 450;
    final static private int spaceMinHeight = 20;
    final static private int animationTime = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        relativeLayoutSpace = (RelativeLayout) findViewById(R.id.relative_layout_space);
        loginRegisterPagerAdapter = new LoginRegisterPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(loginRegisterPagerAdapter);

        buttonLogin = (Button) findViewById(R.id.tab_masuk);
        buttonDaftar = (Button) findViewById(R.id.tab_daftar);
        buttonLogin.setSelected(true);
        buttonLogin.bringToFront();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        buttonLogin.setSelected(true);
                        buttonDaftar.setSelected(false);
                        buttonLogin.bringToFront();
                        //Toast.makeText(MainActivity.this, "login", Toast.LENGTH_SHORT).show();

                        break;
                    case 1:
                        buttonLogin.setSelected(false);
                        buttonDaftar.setSelected(true);
                        buttonDaftar.bringToFront();
                        //Toast.makeText(MainActivity.this, "daftar", Toast.LENGTH_SHORT).show();
                        break;
                }

            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!buttonLogin.isSelected()) {
                    viewPager.setCurrentItem(0);
                }
            }
        });

        buttonDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!buttonDaftar.isSelected()) {
                    viewPager.setCurrentItem(1);
                }

            }
        });

    }

/* buat animasi naik turun :p
    public void animateHeight(final View view, int from, int to, int duration) {
        ValueAnimator anim = ValueAnimator.ofInt(from, to);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                layoutParams.height = val;
                view.setLayoutParams(layoutParams);
            }
        });
        anim.setDuration(duration);
        anim.start();
    }

    private void SpaceDown(){
        if (relativeLayoutSpace.getHeight() != spaceMaxHeight) {
            animateHeight(relativeLayoutSpace, relativeLayoutSpace.getHeight(), spaceMaxHeight, animationTime);
        }
    }
    private void SpaceUp(){
        if (relativeLayoutSpace.getHeight() != spaceMinHeight) {
            animateHeight(relativeLayoutSpace, relativeLayoutSpace.getHeight(), spaceMinHeight, animationTime);
        }
    }*/
}
