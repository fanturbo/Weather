package pub.war3.weather.main


/**
 * Created by snail on 17/6/15.
 */
class WeatherDataEntity(var error: Int,
                        var status: String?,
                        var date: String?,
                        var results: List<ResultsBean>?)

class ResultsBean(var currentCity: String?,
                  var pm25: String?,
                  var index: List<IndexBean>?,
                  var weather_data: List<WeatherDataBean>?)

class IndexBean(var title: String,
                var zs: String,
                var tipt: String,
                var des: String)

class WeatherDataBean(var date: String?,
                      var dayPictureUrl: String?,
                      var nightPictureUrl: String?,
                      var weather: String?,
                      var wind: String?,
                      var temperature: String?)