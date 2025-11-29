// MainActivity.kt
package com.example.petagram

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.petagram.databinding.ActivityMainBinding
import com.example.petagram.ui.home.HomeFragment
import com.example.petagram.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        setupViewPager()
        setupMenu()
    }

    private fun setupViewPager() {
        val fragments = listOf(
            HomeFragment(),     // lista de mascotas
            ProfileFragment()   // perfil con grid
        )
        val adapter = object : androidx.viewpager2.adapter.FragmentStateAdapter(this) {
            override fun getItemCount() = fragments.size
            override fun createFragment(position: Int) = fragments[position]
        }
        binding.viewPager.adapter = adapter
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun setupMenu() {
        binding.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_contact -> {
                    startActivity(Intent(this, com.example.petagram.ui.contact.ContactActivity::class.java))
                    true
                }
                R.id.action_about -> {
                    startActivity(Intent(this, com.example.petagram.ui.about.AboutActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }
}
