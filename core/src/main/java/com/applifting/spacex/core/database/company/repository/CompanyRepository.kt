package com.applifting.spacex.core.database.company.repository

import com.applifting.spacex.core.database.company.CompanyDao
import com.applifting.spacex.core.database.company.CompanyEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by Vlad Sakun on 06.04.2022
 */
class CompanyRepository(
  private val companyDao: CompanyDao
) : CompanyRepositoryContract {

  override fun observeCompany(): Flow<CompanyEntity> {
    return companyDao.observeCompany()
  }

  override suspend fun getCompany(): CompanyEntity {
    return companyDao.getCompany()
  }

  override suspend fun insertCompany(companyEntity: CompanyEntity) {
    companyDao.insertCompany(companyEntity)
  }

  override suspend fun deleteCompany() {
    companyDao.deleteAllCompanies()
  }

}