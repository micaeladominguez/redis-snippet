package org.austral.ingsis.demo.route

import org.austral.ingsis.demo.rule.Rule

data class GetDTO(
    val snippet: String,
    val rules: ArrayList<Rule>
)