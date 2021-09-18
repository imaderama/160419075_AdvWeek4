package id.ac.ubaya.informatika.advweek4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.advweek4.R
import id.ac.ubaya.informatika.advweek4.model.Student
import id.ac.ubaya.informatika.advweek4.util.loadImage
import kotlinx.android.synthetic.main.fragment_student_detail.view.*
import kotlinx.android.synthetic.main.student_list_item.view.*

class StudentListAdapter(val studentList:ArrayList<Student>):RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {
    class StudentViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateStudentList(newStudentList:List<Student>){
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.student_list_item, parent, false)

        return StudentViewHolder(v)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        with(holder.view){
            txtId.text = studentList[position].id
            txtName.text = studentList[position].name
            imageView.loadImage(studentList[position].photoUrl.toString(), holder.view.progressBar)

            btnDetail.setOnClickListener {
//                val studentID = studentList[position].id
//                val studentName = studentList[position].name
//                val studentBod = studentList[position].bod
//                val studentPhone = studentList[position].phone
//                val action = StudentListFragmentDirections.actionStudentDetail(studentID.toString(), studentName.toString(), studentBod.toString(), studentPhone.toString())
                val action = StudentListFragmentDirections.actionStudentDetail(studentList[position].id.toString())
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
}