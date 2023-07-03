package org.austral.ingsis.demo.consumer

import configurationLinter.ConfigClassesLinter

data class ProductCreated(val snippet: String, val rules: ArrayList<ConfigClassesLinter>)