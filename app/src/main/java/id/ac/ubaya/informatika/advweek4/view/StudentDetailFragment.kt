package id.ac.ubaya.informatika.advweek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import id.ac.ubaya.informatika.advweek4.R
import id.ac.ubaya.informatika.advweek4.viewmodel.DetailViewModel
import id.ac.ubaya.informatika.advweek4.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_student_detail.*

class StudentDetailFragment : Fragment() {
    private  lateinit var viewModel: DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()

        if(arguments!=null){
            var playerName = StudentDetailFragmentArgs.fromBundle(requireArguments()).name
            var id = StudentDetailFragmentArgs.fromBundle(requireArguments()).id
            var bod = StudentDetailFragmentArgs.fromBundle(requireArguments()).bod
            var phone = StudentDetailFragmentArgs.fromBundle(requireArguments()).phone
//            txtTurn.text = "$playerName's Turn"
            txtIdS.setText(id)
            txtNameS.setText(playerName)
            txtBod.setText(bod)
            txtPhone.setText(phone)
//            score += playerScore
        }
    }
}