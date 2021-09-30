package com.example.myapplicationyummlyrecipescookingtools.Activities

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager
import com.example.myapplicationyummlyrecipescookingtools.Adapter.ViewPagerAdapter
import com.example.myapplicationyummlyrecipescookingtools.Fragments.*
import com.example.myapplicationyummlyrecipescookingtools.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_home_screen.*

class HomeScreen : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.hide()

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)

        tabLayout.addTab(tabLayout.newTab().setText("FOR YOU"))
        tabLayout.addTab(tabLayout.newTab().setText("EXPLORE"))
        tabLayout.addTab(tabLayout.newTab().setText("PRO"))
        (tabLayout).setTabTextColors(
            ContextCompat.getColor(this, R.color.black),
            ContextCompat.getColor(this, R.color.black)
        )

        tabLayout.tabGravity = TabLayout.GRAVITY_FILL

        val adapter = ViewPagerAdapter(this, supportFragmentManager, tabLayout.tabCount)

        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
                tabLayout.getTabAt(0)?.icon?.setColorFilter(
                    resources.getColor(android.R.color.black),
                    PorterDuff.Mode.SRC_IN
                );
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tabLayout.getTabAt(2)?.icon
                    ?.setColorFilter(
                        resources.getColor(android.R.color.white),
                        PorterDuff.Mode.SRC_IN
                    );
            }

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener {

            when (it.itemId) {
                R.id.home -> {
                    viewPager.visibility = View.VISIBLE
                    loadFragment(JustForYouFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.Search -> {
                    viewPager.visibility = View.GONE
                    loadFragment(SearchFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.Profile -> {

                    loadFragment(ProfileFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.list -> {
                    loadFragment(PremiumFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.Connection -> {
                    loadFragment(ThermometerFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.FrameLayout, fragment)
        transaction.addToBackStack("addFrag")
        transaction.commit()
    }
}