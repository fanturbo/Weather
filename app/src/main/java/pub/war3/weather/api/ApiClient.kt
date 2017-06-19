package pub.war3.weather.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by snail on 16/11/8.
 */
class ApiClient private constructor() {
    private val baseUrl = "http://api.map.baidu.com/";
    private var retrofit: Retrofit? = null
    private var weatherApi: IWeatherApi? = null

    init {
        val okHttpClient = OkHttpClient.Builder()
        retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        weatherApi = retrofit!!.create<IWeatherApi>(IWeatherApi::class.java)
    }

    companion object {
        private var iWeatherApi: IWeatherApi? = ApiClient().weatherApi
        fun getInstance(): IWeatherApi? {
            return iWeatherApi
        }
    }
}
