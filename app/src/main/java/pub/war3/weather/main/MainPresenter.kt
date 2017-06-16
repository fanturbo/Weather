package pub.war3.weather.main

import pub.war3.weather.api.ApiClient
import pub.war3.weather.api.RxSchedulers

/**
 * Created by turbo on 2017/6/16.
 */

class MainPresenter(private val mainView: MainView) {
    fun getWeatherInfo(location: String) {
        ApiClient.iWeatherApi?.getWeather(location)?.compose(RxSchedulers.applySchedulers())
                ?.subscribe({ weatherData -> mainView.showWeather(weatherData) }) { throwable -> mainView.showError(throwable.message) }
    }
}
