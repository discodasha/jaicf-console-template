package com.justai.jaicf.template

import com.justai.jaicf.BotEngine
import com.justai.jaicf.activator.regex.RegexActivator
import com.justai.jaicf.logging.Slf4jConversationLogger
import com.justai.jaicf.template.scenario.mainScenario


val templateBot = BotEngine(
    scenario = mainScenario,
    conversationLoggers = arrayOf(
        Slf4jConversationLogger()
    ),
    activators = arrayOf(
        RegexActivator
    )
)
