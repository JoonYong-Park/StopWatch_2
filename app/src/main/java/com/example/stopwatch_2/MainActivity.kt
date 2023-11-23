package com.example.stopwatch_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.stopwatch_2.ui.theme.StopWatch_2Theme

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StopWatch_2Theme {
        Greeting("Android")
    }
}
// MainActivity 클래스 정의
class MainActivity : ComponentActivity() {

    private val stopwatchviewmodel by viewModels<StopWatchViewModel>()

    // onCreate: 집입점(JAVA의 main() 함수와 비슷)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContent: 화면을 구성하는 메인 컨텐츠 블록을 설정
        setContent {
            StopWatch_2Theme {
                Surface( // Surface: UI 섹션을 나타내는 컨테이너입니다
                    modifier = Modifier.fillMaxSize(), // 화면 전체 크기로 설정
                    color = MaterialTheme.colorScheme.background // 테마에서 정의된 배경색을 사용
                ) {
                    StopWatch(stopWatchViewM = stopwatchviewmodel)
                }
            }
        }
    }
}

@Composable // UI를 구성하는 함수임을 나타냄
fun Greeting(name: String, modifier: Modifier = Modifier)
{

    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

