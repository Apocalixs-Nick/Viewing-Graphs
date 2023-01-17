package com.example.viewinggraphs.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.viewinggraphs.databinding.FragmentScrollPagesBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ScrollPagesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ScrollPagesFragment : Fragment() {

    private var _binding: FragmentScrollPagesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentScrollPagesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pager: ViewPager = binding.pager

        pager.offscreenPageLimit = 2
        pager.adapter = PageAdapter(activity?.supportFragmentManager)
    }


    private class PageAdapter(fm: FragmentManager?) :
    FragmentPagerAdapter(fm!!) {
        override fun getItem(position: Int): Fragment {
            var fragment: Fragment = BarChartFragment()
             when (position) {
                0 -> fragment = BarChartFragment()
                1 -> fragment = PieChartFragment()
                else -> fragment = BarChartFragment()
            }
            return fragment
        }

        override fun getCount(): Int {
            return 2
        }
    }



}