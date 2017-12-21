package bwei.com.heyongwu;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenuItem;

import bwei.com.heyongwu.fragment.CalendarFragment;
import bwei.com.heyongwu.fragment.FaxianFragment;
import bwei.com.heyongwu.view.zhuye.view.HomeFragment;
import bwei.com.heyongwu.view.zhuye.view.fenlei.ProfileFragment;
import bwei.com.heyongwu.view.zhuye.view.setting.SettingsFragment;
import bwei.com.heyongwu.xiaodongxi.Titanic;
import bwei.com.heyongwu.xiaodongxi.TitanicTextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ResideMenu resideMenu;
    private MainActivity mContext;
    private ResideMenuItem itemHome;
    private ResideMenuItem itemProfile;
    private ResideMenuItem itemCalendar;
    private ResideMenuItem itemSettings;
    private ResideMenuItem itemfaxian;
    private TitanicTextView psp;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        psp = findViewById(R.id.psps);
        mContext = this;
        setUpMenu();
        if( savedInstanceState == null )
            changeFragment(new HomeFragment());
        psp();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
    private void setUpMenu() {
//        resideMenu.navigationController.interactivePopGestureRecognizer.enabled = YES;
//        resideMenu.navigationController.interactivePopGestureRecognizer.delegate = nil;
        // attach to current activity;
        resideMenu = new ResideMenu(this);
        resideMenu.setBackground(R.drawable.bg_blue);
        resideMenu.attachToActivity(this);
        resideMenu.setMenuListener(menuListener);
        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip.
        resideMenu.setScaleValue(0.6f);
        // create menu items;
        itemHome     = new ResideMenuItem(this, R.drawable.ac1,     "首页");
        itemProfile  = new ResideMenuItem(this, R.drawable.abx,  "分类");
        itemfaxian = new ResideMenuItem(this,R.drawable.abz,"发现");
        itemCalendar = new ResideMenuItem(this, R.drawable.abv, "购物车");
        itemSettings = new ResideMenuItem(this, R.drawable.ac3, "我的");
        itemHome.setOnClickListener(this);
        itemProfile.setOnClickListener(this);
        itemCalendar.setOnClickListener(this);
        itemSettings.setOnClickListener(this);
        itemfaxian.setOnClickListener(this);

        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemProfile, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemfaxian, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemCalendar, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemSettings, ResideMenu.DIRECTION_RIGHT);


        // You can disable a direction by setting ->
        // resideMenu.setSwipeDirectionDisable(ResideMenu.DIRECTION_RIGHT);

        findViewById(R.id.title3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
        findViewById(R.id.title4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View view) {

        if (view == itemHome){
            changeFragment(new HomeFragment());
        }else if (view == itemProfile){
            changeFragment(new ProfileFragment());
        }else if (view == itemCalendar){
            changeFragment(new CalendarFragment());
        }else if (view == itemSettings){
            changeFragment(new SettingsFragment());
        }else if(view == itemfaxian){
            changeFragment(new FaxianFragment());
        }

        resideMenu.closeMenu();
    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            Toast.makeText(mContext, "打开", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            Toast.makeText(mContext, "关闭", Toast.LENGTH_SHORT).show();
        }
    };

    private void changeFragment(Fragment targetFragment){
        resideMenu.clearIgnoredViewList();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    // What good method is to access resideMenu？
    public ResideMenu getResideMenu(){
        return resideMenu;
    }
    private void psp() {
        Typeface face = Typeface.createFromAsset(getAssets(),"font/english.ttf");
        psp.setTypeface(face);
        new Titanic().start(psp);
    }
}

