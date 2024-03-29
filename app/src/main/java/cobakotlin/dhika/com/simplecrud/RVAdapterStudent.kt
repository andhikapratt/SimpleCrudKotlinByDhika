package cobakotlin.dhika.com.simplecrud

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.student_list.view.*

class RVAdapterStudent(private val context: Context, private val arrayList: ArrayList<Students>) : RecyclerView.Adapter<RVAdapterStudent.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.student_list,parent,false))
    }

    override fun getItemCount(): Int = arrayList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.view.lbNimList.text = arrayList.get(position).nim
        holder.view.lbNameList.text = "Nama : "+arrayList.get(position).name
        holder.view.lbAddressList.text = "Alamat : "+arrayList.get(position).address
        holder.view.lbGenderList.text = "Jenkel : "+arrayList.get(position).gender

        holder.view.cvList.setOnClickListener {

            val i = Intent(context,ManageStudentActivity::class.java)
            i.putExtra("editmode","1")
            i.putExtra("nim",arrayList.get(position).nim)
            i.putExtra("name",arrayList.get(position).name)
            i.putExtra("address",arrayList.get(position).address)
            i.putExtra("gender",arrayList.get(position).gender)
            context.startActivity(i)

        }

    }
    class Holder(val view:View) : RecyclerView.ViewHolder(view)
}
