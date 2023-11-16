package com.example.stopwatch_2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true)
@Composable
fun StopwatchView() {
    StopWatch(stopWatchViewM = StopWatchViewM())
}

@Composable
fun StopWatch(
    stopWatchViewM: StopWatchViewM,
    modifier: Modifier = Modifier
) {
    // Column: 세로로 배치
    Column(
        modifier = modifier
            .fillMaxWidth(),

        horizontalAlignment = Alignment.CenterHorizontally // 가운데 정렬

    ) {
        Text(
            modifier = Modifier
                //.size(width = 300.dp, height = 100.dp)
                .background(Color.Yellow)  // 배경 노란색
                .padding(10.dp)             // 패딩 10dp
                .align(Alignment.CenterHorizontally)

            ,fontSize = 50.sp

            // 가로로 꽉 채우기

            ,text = stopWatchViewM.min.value+":"+
                             stopWatchViewM.sec.value+"."+
                             stopWatchViewM.time.value//, fontSize = 50.sp
        )

        Row( // Row: 가로로 배치
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {

            // 시작/정지 버튼
            Button(
                onClick = { stopWatchViewM.stopwatch() },
                modifier = Modifier
                    .width(150.dp)
                    .height(100.dp)
                    .padding(10.dp),
            )
            {
                Text(text = stopWatchViewM.start.value,
                    modifier = Modifier,
                    fontSize = 25.sp
                )

            }
            // 초기화/탭 버튼
            Button(
                onClick = { stopWatchViewM.reset()},
                modifier = Modifier
                    .width(150.dp)
                    .height(100.dp)
                    .padding(10.dp),

            )
            {
                Text(text = stopWatchViewM.reset.value,
                    modifier = Modifier,
                    fontSize = 25.sp
                )
            }
        }
         Text(
             text = stopWatchViewM.list.toString()
                 .replace("[","")
                 .replace("]","")
                 .replace(",","")
                 .split(" ")
                 .joinToString(separator = "\n")
             , fontSize = 20.sp
         ) // 랩타임 출력
         //String[] splits =  s.replace("[","").replace("]","").split(",");
    }


}