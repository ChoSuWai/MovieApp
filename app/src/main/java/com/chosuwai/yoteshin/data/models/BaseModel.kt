package com.chosuwai.yoteshin.data.models

import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

open class BaseModel {

    init {
        EventBus.getDefault().register(this)
    }

    @Subscribe
    fun onEvent(event: Any?) {

    }
}