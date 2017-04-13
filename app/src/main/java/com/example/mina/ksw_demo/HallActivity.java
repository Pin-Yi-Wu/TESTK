package com.example.mina.ksw_demo;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.zip.Inflater;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 程序主入口
 * @author liuyazhuang
 *
 */
public class HallActivity extends AppCompatActivity{

    private ViewPager mViewPaper;
    private List<ImageView> images;
    private List<View> dots;
    private int currentItem;
    //记录上一次点的位置
    private int oldPosition = 0;
    //存放图片的id
    private int[] imageIds = new int[]{
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.pic5
    };
    //存放图片的标题
    private String[]  titles = new String[]{
            "巩俐不低俗，我就不能低俗",
            "扑树又回来啦！再唱经典老歌引万人大合唱",
            "揭秘北京电影如何升级",
            "乐视网TV版大派送",
            "热血屌丝的反杀"
    };
    private TextView title;
    private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;
    CheckBox hide02;
    TextView tv01;
    private TextView infoTextView;              //ToolBarSource
    private BottomNavigationView bottomNavigationView;            //ToolBarSource

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall);
        mViewPaper = (ViewPager) findViewById(R.id.vp);
        hide02 =(CheckBox)findViewById(R.id.hide02);
        tv01 = (TextView)findViewById(R.id.tv01);

//toolbar source
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Inflater inflater = new Inflater();

        infoTextView = (TextView) findViewById(R.id.infoTextView);        //ToolBarSource

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);        //ToolBarSource

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.inicioItem) {
                    Intent intent = new Intent();
                    intent.setClass(HallActivity.this,HallActivity.class);
                    startActivity(intent);
                } else if (item.getItemId() == R.id.buscarItem) {
                    Intent intent = new Intent();
                    intent.setClass(HallActivity.this,LiveActivity.class);
                    startActivity(intent);
                } else if (item.getItemId() == R.id.camaraItem) {
                    Intent intent = new Intent();
                    intent.setClass(HallActivity.this,SlotActivity.class);
                    startActivity(intent);
                } else if (item.getItemId() == R.id.favoritosItem) {
                    Intent intent = new Intent();
                    intent.setClass(HallActivity.this,GamesActivity.class);
                    startActivity(intent);
                } else if (item.getItemId() == R.id.perfilItem) {
                    infoTextView.setText(R.string.perfil);
                }

                return false;
            }
        });

        //显示的图片
                images = new ArrayList<ImageView>();
                for(int i = 0; i < imageIds.length; i++){
                    ImageView imageView = new ImageView(this);
                    imageView.setBackgroundResource(imageIds[i]);
                    images.add(imageView);
                }
                //显示的小点
                dots = new ArrayList<View>();
                dots.add(findViewById(R.id.dot_0));
                dots.add(findViewById(R.id.dot_1));
                dots.add(findViewById(R.id.dot_2));
                dots.add(findViewById(R.id.dot_3));
                dots.add(findViewById(R.id.dot_4));

                title = (TextView) findViewById(R.id.title);
                title.setText(titles[0]);

                adapter = new ViewPagerAdapter();
                mViewPaper.setAdapter(adapter);

                mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


                    @Override
                    public void onPageSelected(int position) {
                        title.setText(titles[position]);
                        dots.get(position).setBackgroundResource(R.drawable.dot_black);
                        dots.get(oldPosition).setBackgroundResource(R.drawable.dot_white);

                        oldPosition = position;
                        currentItem = position;
                    }

                    @Override
                    public void onPageScrolled(int arg0, float arg1, int arg2) {

                    }

                    @Override
                    public void onPageScrollStateChanged(int arg0) {

                    }
                  });

                //textview隱藏程式碼開始
                    hide02.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                           if(hide02.isChecked()){
                               tv01.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                           }else{
                               tv01.setTransformationMethod(PasswordTransformationMethod.getInstance());
                           }
                        }
                    });
                 }

                            /**
                             * 自定义Adapter
                             * @author liuyazhuang
                             *
                             */
                private class ViewPagerAdapter extends PagerAdapter{

                    @Override
                    public int getCount() {
                        return images.size();
                    }

                    @Override
                    public boolean isViewFromObject(View arg0, Object arg1) {
                        return arg0 == arg1;
                    }

                    @Override
                    public void destroyItem(ViewGroup view, int position, Object object) {
                        // TODO Auto-generated method stub
                        //super.destroyItem(container, position, object);
                        //view.removeView(view.getChildAt(position));
                        //view.removeViewAt(position);
                        view.removeView(images.get(position));
                    }

                    @Override
                    public Object instantiateItem(ViewGroup view, int position) {
                        // TODO Auto-generated method stub
                        view.addView(images.get(position));
                        return images.get(position);
                    }

                }

                /**
                 * 利用线程池定时执行动画轮播
                 */
                @Override
                protected void onStart() {
                    // TODO Auto-generated method stub
                    super.onStart();
                    scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
                    scheduledExecutorService.scheduleWithFixedDelay(
                            new ViewPageTask(),
                            2,
                            2,
                            TimeUnit.SECONDS);
                }


                        /**
                         * 图片轮播任务
                         * @author liuyazhuang
                         *
                         */
                        private class ViewPageTask implements Runnable{

                            @Override
                            public void run() {
                                currentItem = (currentItem + 1) % imageIds.length;
                                mHandler.sendEmptyMessage(0);
                            }
                        }

                            /**
                             * 接收子线程传递过来的数据
                             */
                            private Handler mHandler = new Handler(){
                                public void handleMessage(android.os.Message msg) {
                                    mViewPaper.setCurrentItem(currentItem);
                                };
                            };
                            @Override
                            protected void onStop() {
                                // TODO Auto-generated method stub
                                super.onStop();
                                if(scheduledExecutorService != null){
                                    scheduledExecutorService.shutdown();
                                    scheduledExecutorService = null;
                                }
                            }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.help:
                Intent intent = new Intent();
                intent.setClass(HallActivity.this,Customer_Service.class);
                startActivity(intent);

            case R.id.event:
                Toast.makeText(HallActivity.this,"event",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
                        }