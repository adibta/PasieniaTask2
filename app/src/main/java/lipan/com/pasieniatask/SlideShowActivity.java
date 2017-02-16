package lipan.com.pasieniatask;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class SlideShowActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TextView skipTextView, nextTextView;
    private LinearLayout linearLayoutDotsHolder;
    private ImageView[] dots;

    private ArrayList<String> heading, content;
    private ArrayList<Integer> imgResource;
    private SlideShowPagerAdapter slideShowPagerAdapter;
    private int pageSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_show);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        skipTextView = (TextView) findViewById(R.id.text_skip);
        nextTextView = (TextView) findViewById(R.id.text_next);

        imgResource = new ArrayList<>();
        heading = new ArrayList<>();
        content = new ArrayList<>();

        PrepareData();

        linearLayoutDotsHolder = (LinearLayout) findViewById(R.id.linear_layout_dots_holder);

        CreateDots();

        slideShowPagerAdapter = new SlideShowPagerAdapter(getSupportFragmentManager(), imgResource, heading, content, pageSize);
        viewPager.setAdapter(slideShowPagerAdapter);

        skipTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SlideShowActivity.this,LoginRegisterActivity.class);
                startActivity(intent);
            }
        });
        nextTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewPager.getCurrentItem()!=pageSize-1) {
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                }
                else {
                    Intent intent = new Intent(SlideShowActivity.this,LoginRegisterActivity.class);
                    startActivity(intent);
                }
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == pageSize-1) {
                    nextTextView.setText("Mulai");
                }
                else
                    nextTextView.setText("Berikutnya");

                for (int i = 0; i < pageSize; i++){
                    dots[i].setImageResource(R.drawable.non_selected_item_dot);
                }
                dots[position].setImageResource(R.drawable.selected_item_dot);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void PrepareData(){  //Add content here

        imgResource.add(R.drawable.icon_productive1);
        heading.add("Prepare Your Idea");
        content.add("Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.");

        imgResource.add(R.drawable.icon_productive2);
        heading.add("Get Work Out");
        content.add("A small river named Duden flows by their place and supplies it with the necessary regelialia.");

        imgResource.add(R.drawable.icon_productive3);
        heading.add("Improve Your Performance");
        content.add(" It is a paradisematic country, in which roasted parts of sentences fly into your mouth.");

        pageSize = imgResource.size();
    }

    private void CreateDots()
    {
        dots = new ImageView[pageSize];
        for (int i = 0; i < pageSize ; i++){
            dots[i] = new ImageView(SlideShowActivity.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(5, 0, 5, 0);
            dots[i].setImageResource(R.drawable.non_selected_item_dot);
            linearLayoutDotsHolder.addView(dots[i],params);
        }
        dots[0].setImageResource(R.drawable.selected_item_dot);

    }
}
