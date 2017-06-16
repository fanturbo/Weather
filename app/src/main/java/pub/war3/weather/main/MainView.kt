package pub.war3.weather.main

/**
 * Created by turbo on 2017/6/15.
 */
interface MainView {
    fun showWeather(weather: WeatherDataEntity)

    fun showError(message: String?)

}
