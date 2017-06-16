package pub.war3.weather.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.item_weather_content.view.*
import pub.war3.weather.AppContext
import pub.war3.weather.R

/**
 * Created by turbo on 2017/6/15.
 */
class WeatherAdapter(val data: List<WeatherDataEntity.ResultsBean.WeatherDataBean>) : RecyclerView.Adapter<WeatherAdapter.ViewHoloder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoloder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather_content, parent, false)
        return ViewHoloder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: ViewHoloder, position: Int) {
        viewHolder.setWeatherData(data[position])
    }

    class ViewHoloder(val view: View) : RecyclerView.ViewHolder(view) {
        fun setWeatherData(weatherDataEntity: WeatherDataEntity.ResultsBean.WeatherDataBean) {
            itemView.tv_date.text = weatherDataEntity.date
            Glide.with(itemView.context)
                    .load(weatherDataEntity.dayPictureUrl)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(itemView.iv_day)
            Glide.with(itemView.context)
                    .load(weatherDataEntity.nightPictureUrl)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(itemView.iv_night)
            itemView.tv_weather.text = weatherDataEntity.weather
        }
    }

}