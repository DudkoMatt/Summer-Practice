package com.project.dudko.thebeastofthelabyrinth

class Score{
        var _id: Int = 0
        var level: String? = null
        var coins: Int = 0
        var turns: Int = 0

        constructor(id: Int, level: String, coins: Int, turns: Int) {
            this._id = id
            this.level = level
            this.coins = coins
            this.turns = turns
        }

        constructor(level: String, coins: Int, turns: Int) {
            this.level = level
            this.coins = coins
            this.turns = turns
        }
}