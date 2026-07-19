package com.example.pocketbro.data.mapper

import com.example.pocketbro.data.dto.PocketBroDto
import com.example.pocketbro.domain.model.PocketBro

class PocketBroMapper {
    fun toDomain(dto: PocketBroDto) : PocketBro = PocketBro(
        screenTime = dto.screenTime
    )

    fun toDto(domain: PocketBro) : PocketBroDto = PocketBroDto(
        screenTime = domain.screenTime
    )
}
