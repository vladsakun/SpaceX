package com.applifting.spacex.core.database.company.repository

import com.applifting.spacex.core.database.company.CompanyEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Vlad Sakun on 11.04.2022
 */
interface CompanyRepositoryContract {

  fun observeCompany(): Flow<CompanyEntity?>

  suspend fun getCompany(): CompanyEntity?

  suspend fun insertCompany(companyEntity: CompanyEntity)

  suspend fun deleteCompany()
}