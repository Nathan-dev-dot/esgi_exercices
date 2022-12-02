package com.esgi.android.exercices

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_view) // pour activer la recycle view il faut l'ajouter ici et ligne 56 et 57 décommenter

        val booking = listOf(
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking(),
            generateFakeBooking()
        )


        findViewById<RecyclerView>(R.id.list).apply {
            //layoutManager = LinearLayoutManager(this@MainActivity,)
            //adapter = ListAdapter(booking);
        }
        // TODO Changer cette ligne en fonction des layouts
    }
}

private fun generateFakeBooking() = Booking("nathan", "25 avenue de par chez moi", BookingStatus.UPCOMING, Date(), Date());


class ListAdapter(private val products: List<Booking>) : RecyclerView.Adapter<BookingViewHolder>() {


    override fun getItemCount(): Int = products.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingViewHolder {
        return BookingViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.card_view, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: BookingViewHolder, position: Int) {
        holder.updateDay(
            products[position]
        )
    }


}

class BookingViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    private val status = v.findViewById<TextView>(R.id.status)
    private val price = v.findViewById<TextView>(R.id.price)
    private val place = v.findViewById<TextView>(R.id.place)
    private val desc = v.findViewById<TextView>(R.id.desc)


    fun updateDay(booking: Booking) {
        status.text = booking.status.toString();
        place.text = booking.streetAddress;
        desc.text = booking.arrivalDate.toString();
    }

}