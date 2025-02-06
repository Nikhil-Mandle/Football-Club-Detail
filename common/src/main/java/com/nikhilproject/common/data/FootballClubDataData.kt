package com.nikhilproject.common.data

import com.nikhilproject.common.model.FootballClubRemote
import com.nikhilproject.common.model.PlayerDetailRemote
import com.nikhilproject.common.R
import com.nikhilproject.common.model.FootballClubDataRemote

object FootballClubDataData {
    val footballClubRemoteData = FootballClubDataRemote(
        footballClubCards = listOf(
            FootballClubRemote(
                image = R.drawable.ic_real_madrid,
                name = "Real Madrid",
                playerDetail = listOf(
                    PlayerDetailRemote("Vinícius Júnior", R.drawable.vinicius_jr, "Left Winger"),
                    PlayerDetailRemote("Karim Benzema", R.drawable.benzema, "Center Forward"),
                    PlayerDetailRemote("Luka Modrić", R.drawable.modric, "Midfielder"),
                    PlayerDetailRemote("Toni Kroos", R.drawable.kroos, "Midfielder"),
                    PlayerDetailRemote("Federico Valverde", R.drawable.valverde, "Midfielder"),
                    PlayerDetailRemote("Éder Militão", R.drawable.militao, "Center Back"),
                    PlayerDetailRemote("David Alaba", R.drawable.alaba, "Left Back"),
                    PlayerDetailRemote("Dani Carvajal", R.drawable.carvajal, "Right Back"),
                    PlayerDetailRemote("Thibaut Courtois", R.drawable.courtois, "Goalkeeper"),
                    PlayerDetailRemote("Rodrygo", R.drawable.rodrygo, "Right Winger")
                )
            ),
            FootballClubRemote(
                image = R.drawable.ic_manchester_city,
                name = "Manchester City",
                playerDetail = listOf(
                    PlayerDetailRemote("Erling Haaland", R.drawable.haaland, "Center Forward"),
                    PlayerDetailRemote("Kevin De Bruyne", R.drawable.debruyne, "Midfielder"),
                    PlayerDetailRemote("Jack Grealish", R.drawable.grealish, "Left Winger"),
                    PlayerDetailRemote("Bernardo Silva", R.drawable.silva, "Midfielder"),
                    PlayerDetailRemote("Rodri", R.drawable.rodri, "Midfielder"),
                    PlayerDetailRemote("Rúben Dias", R.drawable.dias, "Center Back"),
                    PlayerDetailRemote("John Stones", R.drawable.stones, "Center Back"),
                    PlayerDetailRemote("Kyle Walker", R.drawable.walker, "Right Back"),
                    PlayerDetailRemote("Ederson", R.drawable.ederson, "Goalkeeper"),
                    PlayerDetailRemote("Phil Foden", R.drawable.foden, "Attacking Midfielder")
                )
            ),
            FootballClubRemote(
                image = R.drawable.ic_barcelona,
                name = "Barcelona",
                playerDetail = listOf(
                    PlayerDetailRemote(
                        "Robert Lewandowski",
                        R.drawable.lewandowski,
                        "Center Forward"
                    ),
                    PlayerDetailRemote("Pedri", R.drawable.pedri, "Midfielder"),
                    PlayerDetailRemote("Gavi", R.drawable.gavi, "Midfielder"),
                    PlayerDetailRemote("Frenkie de Jong", R.drawable.dejong, "Midfielder"),
                    PlayerDetailRemote("Ousmane Dembélé", R.drawable.dembele, "Right Winger"),
                    PlayerDetailRemote("Ansu Fati", R.drawable.fati, "Left Winger"),
                    PlayerDetailRemote("Ronald Araújo", R.drawable.araujo, "Center Back"),
                    PlayerDetailRemote("Jules Koundé", R.drawable.kounde, "Center Back"),
                    PlayerDetailRemote("Marc-André ter Stegen", R.drawable.terstegen, "Goalkeeper"),
                    PlayerDetailRemote("Raphinha", R.drawable.raphinha, "Right Winger")
                )
            ),
            FootballClubRemote(
                image = R.drawable.ic_bayern_munich,
                name = "Bayern Munich",
                playerDetail = listOf(
                    PlayerDetailRemote("Harry Kane", R.drawable.kane, "Center Forward"),
                    PlayerDetailRemote("Joshua Kimmich", R.drawable.kimmich, "Midfielder"),
                    PlayerDetailRemote("Leroy Sane", R.drawable.sane, "Left Winger"),
                    PlayerDetailRemote("Thomas Müller", R.drawable.muller, "Attacking Midfielder"),
                    PlayerDetailRemote("Leon Goretzka", R.drawable.goretzka, "Midfielder"),
                    PlayerDetailRemote("Matthijs de Ligt", R.drawable.deligt, "Center Back"),
                    PlayerDetailRemote("Dayot Upamecano", R.drawable.upamecano, "Center Back"),
                    PlayerDetailRemote("Alphonso Davies", R.drawable.davies, "Left Back"),
                    PlayerDetailRemote("Manuel Neuer", R.drawable.neuer, "Goalkeeper"),
                    PlayerDetailRemote("Kingsley Coman", R.drawable.coman, "Left Winger")
                )
            ),
            FootballClubRemote(
                image = R.drawable.ic_liverpool,
                name = "Liverpool",
                playerDetail = listOf(
                    PlayerDetailRemote("Mohamed Salah", R.drawable.salah, "Right Winger"),
                    PlayerDetailRemote("Virgil van Dijk", R.drawable.vandijk, "Center Back"),
                    PlayerDetailRemote("Alisson Becker", R.drawable.alisson, "Goalkeeper"),
                    PlayerDetailRemote(
                        "Trent Alexander-Arnold",
                        R.drawable.alexanderarnold,
                        "Right Back"
                    ),
                    PlayerDetailRemote("Andrew Robertson", R.drawable.robertson, "Left Back"),
                    PlayerDetailRemote("Fabinho", R.drawable.fabinho, "Defensive Midfielder"),
                    PlayerDetailRemote("Jordan Henderson", R.drawable.henderson, "Midfielder"),
                    PlayerDetailRemote("Thiago Alcântara", R.drawable.thiago, "Midfielder"),
                    PlayerDetailRemote("Darwin Núñez", R.drawable.nunez, "Center Forward"),
                    PlayerDetailRemote("Luis Díaz", R.drawable.diaz, "Left Winger")
                )
            ),
            FootballClubRemote(
                image = R.drawable.ic_psg,
                name = "Paris Saint-Germain",
                playerDetail = listOf(
                    PlayerDetailRemote("Kylian Mbappé", R.drawable.mbappe, "Center Forward"),
                    PlayerDetailRemote("Neymar Jr.", R.drawable.neymar, "Left Winger"),
                    PlayerDetailRemote("Lionel Messi", R.drawable.messi, "Right Winger"),
                    PlayerDetailRemote("Marco Verratti", R.drawable.verratti, "Midfielder"),
                    PlayerDetailRemote("Marquinhos", R.drawable.marquinhos, "Center Back"),
                    PlayerDetailRemote("Achraf Hakimi", R.drawable.hakimi, "Right Back"),
                    PlayerDetailRemote("Gianluigi Donnarumma", R.drawable.donnarumma, "Goalkeeper"),
                    PlayerDetailRemote("Vitinha", R.drawable.vitinha, "Midfielder"),
                    PlayerDetailRemote("Nuno Mendes", R.drawable.mendes, "Left Back"),
                    PlayerDetailRemote("Carlos Soler", R.drawable.soler, "Midfielder")
                )
            )
        )
    )
}