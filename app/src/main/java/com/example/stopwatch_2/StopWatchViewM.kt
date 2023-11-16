package com.example.stopwatch_2

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StopWatchViewM : ViewModel() {
    var time = mutableStateOf("00")                  // 시간을 저장하는 변수
    var sec = mutableStateOf("00")                   // 시간을 저장하는 변수
    var min = mutableStateOf("00")                   // 시간을 저장하는 변수
    var start = mutableStateOf("시작")                // 시작/정지를 저장하는 변수
    var reset = mutableStateOf("초기화")              // 시작/정지를 저장하는 변수
    var list : MutableList<String> = mutableListOf()       // 랩타임을 저장하는 리스트
    var cnt = mutableStateOf(0)                      // 랩타임을 저장하는 리스트
    //val result = list.joinToString(separator = ", ")     // 리스트를 문자열로 변환


    fun stopwatch() {
        if (start.value == "시작") {
            start.value = "정지"
            reset.value = "랩"
        } else {
            start.value = "시작"
            reset.value = "초기화"
        }
        viewModelScope.launch {     // 필요할때만 실행을하는 코루틴
            while (true) {
                if(start.value == "시작") break;      // 정지 버튼 누르면 while문 탈출

                delay(10)
                time.value = (time.value.toInt()+1).toString()
                if(time.value.toInt() < 10) {
                    time.value = "0"+time.value
                }
                if(time.value.toInt() == 100) {
                    time.value = "00"
                    sec.value = (sec.value.toInt()+1).toString()

                    if(sec.value.toInt() < 10 ) {
                        sec.value = "0"+sec.value
                    }
                    if(sec.value.toInt() == 60) {
                        sec.value = "00"
                        min.value = (min.value.toInt()+1).toString()
                        if(min.value.toInt() < 10) {
                            min.value = "0"+min.value
                        }
                    }
                }
            }
        }
    }

    fun reset() {
        if(reset.value == "초기화") {
            time.value = "00"
            sec.value = "00"
            min.value = "00"
            cnt.value = 0
            list.clear()
        }

        else if(reset.value == "랩") {
            cnt.value = cnt.value+1
            list.add("("+cnt.value.toString()+")"+min.value+":"+sec.value+"."+time.value)

            //val result = list.joinToString(separator = " ") // 리스트를 문자열로 변환

        }

    }

}