package com.project.fourhorsemenoftheapocalypse.thebeastofthelabyrinth

class Score{
        var _id: Long = 0
        var level: String = ""
        var coins: Long = 0
        var turns: Long = 0

        constructor(id: Long, level: String, coins: Long, turns: Long) {
            this._id = id
            this.level = level
            this.coins = coins
            this.turns = turns
        }

        constructor(level: String, coins: Long, turns: Long) {
            this.level = level
            this.coins = coins
            this.turns = turns
        }
}