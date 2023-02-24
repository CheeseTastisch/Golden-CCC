package ccc.frame

import ccc.frame.configuration.IConfiguration
import ccc.frame.configuration.impl.Configuration

class Frame {

    companion object {

        fun createFrame(): IConfiguration = Configuration()

    }

}