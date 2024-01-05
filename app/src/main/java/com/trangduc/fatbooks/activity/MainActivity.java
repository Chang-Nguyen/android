package com.trangduc.fatbooks.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.trangduc.fatbooks.Photo;
import com.trangduc.fatbooks.R;
import com.trangduc.fatbooks.adapter.BookFreeAdapter;
import com.trangduc.fatbooks.adapter.CategoryAdapter;
import com.trangduc.fatbooks.adapter.ItemBookAdapter;
import com.trangduc.fatbooks.adapter.NewAdapter;
import com.trangduc.fatbooks.adapter.PhotoAdapter;
import com.trangduc.fatbooks.adapter.PodcastAdapter;
import com.trangduc.fatbooks.domain.BookFreeDomain;
import com.trangduc.fatbooks.domain.CategoryDomain;
import com.trangduc.fatbooks.domain.NewDomain;
import com.trangduc.fatbooks.domain.PodcastDomain;
import com.trangduc.fatbooks.fragment.CommunityFragment;
import com.trangduc.fatbooks.fragment.EndowFragment;
import com.trangduc.fatbooks.fragment.LoginRequiredFragment;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements ItemBookAdapter.buttonClickListener{
    Toolbar toolbar;
    ViewPager2 viewpager2;

    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;

    private Handler photoHandler = new Handler();

    private RecyclerView.Adapter adapter, adapterfree, adapterpod, adapternew;
    private ArrayList<Integer> integerArrayList;
    private ItemBookAdapter itemBookAdapter;

    private RecyclerView recyclerViewCategotyList, recyclerViewItemBookList, recyclerViewBookFreeList, recyclerViewPodcastList, recyclerViewNewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();

        recyclerViewCategoryList();
        recyclerViewItemBookList();
        recyclerViewBookFreeList();
        recyclerViewPodcastList();
        recyclerViewNewList();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.action_home) {
                    handleHomeClick();
                }
                else if (itemId == R.id.action_endow) {
                    switchToFragment(new EndowFragment());
                    return true;
                } else if (itemId == R.id.action_community) {
                    switchToFragment(new CommunityFragment());
                    return true;
                } else if (itemId == R.id.action_Library) {
                    if (userIsLoggedIn()) {
                        handleLibraryClick();}
                    else {
                        switchToFragment(new LoginRequiredFragment()); // Chuyển đến LoginRequiredFragment
                    }
                } else if (itemId == R.id.action_canhan) {
                    if (userIsLoggedIn()) {
                        handleLibraryClick();
                    }
                    else {
                        switchToFragment(new LoginRequiredFragment()); // Chuyển đến LoginRequiredFragment
                    }
                }
                return true;
            }

            private boolean userIsLoggedIn() {
                return false;
            }
        });

//        Image Run
        List<Photo> photo = new ArrayList<>();
        photo.add(new Photo(R.drawable.qc));
        photo.add(new Photo(R.drawable.qc_1));
        photo.add(new Photo(R.drawable.qc_2));
        photo.add(new Photo(R.drawable.qc_3));
        photo.add(new Photo(R.drawable.qc_4));
        viewpager2.setAdapter(new PhotoAdapter(photo, viewpager2));

        viewpager2.setClipToPadding(false);
        viewpager2.setClipChildren(false);
        viewpager2.setOffscreenPageLimit(4);
        viewpager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositionTransform = new CompositePageTransformer();
        compositionTransform.addTransformer(new MarginPageTransformer(30));
        compositionTransform.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1-Math.abs(position);
                page.setScaleY(0.85f + r*0.15f);
            }
        });

        viewpager2.setPageTransformer(compositionTransform);

        viewpager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                photoHandler.removeCallbacks(photoRunnable);
                photoHandler.postDelayed(photoRunnable, 4000);
            }
        });

    }


    private void recyclerViewItemBookList() {
        recyclerViewItemBookList = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        integerArrayList = new ArrayList<>();
        integerArrayList.add(R.drawable.item_1);
        integerArrayList.add(R.drawable.item_2);
        integerArrayList.add(R.drawable.item_3);


        itemBookAdapter = new ItemBookAdapter(this, integerArrayList,this);

        recyclerViewItemBookList.setLayoutManager(linearLayoutManager);
        recyclerViewItemBookList.setAdapter(itemBookAdapter);
    }


    private void recyclerViewCategoryList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategotyList=findViewById(R.id.view1);
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Sách Truyện","pic_1","Sách Mua Lẻ","pic_6"));
        categoryList.add(new CategoryDomain("Sách Nói","pic_2","Sách Mới Nhất","pic_7"));
        categoryList.add(new CategoryDomain("Truyện tranh","pic_3","Cộng Đông Viết","pic_8"));
        categoryList.add(new CategoryDomain("Tóm tắt sách","pic_4","Tủ sách thanh niên","pic_9"));
        categoryList.add(new CategoryDomain("Sách Phật","pic_5","Thư viện số 4.0","pic_10"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategotyList.setAdapter(adapter);
    }

    private void recyclerViewBookFreeList() {
        recyclerViewBookFreeList = findViewById(R.id.recycler_free);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);
        ArrayList<BookFreeDomain> bookfreeList = new ArrayList<>();
        bookfreeList.add(new BookFreeDomain("Không gia đình","free"));
        bookfreeList.add(new BookFreeDomain("Tội ác và Hình phạt","free_1"));
        bookfreeList.add(new BookFreeDomain("Đừng bao giờ từ bỏ ước mơ","free_2"));
        bookfreeList.add(new BookFreeDomain("Đắc nhân tâm","free_3"));
        bookfreeList.add(new BookFreeDomain("Lấp lánh","free_4"));
        bookfreeList.add(new BookFreeDomain("Phong trào trấnh hưng Phật giáo Miền Nam","free_5"));
        bookfreeList.add(new BookFreeDomain("Thanh xuân","free_6"));
        bookfreeList.add(new BookFreeDomain("Truyện kiều","free_7"));
        adapterfree = new BookFreeAdapter(bookfreeList);
        recyclerViewBookFreeList.setAdapter(adapterfree);
    }

    private void recyclerViewPodcastList() {
        recyclerViewPodcastList = findViewById(R.id.recycler_podcast);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);
        ArrayList<PodcastDomain> podcastList = new ArrayList<>();
        podcastList.add(new PodcastDomain("Trạm cảm xúc","pod"));
        podcastList.add(new PodcastDomain("Chuyện hồi đó","pod_1"));
        podcastList.add(new PodcastDomain("Xu hướng gen Z","pod_2"));
        podcastList.add(new PodcastDomain("Một cuốn sách buồn....cười","pod_3"));
        adapterpod = new PodcastAdapter(podcastList);
        recyclerViewPodcastList.setAdapter(adapterpod);
    }

    private void recyclerViewNewList() {
        recyclerViewNewList = findViewById(R.id.recycler_news);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);
        ArrayList<NewDomain> newList = new ArrayList<>();
        newList.add(new NewDomain("Mua 1 tặng 1 thả ga cùng FatBooks","tt"));
        newList.add(new NewDomain("Lịch phát sóng chuyện mới của fatBook","tt_1"));
        adapternew = new NewAdapter(newList);
        recyclerViewNewList.setAdapter(adapternew);
    }

    private Runnable photoRunnable = new Runnable() {
        @Override
        public void run() {
            viewpager2.setCurrentItem(viewpager2.getCurrentItem() + 1);
        }
    };

    private void Anhxa() {
        toolbar = findViewById(R.id.toolbar);
        viewpager2 = findViewById(R.id.viewpager2);
        bottomNavigationView = findViewById(R.id.bottom_nav);

    }

    private void switchToFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void handleHomeClick() {
        getSupportFragmentManager().popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    private void handleEndowClick() {
        Toast.makeText(MainActivity.this, "Ưu đãi", Toast.LENGTH_SHORT).show();
    }

    private void handleCommunityClick() {

    }

    private void handleLibraryClick() {
        Toast.makeText(MainActivity.this, "Thư viện", Toast.LENGTH_SHORT).show();
    }


    private void handleCanhanClick() {
        Toast.makeText(MainActivity.this, "Cá nhân", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onButtonClick(int position) {
        //Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        //startActivity(intent);
    }
}