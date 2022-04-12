package com.applifting.spacex.company.model

/**
 * Created by Vlad Sakun on 11.04.2022
 */
sealed class CompanyDetailsViewState {

  class SetupUI(val uiModel: CompanyDetailsUIModel) : CompanyDetailsViewState()

  object ShowLoader : CompanyDetailsViewState()

  object HideLoader : CompanyDetailsViewState()
}