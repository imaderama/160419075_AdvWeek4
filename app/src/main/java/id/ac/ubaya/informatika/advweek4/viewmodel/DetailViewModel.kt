package id.ac.ubaya.informatika.advweek4.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.informatika.advweek4.model.Student

class DetailViewModel(application: Application): AndroidViewModel(application) {
    val studentLD = MutableLiveData<Student>()

    private val TAG = "volleyTag"
    private var queue: RequestQueue?= null

    fun fetch(url: String): String {
//        val student1 = Student("16055","Nonie","1998/03/28","5718444778",
//                "http://dummyimage.com/75x100.jpg/cc0000/ffffff")
        queue = Volley.newRequestQueue(getApplication())
//        var url = "http://adv.jitusolution.com/student.php?id=16055"

        val stringRequest = StringRequest(Request.Method.GET, url,
                { response ->
                    val sType = object : TypeToken<Student>() { }.type
                    val result = Gson().fromJson<Student>(response,
                            Student::class.java)

                    studentLD.value = result

//                    loadingLD.value = false
                    Log.d("singlevolley", response.toString())

                },
                {
//                    loadingErrorLD.value = true
//                    loadingLD.value = false
                    Log.d("singlevolley", it.toString())
                })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
        return studentLD.value.toString()
//        studentLD.value =
    }
}