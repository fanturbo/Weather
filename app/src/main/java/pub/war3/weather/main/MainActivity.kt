package pub.war3.weather.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import pub.war3.weather.R


class MainActivity : AppCompatActivity(), MainView {

    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecast_list.layoutManager = LinearLayoutManager(this)
        mainPresenter = MainPresenter(this)
        loadData()
    }

    private fun loadData() {
        mainPresenter.getWeatherInfo("北京")
    }

    override fun showWeather(weather: WeatherDataEntity) {
        forecast_list.adapter = WeatherAdapter(weather.results[0].weather_data)
    }

    override fun showError(message: String?) {

    }

}
