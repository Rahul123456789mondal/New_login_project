package com.example.logindemo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.santanu.android.recyclerviewupdate.data.Data
import com.santanu.android.recyclerviewupdate.data.DataSet

/**
 * A simple [Fragment] subclass.
 */
class homeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
    private lateinit var spinner: Spinner
    private val TAG: String = homeFragment::class.java.simpleName
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataSet: List<Data> = DataSet.dataList
        spinner = view.findViewById(R.id.dropdown)
        // Spinner Implementation
        val spinnerDataSet: Array<String> = getSpinnerList(dataSet)
        val spinnerAdapter = activity?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_spinner_dropdown_item, spinnerDataSet
            )
        }
        spinner.adapter = spinnerAdapter
        spinner.onItemSelectedListener = object  : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.d(TAG, "MainActivity{} : onNothingSelected() >>" +
                        " [line ${Thread.currentThread().stackTrace[2].lineNumber}] :: Called"
                )
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Log.d(TAG, "MainActivity{} : onItemSelected() >>" +
                        " [line ${Thread.currentThread().stackTrace[2].lineNumber}] :: Selected Item ${spinnerDataSet[position]}"
                )
                val selected : String = spinnerDataSet[position]
                val newDataList : List<Data> = getZoneList(selected, dataSet)
                Log.d(TAG, "MainActivity{} : onItemSelected() >>" +
                        " [line ${Thread.currentThread().stackTrace[2].lineNumber}] :: New Data Set Size : ${newDataList.size}"
                )
            }

        }
    }

    private fun getZoneList(zone: String, dataSet: List<Data>) : List<Data> {
        var dataList: List<Data> = mutableListOf()
        for (data in dataSet) {
            if (data.zone == zone) {
                dataList = dataList.plus(data)
            }
        }
        return dataList
    }

    private fun getSpinnerList(dataSet: List<Data>) : Array<String> {
        val dropDownSet: HashSet<String> = hashSetOf()
        for (data in dataSet) {
            dropDownSet.add(data.zone)
        }
        return dropDownSet.toTypedArray()
    }

}




































