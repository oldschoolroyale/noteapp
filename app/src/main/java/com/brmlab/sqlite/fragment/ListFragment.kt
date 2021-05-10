package com.brmlab.sqlite.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brmlab.sqlite.R
import com.brmlab.sqlite.adapter.RecyclerViewAdapter
import com.brmlab.sqlite.model.AccountPOJO
import com.brmlab.sqlite.room.viewModel.AccountViewModel


class ListFragment : Fragment() {

    companion object{
        private const val KEY = "LOG_TAG"
    }
    private var adapter = RecyclerViewAdapter()
    private lateinit var observer: Observer<List<AccountPOJO>>

    private val accountViewModel by viewModels<AccountViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list, container, false)


        val recyclerView = view.findViewById<RecyclerView>(R.id.fragmentListRecycler)
        //тут мы получаем список из оффлайн дб и передаем адаптеру
        observer = Observer {
            Log.d(KEY, "${it.count()}")
            adapter.newList(it)
        }

        //тут мы вешаем наш обсервер на слушатель
        accountViewModel.getAllData.observe(viewLifecycleOwner, observer)

        //привязка адаптера к списку
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        return view
    }
}