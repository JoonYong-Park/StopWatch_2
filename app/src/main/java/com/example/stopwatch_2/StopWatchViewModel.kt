package com.example.stopwatch_2

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StopWatchViewModel : ViewModel() {
    var time = mutableStateOf("00")                  // 시간을 저장하는 변수
    var sec = mutableStateOf("00")                   // 시간을 저장하는 변수
    var min = mutableStateOf("00")                   // 시간을 저장하는 변수

    var mode = mutableStateOf(true)                 // 시간/랩타임을 저장하는 변수
    // var start = mutableStateOf("시작")               // 시작/정지를 저장하는 변수
    // var reset = mutableStateOf("초기화")

    var start = "시작"
    var reset = "초기화"

                  // 시작/정지를 저장하는 변수


    var list : MutableList<String> = mutableListOf()       // 랩타임을 저장하는 리스트
    var cnt = mutableStateOf(0)                      // 랩타임을 저장하는 리스트

    // 레코드 리스트 사용

    fun stopwatch() {
        if (mode.value == true) {
            start = "정지"
            reset = "랩"
            mode.value = false
        } else {
            start = "시작"
            reset = "초기화"
            mode.value = true
        }
        viewModelScope.launch {     // 필요할때만 실행을하는 코루틴
            while (true) {
                if(start == "시작") break;      // 정지 버튼 누르면 while문 탈출

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
        if(mode.value == true) {
            time.value = "00"
            sec.value = "00"
            min.value = "00"
            cnt.value = 0
            list.clear()
        }

        else if(mode.value == false) {
            cnt.value = cnt.value+1
            list.add("("+cnt.value.toString()+")"+min.value+":"+sec.value+"."+time.value)

        }

    }

}