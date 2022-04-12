package com.applifting.spacex.core.network.repositories

import com.applifting.spacex.core.database.company.CompanyMapper
import com.applifting.spacex.core.database.company.repository.CompanyRepositoryContract
import com.applifting.spacex.core.database.rocket.RocketMapper
import com.applifting.spacex.core.database.rocket.image.RocketImageMapper
import com.applifting.spacex.core.database.rocket.repository.RocketRepositoryContract
import com.applifting.spacex.core.network.services.SpaceXService

/**
 * Created by Vlad Sakun on 06.04.2022
 */
private const val TAG = "SpaceXRepository"

class SpaceXRepository(
  private val service: SpaceXService,
  private val rocketMapper: RocketMapper,
  private val rocketImageMapper: RocketImageMapper,
  private val rocketRepository: RocketRepositoryContract,
  private val companyMapper: CompanyMapper,
  private val companyRepository: CompanyRepositoryContract
) : SpaceXRepositoryContract {

  override suspend fun fetchRockets() {
    val rockets = service.getRockets()
    val imageEntities = rocketImageMapper.map(rockets)

    if (imageEntities != rocketRepository.getAllImages()) {
      rocketRepository.saveRocketImages(imageEntities)
    }

    rocketRepository.saveRockets(rocketMapper.map(rockets))
  }

  override suspend fun fetchCompany() {
    companyRepository.insertCompany(companyMapper.map(service.getCompany()))
  }
}