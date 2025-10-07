package gz.dam.laprimera

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import gz.dam.laprimera.ui.theme.LaPrimeraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LaPrimeraTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        Log.d("Estados","Estoy en el onCreate")
        Log.e("Fallo", "Error en el onCreate(No es un error es una prueba)")

    }

    override fun onStart() {
        super.onStart()
        Log.d("Estados", "En el estado start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Estados","En el estado resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Estados", "En el estado pausa")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Estados", "En el estado stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Estados","en el onDestroy")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LaPrimeraTheme {
        Greeting("Android")
    }
}