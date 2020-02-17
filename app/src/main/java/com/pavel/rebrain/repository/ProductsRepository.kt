package com.pavel.rebrain.repository

import com.pavel.rebrain.App
import com.pavel.rebrain.domain.Product
import com.pavel.rebrain.domain.util.Generator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.*
import okio.IOException
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named
import kotlin.coroutines.CoroutineContext

/**
 * класс логики формирования и хранения данных
 */
class ProductsRepository @Inject constructor(val okHttpClient: OkHttpClient) : CoroutineScope {

    @Inject
    @field:Named("baseUrl")
    lateinit var baseUrl: String

    private var productList: MutableList<Product> = mutableListOf()

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default

    /**
     * возвращает текущий список продуктов без обращения к бэкенду
     * @return MutableList<Product>
     */
    fun getProducts(): MutableList<Product> {
        return productList
    }

    /**
     * генрирует новый (запрашивает с бэкенда) список продуктов
     */
    fun updateProducts(): MutableList<Product> {

        val request: Request = Request.Builder()
            .url("$baseUrl/products")
            .build()

        // оборачиваем синхронный запрос к api в асинхронную корутину
        // в противном случает будет ошибка в приложении, связанная с выполнением блокирующих
        // сетевых операций на ui thread
        GlobalScope.launch(Dispatchers.IO) {
            try {
                okHttpClient.newCall(request).execute()
                    .use { response ->
                        val serverAnswer = response.body?.string()
                        Timber.tag(App.APP_LOG_TAG)
                            .i("newCall.execute response is: %s", serverAnswer)
                    }
            } catch (e: Exception) {
                Timber.tag(App.APP_LOG_TAG).i("newCall.execute error is: %s", e.message)
            }
        }

        // асинхронный запрос к api
        okHttpClient.newCall(request).enqueue(
            object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Timber.tag(App.APP_LOG_TAG).i("newCall.enqueue error is: %s", e.message)
                }

                override fun onResponse(call: Call, response: Response) {
                    val serverAnswer = response.body?.string()
                    Timber.tag(App.APP_LOG_TAG)
                        .i("newCall.enqueue response is: %s", serverAnswer)
                }
            }
        )

        productList = Generator().getProducts()
        return productList
    }

}