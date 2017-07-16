package chatapp.namita.com.homepage;

import android.content.Context;
import android.support.design.widget.TabLayout;

import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    private ViewPager intro_images;
    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;
    private ViewPagerAdapter mAdapter;
    private int[] mImageResources = {
            R.drawable.album1,
            R.drawable.album2,
            R.drawable.album3,
            R.drawable.album5,
            R.drawable.album6
    };
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.mipmap.image,
            R.mipmap.video,
            R.mipmap.milestone
    };

    private int[] selectedtabIcons = {
            R.mipmap.select_image,
            R.mipmap.select_video,
            R.mipmap.select_milestone
    };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setReference();

        viewPager = (ViewPager) findViewById(R.id.pager);
        setupViewPager(viewPager);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Home");
       // getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setLogo(getResources().getDrawable(R.drawable.menu));
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);




        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("Images");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.select_image, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Videos");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.video, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("Milestone");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.milestone, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();

                TextView selectedText = (TextView) view.findViewById(R.id.tab);
                selectedText.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorAccent));
                selectedText.setCompoundDrawablesWithIntrinsicBounds(0,selectedtabIcons[tab.getPosition()], 0, 0);
                //tab.setIcon(selectedtabIcons[tab.getPosition()]);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();

                TextView selectedText = (TextView) view.findViewById(R.id.tab);
                selectedText.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                selectedText.setCompoundDrawablesWithIntrinsicBounds(0,tabIcons[tab.getPosition()], 0, 0);
               // tab.setIcon(tabIcons[tab.getPosition()]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    private void setupViewPager(ViewPager viewPager) {
        TabPagerAdapter adapter = new TabPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new TabFragment1(), "Images");
        adapter.addFrag(new TabFragment1(), "Videos");
        adapter.addFrag(new TabFragment1(), "Milestone");
        viewPager.setAdapter(adapter);
    }
    public void setReference() {


        intro_images = (ViewPager)findViewById(R.id.pager_introduction);


        pager_indicator = (LinearLayout) findViewById(R.id.viewPagerCountDots);


        mAdapter = new ViewPagerAdapter(MainActivity.this, mImageResources);
        intro_images.setAdapter(mAdapter);
        intro_images.setCurrentItem(0);
        intro_images.setOnPageChangeListener(this);
        setUiPageViewController();
    }

    private void setUiPageViewController() {

        dotsCount = mAdapter.getCount();
        dots = new ImageView[dotsCount];

        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            pager_indicator.addView(dots[i], params);
        }

        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotsCount; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
        }

        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));


    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}