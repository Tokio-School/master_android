package com.tokioschol.coroutinesexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tokioschol.coroutinesexample.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    val mainScope:CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main)
    val workerScope:CoroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        lanzadores()
        mainScope.launch {
            Log.e("manel","el resultado es ${sum().await()}")
        }
        CoroutineScope(Dispatchers.Main).launch{

        }

    }

    fun funA() = workerScope.async {
        delay(3000)
        return@async 1
    }

    fun funB() = workerScope.async {
        delay(3000)
        return@async 2
    }

    fun sum() = mainScope.async {
        val a = funA()
        val b = funB()
        return@async a.await() + b.await()
    }

    private fun lanzadores() {
        lanzadorGlobal()
        lanzadorGlobalMultihilo()
        Log.e("manel","que hace la función ${exampleBlocking()}")
        //lanzadorSupervisor()
        Log.e("manel","el resultado es ${getValue()}")

    }

    private fun exampleBlocking() = runBlocking(Dispatchers.IO){
        return@runBlocking getResult(35)
    }

    private fun getValue() = workerScope.async {

            val result1= async { getResult(3) }
            val result2 = async { getResult(35) }
            //Log.e("manel","los resultados son ${result1.await()} y el segundo es ${result2.await()}")


        return@async result1
    }

    private fun lanzadorGlobalMultihilo() {




        GlobalScope.launch(Dispatchers.IO) {

            val timeMulti = measureTimeMillis {
                val result1= async { getResult(3) }
                val result2 = async { getResult(35) }
                Log.e("manel","los resultados son ${result1.await()} y el segundo es ${result2.await()}")
            }

            withContext(Dispatchers.Main){
                binding?.pruebas?.text = "el tiempo de las llamadas MULTI es $timeMulti"
            }


        }

    }

    private fun lanzadorGlobal() {
        Log.e("manel","METODO LANZADOR GLOBAL")
       GlobalScope.launch(Dispatchers.IO) {
           Log.e("manel","inicio GlobalScope")
           val millisTime = measureTimeMillis {
               val result = getResult(23)
               val anotherResult = getResult(50)
               Log.e("manel","resultados sin multi $result y el otro es $anotherResult")
           }
           Log.e("manel","el tiempo de las llamadas es $millisTime")

       }
        Log.e("manel","FIN METODO LANZADOR GLOBAL")
    }

    private suspend fun getResult(value:Int): Int {
        delay(3000)
        return value * 10
    }


}