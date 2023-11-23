package com.example.stopwatch_2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
    StopWatch(stopWatchViewM = StopWatchViewModel())
}

@Composable
fun StopWatch(
    stopWatchViewM: StopWatchViewModel,
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
                Text(text = stopWatchViewM.start,
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
                Text(text = stopWatchViewM.reset,
                    modifier = Modifier,
                    fontSize = 25.sp
                )
            }
        }

        // 탭(Text 버전) - 스크롤 불가능
         /*Text(
             text = stopWatchViewM.list.toString()
                 .replace("[","")
                 .replace("]","")
                 .replace(",","")
                 .split(" ")
                 .joinToString(separator = "\n")
             , fontSize = 20.sp
         )*/

        // 탭(LazyColumn 버전) - 스크롤 가능
        LazyColumn(content = {
            items(stopWatchViewM.cnt.value){ index ->
                Text(text = stopWatchViewM.list[index])
            }
        })

        // 탭(Column 스크롤 버전)
        /*Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp, alignment = Alignment.CenterVertically)
        ) {
            stopWatchViewM.list.forEachIndexed { index, recordTime ->
                Text(text = recordTime)
            }
        }*/
    }


}