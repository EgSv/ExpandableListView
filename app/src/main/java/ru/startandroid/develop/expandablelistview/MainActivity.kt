package ru.startandroid.develop.expandablelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListView
import android.widget.SimpleExpandableListAdapter

class MainActivity : AppCompatActivity() {

    private val groups = arrayOf("HTC", "Samsung", "LG")
    private val phonesHTC = arrayOf("Sensation", "Desire", "Wildfire", "Hero")
    private val phonesSams = arrayOf("Galaxy S II", "Galaxy Nexus", "Wave")
    private val phonesLG = arrayOf("Optimus", "Optimus Link", "Optimus Black", "Optimus One")

    private var groupData: ArrayList<Map<String, String?>>? = null
    private var childDataItem: ArrayList<Map<String, String?>>? = null
    private var childData: ArrayList<ArrayList<Map<String, String?>>>? = null

    private var m: MutableMap<String, String?>? = null
    private var elvMain: ExpandableListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        groupData = arrayListOf()
        for (group in groups) {
            m = HashMap()
            m?.put("groupName", group)
            groupData!!.add(m as HashMap<String, String?>)
        }
        val groupFrom = arrayOf("groupName")
        val groupTo = intArrayOf(android.R.id.text1)

        childData = ArrayList()
        childDataItem = ArrayList()

        for (phone in phonesHTC) {
            m = HashMap()
            m?.put("phoneName", phone)
            childDataItem!!.add(m as HashMap<String, String?>)
        }
        childData!!.add(childDataItem!!)
        childDataItem = ArrayList()
        for (phone in phonesSams) {
            m = HashMap()
            m?.put("phoneName", phone)
            childDataItem!!.add(m as HashMap<String, String?>)
        }
        childData!!.add(childDataItem!!)
        childDataItem = ArrayList()
        for (phone in phonesLG) {
            m = HashMap()
            m?.put("phoneName", phone)
            childDataItem!!.add(m as HashMap<String, String?>)
        }
        childData!!.add(childDataItem!!)

        val childFrom = arrayOf("phoneName")
        val childTo = intArrayOf(android.R.id.text1)

        val adapter = SimpleExpandableListAdapter(
            this,
            groupData,
            android.R.layout.simple_expandable_list_item_1,
            groupFrom,
            groupTo,
            childData,
            android.R.layout.simple_list_item_1,
            childFrom,
            childTo)
        elvMain = findViewById(R.id.elvMain)
        elvMain!!.setAdapter(adapter)
    }
}