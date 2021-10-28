package id.ac.ubaya.informatika.advweek4.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.ac.ubaya.informatika.advweek4.R
import id.ac.ubaya.informatika.advweek4.databinding.FragmentStudentDetailBinding
import id.ac.ubaya.informatika.advweek4.util.loadImage
import id.ac.ubaya.informatika.advweek4.viewmodel.DetailViewModel
import id.ac.ubaya.informatika.advweek4.viewmodel.ListViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_student_detail.*
import java.util.*
import java.util.concurrent.TimeUnit

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private lateinit var dataBinding:FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(inflater, R.layout.fragment_student_detail, container, false)
        return dataBinding.root
//        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var id = ""

        if(arguments!=null){
//            var playerName = StudentDetailFragmentArgs.fromBundle(requireArguments()).name
            id = StudentDetailFragmentArgs.fromBundle(requireArguments()).id
//            var bod = StudentDetailFragmentArgs.fromBundle(requireArguments()).bod
//            var phone = StudentDetailFragmentArgs.fromBundle(requireArguments()).phone

//            txtIdS.setText(id)
//            txtNameS.setText(playerName)
//            txtBod.setText(bod)
//            txtPhone.setText(phone)
        }

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(id)
//        Toast.makeText(context, "URL: $", Toast.LENGTH_SHORT).show()
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            dataBinding.student = it
            Toast.makeText(context, "URL: ${it.photoUrl}", Toast.LENGTH_SHORT).show()
//            txtIdS.setText(it.id)
//            txtNameS.setText(it.name)
//            txtBod.setText(it.bod)
//            txtPhone.setText(it.phone)
//            imageView2.loadImage(it.photoUrl.toString(), progressBar2)

//            var student = it
//            btnNotif.setOnClickListener {
//                Observable.timer(5, TimeUnit.SECONDS)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe {
//                        MainActivity.showNotification(student.name.toString(),
//                            "A new notification created",
//                            R.drawable.ic_baseline_person_24)
//                    }
//            }
        })
    }
}