package au.com.mealplanner.mealplanner.feature.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import au.com.mealplanner.mealplanner.R
import au.com.mealplanner.mealplanner.data.model.DayOfWeek
import au.com.mealplanner.mealplanner.feature.main.WeeklyPlanAdapter.WeeklyPlanViewHolder

class WeeklyPlanAdapter(dayOfWeekList: List<DayOfWeek>, presenter: WeeklyPlanActivityPresenter) : RecyclerView.Adapter<WeeklyPlanViewHolder>() {

    val weekList: List<DayOfWeek> = dayOfWeekList
    val presenter: WeeklyPlanActivityPresenter = presenter

    override fun onBindViewHolder(holder: WeeklyPlanViewHolder?, position: Int) {
        val dayOfWeek = weekList.get(position)
        holder?.dayLabel?.text = dayOfWeek.name
        holder?.addMealButton?.setOnClickListener({
            presenter.goToAddMealActivity(dayOfWeek)
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WeeklyPlanViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.meal_day_plan_card, parent, false)
        return WeeklyPlanViewHolder(v)
    }

    override fun getItemCount(): Int {
        return weekList.size
    }

    inner class WeeklyPlanViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var dayLabel: TextView = view.findViewById(R.id.day_label)
        var addMealButton: Button = view.findViewById(R.id.add_meal_button)
    }
}