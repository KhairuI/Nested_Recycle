package com.example.nested_recycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.nested_recycle.api.RetrofitInstance
import com.example.nested_recycle.databinding.ActivityMainBinding
import com.example.nested_recycle.repository.MyRepository
import com.example.nested_recycle.viewmodel.ApiViewModel
import com.example.nested_recycle.viewmodel.ApiViewModelFactory
import com.google.gson.Gson
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    //private val viewModel: ApiViewModel by viewModels()

    private lateinit var nameRepo: MyRepository
    private lateinit var apiVM: ApiViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAll()
        getAllName()
        setInfoList()
        setCostList()

        //observe name list
        observeNameList()
    }

    private fun initAll() {
        nameRepo= MyRepository(RetrofitInstance.api)
        apiVM = ViewModelProvider(viewModelStore, ApiViewModelFactory(nameRepo))[ApiViewModel::class.java]

    }

    private fun observeNameList() {
        apiVM.nameResponse.observe(this){
            val body = it.body()?.string()
            if(body.isNullOrBlank()){
                Log.d("xxx", "error: ${it.errorBody()}")
            }
            else{
                val jsonObject = JSONObject(body)
                val nameList= Gson().fromJson(jsonObject.toString(), ModelApi::class.java)
                Log.d("xxx", "observeNameList: $nameList")
            }
        }
    }

    private fun getAllName() {
        apiVM.getNameList()
    }


    private fun setCostList() {
        val costList= mutableListOf(
            ModelCost("100","10","8","5","10","15","20","25"),
            ModelCost("100","10","8","5","10","15","20","25"),
            ModelCost("400","10","8","5","10","15","20","25"),
            ModelCost("100","10","8","5","10","15","20","25"),
            ModelCost("600","10","8","5","10","15","20","25"),
        ModelCost("100","10","8","5","10","15","20","25"),
        ModelCost("100","10","8","5","10","15","20","25"),
        ModelCost("100","10","8","5","10","15","20","25"),
        ModelCost("400","10","8","5","10","15","20","25"),
        ModelCost("100","10","8","5","10","15","20","25"),
        ModelCost("600","10","8","5","10","15","20","25"),
        ModelCost("100","10","8","5","10","15","20","25"),
            ModelCost("100","10","8","5","10","15","20","25"),
            ModelCost("100","10","8","5","10","15","20","25"),
            ModelCost("100","10","8","5","10","15","20","25"),
            ModelCost("400","10","8","5","10","15","20","25"),
            ModelCost("100","10","8","5","10","15","20","25"),
            ModelCost("600","10","8","5","10","15","20","25"),
            ModelCost("100","10","8","5","10","15","20","25"))

        val costAdapter= CostAdapter(costList)
        binding.rvCost.apply {
            setHasFixedSize(true)
            adapter= costAdapter
            //isLayoutFrozen = true
        }
    }

    private fun setInfoList() {
        val infoList= mutableListOf(
            ModelInfo(1, "Alex","25"),
            ModelInfo(1, "Jhon","25"),
            ModelInfo(1, "Bob","25"),
            ModelInfo(1, "Alex2jfkdjf jdfbjkd","25"),
            ModelInfo(1, "Alex3fddfj dfgd","25"),
            ModelInfo(1, "Alex4df dfgd dfgdf","25"),
            ModelInfo(1, "Alex","25"),
            ModelInfo(1, "Jhon","25"),
            ModelInfo(1, "Bob","25"),
            ModelInfo(1, "Alex2jfkdjf jdfbjkd","25"),
            ModelInfo(1, "Alex3fddfj dfgd","25"),
            ModelInfo(1, "Alex4df dfgd dfgdf","25"),
            ModelInfo(1, "Alex","25"),
            ModelInfo(1, "Jhon","25"),
            ModelInfo(1, "Bob","25"),
            ModelInfo(1, "Alex2jfkdjf jdfbjkd","25"),
            ModelInfo(1, "Alex3fddfj dfgd","25"),
            ModelInfo(1, "Alex4df dfgd dfgdf","25"),
            ModelInfo(1, "Bob4df dfgd dfgdf","25"))
        val infoAdapter= InfoAdapter(infoList)
        binding.rvInfo.apply {
            setHasFixedSize(true)
            adapter= infoAdapter
        }
    }
}