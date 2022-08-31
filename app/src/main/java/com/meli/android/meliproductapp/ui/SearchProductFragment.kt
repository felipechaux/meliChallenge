package com.meli.android.meliproductapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.meli.android.meliproductapp.R
import com.meli.android.meliproductapp.databinding.FragmentSearchProductBinding
import com.meli.android.meliproductapp.utils.Constants

class SearchProductFragment : Fragment() {

    private var _binding: FragmentSearchProductBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchProductBinding.inflate(inflater, container, false)
        val view = binding?.root

        setActionListeners()
        return view
    }

    private fun setActionListeners() {
        // listener for buttonSearch
        binding?.buttonSearch?.setOnClickListener {
            findNavController().navigate(
                R.id.action_searchProductFragment_to_productListFragment
            )
        }
        // listener for search view.
        binding?.searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("${Log.INFO}", "query: $query)")
                query?.let {
                    searchProduct(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        // listener for buttonSearch
        binding?.buttonSearch?.setOnClickListener {
            searchProduct(binding?.searchView?.query.toString())
        }
    }

    private fun searchProduct(query: String) {
        findNavController().navigate(
            R.id.action_searchProductFragment_to_productListFragment,
            Bundle().apply {
                putString(Constants.EXTRA_QUERY, query)
            }
        )
    }
}
