package com.applifting.spacex.core.database.company

import com.applifting.spacex.core.extensions.orZero
import com.applifting.spacex.core.mapper.Mapper
import com.applifting.spacex.core.network.responses.company.CompanyResponse

/**
 * Created by Vlad Sakun on 11.04.2022
 */
class CompanyMapper : Mapper<CompanyResponse, CompanyEntity> {

  override suspend fun map(from: CompanyResponse): CompanyEntity {
    return with(from) {
      CompanyEntity(
        id = id.orEmpty(),
        name = name.orEmpty(),
        founder = founder.orEmpty(),
        summary = summary.orEmpty(),
        employees = employees.orZero()
      )
    }
  }
}