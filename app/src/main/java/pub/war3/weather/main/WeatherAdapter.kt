package pub.war3.weather.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.antonioleiva.weatherapp.extensions.ctx
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.item_weather_content.view.*
import kotlinx.android.synthetic.main.item_weather_today.view.*
import pub.war3.weather.AppContext
import pub.war3.weather.R

/**
 * Created by turbo on 2017/6/15.
 */
class WeatherAdapter(val data: List<WeatherDataBean>) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHoloder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHoloder {
        if (viewType == 0) {
            val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_weather_today, parent, false)
            return TodayWeatherViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_weather_content, parent, false)
            return WeatherViewHoloder(view)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(viewHolder: WeatherViewHoloder, position: Int) {
        viewHolder.setWeatherData(data[position])
    }

    //比较一下两个ViewHolder,一个用了with，一个没用
    open class WeatherViewHoloder(view: View) : RecyclerView.ViewHolder(view) {
        open fun setWeatherData(weatherDataEntity: WeatherDataBean) {
            with(weatherDataEntity){
                itemView.tv_date.text = date
                Glide.with(itemView.ctx)
                        .load(dayPictureUrl)
                        .crossFade()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(itemView.iv_day)
                Glide.with(itemView.ctx)
                        .load(nightPictureUrl)
                        .crossFade()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(itemView.iv_night)
                itemView.tv_weather.text = weather
            }
        }
    }

    class TodayWeatherViewHolder(val view: View) : WeatherViewHoloder(view) {
        override fun setWeatherData(weatherDataEntity: WeatherDataBean) {
            itemView.tv_today_date.text = weatherDataEntity.date
            Glide.with(itemView.ctx)
                    .load(weatherDataEntity.dayPictureUrl)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(itemView.iv_today_day)
            Glide.with(itemView.ctx)
                    .load(weatherDataEntity.nightPictureUrl)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(itemView.iv_today_night)
            itemView.tv_today_weather.text = weatherDataEntity.weather
            itemView.tv_today_wind.text = weatherDataEntity.wind
        }
    }

}