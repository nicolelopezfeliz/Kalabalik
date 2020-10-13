package com.example.myapplication.gaming

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.dataclasses.Player

class GamingViewModel : ViewModel() {

    var currentCard = MutableLiveData<CardMissionConsequence>()
    var timedTaskCard = MutableLiveData<CardTimedTask>()
    var updateCardFragment = MutableLiveData<Int>()
    var clearCardFragment = MutableLiveData<Int>()

    var currentTurn = MutableLiveData<Int>().apply {
        value = 0
    }
    var currentRound = MutableLiveData<Int>().apply {
        value = 0
    }

    var currentPlayer = MutableLiveData<Player>().apply {
        value = Player("InitialPlayer0", playerNum = 0)
    }

    fun updatePlayer(player: Player) = currentPlayer.postValue(player)

    fun updateCurrentCard(card: CardMissionConsequence) {
        currentCard.postValue(card)
    }

    fun updateRandomTaskCard(cardTimedTask: CardTimedTask){
        timedTaskCard.value = cardTimedTask
    }

}

fun MutableLiveData<Int>.postEmpty() {
    this.postValue(0)
}

fun MutableLiveData<Int>.postUpdateIntBy(int: Int) {
    this.postValue(this.value?.plus(int))
}