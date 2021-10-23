package com.example.demonavigationdrawertoolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

import com.example.demonavigationdrawertoolbar.fragments.FragmentHome;
import com.example.demonavigationdrawertoolbar.fragments.FragmentKhoanChi;
import com.example.demonavigationdrawertoolbar.fragments.FragmentKhoanThu;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private NavigationView viewNav;
    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_KHOANTHU = 1;
    private static final int FRAGMENT_KHOANCHI = 2;
    private int mCurrent = FRAGMENT_HOME;
    private BottomNavigationView viewBottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intView();
    }
    private void intView() {
        mDrawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolBar);
        viewNav = findViewById(R.id.nav_menulef);
        viewBottomNav = findViewById(R.id.bottom_nav);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout
                , toolbar, R.string.open_drawer, R.string.close_drawer);
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        viewNav.setNavigationItemSelectedListener(this);
        viewBottomNav.setOnItemSelectedListener(this::onNavigationItemSelected);

        replaceFragment(new FragmentHome());
        viewNav.getMenu().findItem(R.id.it_home).setChecked(true);
        setTitleToolBar();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.it_home:
                openHomeFragment();
                viewBottomNav.getMenu().findItem(R.id.it_bottom_home).setChecked(true);
                break;
            case R.id.it_khoanchi:
                openKhoanChiFragment();
                viewBottomNav.getMenu().findItem(R.id.it_bottom_khoan_Chi).setChecked(true);
                break;
            case R.id.it_khoanthu:
                openKhoanThuFragment();
                viewBottomNav.getMenu().findItem(R.id.it_bottom_khoan_thu).setChecked(true);
                break;
            case R.id.it_bottom_home:
                openHomeFragment();
                break;
            case R.id.it_bottom_khoan_Chi:
                openKhoanChiFragment();
                break;
            case R.id.it_bottom_khoan_thu:
                openKhoanThuFragment();
                break;

        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        setTitleToolBar();
        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.myFramelayout, fragment);
        fragmentTransaction.commit();


    }

    private void openHomeFragment() {
        if (mCurrent != FRAGMENT_HOME) {
            replaceFragment(new FragmentHome());
            mCurrent = FRAGMENT_HOME;
        }

    }
    private void openKhoanThuFragment() {
        if (mCurrent != FRAGMENT_KHOANTHU) {
            replaceFragment(new FragmentKhoanThu());

            mCurrent = FRAGMENT_KHOANTHU;
        }

    }
    private void openKhoanChiFragment() {
        if (mCurrent != FRAGMENT_KHOANCHI) {
            replaceFragment(new FragmentKhoanChi());

            mCurrent = FRAGMENT_KHOANCHI;
        }
    }

    private void setTitleToolBar() {

        String title = "";

        switch (mCurrent) {
            case FRAGMENT_HOME:
                title = getString(R.string.nav_home);
                break;
            case FRAGMENT_KHOANCHI:
                title = getString(R.string.nav_khoanchi);
                break;
            case FRAGMENT_KHOANTHU:
                title = getString(R.string.nav_khuanthu);
                break;
        }
        if (getSupportActionBar().getTitle() != null) {

            getSupportActionBar().setTitle(title);
        }


    }
}