package com.example.androiddevchallenge

object DataProvider {
    val fakeTrades = listOf<Trade>(
        Trade(
            "ALK",
            "Alaska Air Group, Inc.",
            "\$7,918",
            -0.54f,
            R.drawable.ic_home_alk
        ),
        Trade(
            "BA",
            "Boeing Co.",
            "\$1,293",
            4.18f,
            R.drawable.ic_home_ba
        ),
        Trade(
            "DAL",
            "Delta Airlines Inc.",
            "\$893.50",
            -0.54f,
            R.drawable.ic_home_dal
        ),
        Trade(
            "EXPE",
            "Expedia Group Inc.",
            "\$12,301",
            2.51f,
            R.drawable.ic_home_exp
        ),
        Trade(
            "EADSY",
            "Airbus SE",
            "\$12,301",
            1.38f,
            R.drawable.ic_home_eadsy
        ),
        Trade(
            "JBLU",
            "Jetblue Airways Corp.",
            "\$8,521",
            1.56f,
            R.drawable.ic_home_jblu
        ),
        Trade(
            "MAR",
            "Marriott International Inc.",
            "\$521",
            2.75f,
            R.drawable.ic_home_mar
        ),
        Trade(
            "CCL",
            "Carnival Corp",
            "\$5,481",
            0.14f,
            R.drawable.ic_home_ccl
        ),
        Trade(
            "RCL",
            "Royal Caribbean Cruises",
            "\$9,184",
            1.69f,
            R.drawable.ic_home_rcl
        ),
        Trade(
            "TRVL",
            "Travelocity Inc.",
            "\$654",
            3.23f,
            R.drawable.ic_home_trvl
        )
    )

    val scrollItems = listOf<Pair<String, Boolean>>(
        Pair("Week", true),
        Pair("ETFs", false),
        Pair("Stocks", false),
        Pair("Funds", false),
        Pair("Hot", false)
    )
}