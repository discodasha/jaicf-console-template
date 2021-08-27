package com.justai.jaicf.template.scenario

import com.justai.jaicf.activator.caila.caila
import com.justai.jaicf.builder.Scenario
import kotlin.random.Random

val mainScenario = Scenario {
    state("start") {
        activators {
            regex("/start")
            intent("Start")
        }
        action {
            reactions.say("Hello!")
        }
    }

    state("end") {
        activators {
            regex("/end")
        }

        action {
            reactions.sayRandom(
                "Game over!",
                "Doesn't matter if you win or not, that was great!"
            )
        }
    }

    state("game") {
        activators {
            regex("/game")
        }

        action {
            reactions.say("Choose number from 1 to 10!")
        }

        state("game_context") {
            activators {
                catchAll()
            }

            action {
                val randomValue = (1..10).random()
                val userValue = request.input.toInt()

                if (randomValue == userValue) {
                    reactions.say("Success!")
                    reactions.go("/end")
                } else {
                    reactions.say("Try again!")
                    reactions.go("/game")
                }
            }
        }
    }

    fallback {
        val requestLength = request.input.length
        reactions.say("There are $requestLength symbols in your request.")
    }

}